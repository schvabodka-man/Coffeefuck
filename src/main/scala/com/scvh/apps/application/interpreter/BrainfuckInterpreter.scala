package com.scvh.apps.application.interpreter

import com.scvh.apps.application.interpreter.brainruntime.{BrainfuckLoopsParameters, BrainfuckMachineParameters, BrainfuckRuntime}
import org.springframework.beans.factory.annotation.{Autowired, Qualifier}
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope("prototype")
class BrainfuckInterpreter {

  @Autowired
  @Qualifier("startLoop")
  var LOOP_STARTER: LoopParams = _
  @Autowired
  @Qualifier("finishLoop")
  var LOOP_FINISHER: LoopParams = _

  def brainfuckInterpreter(bundle: BrainfuckBundle): BrainfuckBundle = {
    val t0 = System.nanoTime()
    interpBrainfuck(bundle.runtime, bundle.parameters, bundle.loops, bundle.oneFrameMode)
    bundle.runtime.setupDurationOfExecution(System.nanoTime() - t0)
    bundle
  }

  def interpBrainfuck(runtime: BrainfuckRuntime, params: BrainfuckMachineParameters, loopsParams: BrainfuckLoopsParameters, oneFrameMode: Boolean): Unit = {
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
          loop(loopsParams, params, LOOP_STARTER)
        }
      case "]" =>
        if (runtime.getCurrentMemBlock != 0) {
          params.lowerPosition
          loop(loopsParams, params, LOOP_FINISHER)
          params.lowerPosition
        }
    }
    params.incrementPosition
    oneFrameMode match {
      case true => params.canIncrementAnyFurther match {
        case true => interpBrainfuck(runtime, params, loopsParams, oneFrameMode)
      }
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
