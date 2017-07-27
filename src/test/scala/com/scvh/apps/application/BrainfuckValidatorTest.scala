package com.scvh.apps.application

import com.scvh.apps.presentation.helpers.brainfuckSpellCheck
import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(classOf[SpringRunner])
@SpringBootTest
class BrainfuckValidatorTest extends FlatSpec {

  private val BRAINFUCK_HELLO_WORLD = "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>."
  private val BRAINFUCK_HELLO_WORLD_WITH_STUFF = "+++++fdhfghgf+++++[gfdgdf>++++ffh+++>+hghsdfhgesdgghfds+++++ +++8746587451789654+>+gfdsgdf++45448dsfds>+<<<gdgfj<-]>++.>+.++sgdhf+++desfghjwaesrgj++..+++.>++.<<+++asfdgfh+++++++fsgdhf+++++.>.++sdgdh+.--adsdgh----.--afsgd------.>+.>."

  "String cleaner" should "Clean program from bullshit characters" in {
    val stringWithoutBullshit = brainfuckSpellCheck(BRAINFUCK_HELLO_WORLD_WITH_STUFF)
    assert(stringWithoutBullshit == BRAINFUCK_HELLO_WORLD)
  }
}
