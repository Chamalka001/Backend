package com.mycompany.icbtwebservice.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author 
 */
@Path("jakartaee9")
public class JakartaEE9Resource {
    
    @GET
    public Response ping(){
        System.out.println("test");
        System.out.println("Hello");
        return Response
                .ok("ping Jakarta EE")
                .build();
    }
}
