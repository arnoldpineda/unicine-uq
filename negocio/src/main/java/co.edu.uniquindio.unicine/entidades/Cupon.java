package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Cupon implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column (length = 100 , nullable = false)
    private String descripcion;

    @Positive
    @Column(nullable = false)
    private float descuento;

    @Column (length = 100 , nullable = false)
    private String criterio;

    @Column(nullable = false)
    private LocalDateTime vencimiento;

    @OneToMany(mappedBy = "cupon")
    private List<CuponCliente> cuponClientes;

    @Builder
    public Cupon(String descripcion, float descuento, String criterio, LocalDateTime vencimiento) {
        this.descripcion = descripcion;
        this.descuento = descuento;
        this.criterio = criterio;
        this.vencimiento = vencimiento;
    }
}
