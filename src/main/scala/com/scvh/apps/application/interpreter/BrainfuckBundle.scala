/*
 * Copyright (c) 2017. scvh-man
 * Licence: http://www.gnu.org/licenses/gpl-3.0.en.html
 */

package com.scvh.apps.application.interpreter

import com.rits.cloning.Cloner
import com.scvh.apps.application.interpreter.brainruntime.{BrainfuckLoopsParameters, BrainfuckMachineParameters, BrainfuckRuntime}

/*
 * Class holding objects needed to run interpreter
 */
class BrainfuckBundle(val parameters: BrainfuckMachineParameters, val oneFrameMode: Boolean) {

  var runtime: BrainfuckRuntime = new BrainfuckRuntime
  var loops: BrainfuckLoopsParameters = new BrainfuckLoopsParameters

  /*
   * Function for deep cloning this object(needed to store states in debugger)
   * @return same object deep cloned
   */
  def copy: BrainfuckBundle = {
    val cloner = new Cloner()
    cloner.deepClone(this)
  }

}
