package com.as.application;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

@ApplicationPath("/")
public class ServicesApp extends ResourceConfig {
	public ServicesApp() {
		packages("com.as.api");

		// Register my custom provider - not needed if it's in my.package.
		// register(SecurityRequestFilter.class);
		// Register an instance of LoggingFilter.
		// register(new LoggingFilter(LOGGER, true));

		// Enable Tracing support.
		property(ServerProperties.TRACING, "ALL");
	}
}
