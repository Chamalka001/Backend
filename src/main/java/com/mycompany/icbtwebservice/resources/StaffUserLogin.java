/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.icbtwebservice.resources;

import com.google.gson.Gson;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author Dinindu
 */

@Path("slogin")
public class StaffUserLogin {
    
    Gson gson = new Gson();
    DBUtils utils = new Utils();
    
    @POST
    @Path("/suserlogin")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response SuserLogin(String json) {
        
       
        
        StaffUser staffUser = gson.fromJson(json,StaffUser.class);
        
        if (utils.SuserLogin(staffUser.getEmail(), staffUser.getS_password())) {
            
            return Response
                    .status(Response.Status.OK)
                    .build();
            
        } else {
            
            return Response
                    .status(Response.Status.UNAUTHORIZED)
                    .build();
        }
    }
    
}
