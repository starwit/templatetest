package de.sim.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import javax.persistence.JoinColumn;
import javax.validation.constraints.Pattern;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import java.util.Set;

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


//entity relations
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ID")
    private AddressEntity address;

    @ManyToMany(mappedBy="user")
    private Set<OrganisationEntity> organisation;

//entity fields getters and setters
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

//entity relations getters and setters
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
