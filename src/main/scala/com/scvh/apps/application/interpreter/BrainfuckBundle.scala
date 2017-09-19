package com.scvh.apps.application.interpreter

import com.rits.cloning.Cloner
import com.scvh.apps.application.interpreter.brainruntime.{BrainfuckLoopsParameters, BrainfuckMachineParameters, BrainfuckRuntime}

class BrainfuckBundle(val parameters: BrainfuckMachineParameters, val oneFrameMode: Boolean) {

  var runtime: BrainfuckRuntime = new BrainfuckRuntime
  var loops: BrainfuckLoopsParameters = new BrainfuckLoopsParameters

  def copy: BrainfuckBundle = {
    val cloner = new Cloner()
    cloner.deepClone(this)
  }

}
