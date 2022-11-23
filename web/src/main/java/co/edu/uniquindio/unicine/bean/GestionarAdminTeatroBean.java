package co.edu.uniquindio.unicine.bean;

import co.edu.uniquindio.unicine.entidades.AdministradorTeatro;
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
import java.util.List;

@Component
@ViewScoped
public class GestionarAdminTeatroBean implements Serializable {

    @Getter  @Setter
    private AdministradorTeatro administradorTeatro;

    @Getter @Setter
    private List<AdministradorTeatro> administradoresTeatro;

    @Getter @Setter
    private List<AdministradorTeatro> administradoresTeatroSeleccionados;

    @Autowired
    private AdminServicio adminServicio;

    private boolean editar;

    @PostConstruct
    public void init(){
        editar = false;
        administradorTeatro = new AdministradorTeatro();
        administradoresTeatro = adminServicio.listaAdminTeatros();
        administradoresTeatroSeleccionados = new ArrayList<>();
    }


    public void crearAdminTeatro(){
        try{
            if(!editar){

                AdministradorTeatro registro = adminServicio.crearAdminTeatro(administradorTeatro);
                administradoresTeatro.add(registro);

                administradorTeatro = new AdministradorTeatro();


                FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Se ha creado un nuevo administrador de teatro");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", msj);

            }else {
                adminServicio.actualizarAdminTeatro(administradorTeatro);
                FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "administrador de teatro actualizado correctamente");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", msj);
            }

        }catch (Exception e){
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", msj);
        }
    }

    public void eliminarAdminTeatro(){

        try {
            for (AdministradorTeatro t : administradoresTeatro) {
                adminServicio.eliminarAdminTeatro(t.getCodigo());
                administradoresTeatro.remove(t);
            }
            administradoresTeatroSeleccionados.clear();
        }catch (Exception e) {
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", msj);
        }
    }

    public String getMensajeBorrar(){
        if(administradoresTeatroSeleccionados.isEmpty()){
            return "Borrar";
        }
        return administradoresTeatroSeleccionados.size()==1 ? "Borrar 1 elemento" : "Borrar " + administradoresTeatroSeleccionados.size()+" elementos";
    }

    public String getMensajeCrear(){
        return editar ? "Editar administrador" : "Crear administrador";
    }

    public void seleccionarAdminTeatro(AdministradorTeatro adminTeatroSeleccionado){
        this.administradorTeatro = adminTeatroSeleccionado;
        editar = true;
    }

    public void crearAdminTeatroDialogo(){
        this.administradorTeatro = new AdministradorTeatro();
        editar = false;
    }
}
