package de.sim.persistence.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import de.sim.persistence.entity.UserEntity;

/**
 * User Repository class
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query("SELECT e FROM UserEntity e WHERE NOT EXISTS (SELECT r FROM e.address r)")
    public List<UserEntity> findAllWithoutAddress();
}
