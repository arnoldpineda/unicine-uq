package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Compra;

import java.util.List;

public interface ClienteServicio {

    Cliente obtenerCliente (Integer codigoCliente) throws Exception;
    Cliente login (String correo, String password) throws Exception;

    Cliente registrarCliente(Cliente cliente) throws Exception;

    Cliente actualizarCliente(Cliente cliente) throws Exception;

    void eliminarCliente (Integer codigoCliente) throws Exception;

    List<Cliente> listarClientes();

    List<Compra> listarHistorial(Integer codigoUsuario) throws Exception;

    Compra hacerCompra(Compra compra) throws Exception;

    boolean redimirCupon (Integer codigoCupon) throws Exception;


}
