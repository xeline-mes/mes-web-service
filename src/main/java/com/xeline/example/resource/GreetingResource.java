
package com.xeline.example.resource;

import com.xeline.example.service.GreetingService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author XenRon
 */
@Component
@Path("/greeting")
public class GreetingResource {
    
    @Autowired
    private GreetingService greetingService;
    
    @GET
    public Response getGreeting(@QueryParam("name") String name) {
        String greeting = greetingService.getGreeting(name);
        return Response.ok(greeting).build();
    }

}
