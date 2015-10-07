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
public class InfoentityPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ie_id")
    private int ieId;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;

    public InfoentityPK() {
    }

    public InfoentityPK(int ieId, String email) {
        this.ieId = ieId;
        this.email = email;
    }

    public int getIeId() {
        return ieId;
    }

    public void setIeId(int ieId) {
        this.ieId = ieId;
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
        hash += (int) ieId;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InfoentityPK)) {
            return false;
        }
        InfoentityPK other = (InfoentityPK) object;
        if (this.ieId != other.ieId) {
            return false;
        }
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.InfoentityPK[ ieId=" + ieId + ", email=" + email + " ]";
    }
    
}
