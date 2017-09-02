package com.scvh.apps.application.brainfuck

import com.scvh.apps.application.brainfuck.brainruntime.{BrainfuckLoopsParameters, BrainfuckMachineParameters, BrainfuckRuntime}
import org.springframework.stereotype.Component

@Component
class BrainfuckInterpreter {

  def brainfuckInterpreter(bundle: BrainfuckBundle): BrainfuckBundle = {
    val t0 = System.nanoTime()
    interpBrainfuck(bundle.runtime, bundle.parameters, bundle.loops)
    bundle.runtime.setupDurationOfExecution(System.nanoTime() - t0)
    bundle
  }

  def interpBrainfuck(runtime: BrainfuckRuntime, params: BrainfuckMachineParameters, looper: BrainfuckLoopsParameters): Unit = {
    params.retrieveProgramAtCurrentPosition match {
      case ">" => runtime.moveCaretForward
      case "<" => runtime.moveCaretBackward
      case "+" => runtime.incMemory
      case "-" => runtime.decrMemory
      case "." => runtime.printMemToANSIChar
      case "," => runtime.inputASCIIChar(params.readArg)
      case "[" =>
        if (runtime.getCurrentMemBlock == 0) {
          params.incrementPosition
          loop(looper, params, new LoopParams("]", "[", (params: BrainfuckMachineParameters) => {
            params.incrementPosition
          }))
        }
      case "]" =>
        if (runtime.getCurrentMemBlock != 0) {
          params.lowerPosition
          loop(looper, params, new LoopParams("[", "]", (params: BrainfuckMachineParameters) => {
            params.lowerPosition
          }))
          params.lowerPosition
        }
    }
    params.incrementPosition
    if (params.canIncrementAnyFurther) {
      interpBrainfuck(runtime, params, looper)
    }
  }

  def loop(looper: BrainfuckLoopsParameters, params: BrainfuckMachineParameters, loopParams: LoopParams): Unit = {
    params.retrieveProgramAtCurrentPosition match {
      case loopParams.secBracket => looper.increment
      case loopParams.mainBracket => looper.decrement
      case default => //dindu nuffin
    }
    loopParams.callback(params)
    if (looper.isHigherThanZero || params.retrieveProgramAtCurrentPosition != loopParams.mainBracket) {
      loop(looper, params, loopParams)
    }
  }

}

class LoopParams(val mainBracket: String, val secBracket: String, val callback: (BrainfuckMachineParameters) => Unit)