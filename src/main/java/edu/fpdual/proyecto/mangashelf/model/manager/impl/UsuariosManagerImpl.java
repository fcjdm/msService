package edu.fpdual.proyecto.mangashelf.model.manager.impl;

import edu.fpdual.proyecto.mangashelf.model.dao.Usuarios;
import edu.fpdual.proyecto.mangashelf.model.manager.UsuariosManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
    public List<Usuarios> findAll(Connection con) {
        // Crea el statement general.
        try (Statement stmt = con.createStatement()) {
            // Realiza la consulta de la BBDD.
            ResultSet result = stmt.executeQuery("SELECT * FROM Usuarios");
            // Set antes del primer registro.
            result.beforeFirst();

            // Inicializar variable.
            List<Usuarios> usuarios = new ArrayList<>();

            // Recorre cada resultado.
            while (result.next()) {
                // Añade una obra por resultado.
                usuarios.add(new Usuarios(result));

            }

            return usuarios;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
