package edu.fpdual.proyecto.mangashelf.model.manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public interface Manager<T> {
    /**
     * Encuentra todas las entidades en la BBDD
     *
     * @param con DB connection
     * @return a {@link Set} of {@link T}
     */
    public Set<T> findAll(Connection con) throws SQLException;
    public Set<T> findByOrderAsc (Connection con) throws SQLException;
    public Set<T> findByOrderDesc (Connection con) throws SQLException;
    public Set<T> findByName (Connection con, String name) throws SQLException;
    public Set<T> queryResult (ResultSet result) throws SQLException;

}
