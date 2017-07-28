package com.scvh.apps.presentation

import com.scvh.apps.application.brainresults.JsonAnswer
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class UI {

  @RequestMapping(Array("/"))
  def mainPage(): String = {
    "index"
  }

  @RequestMapping(Array("/update"))
  def processingBrainfuck: JsonAnswer = {
    null
  }
}
