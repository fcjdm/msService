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

    public Set<ObraUsuario> findAll() throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return obraUsuarioManager.findAll(con);
        }
    }

    public Set<ObraUsuario> findByOrderAsc() throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return obraUsuarioManager.findByOrderAsc(con);
        }
    }

    public Set<ObraUsuario> findByOrderDesc() throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return obraUsuarioManager.findByOrderDesc(con);
        }
    }

    public Set<ObraUsuario> findByName(String nombre) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return obraUsuarioManager.findByName(con, nombre);
        }
    }

}