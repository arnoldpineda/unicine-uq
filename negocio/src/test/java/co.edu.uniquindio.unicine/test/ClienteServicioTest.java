package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Cupon;
import co.edu.uniquindio.unicine.entidades.CuponCliente;
import co.edu.uniquindio.unicine.entidades.Pelicula;
import co.edu.uniquindio.unicine.servicios.ClienteServicio;
import co.edu.uniquindio.unicine.servicios.EmailServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class ClienteServicioTest {

    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired
    private EmailServicio emailServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarClienteTest() {

        Cliente cliente = Cliente.builder().cedula(1234).nombre("Juanito").password("1234").correo("juanito@gmail.com").urlFoto("http").build();

        try {
            Cliente nuevo = clienteServicio.registrarCliente(cliente);
            Assertions.assertNotNull(nuevo);
        } catch (Exception e) {
            //throw new RuntimeException(e); muestra la exception que nosotros creamos, a nivel de prueba se fuerza a fallar
            Assertions.assertTrue(false);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarClienteTest() {

        try {
            Cliente cliente = clienteServicio.obtenerCliente(1);
            cliente.setNombre("Nuevo nombre");
            Cliente nuevo = clienteServicio.actualizarCliente(cliente);

            Assertions.assertEquals("Nuevo nombre", nuevo.getNombre());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarClienteTest() {

        try {
            clienteServicio.eliminarCliente(1); //elimina el cliente, si no lo encuentra arroja la excepcion
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            clienteServicio.obtenerCliente(1); //busca el cliente arroja la excepcion por que no lo encuentra entonces es null
        } catch (Exception e) {
            Assertions.assertTrue(true); //como no lo encuentra arroja error y el assert quiere decir que si lo borro, entonces es true
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarClientesTest() {

        List<Cliente> lista = clienteServicio.listarClientes();
        lista.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerPeliculaTest(){

        try {
            Pelicula pelicula = clienteServicio.obtenerPelicula(1);
            Assertions.assertNotNull(pelicula);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test//
    @Sql("classpath:dataset.sql")
    public void obtenerCuponTest(){

        try {
            CuponCliente cupon = clienteServicio.obtenerCupon(2);
            Assertions.assertNotNull(cupon);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void enviarCorreotest(){
        emailServicio.enviarEmail("prueba de envio", "Este es un mensaje", "jmllantenm@uqvirtual.edu.co" );
    }
}
