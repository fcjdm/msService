package edu.fpdual.webservice.model.manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

/**
 * Manager.
 *
 * Contiene todas las queries utilizadas para la consulta y manipulacion de datos de Autor, Genero y Obra.
 *
 * @author ikisaki
 *
 */
public interface Manager<T> {

    Set<T> findAll(Connection con) throws SQLException;

    Set<T> findByName(Connection con, String name) throws SQLException;

    Set<T> queryResult(ResultSet result) throws SQLException;

    T findByID(Connection con, String id) throws SQLException;

}
