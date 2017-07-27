package com.scvh.apps

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.{EnableAutoConfiguration, SpringBootApplication}
import org.springframework.context.annotation.{ComponentScan, ImportResource}

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@ImportResource(Array("classpath:scala-jackson.xml"))
class CoffeeConfig

object CoffeeFuckApplication extends App {
  SpringApplication.run(classOf[CoffeeConfig])
}