package de.sim.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import javax.persistence.OneToOne;

/**
 * Address Entity class
 */
@XmlRootElement
@Entity
@Table(name = "ADDRESS")
public class AddressEntity extends AbstractEntity<Long> {

//entity fields
    @Column(name="CITY")
    private String city;

    @Column(name="STREET")
    private String street;

    @Column(name="STREETNR")
    private String streetNr;

    @Column(name="CITYCODE")
    private String cityCode;


//entity relations
    @OneToOne(mappedBy = "address")
    private OrganisationEntity organisation;

    @OneToOne(mappedBy = "address")
    private UserEntity user;

//entity fields getters and setters
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNr() {
        return streetNr;
    }

    public void setStreetNr(String streetNr) {
        this.streetNr = streetNr;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

//entity relations getters and setters
    public OrganisationEntity getOrganisation() {
        return organisation;
    }

    public void setOrganisation(OrganisationEntity organisation) {
        this.organisation = organisation;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

}
