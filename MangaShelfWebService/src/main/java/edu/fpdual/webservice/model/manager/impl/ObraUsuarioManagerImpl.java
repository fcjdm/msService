package edu.fpdual.webservice.model.manager.impl;

import edu.fpdual.webservice.model.dao.ObraUsuario;
import edu.fpdual.webservice.model.manager.ObraUsuarioManager;

import java.sql.*;
import java.util.LinkedHashSet;
import java.util.Set;

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
    public Set<ObraUsuario> findAll(Connection con) throws SQLException {
        // Crea el statement general.
        try (Statement stmt = con.createStatement()) {
            // Realiza la consulta de la BBDD.
            ResultSet result = stmt.executeQuery("SELECT * FROM mangas.obra_usuario");

            return queryResult(result);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Set<ObraUsuario> findByOrderAsc(Connection con)throws SQLException {
        // Crea el statement general.
        try (Statement stmt = con.createStatement()) {
            // Realiza la consulta de la BBDD.
            ResultSet result = stmt.executeQuery("SELECT * FROM mangas.obra_usuario ORDER BY obra_usuario.usuario ASC");

            return (LinkedHashSet<ObraUsuario>) queryResult(result);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Set<ObraUsuario> findByOrderDesc(Connection con) throws SQLException {
        // Crea el statement general.
        try (Statement stmt = con.createStatement()) {
            // Realiza la consulta de la BBDD.
            ResultSet result = stmt.executeQuery("SELECT * FROM mangas.obra_usuario ORDER BY obra_usuario.usuario DESC");

            return (LinkedHashSet<ObraUsuario>) queryResult(result);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Set<ObraUsuario> findByName(Connection con, String name) throws SQLException  {
        try(PreparedStatement prepstm = con.prepareStatement("SELECT * FROM mangas.obra_usuario " +
                "WHERE obra_usuario.usuario LIKE ?")){

            prepstm.setString(1, "%" + name + "%");

            ResultSet result = prepstm.executeQuery();
            return queryResult(result);
        }
    }

    @Override
    public Set<ObraUsuario> queryResult(ResultSet result) throws SQLException {
        Set<ObraUsuario> set = new LinkedHashSet<>();
        result.beforeFirst();
        while (result.next()) {
            ObraUsuario obraUsuario = new ObraUsuario(result);
            set.add(obraUsuario);
        }

        return set;
    }

}

