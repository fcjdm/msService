package edu.fpdual.webservice.model.manager.impl;

import edu.fpdual.webservice.model.manager.UsuariosManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Usuarios DTO Manager.
 *
 * Contiene todas las queries definidas utilizadas para la consulta y manipulacion de datos de Usuarios.
 *
 * @author ikisaki
 *
 */
public class UsuariosManagerImpl implements UsuariosManager {


    @Override
    public int createUser(Connection con, String email, String password) throws SQLException {
        try(PreparedStatement prepstm = con.prepareStatement("INSERT INTO mangas.usuarios(emailUsuario, contrasenyaUsuario)" +
                "VALUES (?,?)")){
            prepstm.setString(1, email);
            prepstm.setString(2, password);

            return prepstm.executeUpdate();
        }
    }

    @Override
    public int deleteUser(Connection con, String email, String password) throws SQLException {
        try(PreparedStatement prepstm = con.prepareStatement("DELETE FROM mangas.usuarios " +
                "WHERE usuarios.emailUsuario = ? AND usuarios.contrasenyaUsuario = ?")){
            prepstm.setString(1, email);
            prepstm.setString(2, password);

            return prepstm.executeUpdate();
        }
    }

    @Override
    public int changePassword(Connection con, String email, String oldPassword, String newPassword) throws SQLException {
        try(PreparedStatement prepstm = con.prepareStatement("UPDATE mangas.usuarios " +
                "SET contrasenyaUsuario = ? WHERE emailUsuario = ? AND contrasenyaUsuario = ?")){
            prepstm.setString(1, newPassword);
            prepstm.setString(2, email);
            prepstm.setString(3, oldPassword);

            return prepstm.executeUpdate();
        }
    }
}
