package edu.fpdual.webservice.controller;

import edu.fpdual.webservice.model.manager.impl.*;
import edu.fpdual.webservice.service.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;

@Path("/usuarios")
public class UsuariosController {

    private final UsuariosService usuariosService;

    public UsuariosController(){
        this.usuariosService = new UsuariosService(new UsuariosManagerImpl());
    }

    @POST
    @Path("/create/{email}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public void createUser(@PathParam("email") String email, @PathParam("password") String password){
        try {
            int creado = usuariosService.createUser(email, password);
            if(creado != 1){
                System.out.println(Response.status(500).entity("Internal Error During Creating The User").build());
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(Response.status(500).entity("Internal Error During DB Interaction").build());
        }
    }

    @DELETE
    @Path("/delete/{email}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteUser(@PathParam("email") String email, @PathParam("password") String password) {
        try {
            if (usuariosService.deleteUser(email, password) != 1) {
                System.out.println(Response.status(304).entity("User Was Not Deleted").build());
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(Response.status(500).entity("Internal Error During DB Interaction").build());
        }

    }

    @PUT
    @Path("/update/{email}/{oldpassword}/{newpassword}")
    @Produces(MediaType.APPLICATION_JSON)
    public void changePassword(@PathParam("email") String email, @PathParam("oldpassword") String oldPassword, @PathParam("newpassword") String newPassword){
        try {
            if(usuariosService.changePassword(email, oldPassword, newPassword) != 1){
                System.out.println(Response.status(500).entity("Internal Error During Password Change").build());
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(Response.status(500).entity("Internal Error During DB Interaction").build());
        }
    }

}
