package de.sim.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Organisation Entity class
 */
@XmlRootElement
@Entity
@Table(name = "ORGANISATION")
public class OrganisationEntity extends AbstractEntity<Long> {

//entity fields
    @NotBlank
    @Column(name="NAME", nullable = false)
    private String name;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
        
}
