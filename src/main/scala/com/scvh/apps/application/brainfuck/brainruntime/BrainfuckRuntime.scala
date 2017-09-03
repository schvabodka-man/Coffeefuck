package com.scvh.apps.application.brainfuck.brainruntime

import org.springframework.stereotype.Component

@Component
class BrainfuckRuntime() {

  var memoryPoint = 0
  var output = ""
  var mem = new Array[Byte](65535)
  var duration: Long = 0

  def setupDurationOfExecution(duration: Long) = this.duration = duration

  def getCurrentMemBlock: Byte = mem(memoryPoint)

  def incMemory = mem.update(memoryPoint, (mem(memoryPoint) + 1).toByte)

  def decrMemory = mem.update(memoryPoint, (mem(memoryPoint) - 1).toByte)

  def moveCaretForward = memoryPoint = if (memoryPoint == mem.length - 1) 0 else memoryPoint + 1

  def moveCaretBackward = memoryPoint = if (memoryPoint == 0) mem.length - 1 else memoryPoint - 1

  def printMemToANSIChar = output = output + mem(memoryPoint).toChar

  def inputASCIIChar(char: Char) = mem.update(memoryPoint, char.toByte)
}
