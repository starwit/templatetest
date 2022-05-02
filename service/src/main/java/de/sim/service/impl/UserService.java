package de.sim.service.impl;
import java.util.List;
import de.sim.persistence.entity.UserEntity;
import de.sim.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * User Service class
 *
 */
@Service
public class UserService implements ServiceInterface<UserEntity, UserRepository> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserRepository getRepository() {
        return userRepository;
    }

    public List<UserEntity> findAllWithoutAddress() {
        return userRepository.findAllWithoutAddress();
    }
}
