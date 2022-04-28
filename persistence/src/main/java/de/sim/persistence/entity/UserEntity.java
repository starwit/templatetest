package de.sim.persistence.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFilter;

/**
 * User Entity class
 */
@XmlRootElement
@Entity
@Table(name = "USER")
public class UserEntity extends AbstractEntity<Long> {

    // entity fields
    @Pattern(regexp = "[A-Z][a-zA-Z0-9]{1,100}")
    @NotBlank
    @Column(name = "FIRSTNAME", nullable = false)
    private String firstName;

    @Pattern(regexp = "[A-Z][a-zA-Z0-9]{1,100}")
    @NotBlank
    @Column(name = "LASTNAME", nullable = false)
    private String lastName;

    // entity relations
    @JsonFilter("filterId")
    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ID")
    private AddressEntity address;

    @ManyToMany(mappedBy = "user")
    private Set<OrganisationEntity> organisation;

    // entity fields getters and setters
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

    // entity relations getters and setters
    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public Set<OrganisationEntity> getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Set<OrganisationEntity> organisation) {
        this.organisation = organisation;
    }

}
