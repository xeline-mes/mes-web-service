
package com.xeline.webservice.example.rest;

import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.xeline.webservice.example.BayeuxInitializer;
import com.xeline.webservice.example.EventBroadcaster;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Path("/user/{name}")
public class CometdResource {

    private static ConcurrentMap<String,String> users;

    @Context
    ServletContext context;

    static {
        users = new ConcurrentHashMap<String, String>();
        users.put("someuser","");
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt(@PathParam("name") String name) {
        if (users.containsKey(name)) {
            return "Hello, " + name;
        } else {
            return "Invalid user!";
        }
    }

    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public String createIt(@PathParam("name") String name) {
        if (users.containsKey(name)) {
            return "User already exists";
        }
        users.putIfAbsent(name,"");
        getBroadcaster().userAdded(name);
        return "user added successfully!";
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public String delete(@PathParam("name") String name) {
        boolean removed = users.remove(name, "");
        if (removed)
            getBroadcaster().userRemoved(name);
        return removed? "User deleted": "User not found";
    }

    private EventBroadcaster getBroadcaster() {
        return (EventBroadcaster)context.getAttribute(BayeuxInitializer.BROADCAST_SVC);
    }

}
