package edu.fpdual.webservice.service;

import edu.fpdual.webservice.model.connector.MySQLConnector;
import edu.fpdual.webservice.model.dao.Usuarios;
import edu.fpdual.webservice.model.manager.UsuariosManager;
import edu.fpdual.webservice.model.manager.impl.UsuariosManagerImpl;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Usuarios DTO Service.
 *
 * @author ikisaki
 *
 */
public class UsuariosService {

    private final UsuariosManager usuariosManager;

    public UsuariosService(UsuariosManagerImpl usuariosManager){
        this.usuariosManager = usuariosManager;
    }

    public Usuarios findUser(String email) throws  SQLException, ClassNotFoundException {

        try (Connection con = new MySQLConnector().getMySQLConnection()) {

            return usuariosManager.findUser(con, email);

        }

    }

    public Usuarios login(String email, String password) throws  SQLException, ClassNotFoundException {

        try (Connection con = new MySQLConnector().getMySQLConnection()) {

            return usuariosManager.login(con, email, password);

        }

    }

    public int createUser(String email, String password) throws SQLException, ClassNotFoundException {

        try (Connection con = new MySQLConnector().getMySQLConnection()) {

            return usuariosManager.createUser(con, email, password);

        }

    }

    public int deleteUser(String email) throws SQLException, ClassNotFoundException {

        try (Connection con = new MySQLConnector().getMySQLConnection()) {

            return usuariosManager.deleteUser(con, email);

        }

    }

    public int changePassword(String email, String newPassword) throws SQLException, ClassNotFoundException {

        try (Connection con = new MySQLConnector().getMySQLConnection()) {

            return usuariosManager.changePassword(con, email, newPassword);

        }

    }

}
