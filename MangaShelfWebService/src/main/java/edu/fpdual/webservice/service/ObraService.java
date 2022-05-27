package edu.fpdual.webservice.service;

import edu.fpdual.webservice.model.connector.MySQLConnector;
import edu.fpdual.webservice.model.dao.Autor;
import edu.fpdual.webservice.model.dao.Obra;
import edu.fpdual.webservice.model.manager.AutorManager;
import edu.fpdual.webservice.model.manager.ObraManager;
import edu.fpdual.webservice.model.manager.impl.AutorManagerImpl;
import edu.fpdual.webservice.model.manager.impl.ObraManagerImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

public class ObraService {

    private final ObraManager obraManager;

    public ObraService(ObraManagerImpl obraManager){
        this.obraManager = obraManager;
    }

    public Set<Obra> findAll() throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return obraManager.findAll(con);
        }
    }

    public Set<Obra> findByOrderAsc() throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return obraManager.findByOrderAsc(con);
        }
    }

    public Set<Obra> findByOrderDesc() throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return obraManager.findByOrderDesc(con);
        }
    }

    public Set<Obra> findByName(String nombre) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return obraManager.findByName(con, nombre);
        }
    }

}
