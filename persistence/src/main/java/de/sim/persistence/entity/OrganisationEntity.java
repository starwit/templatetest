package de.sim.persistence.entity;

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

import com.fasterxml.jackson.annotation.JsonFilter;

/**
 * Organisation Entity class
 */
@XmlRootElement
@Entity
@Table(name = "ORGANISATION")
public class OrganisationEntity extends AbstractEntity<Long> {

    // entity fields
    @NotBlank
    @Column(name = "NAME", nullable = false)
    private String name;

    // entity relations
    @JsonFilter("filterId")
    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ID")
    private AddressEntity address;

    @ManyToMany(cascade = CascadeType.REFRESH)
    @JsonFilter("filterId")
    @JoinTable(name = "ORGANISATION_USER", joinColumns = @JoinColumn(name = "ORGANISATION_ID"), inverseJoinColumns = @JoinColumn(name = "USER_ID"))
    private Set<UserEntity> user;

    // entity fields getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // entity relations getters and setters
    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public Set<UserEntity> getUser() {
        return user;
    }

    public void setUser(Set<UserEntity> user) {
        this.user = user;
    }

}
