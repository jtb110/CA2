/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author noncowi
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "infoentities")
@NamedQueries({
    @NamedQuery(name = "Infoentity.findAll", query = "SELECT i FROM Infoentity i"),
    @NamedQuery(name = "Infoentity.findByIeId", query = "SELECT i FROM Infoentity i WHERE i.infoentityPK.Id = :Id"),
    @NamedQuery(name = "Infoentity.findByEmail", query = "SELECT i FROM Infoentity i WHERE i.infoentityPK.email = :email")})
public class Infoentity implements Serializable {

    @Id
    @GeneratedValue(strategy
            = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Id
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
 //Getters Setters

    public Infoentity() {
    }
    public Infoentity(String email) {
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
        if (!(object instanceof Infoentity)) {
            return false;
        }
        Infoentity other = (Infoentity) object;
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
