/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.icbtwebservice.resources;

import com.google.gson.Gson;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author Dinindu
 */

@Path("query")
public class QueryResource {
    
    Gson gson = new Gson();
    DBUtils utils = new Utils();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addQuery(String json) {

        utils.addQuery(gson.fromJson(json, Query.class));
        return Response
                .status(Response.Status.CREATED)
                .build();

    }
    
    
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getQuery(@PathParam("id") int id) {
        Query query = utils.getQuery(id);
        if (query == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        } else {
            return Response
                    .ok(gson.toJson(query))
                    .build();
        }

    }
    
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getQuerys() {
        return Response
                .ok(gson.toJson(utils.getQuerys()))
                .build();
    }
    
}
