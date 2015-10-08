/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author noncowi
 */
@Entity
@Table(name = "address")
//@NamedQueries({
//    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a"),
//    @NamedQuery(name = "Address.findByStreet", query = "SELECT a FROM Address a WHERE a.street = :street"),
//    @NamedQuery(name = "Address.findByAdditionalInfo", query = "SELECT a FROM Address a WHERE a.additionalInfo = :additionalInfo")})
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "street")
    private String street;
    @Column(name = "additionalInfo")
    private String additionalInfo;
    @ManyToOne(fetch=FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.PERSIST})
    private InfoEntity infoEntities;
    
    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
    private CityInfo city;

    public InfoEntity getInfoEntities() {
        return infoEntities;
    }

    public void setInfoEntities(InfoEntity infoEntities) {
        this.infoEntities = infoEntities;
    }

    public CityInfo getCity() {
        return city;
    }

    public void setCity(CityInfo city) {
        this.city = city;
    }

    public Address() {
    }

    public Address(String street) {
        this.street = street;
    }
    public Address(String street,String additionalInfo) {
        this.street = street;
        this.additionalInfo=additionalInfo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (street != null ? street.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.street == null && other.street != null) || (this.street != null && !this.street.equals(other.street))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Address[ street=" + street + " ]";
    }
    
}
