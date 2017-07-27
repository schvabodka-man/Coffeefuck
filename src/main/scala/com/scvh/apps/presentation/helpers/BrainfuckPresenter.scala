package com.scvh.apps.presentation.helpers

import com.scvh.apps.application.BrainfuckBundle
import com.scvh.apps.application.brainruntime.BrainfuckMachineParameters

object brainfuckPresent extends (List[String] => BrainfuckBundle) {
  override def apply(params: List[String]): BrainfuckBundle = {
    params(2) match {
      case "GET" => new BrainfuckBundle(new BrainfuckMachineParameters(brainfuckSpellCheck(params.head), unescapeHtmlChars(params(1))))
      case "POST" => new BrainfuckBundle(new BrainfuckMachineParameters(brainfuckSpellCheck(params.head), params(1)))
    }
  }
}
