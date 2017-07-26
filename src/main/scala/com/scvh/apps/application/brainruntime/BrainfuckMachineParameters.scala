package com.scvh.apps.application.brainruntime

class BrainfuckMachineParameters(program: String, args: String) {
  var programPosition = 0
  var argPosition = 0

  def readArg: Char = {
    val arg = args.charAt(argPosition)
    argPosition += 1
    arg
  }

  def incrementPosition = programPosition += 1

  def lowerPosition = programPosition -= 1

  def retrieveProgramAtCurrentPosition: String = program.charAt(programPosition).toString

  def howManyChars: Int = program.length

  def canIncrementAnyFurther: Boolean = programPosition < program.length
}
