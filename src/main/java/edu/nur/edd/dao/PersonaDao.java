package edu.nur.edd.dao;

import edu.nur.edd.listas.ListaDoble;

import java.sql.*;

public class PersonaDao {
    public PersonaDao() {

    }
    public PersonaDto getById(int id) {
        String sqlSelect = "SELECT id,nombre,altura FROM persona where id=" + id;
        PersonaDto resultado = null;
        try {
            ConexionMySql con = ConexionMySql.getOrCreate();
            ResultSet rs = con.ejecutar(sqlSelect);

            if (rs.next()) {
                int idsql = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int altura = rs.getInt("altura");

                resultado = new PersonaDto(idsql, nombre, altura);
            }

        } catch (SQLException e) {
            // loggear
            // throw new DaoException(msg)
        }
        return resultado;
    }

    public ListaDoble<PersonaDto> getAll() {
        ListaDoble<PersonaDto> resultado = null;
        String sqlSelect = "SELECT id,nombre,altura FROM persona";
        try {
            ConexionMySql con = ConexionMySql.getOrCreate();
            ResultSet rs = con.ejecutar(sqlSelect);

            resultado = new ListaDoble<>();
            while (rs.next()) {
                int idsql = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int altura = rs.getInt("altura");

                resultado.insertar(new PersonaDto(idsql, nombre, altura));
            }
        } catch(SQLException q) {
            // loggear
            // throw new DaoException(msg)
        }
        return resultado;
    }

    public boolean update(PersonaDto p) {
        String sql = "UPDATE persona " +
                "SET nombre='" + p.getNombre() + "', " +
                "altura=" + p.getAltura() +
                " WHERE id=" + p.getId();
        try {
            ConexionMySql con = ConexionMySql.getOrCreate();
            con.ejecutarUpdate(sql);
        } catch (SQLException e) {
            // loggear
            // throw new DaoException(msg)
            return false;
        }
        return true;
    }

    public void delete(int i) {
    }

    public void insert(PersonaDto nuevo) {
    }
}
