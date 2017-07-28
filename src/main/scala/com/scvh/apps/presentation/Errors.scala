package com.scvh.apps.presentation

import javax.servlet.http.HttpServletRequest

import org.springframework.boot.autoconfigure.web.ErrorController
import org.springframework.stereotype.Controller

@Controller
class Errors extends ErrorController {
  override def getErrorPath: String = "/error"

  @Controller(Array("/error"))
  def errorHandler(request: HttpServletRequest): String = {

  }
}
