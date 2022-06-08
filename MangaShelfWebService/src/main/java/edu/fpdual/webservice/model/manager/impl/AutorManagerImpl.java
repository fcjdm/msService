package edu.fpdual.webservice.model.manager.impl;


import edu.fpdual.webservice.model.dao.Autor;
import edu.fpdual.webservice.model.manager.AutorManager;

import java.sql.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Autor DTO Manager.
 *
 * Contiene todas las queries definidas utilizadas para la consulta y manipulacion de datos de Autor.
 *
 * @author ikisaki
 *
 */
public class AutorManagerImpl implements AutorManager {

    @Override
    public Set<Autor> findAll(Connection con) throws SQLException {

        try (Statement stmt = con.createStatement()) {

            ResultSet result = stmt.executeQuery("SELECT * FROM autor");

            return queryResult(result);

        }
    }

    @Override
    public Set<Autor> findByOrderAsc(Connection con)throws SQLException {

        try (Statement stmt = con.createStatement()) {

            ResultSet result = stmt.executeQuery("SELECT * FROM autor ORDER BY nombre ASC");

            return queryResult(result);

        }
    }

    @Override
    public Set<Autor> findByOrderDesc(Connection con) throws SQLException {

        try (Statement stmt = con.createStatement()) {

            ResultSet result = stmt.executeQuery("SELECT * FROM autor ORDER BY nombre DESC");

            return queryResult(result);

        }
    }

    @Override
    public Set<Autor> findByName(Connection con, String name) throws SQLException  {
        try(PreparedStatement prepstm = con.prepareStatement("SELECT * FROM autor " +
                "WHERE nombre LIKE ?")){

            prepstm.setString(1, "%" + name + "%");

            ResultSet result = prepstm.executeQuery();
            return queryResult(result);
        }
    }

    @Override
    public Set<Autor> queryResult(ResultSet result) throws SQLException {
        Set<Autor> set = new LinkedHashSet<>();
        result.beforeFirst();
        while (result.next()) {
            Autor autor = new Autor(result);
            set.add(autor);
        }

        return set;
    }
}
