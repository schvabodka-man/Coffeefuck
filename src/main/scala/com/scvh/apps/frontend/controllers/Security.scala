package com.scvh.apps.frontend.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class Security {

  @RequestMapping(Array("/register"))
  def register(): String = {
    "security/register"
  }

  @RequestMapping(Array("/login"))
  def login(): String = {
    "security/login"
  }
}
