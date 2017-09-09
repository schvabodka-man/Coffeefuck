package com.scvh.apps.application.debugger

import com.scvh.apps.application.interpreter.BrainfuckBundle
import com.scvh.apps.presentetation.parsers.InputPrettifier
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope("session")
class DebuggerBundleBuilder {

  @Autowired
  var inputPrettifier: InputPrettifier = _

  def buildBundle(program: String, args: Array[String]): BrainfuckBundle = {
    //TODO просто допилить
    inputPrettifier.brainfuckPresent(program :: inputPrettifier.checkInput(args) :: "GET" :: Nil)
  }
}
