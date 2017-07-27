package com.scvh.apps.application.brainresults

import com.scvh.apps.application.brainruntime.BrainfuckRuntime

class JsonAnswer(code : String*)

class JsonAnswerOutput(stdout: String) extends JsonAnswer("200")

class JsonAnswerMemory(memory: Array[Byte]) extends JsonAnswer("200")

class JsonAnswerVM(vm: BrainfuckRuntime) extends JsonAnswer("200")

class JsonAnswerFault(code : String, explanation : String) extends JsonAnswer()