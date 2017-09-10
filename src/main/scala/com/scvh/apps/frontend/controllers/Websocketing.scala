package com.scvh.apps.frontend.controllers

import com.scvh.apps.frontend.wrappers.BrainfuckDebuggerFrontend
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.messaging.handler.annotation.{MessageMapping, SendTo}
import org.springframework.stereotype.Controller

@Controller
@Scope("session")
class Websocketing {

  @Autowired
  var debugger: BrainfuckDebuggerFrontend = _

  @MessageMapping(Array("/input/debug"))
  @SendTo(Array("/output/debugger"))
  def debuggerMapping(): Unit = {

  }
}
