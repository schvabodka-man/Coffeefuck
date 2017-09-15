package com.scvh.apps.frontend.wrappers

import com.scvh.apps.application.debugger.BrainfuckDebugger
import com.scvh.apps.application.interpreter.brainruntime.BrainfuckRuntime
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
      case "init" => constructAnswer(debuggerBackend.init(jsonInput.app, jsonInput.args))
      case default => USER_BREAKING_STUFF
    }
  }

  def constructAnswer(brainfuckRuntime: BrainfuckRuntime): JsonAnswerVM = {
    new JsonAnswerVM(brainfuckRuntime)
  }
}
