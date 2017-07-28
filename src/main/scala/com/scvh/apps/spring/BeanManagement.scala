package com.scvh.apps.spring

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext

object getBean extends (String => Unit) {
  override def apply(beanName: String): Unit = new ContextSource().applicationContext.getBean(beanName)
}

class ContextSource {
  @Autowired
  var applicationContext: ApplicationContext = _
}