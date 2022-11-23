package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.Administrador;
import co.edu.uniquindio.unicine.entidades.AdministradorTeatro;
import co.edu.uniquindio.unicine.entidades.Ciudad;
import co.edu.uniquindio.unicine.entidades.Confiteria;
import co.edu.uniquindio.unicine.entidades.Cupon;
import co.edu.uniquindio.unicine.entidades.Pelicula;

import java.util.List;

public interface AdminServicio {

    Administrador login (String correo, String paswword) throws Exception;

    AdministradorTeatro crearAdminTeatro (AdministradorTeatro adminTeatro)throws Exception;

    AdministradorTeatro obtenerAdminTeatro (Integer codigo)throws Exception;

    AdministradorTeatro actualizarAdminTeatro (AdministradorTeatro adminTeatro)throws Exception;

    void eliminarAdminTeatro (Integer codigo)throws Exception;

    List<AdministradorTeatro> listaAdminTeatros ();

    Pelicula crearPelicula (Pelicula pelicula);

    Pelicula obtenerPelicula (Integer codigo)throws Exception;

    Pelicula actualizarPelicula (Pelicula pelicula)throws Exception;

    void eliminarPelicula (Integer codigo)throws Exception;

    List<Pelicula> listarPeliculas ();

    Confiteria crearConfiteria (Confiteria confiteria) throws Exception;

    Confiteria obtenerConfiteria (Integer codigo)throws Exception;

    Confiteria actualizarConfiteria (Confiteria confiteria)throws Exception;

    void eliminarConfiteria (Integer codigo)throws Exception;

    List<Confiteria> listarConfiterias ();

    Cupon crearCupon (Cupon cupon) throws Exception;

    Cupon obtenerCupon (Integer codigo)throws Exception;

    Cupon actualizarCupon (Cupon cupon)throws Exception;

    void eliminarCupon (Integer codigo)throws Exception;

    List<Cupon > listarCupones ();

    Ciudad crearCiudad (Ciudad ciudad);

    Ciudad obtenerCiudad(Integer codigo)throws Exception;

    List<Ciudad> listarCiudades();



}
