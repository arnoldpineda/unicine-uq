package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.AdministradorTeatro;
import co.edu.uniquindio.unicine.entidades.Ciudad;
import co.edu.uniquindio.unicine.entidades.Funcion;
import co.edu.uniquindio.unicine.entidades.Horario;
import co.edu.uniquindio.unicine.entidades.Sala;
import co.edu.uniquindio.unicine.entidades.Teatro;

import java.util.List;

public interface AdminTeatroServicio {

    AdministradorTeatro login (String correo, String paswword) throws Exception;

    Horario crearHorario(Horario horario);

    Horario obtenerHorario(Integer codigo) throws Exception;

    Horario actualizarHorario (Horario horario) throws Exception;

    void eliminarHorario (Integer codigo) throws Exception;

    List<Horario> listarHorarios();

    Ciudad obtenerCiudad(Integer codigo)throws Exception;

    AdministradorTeatro obtenerAdminTeatro (Integer codigo)throws Exception;

    Teatro crearTeatro(Teatro teatro) throws Exception;

    Teatro obtenerTeatro(Integer codigo) throws Exception;

    Teatro actualizarTeatro (Teatro teatro) throws Exception;

    void eliminarTeatro (Integer codigo) throws Exception;

    List<Teatro> listarTeatros();

    Funcion crearFuncion(Funcion funcion) throws Exception;

    Funcion obtenerFuncion(Integer codigo) throws Exception;

    Funcion actualizarFuncion (Funcion funcion) throws Exception;

    void eliminarFuncion (Integer codigo) throws Exception;

    List<Funcion> listarFunciones();

    Sala crearSala(Sala sala) throws Exception;

    Sala obtenerSala(Integer codigo) throws Exception;

    Sala actualizarSala (Sala sala) throws Exception;

    void eliminarSala (Integer codigo) throws Exception;

    List<Sala> listarSalas();


}
