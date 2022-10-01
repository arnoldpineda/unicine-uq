package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class CuponCliente implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column (nullable = false)
    private Boolean estado;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Cupon cupon;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Cliente cliente;

    @OneToOne (mappedBy = "cuponCliente")
    private Compra compra;

    @Builder
    public CuponCliente(Boolean estado, Cupon cupon, Cliente cliente) {
        this.estado = estado;
        this.cupon = cupon;
        this.cliente = cliente;
    }
}
