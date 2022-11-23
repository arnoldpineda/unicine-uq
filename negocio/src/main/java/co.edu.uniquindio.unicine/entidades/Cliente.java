package co.edu.uniquindio.unicine.entidades;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter @Setter
@ToString(callSuper = true)
public class Cliente extends Persona implements Serializable {

    @NotNull
    @Column(nullable = false)
    private Integer cedula;

    @Length(max = 200)
    @Column(nullable = false, length = 200)
    private String urlFoto = "";

    @Column(nullable = false)
    private Boolean estado;

    @ElementCollection
    private List<String> telefonos;

    @ToString.Exclude   //todo lo que sea one to many se exclude del ToString
    @OneToMany(mappedBy = "cliente")
    private List<CuponCliente> cupones;

    @ToString.Exclude
    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;

    @Builder
    public Cliente(Integer cedula, String nombre, String correo, String password, String urlFoto, List<String> telefonos) {
        super(nombre, correo, password);
        this.cedula = cedula;
        this.urlFoto = urlFoto;
        this.telefonos = telefonos;
        this.estado = false;
    }
}
