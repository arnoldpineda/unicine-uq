package co.edu.uniquindio.unicine.entidades;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Entrada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Positive
    private Float precio;

    @Positive
    private Integer fila;

    @Positive
    private Integer columna;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Compra compra;

}
