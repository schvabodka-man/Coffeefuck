package com.scvh.apps.application

import com.scvh.apps.application.brainruntime.{BrainfuckLoopsParameters, BrainfuckMachineParameters, BrainfuckRuntime}

object brainfuckInterpreter extends (BrainfuckRuntime => BrainfuckRuntime) {

  override def apply(runtime: BrainfuckRuntime): BrainfuckRuntime = {
    interpBrainfuck(runtime, new BrainfuckLoopsParameters())
    runtime
  }

  def interpBrainfuck(runtime: BrainfuckRuntime, looper: BrainfuckLoopsParameters): Unit = {
    var params = runtime.retrieveParams
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
          startLoop(looper, params)
        }
      case "]" =>
        if (runtime.getCurrentMemBlock != 0) {
          params.lowerPosition
          finishLoop(looper, params)
          params.lowerPosition
        }
    }
    params.incrementPosition
    if (params.canIncrementAnyFurther) {
      interpBrainfuck(runtime, looper)
    }
  }

  def startLoop(looper: BrainfuckLoopsParameters, params: BrainfuckMachineParameters): Unit = {
    params.retrieveProgramAtCurrentPosition match {
      case "[" => looper.increment
      case "]" => looper.decrement
      case default => //dindu nuffin
    }
    params.incrementPosition
    if (looper.isHigherThanZero || params.retrieveProgramAtCurrentPosition != "]") {
      startLoop(looper, params)
    }
  }

  def finishLoop(looper: BrainfuckLoopsParameters, params: BrainfuckMachineParameters): Unit = {
    params.retrieveProgramAtCurrentPosition match {
      case "]" => looper.increment
      case "[" => looper.decrement
      case default => //dindu nuffin
    }
    params.lowerPosition
    if (looper.isHigherThanZero || params.retrieveProgramAtCurrentPosition != "[") {
      finishLoop(looper, params)
    }
  }
}
