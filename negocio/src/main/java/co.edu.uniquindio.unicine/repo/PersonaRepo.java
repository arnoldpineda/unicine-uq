package co.edu.uniquindio.unicine.repo;

import co.edu.uniquindio.unicine.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepo extends JpaRepository<Persona, Integer> {
}
