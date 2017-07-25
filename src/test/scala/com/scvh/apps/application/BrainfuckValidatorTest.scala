package com.scvh.apps.application

import junit.framework.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(classOf[SpringRunner])
@SpringBootTest
class BrainfuckValidatorTest {

  private val BRAINFUCK_HELLO_WORLD = "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>."
  private val BRAINFUCK_HELLO_WORLD_WITH_STUFF = "+++++fdhfghgf+++++[gfdgdf>++++ffh+++>+hghsdfhgesdgghfds+++++ +++8746587451789654+>+gfdsgdf++45448dsfds>+<<<gdgfj<-]>++.>+.++sgdhf+++desfghjwaesrgj++..+++.>++.<<+++asfdgfh+++++++fsgdhf+++++.>.++sdgdh+.--adsdgh----.--afsgd------.>+.>."

  @Test
  def testCodeExtraction() {
    val test = brainfuckSpellCheck(BRAINFUCK_HELLO_WORLD)
    println(test)
  }
}
