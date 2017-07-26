package com.scvh.apps.application

import com.scvh.apps.application.brainruntime.BrainfuckRuntime

object brainfuckInterpreter extends (BrainfuckRuntime => BrainfuckRuntime) {

  override def apply(runtime: BrainfuckRuntime): BrainfuckRuntime = {
    runtime.retrieveProgram.map(c => executeCode(c.toString, runtime))
    runtime
  }

  def executeCode(c: String, runtime: BrainfuckRuntime) = {
    if (c == ">") {
      runtime.moveCaretForward
    } else if (c == "<") {
      runtime.moveCaretBackward
    } else if (c == "+") {
      runtime.incMemory
    } else if (c == "-") {
      runtime.decrMemory
    } else if (c == ".") {
      runtime.printMemToANSIChar
    } else if (c == ",") {

    } else if (c == "[") {

    } else if (c == "]") {

    }
  }

}

