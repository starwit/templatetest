package de.sim.service;

import de.sim.persistence.repository.AddressRepository;
import de.sim.service.impl.AddressService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Tests for AddressService
 */
@RunWith(SpringRunner.class)
public class AddressServiceTest {

    /**
     * <pre>
     * To check the Service class, we need to have an instance of Service class created and available as a
     * @Bean so that we can @Autowire it in our test class.
     * This configuration is achieved by using the @TestConfiguration annotation.
     * </pre>
     */
    @TestConfiguration
    static class AddressServiceTestConfiguration {

        @Bean
        public AddressService createAddressService() {
            return new AddressService();
        }
    }

    @Autowired
    private AddressService addressService;

    /**
     * Create a mock.
     */
    @MockBean
    private AddressRepository addressRepository;

    @Before
    public void setUp() {
        //TODO: setup objects for each test
    }

    //implement tests here
    @Test
    public void someTest() {
        
    }

}
