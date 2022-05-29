package edu.fpdual.webservice.service;

import edu.fpdual.webservice.model.connector.MySQLConnector;
import edu.fpdual.webservice.model.dao.ObraUsuario;
import edu.fpdual.webservice.model.manager.ObraUsuarioManager;
import edu.fpdual.webservice.model.manager.impl.ObraUsuarioManagerImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

public class ObraUsuarioService {

    private final ObraUsuarioManager obraUsuarioManager;

    public ObraUsuarioService(ObraUsuarioManagerImpl obraUsuarioManager){
        this.obraUsuarioManager = obraUsuarioManager;
    }

    public Set<ObraUsuario> findByUser(String email) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return obraUsuarioManager.findByUser(con, email);
        }
    }

    public int createObraUsuario(String email, String obraLeyendo) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return obraUsuarioManager.createObraUsuario(con, email, obraLeyendo);
        }
    }

    public int deleteObraUsuario(String email) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return obraUsuarioManager.deleteObraUsuario(con, email);
        }
    }

    public int sumarCapitulo(String email, String obraLeyendo) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return obraUsuarioManager.sumarCapitulo(con, email, obraLeyendo);
        }
    }

}