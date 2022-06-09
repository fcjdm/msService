package edu.fpdual.webservice.controller;

import edu.fpdual.webservice.model.dao.Autor;
import edu.fpdual.webservice.model.dao.Obra;
import edu.fpdual.webservice.model.manager.impl.ObraManagerImpl;
import edu.fpdual.webservice.service.ObraService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.Set;

@Path("/obra")
public class ObraController {

    private final ObraService obraService;

    public ObraController(){
        this.obraService = new ObraService(new ObraManagerImpl());
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        try{
            return Response.ok().entity(obraService.findAll()).build();

        }catch (SQLException | ClassNotFoundException e){
            return Response.status(500).entity("DB Error").build();
        }

    }

    @GET
    @Path("/getid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByID(@PathParam("id") String id){
        try{
            Obra obra = obraService.findByID(id);
            if(obra != null){
                return Response.ok().entity(obra).build();
            }else{
                return Response.status(404).entity("Not found").build();
            }

        }catch (SQLException | ClassNotFoundException e){
            return Response.status(500).entity("DB Error").build();
        }

    }


    @GET
    @Path("/get/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByName(@PathParam("name") String name) {
        try {
            Set<Obra> setObras= obraService.findByName(name);

            if (setObras != null) {
                return Response.ok().entity(setObras).build();
            } else {
                return Response.status(404).entity("Not found").build();

            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Internal Error During DB Interaction").build();
        }

    }

}