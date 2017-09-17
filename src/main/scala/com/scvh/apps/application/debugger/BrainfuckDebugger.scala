package com.scvh.apps.application.debugger

import com.scvh.apps.application.interpreter.BrainfuckBundle
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class BrainfuckDebugger {

  @Autowired
  var vmImageHolder: DebuggerVMHolder = _
  @Autowired
  var interpreterManager: DebuggerInterpreterManager = _
  @Autowired
  var bundleBuilder: DebuggerBundleBuilder = _

  def init(program: String, input: Array[String]) = {
    vmImageHolder.update(bundleBuilder.buildBundle(program, input))
    step("next")
  }

  def step(command: String): BrainfuckBundle = {
    command match {
      case "prev" => null //currently no logic for these
      case "next" => stepNext
    }
  }

  private def stepNext: BrainfuckBundle = {
    vmImageHolder.update(interpreterManager.runFurther(vmImageHolder.bundle))
    vmImageHolder.bundle
  }

}
