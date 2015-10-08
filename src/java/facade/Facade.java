/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

//import entities.Company;
//import entities.Person;
import entities.Person;
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
    
    public void create person(){
    }
    Person getPerson(int id){
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Person.findById");
        query.setMaxResults(1);
        return (Person)query.getSingleResult();
    }
   
    public static void main(String[] args) {
        Facade facade = new Facade();
        Persistence.generateSchema("CA2PU", null);
    }
}
