package com.scvh.apps.spring.configs

import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.{AbstractWebSocketMessageBrokerConfigurer, EnableWebSocketMessageBroker, StompEndpointRegistry}

@Configuration
@EnableWebSocketMessageBroker
class WebsocketingConfig extends AbstractWebSocketMessageBrokerConfigurer {

  override def registerStompEndpoints(registry: StompEndpointRegistry) = {
    registry.addEndpoint("/debuginp")
    registry.addEndpoint("/debuginp").withSockJS()
  }

  1455

  override def configureMessageBroker(registry: MessageBrokerRegistry) = {
    registry.enableSimpleBroker("/debugout")
    registry.setApplicationDestinationPrefixes("/coffeedebugger")
  }
}
