package edu.fpdual.webservice.service;

import edu.fpdual.webservice.model.connector.MySQLConnector;
import edu.fpdual.webservice.model.dao.Genero;
import edu.fpdual.webservice.model.manager.GeneroManager;
import edu.fpdual.webservice.model.manager.impl.GeneroManagerImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

public class GeneroService {

    private final GeneroManager generoManager;

    public GeneroService(GeneroManagerImpl generoManager){
        this.generoManager = generoManager;
    }

    public Set<Genero> findAll() throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return generoManager.findAll(con);
        }
    }

    public Set<Genero> findByOrderAsc() throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return generoManager.findByOrderAsc(con);
        }
    }

    public Set<Genero> findByOrderDesc() throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return generoManager.findByOrderDesc(con);
        }
    }

    public Set<Genero> findByName(String nombre) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return generoManager.findByName(con, nombre);
        }
    }

}
