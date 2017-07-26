package com.scvh.apps.application.brainruntime


class BrainfuckRuntime(program: String) {
  var memoryPoint = 0
  var output = ""
  var mem = new Array[Byte](65535)

  def retrieveProgram: String = program

  def getCurrentMemBlock: Byte = mem(memoryPoint)

  def incMemory = mem(memoryPoint) == mem(memoryPoint) + 1

  def decrMemory = mem(memoryPoint) == mem(memoryPoint) + 1

  def moveCaretForward = memoryPoint = if (memoryPoint == 65534) 0 else memoryPoint + 1

  def moveCaretBackward = memoryPoint = if (memoryPoint == 0) 65534 else memoryPoint - 1

  def printMemToANSIChar = output = output + String.valueOf(Character.toChars(mem(memoryPoint)))

}
