/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author noncowi
 */
@Entity
@Table(name = "cityinfos")
@NamedQueries({
    @NamedQuery(name = "Cityinfo.findAll", query = "SELECT c FROM Cityinfo c"),
    @NamedQuery(name = "Cityinfo.findByZipcode", query = "SELECT c FROM Cityinfo c WHERE c.zipcode = :zipcode"),
    @NamedQuery(name = "Cityinfo.findByCity", query = "SELECT c FROM Cityinfo c WHERE c.city = :city")})
public class Cityinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "zipcode")
    private Integer zipcode;
    @Basic(optional = false)
    @Column(name = "city")
    private String city;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cityinfo")
    private Collection<Address> addressCollection;

    public Cityinfo() {
    }

    public Cityinfo(Integer zipcode) {
        this.zipcode = zipcode;
    }

    public Cityinfo(Integer zipcode, String city) {
        this.zipcode = zipcode;
        this.city = city;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Collection<Address> getAddressCollection() {
        return addressCollection;
    }

    public void setAddressCollection(Collection<Address> addressCollection) {
        this.addressCollection = addressCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zipcode != null ? zipcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cityinfo)) {
            return false;
        }
        Cityinfo other = (Cityinfo) object;
        if ((this.zipcode == null && other.zipcode != null) || (this.zipcode != null && !this.zipcode.equals(other.zipcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Cityinfo[ zipcode=" + zipcode + " ]";
    }
    
}
