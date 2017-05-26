
package com.xeline.webservice.example.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author XenRon
 */
@Path("/greeting")
public class GreetingResource {
    
    @GET
    public Response getGreeting(@QueryParam("name") String name) {
        // String greeting = greetingService.getGreeting(name);
        String greeting = "Hello, " + name + "!";
        return Response.ok(greeting).build();
    }

}
