package edu.fpdual.webservice.controller;

import edu.fpdual.webservice.model.manager.impl.AutorManagerImpl;
import edu.fpdual.webservice.model.manager.impl.GeneroManagerImpl;
import edu.fpdual.webservice.service.AutorService;
import edu.fpdual.webservice.service.GeneroService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;

@Path("/genero")
public class GeneroController {

    private final GeneroService generoService;

    public GeneroController(){
        this.generoService = new GeneroService(new GeneroManagerImpl());
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() throws SQLException, ClassNotFoundException{
        return Response.ok().entity(generoService.findAll()).build();
    }

    @GET
    @Path("/get/asc")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByOrderAsc() throws SQLException, ClassNotFoundException{
        return Response.ok().entity(generoService.findByOrderAsc()).build();
    }

    @GET
    @Path("/get/desc")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByOrderDesc() throws SQLException, ClassNotFoundException{
        return Response.ok().entity(generoService.findByOrderDesc()).build();
    }

    @GET
    @Path("/get/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByName(@PathParam("name") String name) {
        try {
            if (name == null) {
                return Response.status(400).entity("Incorrect Parameters").build();
            } else {
                return Response.ok().entity(generoService.findByName(name)).build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Internal Error During DB Interaction").build();
        }

    }

}
