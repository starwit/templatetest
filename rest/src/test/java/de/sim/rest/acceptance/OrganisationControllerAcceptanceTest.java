package de.sim.rest.acceptance;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;

import de.sim.persistence.entity.OrganisationEntity;
/**
 * Acceptance tests for OrganisationController
 */
public class OrganisationControllerAcceptanceTest extends AbstractControllerAcceptanceTest<OrganisationEntity> {


    final static Logger LOG = LoggerFactory.getLogger(OrganisationControllerAcceptanceTest.class);
    private static final String data = "testdata/organisation/";
    private static final String restpath = "/api/organisations/";

    private JacksonTester<OrganisationEntity> jsonTester;

    @Override
    public Class<OrganisationEntity> getEntityClass() {
        return OrganisationEntity.class;
    }

    @Override
    public String getRestPath() {
        return restpath;
    }

    @Override
    public JacksonTester<OrganisationEntity> getJsonTester() {
        return jsonTester;
    }

    @Test
    public void canCreate() throws Exception {
        // given
//        OrganisationEntity entity = readFromFile(data + "Organisation.json");
  
        // when
//        MockHttpServletResponse response = create(entity);

        // then
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//        OrganisationEntity entityresult = mapper.readValue(response.getContentAsString(), OrganisationEntity.class);
//        assertThat(entityresult.getBranch()).isEqualTo("v2");
    }

    @Test
    public void isValidated() throws Exception {
        // given
//        OrganisationEntity entity = readFromFile(data + "Organisation-wrong.json");
  
        // when
//        MockHttpServletResponse response = create(entity);

        // then
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void canNotFindById() throws Exception {
        // when
        MockHttpServletResponse response = mvc
                .perform(get(getRestPath() + "/4242").contentType(MediaType.APPLICATION_JSON)).andReturn()
                .getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void canRetrieveById() throws Exception {
        // given
//        OrganisationEntity entity = readFromFile(data + "Organisation.json");
//        MockHttpServletResponse response = create(entity);
//        OrganisationEntity entity2 = mapper.readValue(response.getContentAsString(), OrganisationEntity.class);

        // when
//        response = retrieveById(entity2.getId());

        // then
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//        OrganisationEntity entityresult = mapper.readValue(response.getContentAsString(), OrganisationEntity.class);
//        assertThat(dtoresult.getBranch()).isEqualTo("v2");
    }

    @Test
    public void canUpdate() throws Exception {

        // given
//        OrganisationEntity entity = readFromFile(data + "Organisation.json");
//        MockHttpServletResponse response = create(entity);
//        OrganisationEntity entity2 = mapper.readValue(response.getContentAsString(), OrganisationEntity.class);

        // when
//        response = update(entity2);

        // then
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//        OrganisationEntity entityresult = mapper.readValue(response.getContentAsString(), OrganisationEntity.class);
//        assertThat(dtoresult.getBranch()).isEqualTo("v2");
    }

    @Override
    @Test
    public void canDelete() throws Exception {
        // given
//        OrganisationEntity entity = readFromFile(data + "Organisation.json");
//        MockHttpServletResponse response = create(entity);
//        OrganisationEntity entity2 = mapper.readValue(response.getContentAsString(), OrganisationEntity.class);
//        response = retrieveById(entity2.getId());
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

        // when
//        delete(entity2.getId());

        // then
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//        response = retrieveById(entity2.getId());
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
    }

}
