package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Libro implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String isbn;

    private String nombre;

    private Integer unidades;

    private Integer anio;

    @Enumerated(EnumType.STRING)
    private Genero genero;

}
