package com.scvh.apps.presentetation.parsers

import com.scvh.apps.application.interpreter.BrainfuckBundle
import com.scvh.apps.application.interpreter.brainruntime.BrainfuckMachineParameters
import org.apache.commons.text.StringEscapeUtils
import org.springframework.stereotype.Component

@Component
class InputPrettifier {

  def brainfuckPresent(params: Map[String, Any]): BrainfuckBundle = {
    new BrainfuckBundle(new BrainfuckMachineParameters(brainfuckSpellCheck(params("app").asInstanceOf[String]), unescapeHtmlChars(checkInput(params("args").asInstanceOf[Array[String]]))), params("frameMode").asInstanceOf[Boolean])
  }

  def brainfuckSpellCheck(code: String) = "[\\[\\].,+<>-]".r.findAllMatchIn(code).mkString

  def unescapeHtmlChars(code: String) = StringEscapeUtils.unescapeHtml3(code)

  //TODO перенести эту проверку в brainfuckPresent
  def checkInput(input: Array[String]) = if (input == null) "" else input.mkString
}