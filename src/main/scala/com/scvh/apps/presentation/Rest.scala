package com.scvh.apps.presentation

import com.scvh.apps.application.brainresults.{JsonAnswer, JsonAnswerOutput}
import com.scvh.apps.presentation.helpers.brainfuckPresent
import org.springframework.web.bind.annotation.{RequestMapping, RequestParam, ResponseBody, RestController}

@RestController
class Rest {

  @RequestMapping(Array("/api/output"))
  @ResponseBody
  def output(@RequestParam("app") app: String, @RequestParam(value = "input", required = false) list: List[String]): JsonAnswer = {
    new JsonAnswerOutput(brainfuckPresent(app :: checkInput(list) :: "GET" :: Nil).output)
  }

  def checkInput(input: List[String]): String = if (input == null) "" else input.mkString

  @RequestMapping(Array("/api/vm"))
  @ResponseBody
  def snapshot(@RequestParam("app") app: String, @RequestParam(value = "input", required = false) list: List[String]): JsonAnswer = {
    null
  }

  @RequestMapping(Array("/api/memory"))
  @ResponseBody
  def memory(@RequestParam("app") app: String, @RequestParam(value = "input", required = false) list: List[String]): JsonAnswer = {
    null
  }
}
