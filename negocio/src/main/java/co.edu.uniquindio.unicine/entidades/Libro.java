package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
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

    @Column(nullable = false)
    private String nombre;

    @PositiveOrZero
    private Integer unidades;

    @PositiveOrZero
    private Integer anio;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genero genero;

}
