package de.sim.persistence.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User Entity class
 */
@XmlRootElement
@Entity
@Table(name = "USER")
public class UserEntity extends AbstractEntity<Long> {

//entity fields
    @NotBlank
    @Column(name = "FIRSTNAME", nullable = false)
    private String firstName;

    @NotBlank
    @Column(name = "LASTNAME", nullable = false)
    private String lastName;


//entity relations
    @JsonFilter("filterId")
    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ID")
    private AddressEntity address;

    @JsonFilter("filterId")
    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(
        name = "USER_ORGANISATION", 
        joinColumns = @JoinColumn(name = "USER_ID"), 
        inverseJoinColumns = @JoinColumn(name = "ORGANISATION_ID"))
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
