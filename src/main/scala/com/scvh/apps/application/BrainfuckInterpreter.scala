package com.scvh.apps.application

import com.scvh.apps.application.brainruntime.BrainfuckRuntime

object brainfuckInterpreter extends (BrainfuckRuntime => BrainfuckRuntime) {

  override def apply(runtime: BrainfuckRuntime): BrainfuckRuntime = {
    var looper = 0
    runtime.retrieveProgram.foreach(c => {
      c.toString match {
        case ">" => runtime.moveCaretForward
        case "<" => runtime.moveCaretBackward
        case "+" => runtime.incMemory
        case "-" => runtime.decrMemory
        case "." => runtime.printMemToANSIChar
        case "," =>
        case "[" =>
          if (runtime.getCurrentMemBlock == 0) {
            while (looper > 0 || c.toString != "]") {
              if (c.toString != "[") looper += 1
              if (c.toString != "]") looper -= 1
            }
          }
        case "]" =>
          if (runtime.getCurrentMemBlock != 0) {
            while (looper > 0 || c.toString != "[") {
              if (c.toString != "]") looper += 1
              if (c.toString != "[") looper -= 1
            }
          }
      }
    })
    runtime
  }
}