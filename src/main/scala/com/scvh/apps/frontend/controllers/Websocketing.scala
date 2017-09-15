package com.scvh.apps.frontend.controllers

import com.scvh.apps.frontend.json.{JsonAnswer, JsonDebuggerProtocol}
import com.scvh.apps.frontend.wrappers.BrainfuckDebuggerFrontend
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.handler.annotation.{MessageMapping, SendTo}
import org.springframework.stereotype.Controller

@Controller
class Websocketing {

  @Autowired
  var debugger: BrainfuckDebuggerFrontend = _

  @MessageMapping(Array("/debuginp"))
  @SendTo(Array("/debugout"))
  def debuggerMapping(input: JsonDebuggerProtocol): JsonAnswer = {
    debugger.debug(input)
  }
}
