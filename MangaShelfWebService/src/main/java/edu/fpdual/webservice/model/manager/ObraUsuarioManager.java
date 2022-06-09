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

    public Set<ObraUsuario> findByUser (Connection con, String email) throws SQLException;
    public int addObra (Connection con, String email, String obraLeyendo) throws SQLException;
    public int deleteObraUsuario (Connection con, String email, String obra) throws SQLException;
    public int sumChap(Connection con, String email, String obra) throws SQLException;
    public int resChap(Connection con, String email, String obra) throws SQLException;
    public Set<ObraUsuario> queryResult (ResultSet result) throws SQLException;
    public ObraUsuario findByID (Connection con, String email, String obra) throws SQLException;
    public int updateStatus (Connection con, String email, String obra, int caps, String status) throws SQLException;
    public Set<ObraUsuario> findByStatus(Connection con, String email, String status) throws SQLException;

}