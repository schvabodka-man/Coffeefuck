package com.scvh.apps.application.brainfuck

import com.scvh.apps.application.brainfuck.brainruntime.{BrainfuckLoopsParameters, BrainfuckMachineParameters, BrainfuckRuntime}
import org.springframework.beans.factory.annotation.Autowired

class BrainfuckBundle(val parameters: BrainfuckMachineParameters) {
  var runtime: BrainfuckRuntime = new BrainfuckRuntime
  var loops: BrainfuckLoopsParameters = new BrainfuckLoopsParameters

  @Autowired
  def injRuntime(runtime: BrainfuckRuntime) = this.runtime = runtime

  @Autowired
  def injLoopParams(loops: BrainfuckLoopsParameters) = this.loops = loops
}
