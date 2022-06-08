package edu.fpdual.webservice.mockito.manager.impl;


import edu.fpdual.webservice.model.dao.Genero;
import edu.fpdual.webservice.model.manager.impl.GeneroManagerImpl;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GeneroManagerImplTest {

    @Mock
    private Connection connection;

    @Mock
    private Statement statement;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private ResultSet resultSet;

    @InjectMocks
    private GeneroManagerImpl generoManager;

    @Test
    void findAll_ok() throws SQLException {

        Genero expectedGenero = new Genero("Accion", "Assassination Classroom");

        when(connection.createStatement()).thenReturn(statement);
        when(statement.executeQuery(any())).thenReturn(resultSet);
        when(resultSet.next()).thenAnswer(new Answer<Boolean>() {

            private int counter = 0;

            @Override
            public Boolean answer(InvocationOnMock invocationOnMock) throws Throwable {
                if(counter < 1){
                    counter++;
                    return true;
                } else {
                    return false;
                }
            }
        });

        doReturn(expectedGenero.getGenero()).when(resultSet).getString(any());
        when(resultSet.getString(any())).thenAnswer(new Answer<String>() {

            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {

                if(invocationOnMock.getArgument(0).equals("Genero")){
                    return expectedGenero.getGenero();
                } else if(invocationOnMock.getArgument(0).equals("Titulo")) {
                    return expectedGenero.getTitulo();
                } else{
                    return null;
                }
            }
        });

        Set<Genero> generoSet = generoManager.findAll(connection);

        MatcherAssert.assertThat(generoSet, Matchers.hasSize(1));
        MatcherAssert.assertThat(generoSet.iterator().next(), Matchers.is(expectedGenero));

    }

    @Test
    void findByName_ok() throws SQLException {

        Genero expectedGenero = new Genero("Accion", "Assassination Classroom");

        when(connection.prepareStatement(any())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenAnswer(new Answer<Boolean>() {

            private int counter = 0;

            @Override
            public Boolean answer(InvocationOnMock invocationOnMock) throws Throwable {
                if(counter < 1){
                    counter++;
                    return true;
                } else {
                    return false;
                }
            }
        });
        doReturn(expectedGenero.getGenero()).when(resultSet).getString(any());
        when(resultSet.getString(any())).thenAnswer(new Answer<String>() {

            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {

                if(invocationOnMock.getArgument(0).equals("Genero")){
                    return expectedGenero.getGenero();
                } else if(invocationOnMock.getArgument(0).equals("Titulo")) {
                    return expectedGenero.getTitulo();
                } else{
                    return null;
                }
            }
        });

        Set<Genero> generoSet = generoManager.findByName(connection,"");

        MatcherAssert.assertThat(generoSet, Matchers.hasSize(1));
        MatcherAssert.assertThat(generoSet.iterator().next(), Matchers.is(expectedGenero));

    }

}