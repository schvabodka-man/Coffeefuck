/*
 * Copyright (c) 2017. scvh-man
 * Licence: http://www.gnu.org/licenses/gpl-3.0.en.html
 */

package com.scvh.apps.application.debugger

import com.scvh.apps.application.interpreter.{BrainfuckBundle, BrainfuckInterpreter}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/*
 * Managing interpreter for debugger
 */
@Component
class DebuggerInterpreterManager {

  @Autowired
  var interpreter: BrainfuckInterpreter = _

  /*
   * Runs one step
   * @param bundle brainfuck interpreter bundle
   * @return result
   */
  def runFurther(bundle: BrainfuckBundle): BrainfuckBundle = interpreter.brainfuckInterpreter(bundle)
}
