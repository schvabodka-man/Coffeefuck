package com.scvh.apps.spring.beans

import com.scvh.apps.frontend.json.{JsonAnswer, JsonAnswerFault}
import org.springframework.context.annotation.{Bean, Configuration}

@Configuration
class JsonErrors {

  @Bean
  def notEnoughArgs(): JsonAnswer = {
    new JsonAnswerFault(400, "Not enough args")
  }
}
