/*
 * Copyright (c) 2017. scvh-man
 * Licence: http://www.gnu.org/licenses/gpl-3.0.en.html
 */

package com.scvh.apps.application.interpreter.brainruntime

import org.springframework.stereotype.Component

/*
 * Class holding params for current loop process
 */
@Component
class BrainfuckLoopsParameters {

  var looper = 0

  def isHigherThanZero: Boolean = looper > 0

  def increment = looper += 1

  def decrement = looper -= 1

}
