package co.edu.uniquindio.unicine.dto;

import co.edu.uniquindio.unicine.entidades.Funcion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class InformacionCompra {
    private Float precioTotal;
    private LocalDateTime fecha;
    private Funcion funcion;
    private Double precioEntradas;
    private Double precioConfiteria;
}