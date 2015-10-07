/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author noncowi
 */
@Embeddable
public class CompanyPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "c_id")
    private int cId;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;

    public CompanyPK() {
    }

    public CompanyPK(int cId, String email) {
        this.cId = cId;
        this.email = email;
    }

    public int getCId() {
        return cId;
    }

    public void setCId(int cId) {
        this.cId = cId;
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
        hash += (int) cId;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompanyPK)) {
            return false;
        }
        CompanyPK other = (CompanyPK) object;
        if (this.cId != other.cId) {
            return false;
        }
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CompanyPK[ cId=" + cId + ", email=" + email + " ]";
    }
    
}
