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
public class Obra {

    private String id;
    private String titulo;
    private int anyoPublicacion;
    private String anyoTermino;
    private String capitulosTotales;

    public Obra(ResultSet result) throws SQLException {
        setId(result.getString("Id"));
        setTitulo(result.getString("Titulo"));
        setAnyoPublicacion(result.getInt("AnyoPublicacion"));
        setAnyoTermino(result.getString("AnyoTermino"));
        setCapitulosTotales(result.getString("CapitulosTotales"));
    }


}