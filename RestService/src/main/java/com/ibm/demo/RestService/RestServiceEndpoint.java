package com.ibm.demo.RestService;

import javax.enterprise.context.ApplicationScoped;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@ApplicationScoped
@Path("/addrows")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestServiceEndpoint {

	@POST
	public Response addRows(String postBody) {
		System.out.println("In the addRows method");
		System.out.println("PostBody=" + postBody);
		
		/*
		 * The idea is to parse the following json and do jzos stuff here.
		 * The expected json look like
		 * { "source_dataset" : "HQL.DG.RAW", "target_vsam": "HQL", "start_rows": "0", "row_count": 10 }
		 */

		RestRequestData restRequest = new RestRequestData();
		restRequest = JsonbBuilder.create().fromJson(postBody, RestRequestData.class);
		
		/*
		 * Now the values for those json elements are in the restRequest POJO
		 */
		System.out.println(restRequest.toString());
		
		/*
		 * Do your jzos stuff here
		 */
		
		return Response.status(Response.Status.CREATED).build();
	}
}
