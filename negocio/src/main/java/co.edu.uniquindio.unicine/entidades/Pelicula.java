package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pelicula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Lob
    @Column(nullable = false)
    private String sinopsis;

    @Column (nullable = false, length = 200)
    private String urlTrailer;

    @Column(nullable = false)
    private String urlImagen;

    @Column(nullable = false)
    private Boolean estado;

    @Lob
    @Column(nullable = false)
    private String reparto;

    @ToString.Exclude
    @OneToMany(mappedBy = "pelicula")
    private List<Funcion> funciones;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genero genero;

    @Builder
    public Pelicula(String nombre, String sinopsis, String urlTrailer, String urlImagen, Boolean estado, String reparto, Genero genero) {
        this.nombre = nombre;
        this.sinopsis = sinopsis;
        this.urlTrailer = urlTrailer;
        this.urlImagen = urlImagen;
        this.estado = estado;
        this.reparto = reparto;
        this.genero = genero;
    }
}
