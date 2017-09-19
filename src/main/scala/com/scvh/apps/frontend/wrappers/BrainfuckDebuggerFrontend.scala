package com.scvh.apps.frontend.wrappers

import com.scvh.apps.application.debugger.BrainfuckDebugger
import com.scvh.apps.application.interpreter.BrainfuckBundle
import com.scvh.apps.frontend.json.{JsonAnswer, JsonAnswerVM, JsonDebuggerProtocol}
import org.springframework.beans.factory.annotation.{Autowired, Qualifier}
import org.springframework.stereotype.Component

@Component
class BrainfuckDebuggerFrontend {

  @Autowired
  var debuggerBackend: BrainfuckDebugger = _

  @Autowired
  @Qualifier("userPlayingWithJs")
  var USER_BREAKING_STUFF: JsonAnswer = _

  def debug(jsonInput: JsonDebuggerProtocol): JsonAnswer = {
    jsonInput.command match {
      case "next" => constructAnswer(debuggerBackend.step("next"))
      case "prev" => constructAnswer(debuggerBackend.step("prev"))
      case "init" => constructAnswer(debuggerBackend.init(jsonInput.app, jsonInput.args))
      case default => USER_BREAKING_STUFF
    }
  }

  def constructAnswer(bundle: BrainfuckBundle): JsonAnswerVM = {
    new JsonAnswerVM(bundle.runtime, bundle.parameters.programPosition, bundle.parameters.canIncrementAnyFurther)
  }
}
