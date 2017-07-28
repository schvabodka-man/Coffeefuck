package com.scvh.apps.spring

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.springframework.stereotype.Component

@Component
class JacksonScalaMapper extends ObjectMapper {
  {
    registerModule(DefaultScalaModule)
  }
}
