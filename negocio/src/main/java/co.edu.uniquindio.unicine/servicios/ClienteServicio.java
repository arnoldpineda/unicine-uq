package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.*;

import java.util.List;

public interface ClienteServicio {

    Cliente obtenerCliente (Integer codigoCliente) throws Exception;
    Cliente login (String correo, String password) throws Exception;

    Cliente registrarCliente(Cliente cliente) throws Exception;

    Cliente actualizarCliente(Cliente cliente) throws Exception;

    void eliminarCliente (Integer codigoCliente) throws Exception;

    List<Cliente> listarClientes();

    Pelicula obtenerPelicula (Integer codigo) throws Exception;

    List<Compra> listarHistorial(Integer codigoUsuario) throws Exception;

    Compra hacerCompra(Compra compra) throws Exception;

    boolean redimirCupon (Integer codigoCupon) throws Exception;

    CuponCliente obtenerCupon(Integer codigo) throws Exception;

    List<Funcion> listarPorCiudad(Integer codigoCiudad) throws Exception;

    List<Pelicula> listarPorEstadoCiudad(EstadoPelicula estadoPelicula, Integer codigoCiudad) throws Exception;

    List<Pelicula> listarPorEstado(EstadoPelicula estadoPelicula) throws Exception;


}
