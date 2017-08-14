package com.scvh.apps.application

import com.scvh.apps.application.brainfuck.brainruntime.BrainfuckMachineParameters
import com.scvh.apps.application.brainfuck.{BrainfuckBundle, BrainfuckInterpreter}
import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(classOf[SpringRunner])
@SpringBootTest
class BrainfuckInterpreterTest extends FlatSpec {

  private val BRAINFUCK_HELLO_WORLD = "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>."
  private val SIMPLE_BRAINFUCK_APP = "++++++++++++++++++++++++++++++++++++.>++++++++++++++++++++++++++++++++++++++++++.>+++++++++++++++++++++++++++++++++++--.<."
  private val ONESIXFIVE_APP = ">+++++++++++[-<+++++++++++++++>]>++++++++++<<[->+>-[>+>>]>[+[-<+>]>+>>]<<<<<<]>>[-]>>>++++++++++<[->-[>+>>]>[+[-<+>]>+>>]<<<<<]>[-]>>[>++++++[-<++++++++>]<.<<+>+>[-]]<[<[->-<]++++++[->++++++++<]>.[-]]<<++++++[-<++++++++>]<.[-]<<[-<+>]"
  private val CAT_APP = ",.,."
  var brainfuck = BrainfuckInterpreter


  "interpreter" should "run simple app without loops and input" in {
    assert(brainfuck.brainfuckInterpreter(new BrainfuckBundle(new BrainfuckMachineParameters(SIMPLE_BRAINFUCK_APP, ""))).output == "$*!*")
  }

  "interpeter" should "read input and print it" in {
    assert(brainfuck.brainfuckInterpreter(new BrainfuckBundle(new BrainfuckMachineParameters(CAT_APP, "ab"))).output == "ab")
  }

  "interpreter" should "execute hello world with loops" in {
    assert(brainfuck.brainfuckInterpreter(new BrainfuckBundle(new BrainfuckMachineParameters(BRAINFUCK_HELLO_WORLD, ""))).output == "Hello World!\n")
  }

  "interpreter" should "print 165" in {
    assert(brainfuck.brainfuckInterpreter(new BrainfuckBundle(new BrainfuckMachineParameters(ONESIXFIVE_APP, ""))).output == "165")
  }
}
