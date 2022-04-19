package de.sim.persistence.repository;

import de.sim.persistence.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Address Repository class
 */
@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

}
