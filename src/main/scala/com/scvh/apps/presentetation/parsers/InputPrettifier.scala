package com.scvh.apps.presentetation.parsers

import com.scvh.apps.application.brainfuck.BrainfuckBundle
import com.scvh.apps.application.brainfuck.brainruntime.BrainfuckMachineParameters
import org.apache.commons.text.StringEscapeUtils

class InputPrettifier {
  def checkInput(input: Array[String]) = if (input == null) "" else input.mkString

  def brainfuckPresent(params: List[String]): BrainfuckBundle = {
    params(2) match {
      case "GET" => new BrainfuckBundle(new BrainfuckMachineParameters(brainfuckSpellCheck(params.head), unescapeHtmlChars(params(1))))
      case "POST" => new BrainfuckBundle(new BrainfuckMachineParameters(brainfuckSpellCheck(params.head), params(1)))
    }
  }

  def brainfuckSpellCheck(code: String) = "[\\[\\].,+<>-]".r.findAllMatchIn(code).mkString

  def unescapeHtmlChars(code: String) = StringEscapeUtils.unescapeHtml3(code)
}