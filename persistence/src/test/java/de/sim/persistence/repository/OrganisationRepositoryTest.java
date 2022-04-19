package de.sim.persistence.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import de.sim.persistence.entity.OrganisationEntity;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Tests for OrganisationRepository
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class OrganisationRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private OrganisationRepository repository;

    @Test
    public void testFindAll() {
        List<OrganisationEntity> organisations = repository.findAll();
        assertTrue(organisations.isEmpty());
    }
}
