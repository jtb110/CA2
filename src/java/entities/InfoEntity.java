/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author noncowi
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "infoentities")
//@NamedQueries({
//    
//    @NamedQuery(name = "Infoentity.findAll", query = "SELECT i FROM Infoentity i"),
//    @NamedQuery(name = "Infoentity.findById", query = "SELECT i FROM Infoentity i WHERE i.id = :Id")
//    @NamedQuery(name = "InfoEntity.findByEmail", query = "SELECT i FROM InfoEntity i WHERE i.email = :email")
//})
public class InfoEntity implements Serializable {
    @Id
    @GeneratedValue(strategy
            = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "phone")
    private Collection<Phone> phones = new ArrayList();
//    @OneToMany
//    @JoinColumn(name = "phone")
//    private Collection<Phone> phones = new ArrayList();
//    
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "adresses")
    private Collection<Address> addresses = new ArrayList();

    public Collection<Phone> getPhones() {
        return phones;
    }

    public void addPhones(Phone phone) {
        this.phones.add(phone);
    }

    public Collection<Address> getAddresses() {
        return addresses;
    }

    public void addAddresses(Address address) {
        this.addresses.add(address);
    }
    
    
    
    public void setAddressCollection(Collection<Address> addressCollection) {
        this.addresses = addressCollection;
    }
    public InfoEntity() {
    }
    public InfoEntity(String email) {
        this.email=email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InfoEntity)) {
            return false;
        }
        InfoEntity other = (InfoEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Infoentity[ id=" + id + " ]";
    }

}