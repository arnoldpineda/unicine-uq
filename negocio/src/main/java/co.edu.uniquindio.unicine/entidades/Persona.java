package co.edu.uniquindio.unicine.entidades;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Persona implements Serializable {
    @Id
    private String cedula;
    private String nombre;
    private String email;
    @ElementCollection
    private List<String> telefono;

    public Persona() {
    }

    public Persona(String cedula, String nombre, String email, List<String> telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getTelefono() {
        return telefono;
    }

    public void setTelefono(List<String> telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Persona persona = (Persona) o;

        return Objects.equals(cedula, persona.cedula);
    }

    @Override
    public int hashCode() {
        return cedula != null ? cedula.hashCode() : 0;
    }
}
