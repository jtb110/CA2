/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author noncowi
 */
@Entity
@Table(name = "infoentities")
@NamedQueries({
    @NamedQuery(name = "Infoentity.findAll", query = "SELECT i FROM Infoentity i"),
    @NamedQuery(name = "Infoentity.findByIeId", query = "SELECT i FROM Infoentity i WHERE i.infoentityPK.ieId = :ieId"),
    @NamedQuery(name = "Infoentity.findByEmail", query = "SELECT i FROM Infoentity i WHERE i.infoentityPK.email = :email")})
public class Infoentity implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InfoentityPK infoentityPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infoentity")
    private Collection<Person> personCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "infoentity")
    private Company company;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infoentity")
    private Collection<Phone> phoneCollection;

    public Infoentity() {
    }

    public Infoentity(InfoentityPK infoentityPK) {
        this.infoentityPK = infoentityPK;
    }

    public Infoentity(int ieId, String email) {
        this.infoentityPK = new InfoentityPK(ieId, email);
    }

    public InfoentityPK getInfoentityPK() {
        return infoentityPK;
    }

    public void setInfoentityPK(InfoentityPK infoentityPK) {
        this.infoentityPK = infoentityPK;
    }

    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Collection<Phone> getPhoneCollection() {
        return phoneCollection;
    }

    public void setPhoneCollection(Collection<Phone> phoneCollection) {
        this.phoneCollection = phoneCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (infoentityPK != null ? infoentityPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Infoentity)) {
            return false;
        }
        Infoentity other = (Infoentity) object;
        if ((this.infoentityPK == null && other.infoentityPK != null) || (this.infoentityPK != null && !this.infoentityPK.equals(other.infoentityPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Infoentity[ infoentityPK=" + infoentityPK + " ]";
    }
    
}
