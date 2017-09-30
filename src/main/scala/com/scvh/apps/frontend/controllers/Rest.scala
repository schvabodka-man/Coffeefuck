/*
 * Copyright (c) 2017. scvh-man
 * Licence: http://www.gnu.org/licenses/gpl-3.0.en.html
 */

package com.scvh.apps.frontend.controllers

import com.scvh.apps.frontend.json.JsonAnswer
import com.scvh.apps.frontend.wrappers.BrainfuckInterpreterFrontend
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{RequestMapping, RequestParam, RestController}

@RestController
class Rest {

  @Autowired
  var brainfuckRunner: BrainfuckInterpreterFrontend = _

  @RequestMapping(Array("/api/output"))
  def output(@RequestParam("app") app: String, @RequestParam(value = "input", required = false) list: Array[String]): JsonAnswer = {
    brainfuckRunner.runCode(app, list, 0)
  }

  @RequestMapping(Array("/api/vm"))
  def snapshot(@RequestParam("app") app: String, @RequestParam(value = "input", required = false) list: Array[String]): JsonAnswer = {
    brainfuckRunner.runCode(app, list, 1)
  }

  @RequestMapping(Array("/api/memory"))
  def memory(@RequestParam("app") app: String, @RequestParam(value = "input", required = false) list: Array[String]): JsonAnswer = {
    brainfuckRunner.runCode(app, list, 2)
  }

}
