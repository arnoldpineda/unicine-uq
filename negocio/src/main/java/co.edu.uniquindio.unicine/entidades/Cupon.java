package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cupon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(length = 100, nullable = false)
    private String descripcion;

    @Positive
    @Column(nullable = false)
    private float descuento;

    @Column(length = 100, nullable = false)
    private String criterio;

    @Column(nullable = false)
    private LocalDateTime vencimiento;

    @ToString.Exclude
    @OneToMany(mappedBy = "cupon")
    private List<CuponCliente> cupon;

    @Builder
    public Cupon(String descripcion, float descuento, String criterio, LocalDateTime vencimiento) {
        this.descripcion = descripcion;
        this.descuento = descuento;
        this.criterio = criterio;
        this.vencimiento = vencimiento;
    }
}
