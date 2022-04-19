package de.sim.persistence.repository;

import de.sim.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * User Repository class
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
