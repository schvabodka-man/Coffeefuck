package com.scvh.apps.application

import com.scvh.apps.application.brainruntime.{BrainfuckLoopsParameters, BrainfuckRuntime}

object brainfuckInterpreter extends (BrainfuckRuntime => BrainfuckRuntime) {

  override def apply(runtime: BrainfuckRuntime): BrainfuckRuntime = {
    interpBrainfuck(runtime, new BrainfuckLoopsParameters())
    runtime
  }

  def interpBrainfuck(runtime: BrainfuckRuntime, looper: BrainfuckLoopsParameters): Unit = {
    runtime.retrieveParams.retrieveProgramAtCurrentPosition match {
      case ">" => runtime.moveCaretForward
      case "<" => runtime.moveCaretBackward
      case "+" => runtime.incMemory
      case "-" => runtime.decrMemory
      case "." => runtime.printMemToANSIChar
      case "," =>
      case "[" =>
        if (runtime.getCurrentMemBlock == 0) {
          runtime.retrieveParams.incrementPosition
          while (looper.isHigherThanZero || runtime.retrieveParams.retrieveProgramAtCurrentPosition != "]") {
            if (runtime.retrieveParams.retrieveProgramAtCurrentPosition == "[") looper.increment
            if (runtime.retrieveParams.retrieveProgramAtCurrentPosition == "]") looper.decrement
            runtime.retrieveParams.incrementPosition
          }
        }
      case "]" =>
        if (runtime.getCurrentMemBlock != 0) {
          runtime.retrieveParams.lowerPosition
          while (looper.isHigherThanZero || runtime.retrieveParams.retrieveProgramAtCurrentPosition != "[") {
            if (runtime.retrieveParams.retrieveProgramAtCurrentPosition == "]") looper.increment
            if (runtime.retrieveParams.retrieveProgramAtCurrentPosition == "[") looper.decrement
            runtime.retrieveParams.lowerPosition
          }
          runtime.retrieveParams.lowerPosition
        }
    }
    runtime.retrieveParams.incrementPosition
    if (runtime.retrieveParams.canIncrementAnyFurther) {
      interpBrainfuck(runtime, looper)
    }
  }
}
