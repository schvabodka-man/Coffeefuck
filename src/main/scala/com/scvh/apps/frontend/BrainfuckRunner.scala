package com.scvh.apps.frontend

import com.scvh.apps.application.brainfuck.{BrainfuckBundle, BrainfuckInterpreter}
import com.scvh.apps.presentetation.parsers.InputPrettifier
import com.scvh.apps.presentetation.validation.ValidationFacade
import org.springframework.stereotype.Component

@Component
class BrainfuckRunner {

  var brainfuckInterpreter: BrainfuckInterpreter = new BrainfuckInterpreter()
  var validationFacade: ValidationFacade = new ValidationFacade()
  var inputPrettifier: InputPrettifier = new InputPrettifier()

  def runCode(app: String, args: Array[String], flag: Int): JsonAnswer = {
    validateAndRun(inputPrettifier.brainfuckPresent(app :: inputPrettifier.checkInput(args) :: "GET" :: Nil), flag)
  }

  def validateAndRun(bundle: BrainfuckBundle, flag: Int): JsonAnswer = {
    validationFacade.brainfuckValidate(bundle.parameters) match {
      case 0 => flag match {
        case 0 => new JsonAnswerOutput(brainfuckInterpreter.brainfuckInterpreter(bundle).output)
        case 1 => new JsonAnswerVM(brainfuckInterpreter.brainfuckInterpreter(bundle))
        case 2 => new JsonAnswerMemory(brainfuckInterpreter.brainfuckInterpreter(bundle).mem)
      }
      case 1 => new JsonAnswerFault(400, "Not enough args")
    }
  }
}
