package com.as.server;

import org.glassfish.jersey.server.ResourceConfig;

public class WorkspaceApp extends ResourceConfig {
  public WorkspaceApp() {
    packages("com.as.api");
  }
}
