package edu.fpdual.proyecto.mangashelf.controller;

import edu.fpdual.proyecto.mangashelf.model.connector.MySQLConnector;
import edu.fpdual.proyecto.mangashelf.model.dao.*;
import edu.fpdual.proyecto.mangashelf.model.manager.impl.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        try (Connection con = new MySQLConnector().getMySQLConnection()){

            List<Autor> autores = new AutorManagerImpl().findAll(con);

            for (Autor autor : autores) {

                System.out.println(autor.getNombre()+" | "+autor.getTitulo());

            }

            System.out.println("");
            System.out.println("");

            List<Genero> generos = new GeneroManagerImpl().findAll(con);

            for (Genero genero : generos) {

                System.out.println(genero.getGenero()+" | "+genero.getTitulo());

            }

            System.out.println("");
            System.out.println("");

            List<Obra> obras = new ObraManagerImpl().findAll(con);

            for (Obra obra : obras) {

                System.out.println(obra.getTitulo()+" | "+obra.getAnyoPublicacion()+" | "+obra.getAnyoTermino()+" | "+obra.getCapitulosTotales());

            }

            System.out.println("");
            System.out.println("");

            List<ObraUsuario> obrasUsuarios = new ObraUsuarioManagerImpl().findAll(con);

            for (ObraUsuario obraUsuario : obrasUsuarios) {

                System.out.println(obraUsuario.getUsuario()+" | "+obraUsuario.getObra()+" | "+obraUsuario.getCapitulosLeidos()+" | "+obraUsuario.getEstado());

            }

            System.out.println("");
            System.out.println("");

            List<Usuarios> usuarios = new UsuariosManagerImpl().findAll(con);

            for (Usuarios usuario : usuarios) {

                System.out.println(usuario.getEmailUsuario()+" | "+usuario.getContrasenyaUsuario());

            }

            System.out.println("");
            System.out.println("");

        }
    }

}
