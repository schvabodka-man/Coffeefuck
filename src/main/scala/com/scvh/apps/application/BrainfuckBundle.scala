package com.scvh.apps.application

import com.scvh.apps.application.brainruntime.{BrainfuckLoopsParameters, BrainfuckMachineParameters, BrainfuckRuntime}

class BrainfuckBundle(val parameters: BrainfuckMachineParameters) {
  val runtime: BrainfuckRuntime = new BrainfuckRuntime()
  val loops: BrainfuckLoopsParameters = new BrainfuckLoopsParameters()
}
