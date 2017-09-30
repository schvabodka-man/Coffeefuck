/*
 * Copyright (c) 2017. scvh-man
 * Licence: http://www.gnu.org/licenses/gpl-3.0.en.html
 */

package com.scvh.apps.application.debugger

import com.scvh.apps.application.debugger.reverse.VMSnaphotsHolder
import com.scvh.apps.application.interpreter.BrainfuckBundle
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/*
 * Debugger backend itself
 * Pretty neat
 */
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

  /*
   * Inject program and run one step at begin
   * @param proram app itself
   * @param input args for it
   */
  def init(program: String, input: Array[String]) = {
    vmImageHolder.update(bundleBuilder.buildBundle(program, input))
    step("next")
  }


  /*
   * Do one step
   * @param command debugger command
   * @return data bundle
   */
  def step(command: String): BrainfuckBundle = {
    command match {
      case "prev" => prevStep
      case "next" => stepNext
    }
  }

  private def stepNext: BrainfuckBundle = {
    vmImageHolder.update(interpreterManager.runFurther(vmImageHolder.bundle))
    snapshotManager.pushSnapshot(vmImageHolder.bundle.copy)
    vmImageHolder.bundle
  }

  private def prevStep: BrainfuckBundle = {
    if (snapshotManager.canRevert()) {
      vmImageHolder.update(snapshotManager.revertSnapshot())
      vmImageHolder.bundle
    } else {
      null //null instead of throwing for functional error handling without side effects
    }
  }

}
