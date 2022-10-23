package co.edu.uniquindio.unicine.dto;

import co.edu.uniquindio.unicine.entidades.Horario;
import co.edu.uniquindio.unicine.entidades.Sala;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class HorarioSalaDTO {
    private Horario horario;
    private Sala sala;
}