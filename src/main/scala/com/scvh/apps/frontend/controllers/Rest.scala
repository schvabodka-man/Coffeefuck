package com.scvh.apps.frontend.controllers

import com.scvh.apps.frontend.{BrainfuckRunner, JsonAnswer}
import org.springframework.web.bind.annotation.{RequestMapping, RequestParam, RestController}

@RestController
class Rest {

  val brainfuckRunner = new BrainfuckRunner()

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
