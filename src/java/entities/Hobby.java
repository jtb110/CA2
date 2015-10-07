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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "hobbies")
@NamedQueries({
    @NamedQuery(name = "Hobby.findAll", query = "SELECT h FROM Hobby h"),
    @NamedQuery(name = "Hobby.findByHId", query = "SELECT h FROM Hobby h WHERE h.hId = :hId"),
    @NamedQuery(name = "Hobby.findByHName", query = "SELECT h FROM Hobby h WHERE h.hName = :hName"),
    @NamedQuery(name = "Hobby.findByDescription", query = "SELECT h FROM Hobby h WHERE h.description = :description")})
public class Hobby implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "h_id")
    private Integer hId;
    @Basic(optional = false)
    @Column(name = "h_name")
    private String hName;
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hobby")
    private Collection<Personhobby> personhobbyCollection;

    public Hobby() {
    }

    public Hobby(Integer hId) {
        this.hId = hId;
    }

    public Hobby(Integer hId, String hName) {
        this.hId = hId;
        this.hName = hName;
    }

    public Integer getHId() {
        return hId;
    }

    public void setHId(Integer hId) {
        this.hId = hId;
    }

    public String getHName() {
        return hName;
    }

    public void setHName(String hName) {
        this.hName = hName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Personhobby> getPersonhobbyCollection() {
        return personhobbyCollection;
    }

    public void setPersonhobbyCollection(Collection<Personhobby> personhobbyCollection) {
        this.personhobbyCollection = personhobbyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hId != null ? hId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hobby)) {
            return false;
        }
        Hobby other = (Hobby) object;
        if ((this.hId == null && other.hId != null) || (this.hId != null && !this.hId.equals(other.hId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Hobby[ hId=" + hId + " ]";
    }
    
}
