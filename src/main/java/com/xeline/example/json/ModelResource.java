/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xeline.example.json;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author XenRon
 */
@Path("/model")
public class ModelResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResponse() {
        Model model = new Model();
        model.name = "Peeskillet";
        return Response.ok(model).build();
    }
}
