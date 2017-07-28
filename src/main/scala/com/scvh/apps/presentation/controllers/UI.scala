package com.scvh.apps.presentation.controllers

import com.scvh.apps.application.brainresults.JsonAnswer
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class UI {

  @RequestMapping(Array("/"))
  def mainPage(model: Model): String = {
    model.addAttribute("memoryCell", 0)
    model.addAttribute("cellValue", 0)
    model.addAttribute("stdout", "")
    "index"
  }

  @RequestMapping(Array("/update"))
  def processingBrainfuck: JsonAnswer = {
    null
  }
}
