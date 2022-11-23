package co.edu.uniquindio.unicine.bean;

import co.edu.uniquindio.unicine.entidades.Ciudad;
import co.edu.uniquindio.unicine.entidades.EstadoPelicula;
import co.edu.uniquindio.unicine.entidades.Genero;
import co.edu.uniquindio.unicine.entidades.Pelicula;
import co.edu.uniquindio.unicine.servicios.AdminServicio;
import co.edu.uniquindio.unicine.servicios.ClienteServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class InicioBean implements Serializable {

    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired
    private AdminServicio adminServicio;

    @Getter @Setter
    private List<Pelicula> peliculasCartelera;

    @Getter @Setter
    private List<Pelicula> peliculasProximas;

    @Getter @Setter
    private List<Ciudad> ciudades;

    @Getter @Setter
    private Ciudad ciudad;

    @PostConstruct
    public void inicializar(){
        try {
            peliculasCartelera = clienteServicio.listarPorEstado(EstadoPelicula.CARTELERA);
            peliculasProximas = clienteServicio.listarPorEstado(EstadoPelicula.PREVENTA);
            ciudades = adminServicio.listarCiudades();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void elegirCiudad(){
        try{
            if (ciudad!=null) {
                peliculasCartelera = clienteServicio.listarPorEstadoCiudad(EstadoPelicula.CARTELERA, ciudad.getCodigo());
                peliculasProximas = clienteServicio.listarPorEstadoCiudad(EstadoPelicula.PREVENTA, ciudad.getCodigo());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
