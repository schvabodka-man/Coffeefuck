/*
 * Copyright (c) 2017. scvh-man
 * Licence: http://www.gnu.org/licenses/gpl-3.0.en.html
 */

package com.scvh.apps.spring.configs

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.springframework.stereotype.Component

/*
 * Generally Scala and Jackson don't go well, so there is hack to change that
 */
@Component
class JacksonScalaMapper extends ObjectMapper {
  {
    registerModule(DefaultScalaModule)
  }
}
