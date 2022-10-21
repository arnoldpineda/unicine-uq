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
public class Compra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MedioPago medioPago;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Positive
    @Column(nullable = false)
    private Float valorTotal;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Funcion funcion;

    @ToString.Exclude
    @OneToMany(mappedBy = "compra")
    private List<Entrada> entradas;

    @ToString.Exclude
    @OneToMany(mappedBy = "compra")
    private List<CompraConfiteria> compraConfiterias;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Cliente cliente;

    @OneToOne
    private CuponCliente cuponCliente;

    @Builder
    public Compra(MedioPago medioPago, Float valorTotal, Funcion funcion, Cliente cliente, CuponCliente cuponCliente) {
        this.medioPago = medioPago;
        this.fecha = LocalDateTime.now();
        this.valorTotal = valorTotal;
        this.funcion = funcion;
        this.cliente = cliente;
        this.cuponCliente = cuponCliente;
    }
}