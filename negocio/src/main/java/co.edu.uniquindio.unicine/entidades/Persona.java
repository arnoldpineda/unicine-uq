package co.edu.uniquindio.unicine.entidades;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Length(max = 100)
    @Column(length = 100, nullable = false)
    private String nombre;

    @Email
    @Length(max = 100)
    @NotNull
    @Column(length = 100, nullable = false, unique = true)
    private String correo;

    @ToString.Exclude
    @Length(max = 16)
    @NotNull
    @Column(nullable = false, length = 16)
    private String password;

    public Persona(String nombre, String correo, String password) {
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
    }
}
