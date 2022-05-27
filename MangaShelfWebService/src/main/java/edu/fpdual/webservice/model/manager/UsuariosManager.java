package edu.fpdual.webservice.model.manager;

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

    public int createUser (Connection con, String email, String password) throws SQLException;
    public int deleteUser (Connection con, String email, String password) throws SQLException;
    public int changePassword (Connection con ,String email, String oldPassword, String newPassword) throws SQLException;



}