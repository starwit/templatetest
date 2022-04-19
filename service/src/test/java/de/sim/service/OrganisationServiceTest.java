package de.sim.service;

import de.sim.persistence.repository.OrganisationRepository;
import de.sim.service.impl.OrganisationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Tests for OrganisationService
 */
@RunWith(SpringRunner.class)
public class OrganisationServiceTest {

    /**
     * <pre>
     * To check the Service class, we need to have an instance of Service class created and available as a
     * @Bean so that we can @Autowire it in our test class.
     * This configuration is achieved by using the @TestConfiguration annotation.
     * </pre>
     */
    @TestConfiguration
    static class OrganisationServiceTestConfiguration {

        @Bean
        public OrganisationService createOrganisationService() {
            return new OrganisationService();
        }
    }

    @Autowired
    private OrganisationService organisationService;

    /**
     * Create a mock.
     */
    @MockBean
    private OrganisationRepository organisationRepository;

    @Before
    public void setUp() {
        //TODO: setup objects for each test
    }

    //implement tests here
    @Test
    public void someTest() {
        
    }

}
