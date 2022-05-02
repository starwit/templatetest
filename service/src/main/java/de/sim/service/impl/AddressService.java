package de.sim.service.impl;
import java.util.List;
import de.sim.persistence.entity.AddressEntity;
import de.sim.persistence.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * Address Service class
 *
 */
@Service
public class AddressService implements ServiceInterface<AddressEntity, AddressRepository> {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public AddressRepository getRepository() {
        return addressRepository;
    }

    public List<AddressEntity> findAllWithoutOrganisation() {
        return addressRepository.findAllWithoutOrganisation();
    }
    public List<AddressEntity> findAllWithoutUser() {
        return addressRepository.findAllWithoutUser();
    }
}
