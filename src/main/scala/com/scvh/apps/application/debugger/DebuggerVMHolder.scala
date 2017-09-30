/*
 * Copyright (c) 2017. scvh-man
 * Licence: http://www.gnu.org/licenses/gpl-3.0.en.html
 */

package com.scvh.apps.application.debugger

import com.scvh.apps.application.interpreter.BrainfuckBundle
import org.springframework.stereotype.Component

/*
 * Holds current VM image
 */
@Component
class DebuggerVMHolder {

  var bundle: BrainfuckBundle = _

  def update(brainfuckBundle: BrainfuckBundle) = this.bundle = brainfuckBundle

}
