package com.scvh.apps.application.brainresults

import com.scvh.apps.application.brainruntime.BrainfuckRuntime

class JsonAnswer(val code: String*)

class JsonAnswerOutput(val stdout: String) extends JsonAnswer("200")

class JsonAnswerMemory(val memory: Array[Byte]) extends JsonAnswer("200")

class JsonAnswerVM(val vm: BrainfuckRuntime) extends JsonAnswer("200")

class JsonAnswerFault(code: String, val explanation: String) extends JsonAnswer()