package edu.fpdual.webservice.controller;

import edu.fpdual.webservice.model.dao.Usuarios;
import edu.fpdual.webservice.model.manager.impl.*;
import edu.fpdual.webservice.service.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import javax.print.attribute.standard.Media;
import java.sql.SQLException;

@Path("/usuarios")
public class UsuariosController {

    private final UsuariosService usuariosService;

    public UsuariosController(){
        this.usuariosService = new UsuariosService(new UsuariosManagerImpl());
    }

    @GET
    @Path("/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findUser(@PathParam("email") String email) throws SQLException, ClassNotFoundException {
        return Response.ok().entity(usuariosService.findUser(email)).build();
    }

    @PATCH
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(Usuarios newUser) throws SQLException, ClassNotFoundException {
        return Response.ok().entity(usuariosService.login(newUser.getEmailUsuario(), newUser.getContrasenyaUsuario())).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(Usuarios newUser) {
        try {
            Usuarios user = usuariosService.findUser(newUser.getEmailUsuario());

            if (user == null) {
                usuariosService.createUser(newUser.getEmailUsuario(), newUser.getContrasenyaUsuario());
                return Response.ok().entity(usuariosService.findUser(newUser.getEmailUsuario())).build();
            } else {
                return Response.status(500).entity("User already exists").build();
            }

        }catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Internal Error During DB Interaction").build();
        }



    }

    @DELETE
    @Path("/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteUser(@PathParam("email") String email) {
        try {
            if (usuariosService.deleteUser(email) != 1) {
                System.out.println(Response.status(304).entity("User Was Not Deleted").build());
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(Response.status(500).entity("Internal Error During DB Interaction").build());
        }

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void changePassword(Usuarios newUser){
        try {
            if(usuariosService.changePassword(newUser.getEmailUsuario(), newUser.getContrasenyaUsuario()) != 1){
                System.out.println(Response.status(500).entity("Internal Error During Password Change").build());
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(Response.status(500).entity("Internal Error During DB Interaction").build());
        }
    }

}
