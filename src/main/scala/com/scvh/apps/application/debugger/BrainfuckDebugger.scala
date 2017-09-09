package com.scvh.apps.application.debugger

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope("session")
class BrainfuckDebugger {

  @Autowired
  var vmHolder: DebuggerVMHolder = _
  @Autowired
  var vmCleaner: DebuggerVMCleaner = _

  def init(program: String, input: Array[String]) {

  }

  def step(command: String) {
    command match {
      case "prev" => //currently no logic for these
      case "next" =>
    }
  }

}
