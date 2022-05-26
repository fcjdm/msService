package edu.fpdual.proyecto.mangashelf.controller;

import edu.fpdual.proyecto.mangashelf.model.connector.MySQLConnector;
import edu.fpdual.proyecto.mangashelf.model.dao.*;
import edu.fpdual.proyecto.mangashelf.model.manager.impl.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        try (Connection con = new MySQLConnector().getMySQLConnection()) {

            int usuario = new UsuariosManagerImpl().createUser(con, "juan", "1234");

            System.out.println(usuario);

            usuario =  new UsuariosManagerImpl().changePassword(con, "juan","1234", "546");
            System.out.println(usuario);
        }
    }

}
