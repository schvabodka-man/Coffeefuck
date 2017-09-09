package com.scvh.apps.frontend.controllers

import com.scvh.apps.frontend.json.JsonAnswer
import com.scvh.apps.frontend.wrappers.BrainfuckRunner
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{RequestMapping, RequestParam, RestController}

@RestController
class Rest {

  @Autowired
  var brainfuckRunner: BrainfuckRunner = _

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
