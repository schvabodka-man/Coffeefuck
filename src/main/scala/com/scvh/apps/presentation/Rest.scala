package com.scvh.apps.presentation

import com.scvh.apps.application.brainresults.JsonAnswer
import org.springframework.web.bind.annotation.{RequestMapping, RequestParam, RestController}

@RestController
class Rest {

  @RequestMapping("/api")
  def restApi(@RequestParam("code") code : String) : JsonAnswer = {

    new JsonAnswer()
  }
}
