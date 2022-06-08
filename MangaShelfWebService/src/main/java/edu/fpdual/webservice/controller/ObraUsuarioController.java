package edu.fpdual.webservice.controller;

import edu.fpdual.webservice.model.dao.Obra;
import edu.fpdual.webservice.model.dao.ObraUsuario;
import edu.fpdual.webservice.model.dao.Usuarios;
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
    @Path("/get/{email}/{obra}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByUser(@PathParam("email") String email, @PathParam("obra") String obra) throws SQLException, ClassNotFoundException{
        try{
            ObraUsuario obus = obraUsuarioService.findByID(email, obra);

            if(obus != null){
                return Response.ok().entity(obus).build();
            }else{
                return Response.status(404).entity("Not found").build();
            }

        }catch (SQLException | ClassNotFoundException e){
            return Response.status(400).entity("Internal Error During DB Interaction").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addObra(ObraUsuario obus) throws SQLException, ClassNotFoundException {
        try {
            ObraUsuario obraUsuario = obraUsuarioService.findByID(obus.getUsuario(), obus.getUsuario());

            if(obraUsuario == null){
                obraUsuarioService.addObra(obus.getUsuario(), obus.getObra());
                return Response.ok().entity(obraUsuarioService.findByID(obus.getUsuario(), obus.getUsuario())).build();
            }else{
                return Response.status(500).entity("Not found").build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(400).entity("Internal Error During DB Interaction").build();
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