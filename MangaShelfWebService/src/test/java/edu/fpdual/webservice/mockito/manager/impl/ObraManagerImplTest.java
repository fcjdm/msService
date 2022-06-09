package edu.fpdual.webservice.mockito.manager.impl;

import edu.fpdual.webservice.model.dao.Obra;
import edu.fpdual.webservice.model.manager.impl.ObraManagerImpl;
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

/**
 * ObraManagerImplTest.
 *
 * Prueba de ObraManagerImpl.
 *
 * @author ikisaki
 *
 */
@ExtendWith(MockitoExtension.class)
class ObraManagerImplTest {

    @Mock
    private Connection connection;

    @Mock
    private Statement statement;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private ResultSet resultSet;

    @InjectMocks
    private ObraManagerImpl obraManager;

    @Test
    void findAll_ok() throws SQLException {

        Obra expectedObra = new Obra("AssassinationClassroom","Assassination Classroom", 2012, "2016", "187");

        when(connection.createStatement()).thenReturn(statement);
        when(statement.executeQuery(any())).thenReturn(resultSet);
        when(resultSet.next()).thenAnswer(new Answer<Boolean>() {

            private int counter = 0;

            @Override
            public Boolean answer(InvocationOnMock invocationOnMock) throws Throwable {

                if (counter < 1) {

                    counter++;

                    return true;

                } else {

                    return false;

                }

            }

        });

        doReturn(expectedObra.getId()).when(resultSet).getString(any());
        when(resultSet.getInt(any())).thenAnswer(new Answer<Integer>() {

            @Override
            public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {

                if (invocationOnMock.getArgument(0).equals("AnyoPublicacion")) {

                    return expectedObra.getAnyoPublicacion();

                } else {

                    return null;

                }

            }

        });

        when(resultSet.getString(any())).thenAnswer(new Answer<String>() {

            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {

                if (invocationOnMock.getArgument(0).equals("Id")) {

                    return expectedObra.getId();

                } else if (invocationOnMock.getArgument(0).equals("Titulo")) {

                    return expectedObra.getTitulo();

                } else if (invocationOnMock.getArgument(0).equals("AnyoTermino")) {

                    return expectedObra.getAnyoTermino();

                } else if (invocationOnMock.getArgument(0).equals("CapitulosTotales")) {

                    return expectedObra.getCapitulosTotales();

                } else {

                    return null;

                }

            }

        });

        Set<Obra> obraSet = obraManager.findAll(connection);

        MatcherAssert.assertThat(obraSet, Matchers.hasSize(1));
        MatcherAssert.assertThat(obraSet.iterator().next(), Matchers.is(expectedObra));

    }

    @Test
    void findByID_ok() throws SQLException {

        Obra expectedObra = new Obra("AssassinationClassroom", "Assassination Classroom", 2012, "2016", "187");

        when(connection.prepareStatement(any())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenAnswer(new Answer<Boolean>() {

            private int counter = 0;

            @Override
            public Boolean answer(InvocationOnMock invocationOnMock) throws Throwable {

                if (counter < 1) {

                    counter++;

                    return true;

                } else {

                    return false;

                }

            }

        });

        doReturn(expectedObra.getId()).when(resultSet).getString(any());
        when(resultSet.getInt(any())).thenAnswer(new Answer<Integer>() {

            @Override
            public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {

                if (invocationOnMock.getArgument(0).equals("AnyoPublicacion")) {

                    return expectedObra.getAnyoPublicacion();

                } else {

                    return null;

                }

            }

        });

        when(resultSet.getString(any())).thenAnswer(new Answer<String>() {

            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {

                if (invocationOnMock.getArgument(0).equals("Id")) {

                    return expectedObra.getId();

                } else if (invocationOnMock.getArgument(0).equals("Titulo")) {

                    return expectedObra.getTitulo();

                } else if (invocationOnMock.getArgument(0).equals("AnyoTermino")) {

                    return expectedObra.getAnyoTermino();

                } else if (invocationOnMock.getArgument(0).equals("CapitulosTotales")) {

                    return expectedObra.getCapitulosTotales();

                } else {

                    return null;

                }

            }

        });

        Obra obra = obraManager.findByID(connection,"");

        MatcherAssert.assertThat(obra, Matchers.is(expectedObra));

    }

}