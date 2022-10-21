package co.edu.uniquindio.unicine.entidades;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
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

    @Builder
    public Entrada(Float precio, Integer fila, Integer columna, Compra compra) {
        this.precio = precio;
        this.fila = fila;
        this.columna = columna;
        this.compra = compra;
    }
}
