package edu.fpdual.webservice.service;

import edu.fpdual.webservice.model.connector.MySQLConnector;
import edu.fpdual.webservice.model.dao.Usuarios;
import edu.fpdual.webservice.model.manager.UsuariosManager;
import edu.fpdual.webservice.model.manager.impl.UsuariosManagerImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

public class UsuariosService {

    private final UsuariosManager usuariosManager;

    public UsuariosService(UsuariosManagerImpl usuariosManager){
        this.usuariosManager = usuariosManager;
    }

    public Set<Usuarios> login (String email, String password) throws  SQLException, ClassNotFoundException{
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return usuariosManager.login(con, email, password);
        }
    }

    public int createUser(String email, String password) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return usuariosManager.createUser(con, email, password);
        }
    }

    public int deleteUser(String email, String password) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return usuariosManager.deleteUser(con, email, password);
        }
    }

    public int changePassword(String email, String oldPassword, String newPassword) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return usuariosManager.changePassword(con, email, oldPassword, newPassword);
        }
    }

}
