package edu.fpdual.webservice.service;

import edu.fpdual.webservice.model.connector.MySQLConnector;
import edu.fpdual.webservice.model.dao.Autor;
import edu.fpdual.webservice.model.manager.AutorManager;
import edu.fpdual.webservice.model.manager.impl.AutorManagerImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

public class AutorService {

    private final AutorManager autorManager;

    public AutorService(AutorManagerImpl autorManager){
        this.autorManager = autorManager;
    }

    public Set<Autor> findAll() throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return autorManager.findAll(con);
        }
    }


    public Set<Autor> findByName(String nombre) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return autorManager.findByName(con, nombre);
        }
    }
    public Autor findByID(String id) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return autorManager.findByID(con, id);
        }
    }

}

