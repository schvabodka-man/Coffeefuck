package com.scvh.apps.application.brainresults

class JsonAnswer(code : String*)

class JsonAnswerSuccess(stdout : String) extends JsonAnswer("200")

class JsonAnswerFault(code : String, explanation : String) extends JsonAnswer()