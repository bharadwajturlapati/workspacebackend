package com.as.api;

import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.io.IOUtils;

import com.as.crosscuts.TraceConfig;
import com.google.gson.Gson;

public class GlobalConfigContextListener implements ServletContextListener {

  private TraceConfig loadTracerIntoContext() {
    try {
      Gson gson = new Gson();
      byte[] tracerConfigContent = Files.readAllBytes(Paths.get("resources", "tracer.json"));
      TraceConfig tc = gson.fromJson(IOUtils.toString(tracerConfigContent, "UTF-8"),
          TraceConfig.class);
      return tc;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public void contextDestroyed(ServletContextEvent servletContextEvent) {
    ServletContext context = servletContextEvent.getServletContext();
    context.removeAttribute("TraceConfig");
  }

  public void contextInitialized(ServletContextEvent servletContextEvent) {
    ServletContext context = servletContextEvent.getServletContext();
    context.setAttribute("TraceConfig", loadTracerIntoContext());
  }

}
