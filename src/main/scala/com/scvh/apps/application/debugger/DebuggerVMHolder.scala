package com.scvh.apps.application.debugger

import com.scvh.apps.application.interpreter.BrainfuckBundle
import org.springframework.stereotype.Component

@Component
class DebuggerVMHolder {

  var bundle: BrainfuckBundle = _

  def update(brainfuckBundle: BrainfuckBundle) = this.bundle = brainfuckBundle

}
