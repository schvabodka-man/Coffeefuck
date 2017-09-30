/*
 * Copyright (c) 2017. scvh-man
 * Licence: http://www.gnu.org/licenses/gpl-3.0.en.html
 */

package com.scvh.apps.spring.configs

import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.{AbstractWebSocketMessageBrokerConfigurer, EnableWebSocketMessageBroker, StompEndpointRegistry}

/*
 * Just Spring config for websocketing
 */
@Configuration
@EnableWebSocketMessageBroker
class WebsocketingConfig extends AbstractWebSocketMessageBrokerConfigurer {

  override def registerStompEndpoints(registry: StompEndpointRegistry) = {
    registry.addEndpoint("/debuginp")
    registry.addEndpoint("/debuginp").withSockJS()
  }

  override def configureMessageBroker(registry: MessageBrokerRegistry) = {
    registry.enableSimpleBroker("/debugout")
    registry.setApplicationDestinationPrefixes("/coffeedebugger")
  }
}
