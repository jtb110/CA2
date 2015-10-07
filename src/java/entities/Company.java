/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author noncowi
 */
@Entity
@Table(name = "companies")
@NamedQueries({
    @NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c"),
    @NamedQuery(name = "Company.findByCId", query = "SELECT c FROM Company c WHERE c.companyPK.cId = :cId"),
    @NamedQuery(name = "Company.findByEmail", query = "SELECT c FROM Company c WHERE c.companyPK.email = :email"),
    @NamedQuery(name = "Company.findByCName", query = "SELECT c FROM Company c WHERE c.cName = :cName"),
    @NamedQuery(name = "Company.findByDescription", query = "SELECT c FROM Company c WHERE c.description = :description"),
    @NamedQuery(name = "Company.findByCvr", query = "SELECT c FROM Company c WHERE c.cvr = :cvr"),
    @NamedQuery(name = "Company.findByNumemployees", query = "SELECT c FROM Company c WHERE c.numemployees = :numemployees"),
    @NamedQuery(name = "Company.findByMarketvalue", query = "SELECT c FROM Company c WHERE c.marketvalue = :marketvalue")})
public class Company implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CompanyPK companyPK;
    @Basic(optional = false)
    @Column(name = "c_name")
    private String cName;
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "cvr")
    private int cvr;
    @Basic(optional = false)
    @Column(name = "numemployees")
    private int numemployees;
    @Basic(optional = false)
    @Column(name = "marketvalue")
    private int marketvalue;
    @JoinColumns({
        @JoinColumn(name = "c_id", referencedColumnName = "ie_id", insertable = false, updatable = false),
        @JoinColumn(name = "email", referencedColumnName = "email", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Infoentity infoentity;

    public Company() {
    }

    public Company(CompanyPK companyPK) {
        this.companyPK = companyPK;
    }

    public Company(CompanyPK companyPK, String cName, int cvr, int numemployees, int marketvalue) {
        this.companyPK = companyPK;
        this.cName = cName;
        this.cvr = cvr;
        this.numemployees = numemployees;
        this.marketvalue = marketvalue;
    }

    public Company(int cId, String email) {
        this.companyPK = new CompanyPK(cId, email);
    }

    public CompanyPK getCompanyPK() {
        return companyPK;
    }

    public void setCompanyPK(CompanyPK companyPK) {
        this.companyPK = companyPK;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCvr() {
        return cvr;
    }

    public void setCvr(int cvr) {
        this.cvr = cvr;
    }

    public int getNumemployees() {
        return numemployees;
    }

    public void setNumemployees(int numemployees) {
        this.numemployees = numemployees;
    }

    public int getMarketvalue() {
        return marketvalue;
    }

    public void setMarketvalue(int marketvalue) {
        this.marketvalue = marketvalue;
    }

    public Infoentity getInfoentity() {
        return infoentity;
    }

    public void setInfoentity(Infoentity infoentity) {
        this.infoentity = infoentity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyPK != null ? companyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
        if ((this.companyPK == null && other.companyPK != null) || (this.companyPK != null && !this.companyPK.equals(other.companyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Company[ companyPK=" + companyPK + " ]";
    }
    
}
