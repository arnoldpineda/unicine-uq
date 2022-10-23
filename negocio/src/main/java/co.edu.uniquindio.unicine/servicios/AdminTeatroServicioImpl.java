package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.AdministradorTeatro;
import co.edu.uniquindio.unicine.entidades.Ciudad;
import co.edu.uniquindio.unicine.entidades.Funcion;
import co.edu.uniquindio.unicine.entidades.Horario;
import co.edu.uniquindio.unicine.entidades.Sala;
import co.edu.uniquindio.unicine.entidades.Teatro;
import co.edu.uniquindio.unicine.repo.AdministradorTeatroRepo;
import co.edu.uniquindio.unicine.repo.CiudadRepo;
import co.edu.uniquindio.unicine.repo.FuncionRepo;
import co.edu.uniquindio.unicine.repo.HorarioRepo;
import co.edu.uniquindio.unicine.repo.SalaRepo;
import co.edu.uniquindio.unicine.repo.TeatroRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminTeatroServicioImpl implements AdminTeatroServicio {

    private final HorarioRepo horarioRepo;
    private final FuncionRepo funcionRepo;
    private final SalaRepo salaRepo;
    private final TeatroRepo teatroRepo;
    private final AdministradorTeatroRepo administradorTeatroRepo;
    private final CiudadRepo ciudadRepo;

    public AdminTeatroServicioImpl(HorarioRepo horarioRepo, FuncionRepo funcionRepo, SalaRepo salaRepo, TeatroRepo teatroRepo, AdministradorTeatroRepo administradorTeatroRepo, CiudadRepo ciudadRepo) {
        this.horarioRepo = horarioRepo;
        this.funcionRepo = funcionRepo;
        this.salaRepo = salaRepo;
        this.teatroRepo = teatroRepo;
        this.administradorTeatroRepo = administradorTeatroRepo;
        this.ciudadRepo = ciudadRepo;
    }

    @Override
    public AdministradorTeatro login(String correo, String paswword) throws Exception {
        AdministradorTeatro administradorTeatro = administradorTeatroRepo.comprobarAutenticacion(correo, paswword);

        if (administradorTeatro == null) {
            throw new Exception("Los datos de autenticación son incorrectos");
        }
        return administradorTeatro;
    }

    @Override
    public Horario crearHorario(Horario horario) {
        return horarioRepo.save(horario);
    }

    @Override
    public Horario obtenerHorario(Integer codigo) throws Exception {
        Optional<Horario> guardado = horarioRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new Exception("No existe horario con el codigo ingresado");
        }
        return guardado.get();
    }

    @Override
    public Horario actualizarHorario(Horario horario) throws Exception {

        Optional<Horario> guardado = horarioRepo.findById(horario.getCodigo());
        if (guardado.isEmpty()) {
            throw new Exception("No existe horario con el codigo ingresado");
        }
        return horarioRepo.save(horario);
    }

    @Override
    public void eliminarHorario(Integer codigo) throws Exception {
        Optional<Horario> guardado = horarioRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new Exception("No existe horario con el codigo ingresado");
        }
        horarioRepo.delete(guardado.get());
    }

    @Override
    public List<Horario> listarHorarios() {
        return horarioRepo.findAll();
    }

    @Override
    public Ciudad obtenerCiudad(Integer codigo) throws Exception {
        Optional<Ciudad> guardado = ciudadRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new Exception("No hay una ciudad con ese codigo");
        }
        return guardado.get();
    }

    @Override
    public AdministradorTeatro obtenerAdminTeatro(Integer codigo) throws Exception {
        Optional<AdministradorTeatro> guardado = administradorTeatroRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new Exception("El administrador no existe");
        }
        return guardado.get();
    }

    @Override
    public Teatro crearTeatro(Teatro teatro) throws Exception {

        boolean ciudad = ciudadExiste(teatro.getCiudad().getCodigo());
        //boolean adminTeatro = adminiTeatroExiste(teatro.getCodigo());
        if (ciudad) {
            return teatroRepo.save(teatro);
        }
        throw new Exception("La ciudad asignada no existe");
    }

    private boolean ciudadExiste(Integer codigo) {
        return ciudadRepo.findById(codigo).orElse(null) != null;
    }

    private boolean adminiTeatroExiste(Integer codigo) {
        return administradorTeatroRepo.findById(codigo).orElse(null) != null;
    }

    @Override
    public Teatro obtenerTeatro(Integer codigo) throws Exception {
        Optional<Teatro> guardado = teatroRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new Exception("El teatro buscado no existe");
        }
        return guardado.get();
    }

    @Override
    public Teatro actualizarTeatro(Teatro teatro) throws Exception {

        Optional<Teatro> guardado = teatroRepo.findById(teatro.getCodigo());

        if (guardado.isEmpty()) {
            throw new Exception("La teatro buscado no existe");
        }
        return teatroRepo.save(teatro);
    }

    @Override
    public void eliminarTeatro(Integer codigo) throws Exception {
        Optional<Teatro> guardado = teatroRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new Exception("El teatro buscado no existe");
        }
        teatroRepo.delete(guardado.get());
    }

    @Override
    public List<Teatro> listarTeatros() {
        return teatroRepo.findAll();
    }

    @Override
    public Funcion crearFuncion(Funcion funcion) throws Exception {
        return null;
    }

    @Override
    public Funcion obtenerFuncion(Integer codigo) throws Exception {
        Optional<Funcion> guardado = funcionRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new Exception("La funcion buscada no existe");
        }
        return guardado.get();
    }

    @Override
    public Funcion actualizarFuncion(Funcion funcion) throws Exception {
        Optional<Funcion> guardado = funcionRepo.findById(funcion.getCodigo());

        if (guardado.isEmpty()) {
            throw new Exception("La funcion buscada no existe");
        }
        return funcionRepo.save(funcion);
    }

    @Override
    public void eliminarFuncion(Integer codigo) throws Exception {
        Optional<Funcion> guardado = funcionRepo.findById(codigo);

        if (guardado.isEmpty()) {
            throw new Exception("La funcion no existe");
        }
        funcionRepo.delete(guardado.get());
    }

    @Override
    public List<Funcion> listarFunciones() {
        return funcionRepo.findAll();
    }

    @Override
    public Sala crearSala(Sala sala) throws Exception {
        return null;
    }

    @Override
    public Sala obtenerSala(Integer codigo) throws Exception {
        return null;
    }

    @Override
    public Sala actualizarSala(Sala sala) throws Exception {
        return null;
    }

    @Override
    public void eliminarSala(Integer codigo) throws Exception {

    }

    @Override
    public List<Sala> listarSalas() {
        return null;
    }


}
