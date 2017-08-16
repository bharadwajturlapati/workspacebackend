package com.as.server;

import static org.fest.assertions.api.Assertions.assertThat;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import com.as.crosscuts.TraceConfig;
import com.google.gson.Gson;

public class GlobalConfigTest {
  private Map<String, Object> context = new HashMap<String, Object>();

  @Test
  public void testTraceConfigSerialization() {
    // loadTracerIntoContext method cloned .. GloalConfig.java
    loadTracerIntoContext();
    TraceConfig tc = (TraceConfig)context.get("TraceConfig");
    assertThat(tc.getIsenabled()).isEqualTo(false);
  }

  private void loadTracerIntoContext() {
    try {
      Gson gson = new Gson();
      byte[] tracerConfigContent = Files.readAllBytes(Paths.get("resources", "tracer.json"));
      TraceConfig tc = gson.fromJson(IOUtils.toString(tracerConfigContent, "UTF-8"),
          TraceConfig.class);
      context.put("TraceConfig", tc);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
