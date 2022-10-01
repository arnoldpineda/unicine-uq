package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Confiteria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Positive
    @Column (nullable =false)
    private float precio;

    @Column (length = 100, nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String urlImagen;

    @OneToMany(mappedBy = "confiteria")
    private List<CompraConfiteria> compraConfiterias;

    @Builder
    public Confiteria(float precio, String nombre, String urlImagen) {
        this.precio = precio;
        this.nombre = nombre;
        this.urlImagen = urlImagen;
    }
}
