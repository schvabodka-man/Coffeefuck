/*
 * Copyright (c) 2017. scvh-man
 * Licence: http://www.gnu.org/licenses/gpl-3.0.en.html
 */

package com.scvh.apps.application.debugger.reverse

import com.scvh.apps.application.interpreter.BrainfuckBundle
import org.springframework.stereotype.Component

import scala.collection.immutable.Stack

@Component
class VMSnaphotsHolder {

  var snapshots = Stack[BrainfuckBundle]()

  def pushSnapshot(snapshot: BrainfuckBundle) = {
    snapshots = snapshots.push(snapshot)
  }

  def revertSnapshot(): BrainfuckBundle = {
    val cached = snapshots.tail.head
    snapshots = snapshots.filter((bundle: BrainfuckBundle) => !(bundle == snapshots.head))
    cached
  }

  def canRevert(): Boolean = {
    if (snapshots.length == 1) {
      false
    } else {
      true
    }
  }
}
