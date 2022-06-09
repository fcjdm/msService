package edu.fpdual.webservice.model.dao;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder

/**
 * Usuarios.
 *
 * DAO de Usuarios.
 *
 * @author ikisaki
 *
 */
public class Usuarios {

    private String emailUsuario;
    private String contrasenyaUsuario;

    public Usuarios(ResultSet result) throws SQLException {

        setEmailUsuario(result.getString("EmailUsuario"));
        setContrasenyaUsuario(result.getString("ContrasenyaUsuario"));

    }

}