package co.edu.uniquindio.unicine.repo;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Compra;
import co.edu.uniquindio.unicine.entidades.Cupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, Integer> {

    //Ejemplo consulta el parametro por posicion del primer parametro que envie con el ?
    //lista los clientes que tienen un correo especifico
    @Query("select c from Cliente c where c.correo = ?1")
    Cliente obtener(String email);

    //Ejemplo Hace una inferencia de buscar por correo sin tener que hacer manualmente la consulta
    Optional<Cliente> findByCorreo(String correo);

    // Ejemplo consulta por nombre de parametro con los dos puntos
    //Comprobar autenticaión por nombre de parametro
    @Query("select c from Cliente c where c.correo = :correo and c.password = :password")
    Cliente comprobarAutenticacion(String correo, String password);

    //Comprobar autenticaión por inferencia
    Cliente findByCorreoAndPassword(String correo, String password);

    @Query("select c from Cliente c where c.estado = :estado")
    List<Cliente> obtenerPorEstado(boolean estado);

    @Query("select comp from Cliente  cli, in (cli.compras) comp where cli.correo = :correo")
    List<Compra> obtenerCompras(String correo);

    @Query("select cup from Cliente  cli join cli.cupones cup where cli.correo = :correo")
    List<Cupon> obtenerCupones(String correo);

    @Query("select cli.nombre, cli.correo, comp from Cliente cli left join cli.compras comp")
    List<Object[]> obtenerComprasTodos();
}
