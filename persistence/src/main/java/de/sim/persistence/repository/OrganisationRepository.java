package de.sim.persistence.repository;

import de.sim.persistence.entity.OrganisationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Organisation Repository class
 */
@Repository
public interface OrganisationRepository extends JpaRepository<OrganisationEntity, Long> {

}
