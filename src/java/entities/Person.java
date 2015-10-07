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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author noncowi
 */
@Entity
@Table(name = "persons")
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findByPId", query = "SELECT p FROM Person p WHERE p.Id = :Id"),
    @NamedQuery(name = "Person.findByFirstname", query = "SELECT p FROM Person p WHERE p.firstname = :firstname"),
    @NamedQuery(name = "Person.findByLastname", query = "SELECT p FROM Person p WHERE p.lastname = :lastname")})
public class Person extends Infoentity implements Serializable {

    @Basic(optional = false)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "lastname")
    private String lastname;
    @JoinColumns({
        @JoinColumn(name = "p_id", referencedColumnName = "ie_id", insertable = false, updatable = false),
        @JoinColumn(name = "email", referencedColumnName = "email")})
    @ManyToOne(optional = false)
    private Infoentity infoentity;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private Collection<Personhobby> personhobbyCollection;

    public Person() {
    }

    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Infoentity getInfoentity() {
        return infoentity;
    }

    public void setInfoentity(Infoentity infoentity) {
        this.infoentity = infoentity;
    }

    public Collection<Personhobby> getPersonhobbyCollection() {
        return personhobbyCollection;
    }

    public void setPersonhobbyCollection(Collection<Personhobby> personhobbyCollection) {
        this.personhobbyCollection = personhobbyCollection;
    }

    @Override
    public String toString() {
        return "entities.Person[ id=" + this.getId() + " ]";
    }

}
