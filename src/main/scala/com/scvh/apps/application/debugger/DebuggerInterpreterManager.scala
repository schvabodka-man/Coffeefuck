package com.scvh.apps.application.debugger

import com.scvh.apps.application.interpreter.{BrainfuckBundle, BrainfuckInterpreter}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class DebuggerInterpreterManager {

  @Autowired
  var interpreter: BrainfuckInterpreter = _

  def runFurther(bundle: BrainfuckBundle): BrainfuckBundle = interpreter.brainfuckInterpreter(bundle)
}
