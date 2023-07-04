package edu.nur.edd.dao;

/**
 * DTO = Datta Transfer Object
 */
public class PersonaDto {
    private int id;
    private String nombre;
    private int altura;

    public PersonaDto(int id, String nombre, int altura) {
        this.id = id;
        this.nombre = nombre;
        this.altura = altura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "PersonaDto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", altura=" + altura +
                '}';
    }
}
