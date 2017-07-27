package com.scvh.apps.application

import com.scvh.apps.application.brainresults.ValidationFlag

object brainfuckValidate extends (String => ValidationFlag) {
  def apply(code: String): ValidationFlag = {
    new ValidationFlag
  }
}