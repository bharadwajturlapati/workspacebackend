package com.as.api;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.as.wsf.docgen.TemplateGen;


@Path("/apidocgen")
public class ApiDocGenActions {
	@POST
	@Produces(MediaType.TEXT_HTML)
	public String post(String requestBody) {
		return TemplateGen.generateHTMLTemplate(requestBody, "api-docgen.vm");
	}
}
