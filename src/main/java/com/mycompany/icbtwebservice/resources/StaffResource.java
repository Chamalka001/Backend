/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.icbtwebservice.resources;

import com.google.gson.Gson;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author Dinindu
 */

@Path("staff")
public class StaffResource {
    
    Gson gson = new Gson();
    DBUtils utils = new Utils();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addStaff(String json) {

        utils.addStaff(gson.fromJson(json, Staff.class));
        return Response
                .status(Response.Status.CREATED)
                .build();

    }
    
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStaff(@PathParam("id") int id) {
        Staff staff = utils.getStaff(id);
        if (staff == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        } else {
            return Response
                    .ok(gson.toJson(staff))
                    .build();
        }

    }
    
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStaffs() {
        return Response
                .ok(gson.toJson(utils.getStaffs()))
                .build();
    }
    
    
    
    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateStaff(String json, @PathParam("id") int id) {
        if (utils.updateStaff(gson.fromJson(json, Staff.class))) {
            return Response
                    .status(Response.Status.OK)
                    .build();
        } else {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }
    }
    
    
    
    @DELETE
    @Path("{id}")
    public Response deleteStaff(@PathParam("id") int id) {
        if (utils.deleteStaff(id)) {
            return Response
                    .status(Response.Status.OK)
                    .build();
        } else {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }

    }
    
}
