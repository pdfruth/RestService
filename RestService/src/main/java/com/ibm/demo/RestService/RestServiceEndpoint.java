package com.ibm.demo.RestService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
//import jakarta.ws.rs.QueryParam;
//import jakarta.ws.rs.core.Restpos.Status

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
		 * The idea is leverage JSON-B to parse the following json payload, deserializing it to a POJO class.
		 * The expected json look like
		 * { "source_dataset" : "HQL.DG.RAW", "target_vsam": "HQL", "start_rows": "0", "row_count": 10 }
		 */

		RestRequestData restRequest = new RestRequestData();
		restRequest = JsonbBuilder.create().fromJson(postBody, RestRequestData.class);
		
		/*
		 * Now the values for those json elements are in the restRequest POJO class
		 * Each of the elements is a String whose value can be individually accessed via;
		 *		restRequest.source_dataset
		 *		restRequest.target_vsam
		 *		restRequest.start_rows
		 *		restRequest.row_count
		 */
		System.out.println(restRequest.toString());
		
		/*
		 * Do your jzos stuff here
		 */
		
		
		/*
		 * Depending how things went return an HTTP status
		 * The example below returns a status of CREATED (201)
		 * Or maybe you rather return OK (200)
		 * If things go badly return a status of INTERNAL_SERVER_ERROR (500)
		 */
		
		return Response.status(Response.Status.CREATED).build(); //201
		// return Response.status(Response.Status.OK).build(); // 200
		// return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build(); // 500
	}
}
