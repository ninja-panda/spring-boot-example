package com.tuturself.httpsintegration;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.apache.tomcat.websocket.server.WsSci;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.SpringServletContainerInitializer;

@Slf4j
@Configuration
public class TomcatEmbed extends SpringServletContainerInitializer {

	@Value("${server.port}")
	private Integer httpsPort;

	@Value("${server.http-port}")
	private Integer httpPort;

	@Bean
	public TomcatServletWebServerFactory servletContainer() {
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
			protected void postProcessContext(Context context) {
				SecurityConstraint securityConstraint = new SecurityConstraint();
				securityConstraint.setUserConstraint("CONFIDENTIAL");
				SecurityCollection collection = new SecurityCollection();
				collection.addPattern("/*");
				securityConstraint.addCollection(collection);
				context.addConstraint(securityConstraint);
			}
		};
		tomcat.addAdditionalTomcatConnectors(initiateHttpConnector());
		return tomcat;
	}

	private Connector initiateHttpConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setScheme("http");
		connector.setPort(httpPort);
		connector.setSecure(false);
		connector.setRedirectPort(httpsPort);
		return connector;
	}

	/**
	 * The following code is required only if you WebSocket endpoint
	 * in your application. We added it for some later example. You
	 * can omit this part if you don't have any WebSocket endpoint.
	 */
	@Bean
	public TomcatContextCustomizer tomcatContextCustomizer() {
		log.info("TOMCAT CONTEXT CUSTOMIZER INITIALIZED");
		return new TomcatContextCustomizer() {
			@Override
			public void customize(Context context) {
				context.addServletContainerInitializer(new WsSci(), null);
			}
		};
	}
}

