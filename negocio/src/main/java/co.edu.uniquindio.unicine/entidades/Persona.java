package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Persona implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String cedula;

    private String nombre;

    private String email;

    @ElementCollection
    private List<String> telefono;

}
