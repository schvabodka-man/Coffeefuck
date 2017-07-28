package com.scvh.apps.spring.beans

import com.scvh.apps.application.LoopParams
import com.scvh.apps.application.brainruntime.BrainfuckMachineParameters
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
