package edu.fpdual.webservice.mockito.manager.impl;

import edu.fpdual.webservice.model.dao.Usuarios;
import edu.fpdual.webservice.model.manager.impl.UsuariosManagerImpl;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

/**
 * UsuariosManagerImplTest.
 *
 * Prueba de UsuariosManagerImpl.
 *
 * @author ikisaki
 *
 */
@ExtendWith(MockitoExtension.class)
class UsuariosManagerImplTest {

    @Mock
    private Connection connection;

    @Mock
    private Statement statement;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private ResultSet resultSet;

    @InjectMocks
    private UsuariosManagerImpl usuariosManager;

    @Test
    void login_ok() throws SQLException {

        Usuarios expectedUsuarios = new Usuarios("pipomasterclass@gmail.com", "Wachino");

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

        doReturn(expectedUsuarios.getEmailUsuario()).when(resultSet).getString(any());
        when(resultSet.getString(any())).thenAnswer(new Answer<String>() {

            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {

                if (invocationOnMock.getArgument(0).equals("EmailUsuario")) {

                    return expectedUsuarios.getEmailUsuario();

                } else if (invocationOnMock.getArgument(0).equals("ContrasenyaUsuario")) {

                    return expectedUsuarios.getContrasenyaUsuario();

                } else {

                    return null;

                }

            }

        });

        Usuarios usuarios = usuariosManager.login(connection,"","");

        MatcherAssert.assertThat(usuarios, Matchers.is(expectedUsuarios));

    }

    @Test
    void findUser_ok() throws SQLException {

        Usuarios expectedUsuarios = new Usuarios("pipomasterclass@gmail.com", "Wachino");

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

        doReturn(expectedUsuarios.getEmailUsuario()).when(resultSet).getString(any());
        when(resultSet.getString(any())).thenAnswer(new Answer<String>() {

            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {

                if (invocationOnMock.getArgument(0).equals("EmailUsuario")) {

                    return expectedUsuarios.getEmailUsuario();

                } else if (invocationOnMock.getArgument(0).equals("ContrasenyaUsuario")) {

                    return expectedUsuarios.getContrasenyaUsuario();

                } else {

                    return null;

                }

            }

        });

        Usuarios usuarios = usuariosManager.findUser(connection,"");

        MatcherAssert.assertThat(usuarios, Matchers.is(expectedUsuarios));

    }

}
