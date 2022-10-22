package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.Administrador;
import co.edu.uniquindio.unicine.entidades.AdministradorTeatro;
import co.edu.uniquindio.unicine.entidades.Ciudad;
import co.edu.uniquindio.unicine.entidades.Confiteria;
import co.edu.uniquindio.unicine.entidades.Cupon;
import co.edu.uniquindio.unicine.entidades.Pelicula;
import co.edu.uniquindio.unicine.repo.AdministradorRepo;
import co.edu.uniquindio.unicine.repo.AdministradorTeatroRepo;
import co.edu.uniquindio.unicine.repo.CiudadRepo;
import co.edu.uniquindio.unicine.repo.ConfiteriaRepo;
import co.edu.uniquindio.unicine.repo.CuponRepo;
import co.edu.uniquindio.unicine.repo.PeliculaRepo;
import net.bytebuddy.implementation.bytecode.Throw;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServicioImpl implements AdminServicio{

    private final AdministradorRepo administradorRepo;
    private final PeliculaRepo peliculaRepo;
    private final AdministradorTeatroRepo administradorTeatroRepo;
    private final ConfiteriaRepo confiteriaRepo;
    private final CuponRepo cuponRepo;
    private final CiudadRepo ciudadRepo;

    public AdminServicioImpl(AdministradorRepo administradorRepo, PeliculaRepo peliculaRepo, AdministradorTeatroRepo administradorTeatroRepo, ConfiteriaRepo confiteriaRepo, CuponRepo cuponRepo, CiudadRepo ciudadRepo) {
        this.administradorRepo = administradorRepo;
        this.peliculaRepo = peliculaRepo;
        this.administradorTeatroRepo = administradorTeatroRepo;
        this.confiteriaRepo = confiteriaRepo;
        this.cuponRepo = cuponRepo;
        this.ciudadRepo = ciudadRepo;
    }

    @Override
    public Administrador login(String correo, String paswword) throws Exception{
        Administrador administrador = administradorRepo.comprobarAutenticacion(correo, paswword);

        if(administrador == null){
            throw new Exception("Los datos de autenticación son incorrectos");
        }
        return administrador;
    }

    @Override
    public AdministradorTeatro crearAdminTeatro(AdministradorTeatro adminTeatro) throws Exception {
        boolean correoExiste = correoEsrepetido(adminTeatro.getCorreo());

        if(correoExiste){
            throw new Exception("El correo ya existe");
        }
        return administradorTeatroRepo.save(adminTeatro);
    }

    private boolean correoEsrepetido(String coreo){
        return administradorTeatroRepo.findByCorreo(coreo).orElse(null)!=null;
    }

    @Override
    public AdministradorTeatro obtenerAdminTeatro(Integer codigo) throws Exception {
        Optional<AdministradorTeatro> guardado = administradorTeatroRepo.findById(codigo);

        if (guardado.isEmpty()){
            throw new Exception("El administrador no existe");
        }
        return guardado.get();
    }

    @Override
    public AdministradorTeatro actualizarAdminTeatro(AdministradorTeatro adminTeatro) throws Exception {

        Optional<AdministradorTeatro> guardado = administradorTeatroRepo.findById(adminTeatro.getCodigo());

        if(guardado.isEmpty()){
            throw new Exception("El administrador de teatro no existe");
        }
        return administradorTeatroRepo.save(adminTeatro);
    }

    @Override
    public void eliminarAdminTeatro(Integer codigo) throws Exception {
        Optional<AdministradorTeatro> guardado = administradorTeatroRepo.findById(codigo);

        if (guardado.isEmpty()){
            throw new Exception("El cliente no existe");
        }
        administradorTeatroRepo.delete(guardado.get());
    }

    @Override
    public List<AdministradorTeatro> listaAdminTeatros() {
        return administradorTeatroRepo.findAll();
    }

    @Override
    public Pelicula crearPelicula(Pelicula pelicula) {
        return peliculaRepo.save(pelicula);
    }

    @Override
    public Pelicula obtenerPelicula(Integer codigo) throws Exception {
        Optional<Pelicula> guardado = peliculaRepo.findById(codigo);

        if (guardado.isEmpty()){
            throw new Exception("La pelicula no existe");
        }
        return guardado.get();
    }

    @Override
    public Pelicula actualizarPelicula(@NotNull Pelicula pelicula) throws Exception {

        Optional<Pelicula> guardado = peliculaRepo.findById(pelicula.getCodigo());

        if(guardado.isEmpty()){
            throw new Exception("La pelicula no existe");
        }
        return peliculaRepo.save(pelicula);
    }

    @Override
    public void eliminarPelicula(Integer codigo) throws Exception {
        Optional<Pelicula> guardado = peliculaRepo.findById(codigo);

        if (guardado.isEmpty()){
            throw new Exception("La pelicula no existe");
        }
        peliculaRepo.delete(guardado.get());
    }

    @Override
    public List<Pelicula> listarPeliculas() {
        return peliculaRepo.findAll();
    }

    @Override
    public Confiteria crearConfiteria(Confiteria confiteria) throws Exception {

        if(confiteria.getPrecio()<=0){
            throw new Exception("El precio es invalido");
        }
        return confiteriaRepo.save(confiteria);
    }

    @Override
    public Confiteria obtenerConfiteria(Integer codigo) throws Exception {
        Optional<Confiteria> guardado = confiteriaRepo.findById(codigo);

        if (guardado.isEmpty()){
            throw new Exception("El producto buscado no existe");
        }
        return guardado.get();
    }

    @Override
    public Confiteria actualizarConfiteria(Confiteria confiteria) throws Exception {

        Optional<Confiteria> guardado = confiteriaRepo.findById(confiteria.getCodigo());

        if(guardado.isEmpty()){
            throw new Exception("El producto buscado no existe");
        }
        return confiteriaRepo.save(confiteria);
    }

    @Override
    public void eliminarConfiteria(Integer codigo) throws Exception {
        Optional<Confiteria> guardado = confiteriaRepo.findById(codigo);

        if (guardado.isEmpty()){
            throw new Exception("El producto buscado no existe");
        }
        confiteriaRepo.delete(guardado.get());
    }

    @Override
    public List<Confiteria> listarConfiterias() {
        return confiteriaRepo.findAll();
    }

    @Override
    public Cupon crearCupon(Cupon cupon) throws Exception {

        if(cupon.getDescuento()<=0){
            throw new Exception("El valor de descuento es invalido");
        }
        return cuponRepo.save(cupon);
    }

    @Override
    public Cupon obtenerCupon(Integer codigo) throws Exception {
        Optional<Cupon> guardado = cuponRepo.findById(codigo);

        if (guardado.isEmpty()){
            throw new Exception("El cupon no existe");
        }
        return guardado.get();
    }

    @Override
    public Cupon actualizarCupon(Cupon cupon) throws Exception {

        Optional<Cupon> guardado = cuponRepo.findById(cupon.getCodigo());

        if(guardado.isEmpty()){
            throw new Exception("El cupon buscado no existe");
        }
        return cuponRepo.save(cupon);
    }

    @Override
    public void eliminarCupon(Integer codigo) throws Exception {
        Optional<Cupon> guardado = cuponRepo.findById(codigo);

        if (guardado.isEmpty()){
            throw new Exception("El cupon buscado no existe");
        }
        cuponRepo.delete(guardado.get());
    }

    @Override
    public List<Cupon> listarCupones() {
        return cuponRepo.findAll();
    }

    @Override
    public Ciudad crearCiudad(Ciudad ciudad) {
        return ciudadRepo.save(ciudad);
    }

    @Override
    public Ciudad obtenerCiudad(Integer codigo) throws Exception {
        Optional<Ciudad> guardado = ciudadRepo.findById(codigo);

        if (guardado.isEmpty()){
            throw new Exception("La ciudad no existe");
        }
        return guardado.get();
    }

}
