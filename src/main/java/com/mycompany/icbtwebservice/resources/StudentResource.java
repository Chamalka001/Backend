package com.mycompany.icbtwebservice.resources;

import jakarta.ws.rs.Path;
import com.google.gson.Gson;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author tharindulakshan
 */
@Path("students")
public class StudentResource {

    Gson gson = new Gson();
    DBUtils utils = new Utils();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addStudent(String json) {

        utils.addStudent(gson.fromJson(json, Student.class));
        return Response
                .status(Response.Status.CREATED)
                .build();

    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudent(@PathParam("id") int id) {
        Student student = utils.getStudent(id);
        if (student == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        } else {
            return Response
                    .ok(gson.toJson(student))
                    .build();
        }

    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudents() {
        return Response
                .ok(gson.toJson(utils.getStudents()))
                .build();
    }
    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateStudent(String json, @PathParam("id") int id) {
        if (utils.updateStudent(gson.fromJson(json, Student.class))) {
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
    public Response deleteStudent(@PathParam("id") int id) {
        if (utils.deleteStudent(id)) {
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
