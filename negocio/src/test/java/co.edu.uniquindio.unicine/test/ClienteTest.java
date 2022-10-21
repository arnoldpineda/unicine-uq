package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.repo.ClienteRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteTest {

    @Autowired
    private ClienteRepo clienteRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar (){

        String[] tels = new String[]{"32445454", "4874746"};
        Cliente cliente = new Cliente(1234, "Pepito", "pepe@email.com", "123344", "ruta", Arrays.asList(tels));

        Cliente guardado = clienteRepo.save(cliente);
        //Assertions.assertEquals("Pepito", guardado.getNombre()); // compara el valor esperado con el guardado
        Assertions.assertNotNull(guardado);// comprueba que si haya quedao guardado en la base de datos, el objeto devuelto no puede ser null
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar() {
        Cliente buscado = clienteRepo.findById(1).orElse(null); //consulta
        clienteRepo.delete(buscado); //borra
        Assertions.assertNull(clienteRepo.findById(1).orElse(null)); //verifica que si sea null, si no lo encuentra devuelve null
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar() {
        Cliente guardado = clienteRepo.findById(4).orElse(null); //consulta
        guardado.setCorreo("pepe_nuevo@email.com");

        Cliente nuevo = clienteRepo.save(guardado);//verifica el Id y como ya esta creado modifica el correo
        Assertions.assertEquals("pepe_nuevo@email.com", nuevo.getCorreo());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtener() {
        Optional<Cliente> buscado = clienteRepo.findById(4); //consulta
        Assertions.assertNotNull(buscado.orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar() {
        List<Cliente> lista = clienteRepo.findAll();
        lista.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerPorCorreo() {
        Cliente cliente = clienteRepo.findByCorreo("luisa@gmail.com").orElse(null);
        //System.out.println(cliente);
        Assertions.assertNotNull(cliente); //No puede devolver un null
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void comprobarAutenticacion() {
        Cliente cliente = clienteRepo.findByCorreoAndPassword("luisa@gmail.com", "34s5d");
        //System.out.println(cliente);
        Assertions.assertNotNull(cliente); // estoy afirmando que no puede ser null
    }
}
