package co.edu.uniquindio.unicine.repo;

import co.edu.uniquindio.unicine.entidades.DistribuccionSillas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistribuccionSillasRepo extends JpaRepository<DistribuccionSillas, Integer> {
}
