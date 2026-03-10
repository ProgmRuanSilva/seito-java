package br.com.seito.factories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    String url = "jdbc:oracle:thin:@//oracle.fiap.com.br:1521/orcl";
    String user = "rm566719";
    String password = "240902";

    public Connection conexao() throws ClassNotFoundException, SQLException {

        // Instânciando o DriveManager
        Class.forName("oracle.jdbc.driver.OracleDriver");

        return DriverManager.getConnection(url, user, password);
    }

}

