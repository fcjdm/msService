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

    public int addObra(String email, String obraLeyendo) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return obraUsuarioManager.addObra(con, email, obraLeyendo);
        }
    }

    public int deleteObraUsuario(String email, String obra) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return obraUsuarioManager.deleteObraUsuario(con, email, obra);
        }
    }

    public int sumChap(String email, String obra) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return obraUsuarioManager.sumChap(con, email, obra);
        }
    }
    public int resChap(String email, String obra) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return obraUsuarioManager.sumChap(con, email, obra);
        }
    }

    public ObraUsuario findByID(String email, String obra) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return obraUsuarioManager.findByID(con, email, obra);
        }
    }

    public int updateStatus(String email, String obra, String status) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return obraUsuarioManager.updateStatus(con, email, obra, status);
        }
    }

}