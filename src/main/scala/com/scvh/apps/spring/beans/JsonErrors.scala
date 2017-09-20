/*
 * Copyright (c) 2017. scvh-man
 * Licence: http://www.gnu.org/licenses/gpl-3.0.en.html
 */

package com.scvh.apps.spring.beans

import com.scvh.apps.frontend.json.{JsonAnswer, JsonAnswerFault}
import org.springframework.context.annotation.{Bean, Configuration}

@Configuration
class JsonErrors {

  @Bean
  def notEnoughArgs: JsonAnswer = {
    new JsonAnswerFault(400, "Not enough args")
  }

  @Bean
  def userPlayingWithJs: JsonAnswer = {
    new JsonAnswerFault(400, "Stop playing with protocol")
  }

  @Bean
  def cannotDecrementAnyFurther: JsonAnswer = {
    new JsonAnswerFault(400, "Can't decrement")
  }
}
