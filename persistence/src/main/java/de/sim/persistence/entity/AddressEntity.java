package de.sim.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


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
        
}
