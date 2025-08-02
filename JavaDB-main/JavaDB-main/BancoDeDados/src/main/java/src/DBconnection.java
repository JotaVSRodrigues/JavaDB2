package src;

import java.sql.*;

public class DBconnection {
    // variáveis necessárias para entrar no DB (URL, USER, SENHA)
    private static final String URL = "jdbc:mysql://localhost:3306/bd_teste";
    private static final String USER = "root";
    private static final String SENHA = "admin";
    
    // conexão com o DB
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, SENHA);
    }
}
