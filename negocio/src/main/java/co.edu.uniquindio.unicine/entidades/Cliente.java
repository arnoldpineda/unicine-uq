package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
@ToString
public class Cliente implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private Integer cedula;// es el mismo codigo ??

    @Column (length = 100 , nullable = false)
    private String nombre;

    @Column (nullable = false)
    private String fotoUrl;

    @Email
    @Column(length = 100, nullable = false, unique = true)
    private String correo;

    @Column(nullable = false, length = 16)
    private String password;

    @Column (nullable = false)
    private boolean estado;

    @ElementCollection
    private Map<String, String> telefono;

    @OneToMany(mappedBy = "cupon")
    private List<CuponCliente> cuponClientes;

    @OneToMany (mappedBy = "cliente")
    private List<Compra> compras;

    @Builder
    public Cliente(String nombre, String correo, String password, boolean estado, Map<String, String> telefono) {
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.estado = estado;
        this.telefono = telefono;
    }
}
