package edu.fpdual.webservice.model.manager.impl;


import edu.fpdual.webservice.model.dao.Autor;
import edu.fpdual.webservice.model.dao.Obra;
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
    public Set<Autor> findByName(Connection con, String name) throws SQLException  {
        try(PreparedStatement prepstm = con.prepareStatement("SELECT * FROM autor " +
                "WHERE nombre LIKE ?")){

            prepstm.setString(1, "%" + name + "%");

            ResultSet result = prepstm.executeQuery();

            if(result.next()){
                return queryResult(result);
            }else{
                return null;
            }

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

    @Override
    public Autor findByID(Connection con, String id) throws SQLException {
        try(PreparedStatement prepstm = con.prepareStatement("SELECT * FROM autor " +
                "WHERE titulos LIKE ?")){

            prepstm.setString(1, id);

            ResultSet result = prepstm.executeQuery();

            if(result.next()){
                result.beforeFirst();
                result.next();
                return new Autor(result);
            } else{
                return null;
            }
        }
    }
}
