package com.scvh.apps.frontend

import com.scvh.apps.application.brainfuck.{BrainfuckBundle, BrainfuckInterpreter}
import com.scvh.apps.presentetation.parsers.InputPrettifier
import com.scvh.apps.presentetation.validation.BrainfuckCodeValidator
import org.springframework.stereotype.Component

@Component
class BrainfuckRunner {

  var brainfuckInterpreter = BrainfuckInterpreter
  var validationFacade: BrainfuckCodeValidator = new BrainfuckCodeValidator()
  var inputPrettifier: InputPrettifier = new InputPrettifier()

  def runCode(app: String, args: Array[String], flag: Int): JsonAnswer = {
    validateAndRun(inputPrettifier.brainfuckPresent(app :: inputPrettifier.checkInput(args) :: "GET" :: Nil), flag)
  }

  def validateAndRun(bundle: BrainfuckBundle, flag: Int): JsonAnswer = {
    val runtime = brainfuckInterpreter.brainfuckInterpreter(bundle).runtime
    validationFacade.brainfuckValidate(bundle.parameters) match {
      case 0 => flag match {
        case 0 => new JsonAnswerOutput(runtime.output, runtime.duration)
        case 1 => new JsonAnswerVM(runtime)
        case 2 => new JsonAnswerMemory(runtime.mem, runtime.duration)
      }
      case 1 => new JsonAnswerFault(400, "Not enough args")
    }
  }
}
