package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.repo.CiudadRepo;
import co.edu.uniquindio.unicine.servicios.AdminTeatroServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
public class AdminTeatroServicioTest {

    @Autowired
    private AdminTeatroServicio adminTeatroServicio;
    private CiudadRepo ciudadRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void loginTest() {
        try {
            AdministradorTeatro administradorTeatro = adminTeatroServicio.login("admin1@email.com", "54s21d");
            Assertions.assertNotNull(administradorTeatro);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void crearHorarioTest() {
        Horario horario = Horario.builder().dia(1).hora(LocalTime.parse("14:00")).fechaInicio(LocalDate.parse("2022-10-30")).fechaFin(LocalDate.parse("2022-11-30")).build();

        Horario nuevo = adminTeatroServicio.crearHorario(horario);
        Assertions.assertNotNull(nuevo);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerHorarioTest() {

        try {
            Horario horario = adminTeatroServicio.obtenerHorario(1);
            Assertions.assertNotNull(horario);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarHorarioTest() {

        try {
            Horario horario = adminTeatroServicio.obtenerHorario(1);
            horario.setHora(LocalTime.parse("12:00"));
            Horario nuevo = adminTeatroServicio.actualizarHorario(horario);
            Assertions.assertEquals(LocalTime.parse("12:00"), nuevo.getHora());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarPeliculaTest() {

        try {
            adminTeatroServicio.eliminarHorario(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            adminTeatroServicio.obtenerHorario(1);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarHorariosTest() {
        List<Horario> lista = adminTeatroServicio.listarHorarios();
        lista.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void crearTeatroTest() throws Exception {

        Ciudad ciudad = adminTeatroServicio.obtenerCiudad(1);
        AdministradorTeatro adminTeatro = adminTeatroServicio.obtenerAdminTeatro(1);

        Teatro teatro = Teatro.builder().nombre("nombre").direccion("direccion").telefono("6475325").ciudad(ciudad).administradorTeatro(adminTeatro).build();

        Teatro nuevo = adminTeatroServicio.crearTeatro(teatro);
        Assertions.assertNotNull(nuevo);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarTeatroTest() {

        try {
            Teatro teatro = adminTeatroServicio.obtenerTeatro(1);
            teatro.setNombre("Nuevo nombre");
            Teatro nuevo = adminTeatroServicio.actualizarTeatro(teatro);
            Assertions.assertEquals("Nuevo nombre", nuevo.getNombre());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarTeatroTest() {

        try {
            adminTeatroServicio.eliminarTeatro(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            adminTeatroServicio.obtenerTeatro(1);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarTeatrosTest() {
        List<Teatro> lista = adminTeatroServicio.listarTeatros();
        lista.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerFuncionTest() {

        try {
            Funcion funcion = adminTeatroServicio.obtenerFuncion(1);
            Assertions.assertNotNull(funcion);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarFuncionTest() {

        try {
            Funcion funcion = adminTeatroServicio.obtenerFuncion(1);
            funcion.setPrecio(2000F);
            Funcion nuevo = adminTeatroServicio.actualizarFuncion(funcion);
            Assertions.assertEquals(2000, nuevo.getPrecio());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarFuncionTest() {

        try {
            adminTeatroServicio.eliminarFuncion(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            adminTeatroServicio.obtenerFuncion(1);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarFuncionTest() {
        List<Funcion> lista = adminTeatroServicio.listarFunciones();
        lista.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerSalaTest() {

        try {
            Sala sala = adminTeatroServicio.obtenerSala(1);
            Assertions.assertNotNull(sala);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarSalaTest() {

        try {
            Sala sala = adminTeatroServicio.obtenerSala(1);
            sala.setNombre("Nuevo nombre");
            Sala nuevo = adminTeatroServicio.actualizarSala(sala);
            Assertions.assertEquals("Nuevo nombre", nuevo.getNombre());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarSalaTest() {

        try {
            adminTeatroServicio.eliminarSala(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            adminTeatroServicio.obtenerSala(1);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarSalaTest() {
        List<Sala> lista = adminTeatroServicio.listarSalas();
        lista.forEach(System.out::println);
    }
}
