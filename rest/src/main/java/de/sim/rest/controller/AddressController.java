package de.sim.rest.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.sim.persistence.entity.AddressEntity;
import de.sim.service.impl.AddressService;
import de.sim.persistence.exception.NotificationException;
import de.sim.rest.exception.NotificationDto;
import io.swagger.v3.oas.annotations.Operation;

/**
 * Address RestController
 * Have a look at the RequestMapping!!!!!!
 */
@RestController
@RequestMapping("${rest.base-path}/address")
public class AddressController {

    static final Logger LOG = LoggerFactory.getLogger(AddressController.class);

    @Autowired
    private AddressService addressService;

    @Operation(summary = "Get all address")
    @GetMapping
    public List<AddressEntity> findAll() {
        return this.addressService.findAll();
    }

    @Operation(summary = "Get all address without organisation")
    @GetMapping(value = "find-without-organisation")
    public List<AddressEntity> findAllWithoutOrganisation() {
        return addressService.findAllWithoutOrganisation();
    }
    @Operation(summary = "Get all address without user")
    @GetMapping(value = "find-without-user")
    public List<AddressEntity> findAllWithoutUser() {
        return addressService.findAllWithoutUser();
    }

    @Operation(summary = "Get address with id")
    @GetMapping(value = "/{id}")
    public AddressEntity findById(@PathVariable("id") Long id) {
        return this.addressService.findById(id);
    }

    @Operation(summary = "Create address")
    @PostMapping
    public AddressEntity save(@Valid @RequestBody AddressEntity entity) {
        return update(entity);
    }

    @Operation(summary = "Update address")
    @PutMapping
    public AddressEntity update(@Valid @RequestBody AddressEntity entity) {
        return addressService.saveOrUpdate(entity);
    }

    @Operation(summary = "Delete address")
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) throws NotificationException {
        addressService.delete(id);
    }

    @ExceptionHandler(value = { EntityNotFoundException.class })
    public ResponseEntity<Object> handleException(EntityNotFoundException ex) {
        LOG.info("Address not found. {}", ex.getMessage());
        NotificationDto output = new NotificationDto("error.address.notfound", "Address not found.");
        return new ResponseEntity<>(output, HttpStatus.NOT_FOUND);
    }
}
