package edu.fpdual.webservice.model.connector;

import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Clase responsable de la creación de la conexion con la BBDD de MySQL.
 *
 * @author ikisaki
 *
 */
public class MySQLConnector {

    @Setter
    @Getter
    Properties prop = new Properties();

    public MySQLConnector() {

        try {

            prop.load(getClass().getClassLoader().getResourceAsStream("config.properties"));

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    /**
     * Crea la conexión para la BBDD de MySQL
     *
     * @return a {@link Connection}
     * @throws ClassNotFoundException
     * @throws SQLException
     *
     * @author ikisaki
     *
     */
    public Connection getMySQLConnection() throws ClassNotFoundException, SQLException {

        try {

            Class.forName(prop.getProperty(MySQLConstants.DRIVER));

            return  DriverManager.getConnection(getURL());

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();
            throw e;

        }

    }

    /**
     * Obtiene la URL para conectar con la BBDD de MySQL.
     *
     * @return URL
     *
     * @author ikisaki
     *
     */
    private String getURL() {

        return new StringBuilder().append(prop.getProperty(MySQLConstants.URL_PREFIX))
                .append(prop.getProperty(MySQLConstants.URL_HOST)).append(":")
                .append(prop.getProperty(MySQLConstants.URL_PORT)).append("/")
                .append(prop.getProperty(MySQLConstants.URL_SCHEMA)).append("?user=")
                .append(prop.getProperty(MySQLConstants.USER)).append("&password=")
                .append(prop.getProperty(MySQLConstants.PASSWD)).append("&useSSL=")
                .append(prop.getProperty(MySQLConstants.URL_SSL)).append(("&allowPublicKeyRetrieval="))
                .append(prop.getProperty(MySQLConstants.ALLOW_PUBLIC_KEY_RETRIEVAL)).append(("&useJDBCCompliantTimezoneShift="))
                .append(prop.getProperty(MySQLConstants.USE_JDBC_COMPLIANT_TIMEZONE_SHIFT)).append(("&useLegacyDatetimeCode="))
                .append(prop.getProperty(MySQLConstants.USE_LEGACY_DATE_TIME_CODE)).append(("&serverTimezone="))
                .append(prop.getProperty(MySQLConstants.SERVER_TIMEZONE)).toString();

    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        MySQLConnector connector = new MySQLConnector();

        Connection connection = connector.getMySQLConnection();

        System.out.println(connection.getCatalog());

    }

}
