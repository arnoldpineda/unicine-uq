package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.repo.CompraConfiteriaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CompraConfiteriaTest {

    @Autowired
    private CompraConfiteriaRepo compraConfiteriaRepo;
}
