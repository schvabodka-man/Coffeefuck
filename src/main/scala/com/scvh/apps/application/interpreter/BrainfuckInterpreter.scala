/*
 * Copyright (c) 2017. scvh-man
 * Licence: http://www.gnu.org/licenses/gpl-3.0.en.html
 */

package com.scvh.apps.application.interpreter

import com.scvh.apps.application.interpreter.brainruntime.{BrainfuckLoopsParameters, BrainfuckMachineParameters, BrainfuckRuntime}
import org.springframework.beans.factory.annotation.{Autowired, Qualifier}
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/*
 * The core class for everything. Interpreter itself
 */
@Component
@Scope("prototype")
class BrainfuckInterpreter {

  @Autowired
  @Qualifier("startLoop")
  var LOOP_STARTER: LoopParams = _
  @Autowired
  @Qualifier("finishLoop")
  var LOOP_FINISHER: LoopParams = _

  /*
   * Runs brainfuck code and returns result
   * @param bundle data bundle
   * @return result of calculation
   */
  def brainfuckInterpreter(bundle: BrainfuckBundle): BrainfuckBundle = {
    val t0 = System.nanoTime() //this is for getting time of execution
    interpBrainfuck(bundle.runtime, bundle.parameters, bundle.loops, bundle.oneFrameMode)
    bundle.runtime.setupDurationOfExecution(System.nanoTime() - t0)
    bundle
  }

  /*
 * Runs brainfuck code and returns result
 * @param runtime vm image
 * @param params machine parameters(program and args)
 * @param loopParams helper object for loops
 * @param oneFrameMode binary flag that detects if app runs in debug mode. If it is it will run only one iteration
 * @return result of calculation
 */
  def interpBrainfuck(runtime: BrainfuckRuntime, params: BrainfuckMachineParameters, loopsParams: BrainfuckLoopsParameters, oneFrameMode: Boolean): Unit = {
    params.retrieveProgramAtCurrentPosition match {
      case ">" => runtime.moveCaretForward
      case "<" => runtime.moveCaretBackward
      case "+" => runtime.incMemory
      case "-" => runtime.decrMemory
      case "." => runtime.printMemToANSIChar
      case "," => runtime.inputASCIIChar(params.readArg)
      case "[" =>
        if (runtime.getCurrentMemBlock == 0) {
          params.incrementPosition
          loop(loopsParams, params, LOOP_STARTER)
        }
      case "]" =>
        if (runtime.getCurrentMemBlock != 0) {
          params.lowerPosition
          loop(loopsParams, params, LOOP_FINISHER)
          params.lowerPosition
        }
    }
    params.incrementPosition
    if (!oneFrameMode) {
      if (params.canIncrementAnyFurther) {
        interpBrainfuck(runtime, params, loopsParams, oneFrameMode)
      }
    }
  }

  /*
   * Just loops for brainfuck code
   * @param looper helper object for loops
   * @param params vm parameters(program, input args)
   * @param loopParams loop type([ or ])
   */
  def loop(looper: BrainfuckLoopsParameters, params: BrainfuckMachineParameters, loopParams: LoopParams): Unit = {
    params.retrieveProgramAtCurrentPosition match {
      case loopParams.secBracket => looper.increment
      case loopParams.mainBracket => looper.decrement
      case default => //dindu nuffin
    }
    loopParams.callback(params)
    if (looper.isHigherThanZero || params.retrieveProgramAtCurrentPosition != loopParams.mainBracket) {
      loop(looper, params, loopParams)
    }
  }

}

/*
 * Class for describing two "directions" of loops
 */
class LoopParams(val mainBracket: String, val secBracket: String, val callback: (BrainfuckMachineParameters) => Unit)
