package com.scvh.apps.frontend.controllers

import org.springframework.context.annotation.Scope
import org.springframework.messaging.handler.annotation.{MessageMapping, SendTo}
import org.springframework.stereotype.Controller

@Controller
@Scope("session")
class Websocketing {

  @MessageMapping("/input/debug")
  @SendTo("/output/debugger")
  def debuggerMapping(): Unit = {

  }
}
