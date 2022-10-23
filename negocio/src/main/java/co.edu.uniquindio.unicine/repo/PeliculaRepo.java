package co.edu.uniquindio.unicine.repo;

import co.edu.uniquindio.unicine.dto.HorarioSalaDTO;
import co.edu.uniquindio.unicine.entidades.Genero;
import co.edu.uniquindio.unicine.entidades.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeliculaRepo extends JpaRepository<Pelicula, Integer> {

    @Query("select p from Pelicula p where p.nombre like concat('%',:nombre, '%') and p.estado = :estadoPelicula")
    List<Pelicula> buscarPeliculas(String nombre, Boolean estadoPelicula);

    @Query("select new co.edu.uniquindio.unicine.dto.HorarioSalaDTO(f.horario, f.sala) from Pelicula p join p.funciones f where p.codigo = :codigoPelicula and f.sala.teatro.codigo = :codigoTeatro")
    List<HorarioSalaDTO> listarHorarios(Integer codigoPelicula, Integer codigoTeatro);

    /*@Query("select p from Pelicula p where :generoPelicula member of p.genero order by p.nombre asc")
    List<Pelicula> ListarPeliculas(Genero generoPelicula);*/
}
