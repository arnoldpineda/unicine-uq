package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Cupon;
import co.edu.uniquindio.unicine.entidades.CuponCliente;
import co.edu.uniquindio.unicine.repo.ClienteRepo;
import co.edu.uniquindio.unicine.repo.CuponClienteRepo;
import co.edu.uniquindio.unicine.repo.CuponRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CuponClienteTest {

    @Autowired
    private CuponClienteRepo cuponClienteRepo;
    @Autowired
    private CuponRepo cuponRepo;
    @Autowired
    private ClienteRepo clienteRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar() {

        Cupon cupon = new Cupon("cupon", 0.15f, "registro", LocalDateTime.now());
        Cupon cuponGuardado = cuponRepo.save(cupon);
        String[] tels = new String[]{"32445454", "4874746"};
        Cliente cliente = new Cliente(1234, "Pepito", "pepe@email.com", "123344", "ruta", Arrays.asList(tels));
        Cliente clienteGuardado = clienteRepo.save(cliente);

        CuponCliente cuponCliente = new CuponCliente(false, cuponGuardado, clienteGuardado);

        CuponCliente guardado = cuponClienteRepo.save(cuponCliente);
        Assertions.assertNotNull(guardado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar() {
        CuponCliente buscado = cuponClienteRepo.findById(1).orElse(null);
        cuponClienteRepo.delete(buscado);
        Assertions.assertNull(cuponClienteRepo.findById(1).orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar() {
        CuponCliente guardado = cuponClienteRepo.findById(4).orElse(null);
        guardado.setEstado(true);

        CuponCliente nuevo = cuponClienteRepo.save(guardado);
        Assertions.assertEquals(true, nuevo.getEstado());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtener() {
        Optional<CuponCliente> buscado = cuponClienteRepo.findById(4);
        Assertions.assertNotNull(buscado.orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar() {
        List<CuponCliente> lista = cuponClienteRepo.findAll();
        lista.forEach(System.out::println);
    }

}
