package com.scvh.apps.presentation

import com.scvh.apps.application.brainresults._
import com.scvh.apps.application.{BrainfuckBundle, brainfuckInterpreter, brainfuckValidate}
import com.scvh.apps.presentation.helpers.{brainfuckPresent, checkInput}
import org.springframework.web.bind.annotation.{RequestMapping, RequestParam, RestController}

@RestController
class Rest {

  @RequestMapping(Array("/api/output"))
  def output(@RequestParam("app") app: String, @RequestParam(value = "input", required = false) list: Array[String]): JsonAnswer = {
    validateAndRun(brainfuckPresent(app :: checkInput(list) :: "GET" :: Nil), (bundle: BrainfuckBundle) => {
      new JsonAnswerOutput(brainfuckInterpreter(bundle).output)
    })
  }

  @RequestMapping(Array("/api/vm"))
  def snapshot(@RequestParam("app") app: String, @RequestParam(value = "input", required = false) list: Array[String]): JsonAnswer = {
    validateAndRun(brainfuckPresent(app :: checkInput(list) :: "GET" :: Nil), (bundle: BrainfuckBundle) => {
      new JsonAnswerVM(brainfuckInterpreter(bundle))
    })
  }

  def validateAndRun(bundle: BrainfuckBundle, callback: (BrainfuckBundle) => JsonAnswer): JsonAnswer = {
    brainfuckValidate(bundle.parameters) match {
      case 0 => callback(bundle)
      case 1 => new JsonAnswerFault(400, "Not enough args")
    }
  }

  @RequestMapping(Array("/api/memory"))
  def memory(@RequestParam("app") app: String, @RequestParam(value = "input", required = false) list: Array[String]): JsonAnswer = {
    validateAndRun(brainfuckPresent(app :: checkInput(list) :: "GET" :: Nil), (bundle: BrainfuckBundle) => {
      new JsonAnswerMemory(brainfuckInterpreter(bundle).mem)
    })
  }
}
