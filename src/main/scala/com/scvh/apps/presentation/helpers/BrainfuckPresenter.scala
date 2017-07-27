package com.scvh.apps.presentation.helpers

import com.scvh.apps.application.brainruntime.{BrainfuckMachineParameters, BrainfuckRuntime}
import com.scvh.apps.application.{BrainfuckBundle, brainfuckInterpreter}

object brainfuckPresent extends (List[String] => BrainfuckRuntime) {
  override def apply(params: List[String]): BrainfuckRuntime = {
    params(2) match {
      case "GET" => brainfuckInterpreter(new BrainfuckBundle(new BrainfuckMachineParameters(brainfuckSpellCheck(params.head), unescapeHtmlChars(params(1)))))
      case "POST" => brainfuckInterpreter(new BrainfuckBundle(new BrainfuckMachineParameters(brainfuckSpellCheck(params.head), params(1))))
    }
  }
}
