/*
 * Copyright (c) 2017. scvh-man
 * Licence: http://www.gnu.org/licenses/gpl-3.0.en.html
 */

package com.scvh.apps.presentetation.validation

import com.scvh.apps.application.interpreter.brainruntime.BrainfuckMachineParameters
import org.springframework.stereotype.Component

@Component
class BrainfuckCodeValidator {

  //now it's only checking for input
  def brainfuckValidate(things: BrainfuckMachineParameters): Int = {
    if (!isEnoughInput(things)) return 1
    0
  }

  def isEnoughInput(v1: BrainfuckMachineParameters): Boolean = "[,]".r.findAllMatchIn(v1.program).length == v1.args.length

}
