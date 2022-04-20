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

import de.sim.persistence.entity.UserEntity;
import de.sim.service.impl.UserService;
import de.sim.persistence.exception.NotificationException;
import de.sim.rest.exception.NotificationDto;
import io.swagger.v3.oas.annotations.Operation;

/**
 * User RestController
 * Have a look at the RequestMapping!!!!!!
 */
@RestController
@RequestMapping("${rest.base-path}/user")
public class UserController {

    static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Operation(summary = "Get all users")
    @GetMapping
    public List<UserEntity> findAll() {
        return this.userService.findAll();
    }

    @Operation(summary = "Get user with id")
    @GetMapping(value = "/{id}")
    public UserEntity findById(@PathVariable("id") Long id) {
        return this.userService.findById(id);
    }

    @Operation(summary = "Create {entity.name?lower_case}")
    @PostMapping
    public UserEntity save(@Valid @RequestBody UserEntity entity) {
        return update(entity);
    }

    @Operation(summary = "Update {entity.name?lower_case}")
    @PutMapping
    public UserEntity update(@Valid @RequestBody UserEntity entity) {
        return userService.saveOrUpdate(entity);
    }

    @Operation(summary = "Delete {entity.name?lower_case}")
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) throws NotificationException {
        this.userService.delete(id);
    }

    @ExceptionHandler(value = { EntityNotFoundException.class })
    public ResponseEntity<Object> handleException(EntityNotFoundException ex) {
        LOG.info("User not found. {}", ex.getMessage());
        NotificationDto output = new NotificationDto("error.user.notfound", "User not found.");
        return new ResponseEntity<>(output, HttpStatus.NOT_FOUND);
    }
}
