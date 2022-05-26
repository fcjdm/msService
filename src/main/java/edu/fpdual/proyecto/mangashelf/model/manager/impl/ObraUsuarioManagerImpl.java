package edu.fpdual.proyecto.mangashelf.model.manager.impl;

import edu.fpdual.proyecto.mangashelf.model.dao.ObraUsuario;
import edu.fpdual.proyecto.mangashelf.model.manager.ObraUsuarioManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
    public Set<ObraUsuario> findAll(Connection con) {
        // Crea el statement general.
        return null;
    }

    @Override
    public Set<ObraUsuario> findByOrderAsc(Connection con) throws SQLException {
        return null;
    }

    @Override
    public Set<ObraUsuario> findByOrderDesc(Connection con) throws SQLException {
        return null;
    }

    @Override
    public Set<ObraUsuario> findByName(Connection con, String name) throws SQLException {
        return null;
    }

    @Override
    public Set<ObraUsuario> queryResult(ResultSet result) throws SQLException {
        return null;
    }
}

