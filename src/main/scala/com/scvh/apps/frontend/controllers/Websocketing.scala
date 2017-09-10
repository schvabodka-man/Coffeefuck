package com.scvh.apps.frontend.controllers

import org.springframework.context.annotation.Scope
import org.springframework.messaging.handler.annotation.{MessageMapping, SendTo}
import org.springframework.stereotype.Controller

@Controller
@Scope("session")
class Websocketing {

  @MessageMapping(Array("/input/debug"))
  @SendTo(Array("/output/debugger"))
  def debuggerMapping(): Unit = {

  }
}
