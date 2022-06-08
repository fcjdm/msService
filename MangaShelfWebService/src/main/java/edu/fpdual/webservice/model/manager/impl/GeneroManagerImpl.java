package edu.fpdual.webservice.model.manager.impl;


import edu.fpdual.webservice.model.dao.Genero;
import edu.fpdual.webservice.model.manager.GeneroManager;

import java.sql.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Genero DTO Manager.
 *
 * Contiene todas las queries definidas utilizadas para la consulta y manipulacion de datos de Genero.
 *
 * @author ikisaki
 *
 */
public class GeneroManagerImpl implements GeneroManager {

    @Override
    public Set<Genero> findAll(Connection con) throws SQLException {

        try (Statement stmt = con.createStatement()) {

            ResultSet result = stmt.executeQuery("SELECT * FROM genero");

            return queryResult(result);

        }
    }

    @Override
    public Set<Genero> findByOrderAsc(Connection con)throws SQLException {

        try (Statement stmt = con.createStatement()) {

            ResultSet result = stmt.executeQuery("SELECT * FROM genero ORDER BY genero ASC");

            return queryResult(result);

        }
    }

    @Override
    public Set<Genero> findByOrderDesc(Connection con) throws SQLException {

        try (Statement stmt = con.createStatement()) {

            ResultSet result = stmt.executeQuery("SELECT * FROM genero ORDER BY genero DESC");

            return queryResult(result);

        }
    }

    @Override
    public Set<Genero> findByName(Connection con, String name) throws SQLException  {
        try(PreparedStatement prepstm = con.prepareStatement("SELECT * FROM genero " +
                "WHERE genero LIKE ?")){

            prepstm.setString(1, "%" + name + "%");

            ResultSet result = prepstm.executeQuery();
            return queryResult(result);
        }
    }

    @Override
    public Set<Genero> queryResult(ResultSet result) throws SQLException {
        Set<Genero> set = new LinkedHashSet<>();
        result.beforeFirst();
        while (result.next()) {
            Genero genero = new Genero(result);
            set.add(genero);
        }

        return set;
    }
}
