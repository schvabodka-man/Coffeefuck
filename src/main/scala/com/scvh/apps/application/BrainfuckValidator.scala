package com.scvh.apps.application

import com.scvh.apps.application.brainresults.ValidationFlag

object brainfuckSpellCheck extends (String => String) {
  private val REGEX = "[\\[\\].,+<>-]+".r
  def apply(code : String) : String = REGEX.findAllMatchIn(code).toString()
}

object brainfuckValidate extends (String => ValidationFlag) {
  def apply(code: String): ValidationFlag = {
    new ValidationFlag
  }
}