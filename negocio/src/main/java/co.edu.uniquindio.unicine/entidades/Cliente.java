package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private Integer cedula;// es el mismo codigo ??

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String fotoUrl;

    @Email
    @Column(length = 100, nullable = false, unique = true)
    private String correo;

    @Column(nullable = false, length = 16)
    private String password;

    @Column(nullable = false)
    private boolean estado;

    @ElementCollection
    private List<String> telefonos;

    @ToString.Exclude   //todo lo que sea one to many se exclude del ToString
    @OneToMany(mappedBy = "cupon")
    private List<CuponCliente> cuponClientes;

    @ToString.Exclude
    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;

    @Builder
    public Cliente(Integer cedula, String nombre, String correo, String password, String fotoUrl, List<String> telefonos) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.fotoUrl = fotoUrl;
        this.telefonos = telefonos;
        this.estado = false;
    }
}
