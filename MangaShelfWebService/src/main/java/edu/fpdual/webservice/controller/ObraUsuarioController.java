package edu.fpdual.webservice.controller;

import edu.fpdual.webservice.model.manager.impl.ObraUsuarioManagerImpl;
import edu.fpdual.webservice.service.ObraUsuarioService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;

@Path("/obrausuario")
public class ObraUsuarioController {

    private final ObraUsuarioService obraUsuarioService;

    public ObraUsuarioController(){
        this.obraUsuarioService = new ObraUsuarioService(new ObraUsuarioManagerImpl());
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() throws SQLException, ClassNotFoundException{
        return Response.ok().entity(obraUsuarioService.findAll()).build();
    }

    @GET
    @Path("/get/asc")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByOrderAsc() throws SQLException, ClassNotFoundException{
        return Response.ok().entity(obraUsuarioService.findByOrderAsc()).build();
    }

    @GET
    @Path("/get/desc")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByOrderDesc() throws SQLException, ClassNotFoundException{
        return Response.ok().entity(obraUsuarioService.findByOrderDesc()).build();
    }

    @GET
    @Path("/get/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByName(@PathParam("name") String name) {
        try {
            if (name == null) {
                return Response.status(400).entity("Incorrect Parameters").build();
            } else {
                return Response.ok().entity(obraUsuarioService.findByName(name)).build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Internal Error During DB Interaction").build();
        }

    }

}