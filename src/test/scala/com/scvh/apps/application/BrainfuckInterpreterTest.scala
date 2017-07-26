package com.scvh.apps.application

import com.scvh.apps.application.brainruntime.BrainfuckRuntime
import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(classOf[SpringRunner])
@SpringBootTest
class BrainfuckInterpreterTest extends FlatSpec {

  private val BRAINFUCK_HELLO_WORLD = "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>."
  private val SIMPLE_BRAINFUCK_APP = "++++++++++++++++++++++++++++++++++++.>++++++++++++++++++++++++++++++++++++++++++.>+++++++++++++++++++++++++++++++++++--.<."

  "interpreter" should "run simple app without loops and input" in {
    assert(brainfuckInterpreter(new BrainfuckRuntime(SIMPLE_BRAINFUCK_APP)).output == "$*!*")
  }

  "interpeter" should "read input and print it" in {

  }

  "interpreter" should "execute hello world with loops" in {
    assert(brainfuckInterpreter(new BrainfuckRuntime(BRAINFUCK_HELLO_WORLD)).output == "Hello World!")
  }
}
