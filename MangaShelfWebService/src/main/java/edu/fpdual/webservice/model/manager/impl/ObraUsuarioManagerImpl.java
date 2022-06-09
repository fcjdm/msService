package edu.fpdual.webservice.model.manager.impl;

import edu.fpdual.webservice.Status;
import edu.fpdual.webservice.model.dao.ObraUsuario;
import edu.fpdual.webservice.model.manager.ObraUsuarioManager;

import java.sql.*;
import java.util.LinkedHashSet;
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
    public Set<ObraUsuario> findByUser(Connection con, String email) throws SQLException  {
        try(PreparedStatement prepstm = con.prepareStatement("SELECT * FROM obra_usuario " +
                "WHERE usuario LIKE ?")){

            prepstm.setString(1, "%" + email + "%");

            ResultSet result = prepstm.executeQuery();
            return queryResult(result);
        }
    }

    @Override
    public int addObra(Connection con, String email, String obraLeyendo) throws SQLException {

        try(PreparedStatement prepstm = con.prepareStatement("INSERT INTO obra_usuario(usuario, obra, capitulosLeidos, estado) " +
                "VALUES (?,?,0,?)")){
            prepstm.setString(1, email);
            prepstm.setString(2, obraLeyendo);
            prepstm.setString(3, Status.LEYENDO.toString());
            return prepstm.executeUpdate();
        }
    }

    @Override
    public int deleteObraUsuario(Connection con, String email, String obra) throws SQLException {
        try(PreparedStatement prepstm = con.prepareStatement("DELETE FROM obra_usuario " +
                "WHERE usuario = ? AND obra = ?")){
            prepstm.setString(1, email);
            prepstm.setString(2, obra);

            return prepstm.executeUpdate();
        }
    }

    @Override
    public int sumChap(Connection con, String email, String obra) throws SQLException {
        try(PreparedStatement prepstm = con.prepareStatement("UPDATE obra_usuario " +
                "SET capitulosLeidos = capitulosLeidos + 1 WHERE usuario = ? AND obra = ?")){
            prepstm.setString(1, email);
            prepstm.setString(2, obra);

            return prepstm.executeUpdate();
        }
    }

    @Override
    public int resChap(Connection con, String email, String obra) throws SQLException {
        try(PreparedStatement prepstm = con.prepareStatement("UPDATE obra_usuario " +
                "SET capitulosLeidos = capitulosLeidos - 1 WHERE usuario = ? AND obra = ?")){
            prepstm.setString(1, email);
            prepstm.setString(2, obra);

            return prepstm.executeUpdate();
        }
    }

    @Override
    public Set<ObraUsuario> queryResult(ResultSet result) throws SQLException {
        Set<ObraUsuario> set = new LinkedHashSet<>();
        result.beforeFirst();
        while (result.next()) {
            ObraUsuario obraUsuario = new ObraUsuario(result);
            set.add(obraUsuario);
        }

        return set;
    }

    @Override
    public ObraUsuario findByID(Connection con, String email, String obra) throws SQLException {
        try(PreparedStatement prepstm = con.prepareStatement("SELECT * FROM obra_usuario " +
                "WHERE usuario LIKE ? AND obra LIKE ?")){

            prepstm.setString(1, email);
            prepstm.setString(2, obra);

            ResultSet result = prepstm.executeQuery();

            if(result.next()){
                result.beforeFirst();
                result.next();
                return new ObraUsuario(result);
            } else{
                return null;
            }
        }
    }

    @Override
    public int updateStatus(Connection con, String email, String obra, String status) throws SQLException {
        try(PreparedStatement prepstm = con.prepareStatement("UPDATE obra_usuario " +
                "SET estado = ? WHERE usuario = ? AND obra = ?")){
            prepstm.setString(1, status);
            prepstm.setString(2, email);
            prepstm.setString(3, obra);

            return prepstm.executeUpdate();
        }
    }

}

