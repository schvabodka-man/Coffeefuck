/*
 * Copyright (c) 2017. scvh-man
 * Licence: http://www.gnu.org/licenses/gpl-3.0.en.html
 */

package com.scvh.apps.application

import com.scvh.apps.application.interpreter.brainruntime.BrainfuckMachineParameters
import com.scvh.apps.application.interpreter.{BrainfuckBundle, BrainfuckInterpreter}
import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(classOf[SpringRunner])
@SpringBootTest
class BrainfuckInterpreterTest extends FlatSpec {

  private val BRAINFUCK_HELLO_WORLD = "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>."
  private val SIMPLE_BRAINFUCK_APP = "++++++++++++++++++++++++++++++++++++.>++++++++++++++++++++++++++++++++++++++++++.>+++++++++++++++++++++++++++++++++++--.<."
  private val ONESIXFIVE_APP = ">+++++++++++[-<+++++++++++++++>]>++++++++++<<[->+>-[>+>>]>[+[-<+>]>+>>]<<<<<<]>>[-]>>>++++++++++<[->-[>+>>]>[+[-<+>]>+>>]<<<<<]>[-]>>[>++++++[-<++++++++>]<.<<+>+>[-]]<[<[->-<]++++++[->++++++++<]>.[-]]<<++++++[-<++++++++>]<.[-]<<[-<+>]"
  private val CAT_APP = ",.,."

  @Autowired
  var brainfuck: BrainfuckInterpreter = _

  "interpreter" should "run simple app without loops and input" in {
    assert(brainfuck.brainfuckInterpreter(new BrainfuckBundle(new BrainfuckMachineParameters(SIMPLE_BRAINFUCK_APP, ""), false)).runtime.output == "$*!*")
  }

  "interpeter" should "read input and print it" in {
    assert(brainfuck.brainfuckInterpreter(new BrainfuckBundle(new BrainfuckMachineParameters(CAT_APP, "ab"), false)).runtime.output == "ab")
  }

  "interpreter" should "execute hello world with loops" in {
    assert(brainfuck.brainfuckInterpreter(new BrainfuckBundle(new BrainfuckMachineParameters(BRAINFUCK_HELLO_WORLD, ""), false)).runtime.output == "Hello World!\n")
  }

  "interpreter" should "print 165" in {
    assert(brainfuck.brainfuckInterpreter(new BrainfuckBundle(new BrainfuckMachineParameters(ONESIXFIVE_APP, ""), false)).runtime.output == "165")
  }
}
