package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.repo.ClienteRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteTest {

    @Autowired
    private ClienteRepo clienteRepo;

    @Test
    public void registrar (){

        String [] tels  = new String[] {"32445454", "4874746"};
        Cliente cliente = new Cliente(1234, "Pepito", "pepe@email.com", "123344", "ruta", Arrays.asList(tels));


        Cliente guardado = clienteRepo.save(cliente);

        Assertions.assertEquals("Pepito", guardado.getNombre()); // compara el valor esperado con el guardado

        Assertions.assertNotNull(guardado);// comprueba que si haya quedao guardado en la base de datos
    }

    @Test
   public void eliminar() {
        String[] tels = new String[]{"32445454", "4874746"};
        Cliente cliente = new Cliente(1234, "Pepito", "pepe@email.com", "123344", "ruta", Arrays.asList(tels));

        Cliente guardado = clienteRepo.save(cliente); //registra

        clienteRepo.delete(guardado); //borra

        Optional<Cliente> buscado = clienteRepo.findById(1234); //consulta

        Assertions.assertNull(buscado.orElse(null)); //verifica que si sea null, si no lo encuentra devuelve null
    }

    @Test
    public void actualizar() {
        String[] tels = new String[]{"32445454", "4874746"};
        Cliente cliente = new Cliente(1234, "Pepito", "pepe@email.com", "123344", "ruta", Arrays.asList(tels));

        Cliente guardado = clienteRepo.save(cliente); //registra

        guardado.setCorreo("pepe_nuevo@email.com");

        Cliente nuevo = clienteRepo.save(guardado);//verifica el Id y como ya esta creado modifica el correo

        Assertions.assertEquals("pepe_nuevo@email.com", nuevo.getCorreo());
    }

    @Test
    public void obtener() {
        String[] tels = new String[]{"32445454", "4874746"};
        Cliente cliente = new Cliente(1234, "Pepito", "pepe@email.com", "123344", "ruta", Arrays.asList(tels));

        Cliente guardado = clienteRepo.save(cliente); //registra

        Optional<Cliente> buscado = clienteRepo.findById(1234); //consulta

        System.out.println(buscado.orElse(null));
    }

    @Test
    public void listar() {
        String[] tels = new String[]{"32445454", "4874746"};
        Cliente cliente = new Cliente(1234, "Pepito", "pepe@email.com", "123344", "ruta", Arrays.asList(tels));
        clienteRepo.save(cliente); //registra

           Cliente cliente1 = new Cliente(12345, "Luis", "luis@email.com", "123344", "ruta", Arrays.asList(tels));
        clienteRepo.save(cliente1); //registra

        List<Cliente> lista = clienteRepo.findAll();

        System.out.println(lista);
    }



}
