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
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author Dinindu
 */

@Path("payment")
public class PaymentResource {
    
    Gson gson = new Gson();
    DBUtils utils = new Utils();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPayment(String json) {

        utils.addPayment(gson.fromJson(json, Payment.class));
        return Response
                .status(Response.Status.CREATED)
                .build();

    }
    
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPayments() {
        return Response
                .ok(gson.toJson(utils.getPayments()))
                .build();
    }
    
}
