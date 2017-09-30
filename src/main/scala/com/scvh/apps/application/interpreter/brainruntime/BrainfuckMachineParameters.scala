/*
 * Copyright (c) 2017. scvh-man
 * Licence: http://www.gnu.org/licenses/gpl-3.0.en.html
 */

package com.scvh.apps.application.interpreter.brainruntime

/*
 * Holder for program and arguments
 */
class BrainfuckMachineParameters(val program: String, val args: String) {
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

  /*
   * Test if you can proceed further in execution
   */
  def canIncrementAnyFurther: Boolean = programPosition < program.length
}
