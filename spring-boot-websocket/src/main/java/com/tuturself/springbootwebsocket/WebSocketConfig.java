package com.tuturself.springbootwebsocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import java.util.List;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	/**
	 * Message broker to carry the messages back to the client on destinations prefixed with
	 * "/topic" and "/queue". "/app" prefix for messages that are bound for @MessageMapping-annotated
	 * methods in controller class. This prefix will be used to define all the message mappings; for
	 * example, "/app/message" is the endpoint that the WebSocketController.processMessageFromClient()
	 * method is mapped to handle
	 *
	 * @param config
	 */
	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableSimpleBroker("/topic/", "/queue/");
		config.setApplicationDestinationPrefixes("/app");
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/greeting").setAllowedOrigins("*");
	}

	@Override
	public void configureClientInboundChannel(ChannelRegistration channelRegistration) {
	}

	@Override
	public void configureClientOutboundChannel(ChannelRegistration channelRegistration) {
	}

	@Override
	public boolean configureMessageConverters(List<MessageConverter> arg0) {
		return true;
	}
}
