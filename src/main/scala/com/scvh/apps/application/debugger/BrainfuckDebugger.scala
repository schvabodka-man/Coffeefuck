package com.scvh.apps.application.debugger

import com.scvh.apps.application.debugger.reverse.VMSnaphotsHolder
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

  @Autowired
  var snapshotManager: VMSnaphotsHolder = _

  def init(program: String, input: Array[String]) = {
    vmImageHolder.update(bundleBuilder.buildBundle(program, input))
    step("next")
  }

  def step(command: String): BrainfuckBundle = {
    command match {
      case "prev" => snapshotManager.revertSnapshot()
      case "next" => stepNext
    }
  }

  private def stepNext: BrainfuckBundle = {
    vmImageHolder.update(interpreterManager.runFurther(vmImageHolder.bundle))
    snapshotManager.pushSnapshot(vmImageHolder.bundle.copy)
    vmImageHolder.bundle
  }

}
