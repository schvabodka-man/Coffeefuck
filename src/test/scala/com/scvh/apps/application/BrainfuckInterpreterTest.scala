package com.scvh.apps.application

import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(classOf[SpringRunner])
@SpringBootTest
class BrainfuckInterpreterTest extends FlatSpec {

  private val BRAINFUCK_HELLO_WORLD = "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>."

  "interpreter" should "run hello world" in {

  }
}
