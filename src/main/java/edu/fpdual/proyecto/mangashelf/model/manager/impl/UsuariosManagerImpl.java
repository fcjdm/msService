package edu.fpdual.proyecto.mangashelf.model.manager.impl;

import edu.fpdual.proyecto.mangashelf.model.dao.Usuarios;
import edu.fpdual.proyecto.mangashelf.model.manager.UsuariosManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    public Set<Usuarios> findAll(Connection con) {
        return null;
    }

    @Override
    public Set<Usuarios> findByOrderAsc(Connection con) throws SQLException {
        return null;
    }

    @Override
    public Set<Usuarios> findByOrderDesc(Connection con) throws SQLException {
        return null;
    }

    @Override
    public Set<Usuarios> findByName(Connection con, String name) throws SQLException {
        return null;
    }

    @Override
    public Set<Usuarios> queryResult(ResultSet result) throws SQLException {
        return null;
    }
}
