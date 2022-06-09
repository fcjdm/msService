package edu.fpdual.webservice.model.manager;

import edu.fpdual.webservice.model.dao.ObraUsuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

/**
 * ObraUsuario DTO Manager.
 *
 * Contiene todas las queries utilizadas para la consulta y manipulacion de datos de ObraUsuarios.
 *
 * @author ikisaki
 *
 */
public interface ObraUsuarioManager{

    Set<ObraUsuario> findByUser(Connection con, String email) throws SQLException;

    int addObra(Connection con, String email, String obraLeyendo) throws SQLException;

    int deleteObraUsuario(Connection con, String email, String obra) throws SQLException;

    int sumChap(Connection con, String email, String obra) throws SQLException;

    int resChap(Connection con, String email, String obra) throws SQLException;

    Set<ObraUsuario> queryResult(ResultSet result) throws SQLException;

    ObraUsuario findByID(Connection con, String email, String obra) throws SQLException;

    int updateStatus(Connection con, String email, String obra, int caps, String status) throws SQLException;

    Set<ObraUsuario> findByStatus(Connection con, String email, String status) throws SQLException;

}