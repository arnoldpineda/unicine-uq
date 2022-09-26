package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;

@Entity
@Inheritance
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false, length = 200)
    private String nombre;
}
