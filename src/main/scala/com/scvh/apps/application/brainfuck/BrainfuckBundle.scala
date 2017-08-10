package com.scvh.apps.application.brainfuck

import com.scvh.apps.application.brainfuck.brainruntime.{BrainfuckLoopsParameters, BrainfuckMachineParameters, BrainfuckRuntime}

class BrainfuckBundle(val parameters: BrainfuckMachineParameters) {

  var runtime: BrainfuckRuntime = new BrainfuckRuntime()
  var loops: BrainfuckLoopsParameters = new BrainfuckLoopsParameters()
}
