package com.scvh.apps.application

import com.scvh.apps.application.brainruntime.BrainfuckRuntime

object BrainfuckInterpreter extends (BrainfuckRuntime => BrainfuckRuntime) {
  override def apply(runtime: BrainfuckRuntime): BrainfuckRuntime = {
    val l = 0
    for (i <- 0 to runtime.programChars) {
      if (runtime.getProgramCharAtPoint(i) == ">") {

      } else if (runtime.getProgramCharAtPoint(i) == "<") {

      } else if (runtime.getProgramCharAtPoint(i) == "+") {
        runtime.incMemory()
      } else if (runtime.getProgramCharAtPoint(i) == "-") {
        runtime.decrMemory()
      } else if (runtime.getProgramCharAtPoint(i) == ".") {

      } else if (runtime.getProgramCharAtPoint(i) == ",") {

      } else if (runtime.getProgramCharAtPoint(i) == "[") {

      } else if (runtime.getProgramCharAtPoint(i) == "]") {

      }
    }
  }
}

