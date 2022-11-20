package co.edu.uniquindio.unicine.entidades;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@ToString(callSuper = true)
public class Cliente extends Persona implements Serializable {

    @Column(nullable = false)
    private Integer cedula;

    @Column(nullable = false, length = 200)
    private String urlFoto;

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
