package com.scvh.apps.frontend

import com.scvh.apps.application.brainfuck.brainruntime.BrainfuckRuntime

class JsonAnswer()

class JsonAnswerOutput(val stdout: String, val time: Long) extends JsonAnswer() {
  val code = 200
}

class JsonAnswerMemory(val memory: Array[Byte], val time: Long) extends JsonAnswer() {
  val code = 200
}

class JsonAnswerVM(val vm: BrainfuckRuntime) extends JsonAnswer() {
  val code = 200
}

class JsonAnswerFault(val code: Int, val explanation: String) extends JsonAnswer()