package co.edu.uniquindio.unicine.entidades;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Libro implements Serializable {
    @Id
    private String isbn;
    private String nombre;
    private Integer unidades;
    private Integer anio;
    @Enumerated(EnumType.STRING)
    private Genero genero;

    public Libro() {
    }

    public Libro(String isbn, String nombre, Integer unidades, Integer anio, Genero genero) {
        this.isbn = isbn;
        this.nombre = nombre;
        this.unidades = unidades;
        this.anio = anio;
        this.genero = genero;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String ibsn) {
        this.isbn = ibsn;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getUnidades() {
        return unidades;
    }

    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Libro libro = (Libro) o;

        return Objects.equals(isbn, libro.isbn);
    }

    @Override
    public int hashCode() {
        return isbn != null ? isbn.hashCode() : 0;
    }
}
