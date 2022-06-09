package edu.fpdual.webservice.model.manager;

import edu.fpdual.webservice.model.dao.Usuarios;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Usuarios DTO Manager.
 *
 * Contiene todas las queries utilizadas para la consulta y manipulacion de datos de Usuarios.
 *
 * @author ikisaki
 *
 */
public interface UsuariosManager{

    Usuarios findUser(Connection con, String email) throws SQLException;

    Usuarios login(Connection con, String email, String password) throws SQLException;

    int createUser(Connection con, String email, String password) throws SQLException;

    int deleteUser(Connection con, String email) throws SQLException;

    int changePassword(Connection con, String email, String newPassword) throws SQLException;

}