/*
 * Copyright (c) 2017. scvh-man
 * Licence: http://www.gnu.org/licenses/gpl-3.0.en.html
 */

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

  def checkInput(input: Array[String]) = if (input == null) "" else input.mkString
}