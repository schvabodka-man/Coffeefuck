package com.scvh.apps.application.brainruntime


class BrainfuckRuntime(program: String) {
  var memoryPoint = 0
  var output = ""
  var mem = new Array[Byte](65535)

  def retrieveProgram: String = program

  def getCurrentMemBlock: Byte = mem(memoryPoint)

  def incMemory = mem.update(memoryPoint, (mem(memoryPoint) + 1).toByte)

  def decrMemory = mem.update(memoryPoint, (mem(memoryPoint) - 1).toByte)

  def moveCaretForward = memoryPoint = if (memoryPoint == 65534) 0 else memoryPoint + 1

  def moveCaretBackward = memoryPoint = if (memoryPoint == 0) 65534 else memoryPoint - 1

  def printMemToANSIChar = output = output + String.valueOf(Character.toChars(mem(memoryPoint)))

}
