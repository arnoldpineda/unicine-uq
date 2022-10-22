package co.edu.uniquindio.unicine.repo;

import co.edu.uniquindio.unicine.entidades.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministradorRepo extends JpaRepository<Administrador, Integer> {

    //Comprobar autenticacion
    @Query("select a from Administrador a where a.correo = :correo and a.password =:password")
    Administrador comprobarAutenticacion(String correo, String password);



}
