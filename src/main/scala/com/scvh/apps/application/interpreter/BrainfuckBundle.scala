package com.scvh.apps.application.interpreter

import com.scvh.apps.application.interpreter.brainruntime.{BrainfuckLoopsParameters, BrainfuckMachineParameters, BrainfuckRuntime}

class BrainfuckBundle(val parameters: BrainfuckMachineParameters, val oneFrameMode: Boolean) {

  var runtime: BrainfuckRuntime = new BrainfuckRuntime
  var loops: BrainfuckLoopsParameters = new BrainfuckLoopsParameters
}
