package de.sim.persistence.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import de.sim.persistence.entity.AddressEntity;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Tests for AddressRepository
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class AddressRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AddressRepository repository;

    @Test
    public void testFindAll() {
        List<AddressEntity> addresss = repository.findAll();
        assertTrue(addresss.isEmpty());
    }
}
