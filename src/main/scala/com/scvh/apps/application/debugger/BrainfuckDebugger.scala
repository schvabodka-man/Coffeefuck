package com.scvh.apps.application.debugger

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope("session")
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

  def step(command: String) = {
    command match {
      case "prev" => //currently no logic for these
      case "next" => stepNext
    }
  }

  def stepNext = vmImageHolder.update(interpreterManager.runFurther(vmImageHolder.bundle))

}
