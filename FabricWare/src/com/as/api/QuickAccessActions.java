package com.as.api;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.as.jdbc.QuickAccessDataSourceHelper;

@Path("/quickaccess")
public class QuickAccessActions {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String get() {
		QuickAccessDataSourceHelper accessDataSourceHelper = new QuickAccessDataSourceHelper();
		return accessDataSourceHelper.readFromDB();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String post(String requestBody) {
		QuickAccessDataSourceHelper accessDataSourceHelper = new QuickAccessDataSourceHelper();

		return accessDataSourceHelper.insertIntoDB(requestBody);
	}

	@DELETE
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String delete(@PathParam("id") String id) {
		QuickAccessDataSourceHelper accessDataSourceHelper = new QuickAccessDataSourceHelper();
		accessDataSourceHelper.deleteFromDb(id);
		return "";
	}
}
