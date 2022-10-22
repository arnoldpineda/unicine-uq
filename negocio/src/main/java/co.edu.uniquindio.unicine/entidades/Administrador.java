package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class Administrador extends Persona implements Serializable {

    @Builder
    public Administrador(String nombre, String correo, String password) {
        super(nombre, correo, password);
    }
}
