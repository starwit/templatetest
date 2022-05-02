package de.sim.persistence.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import de.sim.persistence.entity.OrganisationEntity;

/**
 * Organisation Repository class
 */
@Repository
public interface OrganisationRepository extends JpaRepository<OrganisationEntity, Long> {

    @Query("SELECT e FROM OrganisationEntity e WHERE NOT EXISTS (SELECT r FROM e.address r)")
    public List<OrganisationEntity> findAllWithoutAddress();
}
