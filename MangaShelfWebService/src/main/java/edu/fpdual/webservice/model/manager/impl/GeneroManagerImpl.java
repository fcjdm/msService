package edu.fpdual.webservice.model.manager.impl;

import edu.fpdual.webservice.model.dao.Genero;
import edu.fpdual.webservice.model.manager.GeneroManager;

import java.sql.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Genero DTO ManagerImpl.
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

            if (result.next()) {

                return queryResult(result);

            } else {

                return null;

            }

        }

    }

    @Override
    public Set<Genero> findByName(Connection con, String name) throws SQLException {

        try (PreparedStatement prepstm = con.prepareStatement("SELECT * FROM genero " +
                "WHERE genero LIKE ?")) {

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

    @Override
    public Genero findByID(Connection con, String id) throws SQLException {

        try (PreparedStatement prepstm = con.prepareStatement("SELECT * FROM genero " +
                "WHERE titulo LIKE ?")) {

            prepstm.setString(1, id);

            ResultSet result = prepstm.executeQuery();

            if (result.next()) {

                result.beforeFirst();
                result.next();

                return new Genero(result);

            } else {

                return null;

            }

        }

    }

}
