package com.as.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.as.utils.DateTimeUtil;
import com.as.utils.ServerConstants;

@Path("health-check")
public class HealthCheck extends IAPIRuleSet {

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String getHealthCheck() {

    callTrace(ServerConstants.HEALTHCHECKCOMPONENT);

    String returnString = DateTimeUtil.getDateTimeString();

    callTrace(ServerConstants.HEALTHCHECKCOMPONENT);

    return returnString;
  }
}
