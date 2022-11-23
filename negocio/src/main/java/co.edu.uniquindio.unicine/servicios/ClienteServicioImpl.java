package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Compra;
import co.edu.uniquindio.unicine.entidades.CuponCliente;
import co.edu.uniquindio.unicine.entidades.Pelicula;
import co.edu.uniquindio.unicine.repo.ClienteRepo;
import co.edu.uniquindio.unicine.repo.CuponClienteRepo;
import co.edu.uniquindio.unicine.repo.FuncionRepo;
import co.edu.uniquindio.unicine.repo.PeliculaRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicioImpl implements ClienteServicio {

    private final ClienteRepo clienteRepo;
    private final PeliculaRepo peliculaRepo;
    private final CuponClienteRepo cuponClienteRepo;
    private final EmailServicio emailServicio;

    private final FuncionRepo funcionRepo;

    public ClienteServicioImpl(ClienteRepo clienteRepo, PeliculaRepo peliculaRepo, CuponClienteRepo cuponClienteRepo, EmailServicio emailServicio, FuncionRepo funcionRepo) {
        this.clienteRepo = clienteRepo;
        this.peliculaRepo = peliculaRepo;
        this.cuponClienteRepo = cuponClienteRepo;
        this.emailServicio = emailServicio;
        this.funcionRepo = funcionRepo;
    }

    @Override
    public Cliente obtenerCliente(Integer codigoCliente) throws Exception {
        Optional<Cliente> guardado = clienteRepo.findById(codigoCliente);

        if (guardado.isEmpty()) {
            throw new Exception("El cliente no existe");
        }
        return guardado.get();
    }

    @Override
    public Cliente login(String correo, String password) throws Exception {
        Cliente cliente = clienteRepo.comprobarAutenticacion(correo, password);

        if (cliente == null) {
            throw new Exception("Los datos de autenticación son incorrectos");
        }
        return cliente;
    }

    @Override
    public Cliente registrarCliente(Cliente cliente) throws Exception {

        boolean correoExiste = correoEsRepetido(cliente.getCorreo());

        if (correoExiste){
            throw new Exception("El correo ya está registrado");
        }
        cliente.setEstado(false);
        Cliente registro = clienteRepo.save(cliente);
        emailServicio.enviarEmail("Registro en unicine", "Debe ir al siguiente enlace para activar la cuenta", cliente.getCorreo());
        return registro;
    }

    //Si devuelve un valor diferente a null, es por que esta repetido, es true
    private boolean correoEsRepetido(String correo) {
        return clienteRepo.findByCorreo(correo).orElse(null) != null;
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) throws Exception {

        Optional<Cliente> guardado = clienteRepo.findById(cliente.getCodigo());

        if (guardado.isEmpty()) {
            throw new Exception("El cliente no existe");
        }
        return clienteRepo.save(cliente);
    }

    @Override
    public void eliminarCliente(Integer codigoCliente) throws Exception {

        Optional<Cliente> guardado = clienteRepo.findById(codigoCliente);

        if (guardado.isEmpty()) {
            throw new Exception("El cliente no existe");
        }
        clienteRepo.delete(guardado.get());
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepo.findAll();
    }

    @Override
    public Pelicula obtenerPelicula(Integer codigo) throws Exception {
        Optional<Pelicula> guardado = peliculaRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new Exception("La pelicula no existe");
        }
        return guardado.get();
    }

    @Override
    public List<Compra> listarHistorial(Integer codigoUsuario) throws Exception {
        return null;
    }

    @Override
    public Compra hacerCompra(Compra compra) throws Exception {
        return null;
    }

    @Override
    public boolean redimirCupon(Integer codigoCupon) throws Exception {

        return false;
    }

    @Override
    public CuponCliente obtenerCupon(Integer codigo) throws Exception {
        Optional<CuponCliente> guardado = cuponClienteRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new Exception("El cupon no existe");
        }
        return guardado.get();
    }

    @Override
    public List<Funcion> listarPorCiudad(Integer codigoCiudad) throws Exception {
        return funcionRepo.listarFuncionesCiudad(codigoCiudad);
    }

    @Override
    public List<Pelicula> listarPorEstadoCiudad(EstadoPelicula estadoPelicula, Integer codigoCiudad) throws Exception {
        return funcionRepo.listarPeliculasEstadoCiudad(codigoCiudad, estadoPelicula);
    }

    @Override
    public List<Pelicula> listarPorEstado(EstadoPelicula estadoPelicula) throws Exception {
        return funcionRepo.listarPeliculasEstado(estadoPelicula);
    }


}
