package com.scvh.apps.application

import com.scvh.apps.application.brainruntime.BrainfuckRuntime

object BrainfuckInterpreter extends (BrainfuckRuntime => String) {
  override def apply(runtime: BrainfuckRuntime): String = ???
}

