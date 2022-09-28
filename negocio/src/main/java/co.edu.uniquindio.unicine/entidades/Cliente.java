package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cliente extends Persona implements Serializable {

    @ElementCollection
    private Map<String, String> telefono;

}
