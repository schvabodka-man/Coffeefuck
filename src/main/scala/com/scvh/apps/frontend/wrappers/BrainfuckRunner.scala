package com.scvh.apps.frontend.wrappers

import com.scvh.apps.application.interpreter.{BrainfuckBundle, BrainfuckInterpreter}
import com.scvh.apps.frontend.json.{JsonAnswer, JsonAnswerMemory, JsonAnswerOutput, JsonAnswerVM}
import com.scvh.apps.presentetation.parsers.InputPrettifier
import com.scvh.apps.presentetation.validation.BrainfuckCodeValidator
import org.springframework.beans.factory.annotation.{Autowired, Qualifier}
import org.springframework.stereotype.Component

@Component
class BrainfuckRunner {

  @Autowired
  var brainfuckInterpreter: BrainfuckInterpreter = _
  @Autowired
  var validationFacade: BrainfuckCodeValidator = _
  @Autowired
  var inputPrettifier: InputPrettifier = _

  //IMHO nice declarative way to get "static" pre-built shit. Better than doing getbean like pleb
  @Autowired
  @Qualifier("notEnoughArgs")
  var NOT_ENOUGH_ARGS_JSON: JsonAnswer = _

  def runCode(app: String, args: Array[String], flag: Int): JsonAnswer = {
    validateAndRun(inputPrettifier.brainfuckPresent(Map("app" -> app, "args" -> args, "frameMode" -> false)), flag)
  }

  private def validateAndRun(bundle: BrainfuckBundle, flag: Int): JsonAnswer = {
    val runtime = brainfuckInterpreter.brainfuckInterpreter(bundle).runtime
    validationFacade.brainfuckValidate(bundle.parameters) match {
      case 0 => flag match {
        case 0 => new JsonAnswerOutput(runtime.output, runtime.duration)
        case 1 => new JsonAnswerVM(runtime, bundle.parameters.programPosition, bundle.parameters.canIncrementAnyFurther)
        case 2 => new JsonAnswerMemory(runtime.mem, runtime.duration)
      }
      case 1 => NOT_ENOUGH_ARGS_JSON
    }
  }
}
