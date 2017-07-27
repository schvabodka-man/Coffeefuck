package com.scvh.apps.presentation.helpers

import org.apache.commons.text.StringEscapeUtils

object brainfuckSpellCheck extends (String => String) {
  def apply(code: String): String = "[\\[\\].,+<>-]".r.findAllMatchIn(code).mkString
}

object unescapeHtmlChars extends (String => String) {
  def apply(code: String): String = StringEscapeUtils.unescapeHtml3(code)
}

object checkInput extends (Array[String] => String) {
  def apply(input: Array[String]): String = if (input == null) "" else input.mkString
}