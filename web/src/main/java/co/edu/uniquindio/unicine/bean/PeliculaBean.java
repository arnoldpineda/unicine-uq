package co.edu.uniquindio.unicine.bean;

import co.edu.uniquindio.unicine.entidades.EstadoPelicula;
import co.edu.uniquindio.unicine.entidades.Genero;
import co.edu.uniquindio.unicine.entidades.Pelicula;
import co.edu.uniquindio.unicine.servicios.AdminServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@ViewScoped
public class PeliculaBean implements Serializable {

    @Getter @Setter
    private Pelicula pelicula;

    @Getter @Setter
    private List<Pelicula> peliculas;

    @Getter @Setter
    private List<Pelicula> peliculasSeleccionadas;

    @Autowired
    private AdminServicio adminServicio;

    @Getter @Setter
    private List<Genero> generos;

    private boolean editar;

    @PostConstruct
    public void init(){
        pelicula = new Pelicula();
        generos = Arrays.asList(Genero.values());
        editar = false;
        peliculasSeleccionadas = new ArrayList<>();
        peliculas = adminServicio.listarPeliculas();
    }

    public void crearPelicula(){
        try{
            if(!editar){

            pelicula.setEstado(EstadoPelicula.CARTELERA);

            Pelicula registro = adminServicio.crearPelicula(pelicula);
            peliculas.add(registro);

            pelicula = new Pelicula();


            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Se ha creado la película correctamente");
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", msj);

            }else {
                adminServicio.actualizarPelicula(pelicula);
                FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Película actualizada correctamente");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", msj);
            }

        }catch (Exception e){
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", msj);
        }
    }

    public void eliminarPelicula(){

        try {
            for (Pelicula t : peliculasSeleccionadas) {
                adminServicio.eliminarPelicula(t.getCodigo());
                peliculas.remove(t);
            }
            peliculasSeleccionadas.clear();
        }catch (Exception e) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", msj);
        }
    }

    public String getMensajeBorrar(){
        if(peliculasSeleccionadas.isEmpty()){
            return "Borrar";
        }
        return peliculasSeleccionadas.size()==1 ? "Borrar 1 elemento" : "Borrar " + peliculasSeleccionadas.size()+" elementos";
    }

    public String getMensajeCrear(){
        return editar ? "Editar pelicula" : "Crear pelicula";
    }

    public void seleccionarPelicula(Pelicula peliculaSeleccionada){
        this.pelicula = peliculaSeleccionada;
        editar = true;
    }

    public void crearPeliculaDialogo(){
        this.pelicula = new Pelicula();
        editar = false;
    }
}
