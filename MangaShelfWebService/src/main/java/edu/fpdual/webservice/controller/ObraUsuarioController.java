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
    @Path("/get/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByUser(@PathParam("email") String email) throws SQLException, ClassNotFoundException{
        return Response.ok().entity(obraUsuarioService.findByUser(email)).build();
    }

    @POST
    @Path("/create/{email}/{obraleyendo}")
    @Produces(MediaType.APPLICATION_JSON)
    public void createUser(@PathParam("email") String email, @PathParam("obraleyendo") String obraLeyendo){
        try {
            int creado = obraUsuarioService.createObraUsuario(email, obraLeyendo);
            if(creado != 1){
                System.out.println(Response.status(500).entity("Internal Error During Creating The User").build());
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(Response.status(500).entity("Internal Error During DB Interaction").build());
        }
    }

    @DELETE
    @Path("/delete/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteUser(@PathParam("email") String email) {
        try {
            if (obraUsuarioService.deleteObraUsuario(email) != 1) {
                System.out.println(Response.status(304).entity("User Was Not Deleted").build());
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(Response.status(500).entity("Internal Error During DB Interaction").build());
        }

    }

    @PUT
    @Path("/update/{email}/{obraleyendo}")
    @Produces(MediaType.APPLICATION_JSON)
    public void changePassword(@PathParam("email") String email, @PathParam("obraleyendo") String obraLeyendo){
        try {
            if(obraUsuarioService.sumarCapitulo(email, obraLeyendo) != 1){
                System.out.println(Response.status(500).entity("Internal Error During Chapter Addition").build());
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(Response.status(500).entity("Internal Error During DB Interaction").build());
        }
    }

}