package com.scvh.apps.presentetation.parsers

import com.scvh.apps.application.interpreter.BrainfuckBundle
import com.scvh.apps.application.interpreter.brainruntime.BrainfuckMachineParameters
import org.apache.commons.text.StringEscapeUtils
import org.springframework.stereotype.Component

@Component
class InputPrettifier {

  //TODO заменить на тюпл и почистить код
  def brainfuckPresent(params: List[String]): BrainfuckBundle = {
    params(2) match {
      case "GET" => new BrainfuckBundle(new BrainfuckMachineParameters(brainfuckSpellCheck(params.head), unescapeHtmlChars(params(1))), false)
      case "POST" => new BrainfuckBundle(new BrainfuckMachineParameters(brainfuckSpellCheck(params.head), params(1)), false)
    }
  }

  def brainfuckSpellCheck(code: String) = "[\\[\\].,+<>-]".r.findAllMatchIn(code).mkString

  def unescapeHtmlChars(code: String) = StringEscapeUtils.unescapeHtml3(code)

  //TODO перенести эту проверку в brainfuckPresent
  def checkInput(input: Array[String]) = if (input == null) "" else input.mkString
}