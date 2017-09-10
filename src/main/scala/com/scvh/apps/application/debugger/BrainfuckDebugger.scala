package com.scvh.apps.application.debugger

import com.scvh.apps.application.interpreter.brainruntime.BrainfuckRuntime
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

  def step(command: String): BrainfuckRuntime = {
    command match {
      case "prev" => null //currently no logic for these
      case "next" => stepNext
    }
  }

  private def stepNext: BrainfuckRuntime = {
    vmImageHolder.update(interpreterManager.runFurther(vmImageHolder.bundle))
    vmImageHolder.bundle.runtime
  }

}
