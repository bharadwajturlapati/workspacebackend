package com.as.api;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;

import com.as.crosscuts.TSM;
import com.as.crosscuts.Trace;
import com.as.utils.DateTimeUtil;

public abstract class IAPIRuleSet {
  @Context
  private ServletContext context;

  public void callTrace(String component) {
    Trace trace = new Trace(context);
    trace.TraceAPI(new TSM(DateTimeUtil.getDateTimeString(), component));
  }
}
