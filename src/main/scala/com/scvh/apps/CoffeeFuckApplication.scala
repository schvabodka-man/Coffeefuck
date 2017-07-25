package com.scvh.apps

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.{EnableAutoConfiguration, SpringBootApplication}
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
class CoffeeConfig

object CoffeeFuckApplication extends App {
  SpringApplication.run(classOf[CoffeeConfig])
}