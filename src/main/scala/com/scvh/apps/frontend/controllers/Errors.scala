/*
 * Copyright (c) 2017. scvh-man
 * Licence: http://www.gnu.org/licenses/gpl-3.0.en.html
 */

package com.scvh.apps.frontend.controllers

import javax.servlet.http.HttpServletRequest

import org.springframework.boot.autoconfigure.web.ErrorController
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod}

@Controller
class Errors extends ErrorController {

  @RequestMapping(value = Array("/error"), method = Array(RequestMethod.GET))
  def error(httpRequest: HttpServletRequest, model: Model): String = {
    httpRequest.getAttribute("javax.servlet.error.status_code").asInstanceOf[Int] match {
      case 404 => model.addAttribute("code", 404); model.addAttribute("text", "Not found")
      case 400 => model.addAttribute("code", 400); model.addAttribute("text", "Bad request")
      case 403 => model.addAttribute("code", 403); model.addAttribute("text", "Forbidden")
      case 500 => model.addAttribute("code", 500); model.addAttribute("text", "Internal error")
      case default => model.addAttribute("code", 500); model.addAttribute("text", "Internal error")
    }
    "error"
  }

  override def getErrorPath: String = "/error"
}
