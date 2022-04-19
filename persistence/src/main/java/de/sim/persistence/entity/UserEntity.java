package de.sim.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotBlank;

/**
 * User Entity class
 */
@XmlRootElement
@Entity
@Table(name = "USER")
public class UserEntity extends AbstractEntity<Long> {

//entity fields
    @NotBlank
    @Column(name="FIRSTNAME", nullable = false)
    private String firstName;
    
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
