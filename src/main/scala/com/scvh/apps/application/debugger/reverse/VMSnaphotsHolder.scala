package com.scvh.apps.application.debugger.reverse

import com.scvh.apps.application.interpreter.BrainfuckBundle
import org.springframework.stereotype.Component

import scala.collection.mutable.ListBuffer

@Component
class VMSnaphotsHolder {

  var snapshots = List[BrainfuckBundle]() //you can use Stack for these but i see no point.

  def pushSnapshot(snapshot: BrainfuckBundle) = {
    //buffer is much more cleaner and nicer than simly do +=
    val buffer = ListBuffer[BrainfuckBundle]()
    snapshots.map((bundle: BrainfuckBundle) => buffer += bundle)
    buffer += snapshot
    snapshots = buffer.result()
  }

  def revertSnapshot(): BrainfuckBundle = {
    val cached = snapshots(1)
    snapshots = snapshots.filter((bundle: BrainfuckBundle) => bundle == snapshots.head)
    cached
  }
}
