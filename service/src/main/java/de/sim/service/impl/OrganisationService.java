package de.sim.service.impl;

import de.sim.persistence.entity.OrganisationEntity;
import de.sim.persistence.repository.OrganisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * Organisation Service class
 *
 */
@Service
public class OrganisationService implements ServiceInterface<OrganisationEntity, OrganisationRepository> {

    @Autowired
    private OrganisationRepository organisationRepository;

    @Override
    public OrganisationRepository getRepository() {
        return organisationRepository;
    }

}
