/*
 * Copyright (c) 2017. scvh-man
 * Licence: http://www.gnu.org/licenses/gpl-3.0.en.html
 */

package com.scvh.apps.frontend.json

import com.scvh.apps.application.interpreter.brainruntime.BrainfuckRuntime

trait JsonAnswer

class JsonSuccess extends JsonAnswer {
  val code = 200
}

class JsonAnswerOutput(val stdout: String, val time: Long) extends JsonSuccess

class JsonAnswerMemory(val memory: Array[Byte], val time: Long) extends JsonSuccess

class JsonAnswerVM(val vm: BrainfuckRuntime, val programPoint: Int, val anyFurther: Boolean) extends JsonSuccess

class JsonAnswerFault(val code: Int, val explanation: String) extends JsonAnswer

class JsonDebuggerProtocol(val command: String, val app: String, val args: Array[String])