package com.scvh.apps.application.brainfuck.brainruntime

import org.springframework.stereotype.Component

@Component
class BrainfuckLoopsParameters() {

  var looper = 0

  def isHigherThanZero: Boolean = looper > 0

  def increment = looper += 1

  def decrement = looper -= 1
}