package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Administrador;
import co.edu.uniquindio.unicine.entidades.AdministradorTeatro;
import co.edu.uniquindio.unicine.entidades.Ciudad;
import co.edu.uniquindio.unicine.entidades.Confiteria;
import co.edu.uniquindio.unicine.entidades.Cupon;
import co.edu.uniquindio.unicine.entidades.Genero;
import co.edu.uniquindio.unicine.entidades.Pelicula;
import co.edu.uniquindio.unicine.servicios.AdminServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@Transactional
public class AdminServicioTest {

    @Autowired
    private AdminServicio adminServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void loginTest(){
        try {
            Administrador administrador = adminServicio.login("adminPlataforma@email.com", "54s21d");
            Assertions.assertNotNull(administrador);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void crearAdminTeatroTest(){
        AdministradorTeatro administradorTeatro = AdministradorTeatro.builder().correo("nuevoAdminTeatro@gmail.com").nombre("NuevoAdminTeatro").password("134dd").build();

        try {
            AdministradorTeatro nuevo = adminServicio.crearAdminTeatro(administradorTeatro);
            Assertions.assertNotNull(nuevo);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerAdminTeatroTest(){

        try {
            AdministradorTeatro administradorTeatro = adminServicio.obtenerAdminTeatro(1);
            Assertions.assertNotNull(administradorTeatro);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarAdminTeatroTest(){

        try {
            AdministradorTeatro administradorTeatro = adminServicio.obtenerAdminTeatro(1);
            administradorTeatro.setNombre("Nuevo nombre");
            AdministradorTeatro nuevo = adminServicio.actualizarAdminTeatro(administradorTeatro);
            Assertions.assertEquals("Nuevo nombre", nuevo.getNombre());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarAdminTeatroTest(){

        try {
            adminServicio.eliminarAdminTeatro(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            adminServicio.obtenerAdminTeatro(1);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listaAdminTeatrosTest(){
        List<AdministradorTeatro> lista = adminServicio.listaAdminTeatros();
        lista.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void crearPeliculaTest(){
        Pelicula pelicula = Pelicula.builder().nombre("Harry Poter").sinopsis("Sinopsis").urlTrailer("Trailer").urlImagen("Imagen").estado(true).reparto("reparto").genero(Genero.valueOf("CIENCIA_FICCION")).build();

        Pelicula nuevo = adminServicio.crearPelicula(pelicula);
        Assertions.assertNotNull(nuevo);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerPeliculaTest(){

        try {
            Pelicula pelicula = adminServicio.obtenerPelicula(1);
            Assertions.assertNotNull(pelicula);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarPeliculaTest(){

        try {
            Pelicula pelicula = adminServicio.obtenerPelicula(1);
            pelicula.setNombre("Nuevo nombre");
            Pelicula nuevo = adminServicio.actualizarPelicula(pelicula);
            Assertions.assertEquals("Nuevo nombre", nuevo.getNombre());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarPeliculaTest(){

        try {
            adminServicio.eliminarPelicula(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            adminServicio.obtenerPelicula(1);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarPeliculasTest(){
        List<Pelicula> lista = adminServicio.listarPeliculas();
        lista.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void crearConfiteriaTest(){
        Confiteria confiteria = Confiteria.builder().precio(25000).nombre("combo 2").urlImagen("Imagen").build();

        try {
            Confiteria nuevo = adminServicio.crearConfiteria(confiteria);
            Assertions.assertNotNull(nuevo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerConfiteriaTest(){

        try {
            Confiteria confiteria = adminServicio.obtenerConfiteria(1);
            Assertions.assertNotNull(confiteria);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarConfiteriaTest(){

        try {
            Confiteria confiteria = adminServicio.obtenerConfiteria(1);
            confiteria.setNombre("Nuevo nombre");
            Confiteria nuevo = adminServicio.actualizarConfiteria(confiteria);
            Assertions.assertEquals("Nuevo nombre", nuevo.getNombre());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarConfiteriaTest(){

        try {
            adminServicio.eliminarConfiteria(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            adminServicio.obtenerConfiteria(1);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarConfiteriasTest(){
        List<Confiteria> lista = adminServicio.listarConfiterias();
        lista.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void crearCuponTest(){
        Cupon cupon = Cupon.builder().descripcion("Nuevo Cupon").descuento(15).criterio("cumpleaños").vencimiento(LocalDateTime.parse("2022-10-30T15:50:05.609")).build();

        try {
            Cupon nuevo = adminServicio.crearCupon(cupon);
            Assertions.assertNotNull(nuevo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerCuponTest(){

        try {
            Cupon cupon = adminServicio.obtenerCupon(1);
            Assertions.assertNotNull(cupon);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarCuponTest(){

        try {
            Cupon cupon = adminServicio.obtenerCupon(1);
            cupon.setCriterio("Nuevo Criterio");
            Cupon nuevo = adminServicio.actualizarCupon(cupon);
            Assertions.assertEquals("Nuevo Criterio", nuevo.getCriterio());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarCuponTest(){

        try {
            adminServicio.eliminarCupon(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            adminServicio.obtenerCupon(1);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCuponesTest(){
        List<Cupon> lista = adminServicio.listarCupones();
        lista.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void crearCiudadTest(){
        Ciudad ciudad = Ciudad.builder().nombre("Nueva Ciudad").build();

        Ciudad nuevo = adminServicio.crearCiudad(ciudad);
        Assertions.assertNotNull(nuevo);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerCiudadTest(){

        try {
            Ciudad ciudad = adminServicio.obtenerCiudad(1);
            Assertions.assertNotNull(ciudad);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
