package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Autor extends Persona implements Serializable {

    @ManyToMany(mappedBy = "autores")
    private List<Libro> libros;

}
