package de.sim.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotBlank;

/**
 * User Entity class
 */
@XmlRootElement
@Entity
@Table(name = "USER")
public class UserEntity extends AbstractEntity<Long> {

//entity fields
    @Pattern(regexp = "[A-Z][a-zA-Z0-9]{1,100}")
    @NotBlank
    @Column(name="FIRSTNAME", nullable = false)
    private String firstName;
    
    @Pattern(regexp = "[A-Z][a-zA-Z0-9]{1,100}")
    @NotBlank
    @Column(name="LASTNAME", nullable = false)
    private String lastName;
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
        
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
        
}
