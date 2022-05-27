package edu.fpdual.webservice.controller;

import edu.fpdual.webservice.model.connector.MySQLConnector;
import edu.fpdual.webservice.model.dao.Obra;
import edu.fpdual.webservice.model.manager.impl.ObraManagerImpl;
import edu.fpdual.webservice.model.manager.impl.UsuariosManagerImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        try (Connection con = new MySQLConnector().getMySQLConnection()) {

            Set<Obra> obras = new ObraManagerImpl().findAll(con);

            System.out.println(obras);
        }
    }

}
