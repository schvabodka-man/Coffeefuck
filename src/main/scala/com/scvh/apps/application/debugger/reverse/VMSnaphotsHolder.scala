/*
 * Copyright (c) 2017. scvh-man
 * Licence: http://www.gnu.org/licenses/gpl-3.0.en.html
 */

package com.scvh.apps.application.debugger.reverse

import java.util

import com.scvh.apps.application.interpreter.BrainfuckBundle
import org.springframework.stereotype.Component

/*
 * Holds snapshots history for the app execution process
 */
@Component
class VMSnaphotsHolder {

  var snapshots = util.Stack[BrainfuckBundle]()

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
