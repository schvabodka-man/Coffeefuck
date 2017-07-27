package com.scvh.apps.presentation.helpers

import org.apache.commons.text.StringEscapeUtils

object brainfuckSpellCheck extends (String => String) {
  private val REGEX = "[\\[\\].,+<>-]".r

  def apply(code: String): String = REGEX.findAllMatchIn(code).mkString
}

object unescapeHtmlChars extends (String => String) {
  def apply(code: String): String = StringEscapeUtils.unescapeHtml3(code)
}
