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

import de.sim.persistence.entity.OrganisationEntity;
import de.sim.service.impl.OrganisationService;
import de.sim.persistence.exception.NotificationException;
import de.sim.rest.exception.NotificationDto;
import io.swagger.v3.oas.annotations.Operation;

/**
 * Organisation RestController
 * Have a look at the RequestMapping!!!!!!
 */
@RestController
@RequestMapping("${rest.base-path}/organisation")
public class OrganisationController {

    static final Logger LOG = LoggerFactory.getLogger(OrganisationController.class);

    @Autowired
    private OrganisationService organisationService;

    @Operation(summary = "Get all organisations")
    @GetMapping
    public List<OrganisationEntity> findAll() {
        return this.organisationService.findAll();
    }

    @Operation(summary = "Get organisation with id")
    @GetMapping(value = "/{id}")
    public OrganisationEntity findById(@PathVariable("id") Long id) {
        return this.organisationService.findById(id);
    }

    @Operation(summary = "Create {entity.name?lower_case}")
    @PostMapping
    public OrganisationEntity save(@Valid @RequestBody OrganisationEntity entity) {
        return update(entity);
    }

    @Operation(summary = "Update {entity.name?lower_case}")
    @PutMapping
    public OrganisationEntity update(@Valid @RequestBody OrganisationEntity entity) {
        return organisationService.saveOrUpdate(entity);
    }

    @Operation(summary = "Delete {entity.name?lower_case}")
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) throws NotificationException {
        this.organisationService.delete(id);
    }

    @ExceptionHandler(value = { EntityNotFoundException.class })
    public ResponseEntity<Object> handleException(EntityNotFoundException ex) {
        LOG.info("Organisation not found. {}", ex.getMessage());
        NotificationDto output = new NotificationDto("error.organisation.notfound", "Organisation not found.");
        return new ResponseEntity<>(output, HttpStatus.NOT_FOUND);
    }
}
