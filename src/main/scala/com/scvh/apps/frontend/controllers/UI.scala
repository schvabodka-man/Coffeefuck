package com.scvh.apps.frontend.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class UI {

  @RequestMapping(Array("/"))
  def mainPage(model: Model): String = {
    nullModel(model)
    "index"
  }

  def nullModel(model: Model): Unit = {
    model.addAttribute("memoryCell", 0)
    model.addAttribute("cellValue", 0)
    model.addAttribute("time", 0)
  }

  @RequestMapping(Array("/debugger"))
  def debuggerPage(model: Model): String = {
    nullModel(model)
    "debugger"
  }
}
