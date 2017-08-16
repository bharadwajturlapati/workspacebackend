package com.as.crosscuts;

import javax.servlet.ServletContext;

public class Trace {

  private ServletContext context;

  public Trace(ServletContext context) {
    this.context = context;
  }

  public boolean isTraceOn() {
    TraceConfig traceConfigObject = (TraceConfig)context.getAttribute("TraceConfig");
    return traceConfigObject.getIsenabled();
  }

  public void TraceAPI(TSM tsm) {
    /* Log to DB of file server. */
    if (isTraceOn()) {
      System.out.println(tsm.getDatetime() + " IN Component" + tsm.getWhichComponentTsmIn());
    }
  }
}
