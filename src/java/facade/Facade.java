/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Company;
import entities.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author noncowi
 */
public class Facade {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2PU");
    
    Person getPerson (int id){
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Infoentity.findById");
        query.setParameter("Id", id);
        query.setMaxResults(1);
        return (Person)query.getSingleResult();
    }
    Company getCompany (int id){
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Infoentity.findById");
        query.setParameter("Id", id);
        query.setMaxResults(1);
        return (Company)query.getSingleResult();
    }
    List<Person> getPersons(){
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Infoentity.findAll");
        return query.getResultList();
    }
//    List<Person> getPersonsbyHobby(){
//        EntityManager em = emf.createEntityManager();
//        Query query = em.createNamedQuery("Personhobby.findByHId");
//        query.setParameter("hId", 1);
//        return query.getResultList();
//    }
   
    public static void main(String[] args) {
        Facade facade = new Facade();
        Persistence.generateSchema("CA2PU", null);
//      System.out.println(facade.getPerson(1).toString());
//      System.out.println(facade.getCompany(2).toString());
//        System.out.println(facade.getPersonsbyHobby());
    }
}
