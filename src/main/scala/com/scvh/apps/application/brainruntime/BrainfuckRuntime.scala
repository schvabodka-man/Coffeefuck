package com.scvh.apps.application.brainruntime


class BrainfuckRuntime(program: String) {
  val programChars = program.length
  var memoryPoint = 0
  var programPoint = 0
  var output = ""
  var mem = new Array[Byte](65535)

  def getProgramCharAtPoint(point: Int): String = program.charAt(point).toString

  def incMemory() = mem(memoryPoint) += 1

  def decrMemory() = mem(memoryPoint) -= 1

  def addToOutput(stdout: String) = {
    output = output + stdout
  }
}
