package de.sim.rest.integration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;

import de.sim.persistence.entity.AddressEntity;
import de.sim.rest.controller.AddressController;
import de.sim.service.impl.AddressService;

/**
 * Tests for AddressController
 *
 * <pre>
 * @WebMvcTest also auto-configures MockMvc which offers a powerful way of
 * easy testing MVC controllers without starting a full HTTP server.
 * </pre>
 */
@WebMvcTest(controllers = AddressController.class)
public class AddressControllerIntegrationTest extends AbstractControllerIntegrationTest<AddressEntity> {

    @MockBean
    private AddressService addressService;

    private JacksonTester<AddressEntity> jsonAddressEntity;
    private static final String data = "testdata/address/";
    private static final String restpath = "/api/addresss/";

    @Override
    public Class<AddressEntity> getEntityClass() {
        return AddressEntity.class;
    }

    @Override
    public String getRestPath() {
        return restpath;
    }

    //implement tests here
    @Test
    public void canRetrieveById() throws Exception {

//        AddressEntity entityToTest = readFromFile(data + "address.json");
//        when(appService.findById(0L)).thenReturn(entityToTest);

//        MockHttpServletResponse response = retrieveById(0L);

        // then
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//        assertThat(response.getContentAsString())
//                .isEqualTo(jsonAppDto.write(dto).getJson());
    }

}
