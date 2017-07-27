package com.scvh.apps.application.brainresults

import com.scvh.apps.application.brainruntime.BrainfuckRuntime

class JsonAnswer()

class JsonAnswerOutput(val stdout: String) extends JsonAnswer() {
  val code = 200
}

class JsonAnswerMemory(val memory: Array[Byte]) extends JsonAnswer() {
  val code = 200
}

class JsonAnswerVM(val vm: BrainfuckRuntime) extends JsonAnswer() {
  val code = 200
}

class JsonAnswerFault(val code: Int, val explanation: String) extends JsonAnswer()