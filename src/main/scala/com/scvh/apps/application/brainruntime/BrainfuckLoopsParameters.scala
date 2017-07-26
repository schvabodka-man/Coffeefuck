package com.scvh.apps.application.brainruntime

class BrainfuckLoopsParameters() {

  var looper = 0

  def isHigherThanZero: Boolean = looper > 0

  def increment = looper += 1

  def decrement = looper -= 1
}
