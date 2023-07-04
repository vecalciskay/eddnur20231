package edu.nur.edd.dao;

import edu.nur.edd.listas.ListaDoble;

import java.sql.*;

public class TestConexionPosgres {

    private final String url = "jdbc:mysql://localhost/p3";
    private final String user = "postgres";
    private final String password = "root";

    public static void main(String[] args) throws Exception {

        String sqlSelectAllPersons = "SELECT * FROM persona";
        String connectionUrl = "jdbc:mysql://localhost:3306/ed?useLegacyDatetimeCode=false&serverTimezone=UTC";

        Connection conn = DriverManager.getConnection(connectionUrl, "root", "root");
        PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            int altura = rs.getInt("altura");

            System.out.println(id + "|" + nombre + "|" + altura);
        }
    }
}
