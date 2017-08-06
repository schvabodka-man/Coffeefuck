package com.scvh.apps.application

import com.scvh.apps.presentetation.parsers.InputPrettifier
import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(classOf[SpringRunner])
@SpringBootTest
class BrainfuckPrettifierTest extends FlatSpec {

  private val prettyInput = new InputPrettifier()

  private val BRAINFUCK_HELLO_WORLD = "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>."
  private val BRAINFUCK_HELLO_WORLD_WITH_STUFF = "+++++fdhfghgf+++++[gfdgdf>++++ffh+++>+hghsdfhgesdgghfds+++++ +++8746587451789654+>+gfdsgdf++45448dsfds>+<<<gdgfj<-]>++.>+.++sgdhf+++desfghjwaesrgj++..+++.>++.<<+++asfdgfh+++++++fsgdhf+++++.>.++sdgdh+.--adsdgh----.--afsgd------.>+.>."

  private val BRAINFUCK_APP_ESCAPED = "%2B%2B%2B%2B%2B%2B%2B.%3E%2B%2B%2B%2B%2B%2B."
  private val BRAINFUCK_APP_UNESCAPED = "+++++++.>++++++."
  private val BRAINFUCK_INPUT_STRING = "ab"
  private var BRAINFUCK_INPUT_ARRAY = new Array[String](2)

  "Prettifier" should "Clean program from bullshit characters" in {
    val stringWithoutBullshit = prettyInput.brainfuckSpellCheck(BRAINFUCK_HELLO_WORLD_WITH_STUFF)
    assert(stringWithoutBullshit == BRAINFUCK_HELLO_WORLD)
  }

  "Prettifier" should "Decode url string" in {
    val stringWithoutBullshit = prettyInput.unescapeHtmlChars(BRAINFUCK_APP_ESCAPED)
    assert(stringWithoutBullshit == BRAINFUCK_APP_UNESCAPED)
  }

  "Prettifier" should "Convert array to string" in {
    BRAINFUCK_INPUT_ARRAY.update(0, "a")
    BRAINFUCK_INPUT_ARRAY.update(1, "b")
    val nonArray = prettyInput.checkInput(BRAINFUCK_INPUT_ARRAY)
    assert(nonArray == BRAINFUCK_INPUT_STRING)
  }
}
