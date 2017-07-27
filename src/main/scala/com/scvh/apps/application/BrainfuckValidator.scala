package com.scvh.apps.application

import com.scvh.apps.application.brainruntime.BrainfuckMachineParameters

object brainfuckValidate extends (BrainfuckMachineParameters => Int) {
  def apply(things: BrainfuckMachineParameters): Int = {
    if (!isEnoughInput(things)) return 1
    0
  }
}

object isEnoughInput extends (BrainfuckMachineParameters => Boolean) {
  override def apply(v1: BrainfuckMachineParameters): Boolean = "[,]".r.findAllMatchIn(v1.program).length == v1.args.length
}