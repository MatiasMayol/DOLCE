package com.ejemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/facturas";
    private static final String USUARIO = "root";
    private static final String CLAVE = "123456";

    public static Connection conectar() {
        try {
            Connection conn = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println(" Conexión exitosa a la base de datos.");
            return conn;
        } catch (SQLException e) {
            System.out.println("? Error al conectar: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        conectar();
    }
}
