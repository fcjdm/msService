package edu.fpdual.webservice.controller;

import edu.fpdual.webservice.model.dao.Autor;
import edu.fpdual.webservice.model.dao.Obra;
import edu.fpdual.webservice.model.manager.impl.AutorManagerImpl;
import edu.fpdual.webservice.service.AutorService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.Set;

@Path("/autor")
public class AutorController {

    private final AutorService autorService;

    public AutorController(){
        this.autorService = new AutorService(new AutorManagerImpl());
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() throws SQLException, ClassNotFoundException{
        return Response.ok().entity(autorService.findAll()).build();
    }

    @GET
    @Path("/get/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByName(@PathParam("name") String name) {
        try {
            Set<Autor> setAutores= autorService.findByName(name);

            if (setAutores != null) {
                return Response.ok().entity(setAutores).build();
            } else {
                return Response.status(404).entity("Not found").build();

            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Internal Error During DB Interaction").build();
        }

    }

    @GET
    @Path("/getid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByID(@PathParam("id") String id){
        try{
            Autor autor = autorService.findByID(id);
            if(autor != null){
                return Response.ok().entity(autor).build();
            }else{
                return Response.status(404).entity("Not found").build();
            }

        }catch (SQLException | ClassNotFoundException e){
            return Response.status(500).entity("DB Error").build();
        }

    }

}