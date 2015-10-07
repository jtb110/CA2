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
@Table(name = "personhobby")
@NamedQueries({
    @NamedQuery(name = "Personhobby.findAll", query = "SELECT p FROM Personhobby p"),
    @NamedQuery(name = "Personhobby.findByPId", query = "SELECT p.hobby FROM Personhobby p where p.person.id = :pId"),
    @NamedQuery(name = "Personhobby.findByHId", query = "SELECT p.person FROM Personhobby p where p.hobby.hId = :hId"),
    @NamedQuery(name = "Personhobby.findByPhId", query = "SELECT p FROM Personhobby p WHERE p.phId = :phId")})
public class Personhobby implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ph_id")
    private Integer phId;
    @JoinColumn(name = "p_id", referencedColumnName = "p_id")
    @ManyToOne(optional = false)
    private Person person;
    @JoinColumn(name = "h_id", referencedColumnName = "h_id")
    @ManyToOne(optional = false)
    private Hobby hobby;

    public Personhobby() {
    }

    public Personhobby(Integer phId) {
        this.phId = phId;
    }

    public Integer getPhId() {
        return phId;
    }

    public void setPhId(Integer phId) {
        this.phId = phId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Hobby getHobby() {
        return hobby;
    }

    public void setHobby(Hobby hobby) {
        this.hobby = hobby;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (phId != null ? phId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personhobby)) {
            return false;
        }
        Personhobby other = (Personhobby) object;
        if ((this.phId == null && other.phId != null) || (this.phId != null && !this.phId.equals(other.phId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Personhobby[ phId=" + phId + " ]";
    }
    
}
