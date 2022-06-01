package edu.fpdual.webservice.model.manager.impl;

import edu.fpdual.webservice.model.dao.Obra;
import edu.fpdual.webservice.model.manager.ObraManager;

import java.sql.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Obra DTO Manager.
 *
 * Contiene todas las queries definidas utilizadas para la consulta y manipulacion de datos de Obra.
 *
 * @author ikisaki
 *
 */
public class ObraManagerImpl implements ObraManager {

    @Override
    public Set<Obra> findAll(Connection con) throws SQLException {
        // Crea el statement general.
        try (Statement stmt = con.createStatement()) {
            // Realiza la consulta de la BBDD.
            ResultSet result = stmt.executeQuery("SELECT * FROM obra");

            return queryResult(result);

        }
    }

    @Override
    public Set<Obra> findByOrderAsc(Connection con)throws SQLException {
        // Crea el statement general.
        try (Statement stmt = con.createStatement()) {
            // Realiza la consulta de la BBDD.
            ResultSet result = stmt.executeQuery("SELECT * FROM obra ORDER BY titulo ASC");

            return queryResult(result);

        }
    }

    @Override
    public Set<Obra> findByOrderDesc(Connection con) throws SQLException {
        // Crea el statement general.
        try (Statement stmt = con.createStatement()) {
            // Realiza la consulta de la BBDD.
            ResultSet result = stmt.executeQuery("SELECT * FROM obra ORDER BY titulo DESC");

            return queryResult(result);

        }
    }

    @Override
    public Set<Obra> findByName(Connection con, String name) throws SQLException  {
        try(PreparedStatement prepstm = con.prepareStatement("SELECT * FROM obra " +
                "WHERE titulo LIKE ?")){

            prepstm.setString(1, "%" + name + "%");

            ResultSet result = prepstm.executeQuery();
            return queryResult(result);
        }
    }

    @Override
    public Set<Obra> queryResult(ResultSet result) throws SQLException {
        Set<Obra> set = new LinkedHashSet<>();
        result.beforeFirst();
        while (result.next()) {
            Obra obra = new Obra(result);
            set.add(obra);
        }

        return set;
    }
}
