package com.as.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.as.utils.DateTimeUtil;

@Path("/health-check")
public class HealthCheck {

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String getHealthCheck() {
    String returnString = DateTimeUtil.getDateTimeString();
    return returnString;
  }
}
