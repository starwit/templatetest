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

import de.sim.persistence.entity.OrganisationEntity;
import de.sim.rest.controller.OrganisationController;
import de.sim.service.impl.OrganisationService;

/**
 * Tests for OrganisationController
 *
 * <pre>
 * @WebMvcTest also auto-configures MockMvc which offers a powerful way of
 * easy testing MVC controllers without starting a full HTTP server.
 * </pre>
 */
@WebMvcTest(controllers = OrganisationController.class)
public class OrganisationControllerIntegrationTest extends AbstractControllerIntegrationTest<OrganisationEntity> {

    @MockBean
    private OrganisationService organisationService;

    private JacksonTester<OrganisationEntity> jsonOrganisationEntity;
    private static final String data = "testdata/organisation/";
    private static final String restpath = "/api/organisations/";

    @Override
    public Class<OrganisationEntity> getEntityClass() {
        return OrganisationEntity.class;
    }

    @Override
    public String getRestPath() {
        return restpath;
    }

    //implement tests here
    @Test
    public void canRetrieveById() throws Exception {

//        OrganisationEntity entityToTest = readFromFile(data + "organisation.json");
//        when(appService.findById(0L)).thenReturn(entityToTest);

//        MockHttpServletResponse response = retrieveById(0L);

        // then
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//        assertThat(response.getContentAsString())
//                .isEqualTo(jsonAppDto.write(dto).getJson());
    }

}
