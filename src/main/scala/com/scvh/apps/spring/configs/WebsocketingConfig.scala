package com.scvh.apps.spring.configs

import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.{AbstractWebSocketMessageBrokerConfigurer, EnableWebSocketMessageBroker, StompEndpointRegistry}

@Configuration
@EnableWebSocketMessageBroker
class WebsocketingConfig extends AbstractWebSocketMessageBrokerConfigurer {

  override def registerStompEndpoints(registry: StompEndpointRegistry): Unit = {
    registry.addEndpoint("/debuginp")
    registry.addEndpoint("/debuginp").withSockJS()
  }

  override def configureMessageBroker(registry: MessageBrokerRegistry): Unit = {
    registry.enableSimpleBroker("/debugout")
    registry.setApplicationDestinationPrefixes("/coffeedebugger")
  }
}
