package edu.fpdual.webservice.controller;

import edu.fpdual.webservice.model.dao.Genero;
import edu.fpdual.webservice.model.manager.impl.GeneroManagerImpl;
import edu.fpdual.webservice.service.GeneroService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.Set;

/**
 * Genero.
 *
 * Controller de Genero.
 *
 * @author ikisaki
 *
 */
@Path("/genero")
public class GeneroController {

    private final GeneroService generoService;

    public GeneroController(){
        this.generoService = new GeneroService(new GeneroManagerImpl());
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() throws SQLException, ClassNotFoundException {

        return Response.ok().entity(generoService.findAll()).build();

    }

    @GET
    @Path("/get/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByName(@PathParam("name") String name) {

        try {

            Set<Genero> setGeneros= generoService.findByName(name);

            if (setGeneros != null) {

                return Response.ok().entity(setGeneros).build();

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
    public Response findByID(@PathParam("id") String id) {

        try {

            Genero genero = generoService.findByID(id);

            if (genero != null) {

                return Response.ok().entity(genero).build();

            } else {

                return Response.status(404).entity("Not found").build();

            }

        } catch (SQLException | ClassNotFoundException e) {

            return Response.status(500).entity("DB Error").build();

        }

    }

}
