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
@Path("customer")
public class CustomerResource {
    
    Gson gson = new Gson();
    DBUtils utils = new Utils();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCustomer(String json) {

        utils.addCustomer(gson.fromJson(json, Customer.class));
        return Response
                .status(Response.Status.CREATED)
                .build();

    }
    
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomer(@PathParam("id") int id) {
        Customer customer = utils.getCustomer(id);
        if (customer == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        } else {
            return Response
                    .ok(gson.toJson(customer))
                    .build();
        }

    }
    
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomers() {
        return Response
                .ok(gson.toJson(utils.getCustomers()))
                .build();
    }
    
    
    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCustomer(String json, @PathParam("id") int id) {
        if (utils.updateCustomer(gson.fromJson(json, Customer.class))) {
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
    public Response deleteCustomer(@PathParam("id") int id) {
        if (utils.deleteCustomer(id)) {
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
