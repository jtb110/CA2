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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author noncowi
 */
@Entity
@Table(name = "phones")
@NamedQueries({
    @NamedQuery(name = "Phone.findAll", query = "SELECT p FROM Phone p"),
    @NamedQuery(name = "Phone.findByPhonenumber", query = "SELECT p FROM Phone p WHERE p.phonenumber = :phonenumber"),
    @NamedQuery(name = "Phone.findByInfoId", query = "SELECT p FROM Phone p WHERE p.infoentity.id = :id"),
    @NamedQuery(name = "Phone.findByDescription", query = "SELECT p FROM Phone p WHERE p.description = :description")})
public class Phone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "phonenumber")
    private Integer phonenumber;
    @Column(name = "description")
    private String description;
//    @JoinColumn(name = "owner", referencedColumnName = "infoentity.id")
//    @ManyToOne(optional = false)
    private InfoEntity infoentity;

    public Phone() {
    }

    public Phone(Integer phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Integer getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(Integer phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public InfoEntity getInfoentity() {
        return infoentity;
    }

    public void setInfoentity(InfoEntity infoentity) {
        this.infoentity = infoentity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (phonenumber != null ? phonenumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phone)) {
            return false;
        }
        Phone other = (Phone) object;
        if ((this.phonenumber == null && other.phonenumber != null) || (this.phonenumber != null && !this.phonenumber.equals(other.phonenumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Phone[ phonenumber=" + phonenumber + " ]";
    }
    
}
