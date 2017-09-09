package com.scvh.apps.spring.beans

import com.scvh.apps.application.interpreter.LoopParams
import com.scvh.apps.application.interpreter.brainruntime.BrainfuckMachineParameters
import org.springframework.context.annotation.{Bean, Configuration}

@Configuration
class BrainfuckParamsForLoops {

  @Bean
  def startLoop: LoopParams = new LoopParams("]", "[", (params: BrainfuckMachineParameters) => {
    params.incrementPosition
  })

  @Bean
  def finishLoop: LoopParams = new LoopParams("[", "]", (params: BrainfuckMachineParameters) => {
    params.lowerPosition
  })

}
