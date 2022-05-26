package edu.fpdual.proyecto.mangashelf.model.manager.impl;

import edu.fpdual.proyecto.mangashelf.model.dao.ObraUsuario;
import edu.fpdual.proyecto.mangashelf.model.manager.ObraUsuarioManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * ObraUsuario DTO Manager.
 *
 * Contiene todas las queries definidas utilizadas para la consulta y manipulacion de datos de ObraUsuario.
 *
 * @author ikisaki
 *
 */
public class ObraUsuarioManagerImpl implements ObraUsuarioManager {

    @Override
    public List<ObraUsuario> findAll(Connection con) {
        // Crea el statement general.
        try (Statement stmt = con.createStatement()) {
            // Realiza la consulta de la BBDD.
            ResultSet result = stmt.executeQuery("SELECT * FROM Obra_usuario");
            // Set antes del primer registro.
            result.beforeFirst();

            // Inicializar variable.
            List<ObraUsuario> obrasUsuarios = new ArrayList<>();

            // Recorre cada resultado.
            while (result.next()) {
                // Añade una obra por resultado.
                obrasUsuarios.add(new ObraUsuario(result));

            }

            return obrasUsuarios;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

