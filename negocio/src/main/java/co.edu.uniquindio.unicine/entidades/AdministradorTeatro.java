package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class AdministradorTeatro extends Persona implements Serializable {

    @ToString.Exclude
    @OneToMany(mappedBy = "administradorTeatro")
    private List<Teatro> teatros;

    @Builder
    public AdministradorTeatro(String correo, String nombre, String password) {
        super(nombre, correo, password);
    }
}
