package com.scvh.apps.application.brainruntime

class BrainfuckMachineParameters(program: String) {
  var programPosition = 0

  def incrementPosition = programPosition += 1

  def lowerPosition = programPosition -= 1

  def retrieveProgramAtCurrentPosition: String = program.charAt(programPosition).toString

  def howManyChars: Int = program.length

  def canIncrementAnyFurther: Boolean = programPosition < program.length
}
