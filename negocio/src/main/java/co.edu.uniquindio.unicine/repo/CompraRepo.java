package co.edu.uniquindio.unicine.repo;

import co.edu.uniquindio.unicine.dto.InformacionCompra;
import co.edu.uniquindio.unicine.entidades.Compra;
import co.edu.uniquindio.unicine.entidades.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepo extends JpaRepository<Compra, Integer> {

    @Query("select e from Compra c join c.entradas e where c.codigo = :codigoCompra")
    List<Entrada> obtenerEntradas(Integer codigoCompra);

    @Query("select c.cliente.codigo, count (c) from Compra c where c.cupon is not null group by c.cliente")
    List<Object[]> contarCuponesRedimidos();

    @Query("select sum(c.valorTotal) from Compra c where c.cliente.codigo = :codigoCliente")
    Float calcularTotalGastado(Integer codigoCliente);

    @Query("select c.cliente, c from Compra c order by c.valorTotal desc")
    List<Object[]> obtenerComprarMasCostosa();

    @Query("select new co.edu.uniquindio.unicine.dto.InformacionCompra(c.valorTotal, c.fecha, c.funcion, (select sum(cc.precio*cc.unidades) from  CompraConfiteria cc where cc.compra.codigo = c.codigo), (select sum(e.precio) from  Entrada e where e.compra.codigo = c.codigo)) from Compra c where c.cliente.codigo = :codigoCliente")
    List<InformacionCompra> obtenerInformacionCompras(Integer codigoCliente);

    @Query("select c.funcion.pelicula, count(c) from  Compra c where c.funcion.sala.teatro.ciudad.codigo = :codigoCiudad group by c.funcion.pelicula")
    List<Object[]> obtenerPeliculaMasVista(Integer codigoCiudad);

}
