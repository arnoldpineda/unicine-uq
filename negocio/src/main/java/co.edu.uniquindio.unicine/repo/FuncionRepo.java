package co.edu.uniquindio.unicine.repo;

import co.edu.uniquindio.unicine.entidades.EstadoPelicula;
import co.edu.uniquindio.unicine.entidades.Funcion;
import co.edu.uniquindio.unicine.entidades.Horario;
import co.edu.uniquindio.unicine.entidades.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FuncionRepo extends JpaRepository<Funcion, Integer> {

    @Query("select f.pelicula.nombre from Funcion f where f.codigo = :codigoFuncion")
    String obtenerNombrePelicula(Integer codigoFuncion);

    @Query("select distinct f.pelicula from Funcion f")
    List<Pelicula> obtenerPeliculas();

    @Query("select new co.edu.uniquindio.unicine.dto.FuncionDTO(f.pelicula.nombre, f.pelicula.estado, f.pelicula.urlImagen, f.sala.codigo, f.sala.teatro.direccion, f.sala.teatro.ciudad.nombre, f.horario) from Funcion f where f.pelicula.codigo = :codigoPelicula")
    List<Funcion> listarFunciones(Integer codigoPelicula);

    @Query("select f from Funcion f where f.sala.teatro.codigo = :codigoTeatro and f.compras is empty")
    List<Funcion> obtenerFuncionesSinCompras(Integer codigoTeatro);

    @Query("select f from Funcion f where f.sala.teatro.codigo = :codigoTeatro and f.horario.fechaInicio < :fechaInicio or f.horario.fechaFin > :fechaFin")
    List<Funcion> obtenerFuncionesTeatro(Integer codigoTeatro, LocalDate fechaInicio, LocalDate fechaFin);

    @Query("select t.ciudad.codigo, t.ciudad.nombre, count(t) from Teatro t group by t.ciudad")
    List<Object[]> contarTeatros();

    @Query ("select f from Funcion f where f.sala.teatro.ciudad.codigo = :codigoCiudad")
    List<Funcion> listarFuncionesCiudad (Integer codigoCiudad);

    @Query("select f from Sala s join s.funciones f where s.codigo = :codigoSala and f.horario =:horario")
    List<Funcion> obtenerFuncionesSala(Horario horario, Integer codigo);

    @Query ("select f from Funcion f where f.sala.teatro.codigo = :codigoTeatro")
    List<Funcion> listarFuncionesTeatro (Integer codigoTeatro);

    @Query("select f from Funcion f where f.sala.codigo = :codigoSala and f.horario =:horario")
    List<Funcion> listarFuncionesSala (Horario horario, Integer codigoSala);

    @Query ("select distinct f.pelicula from Funcion f where f.sala.teatro.ciudad.codigo = :codigoCiudad and f.pelicula.estado = :estadoPelicula")
    List<Pelicula> listarPeliculasEstadoCiudad(Integer codigoCiudad, EstadoPelicula estadoPelicula);

    @Query ("select distinct f.pelicula from Funcion f where f.pelicula.estado = :estadoPelicula")
    List<Pelicula> listarPeliculasEstado(EstadoPelicula estadoPelicula);
}
