/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author noncowi
 */
public class Facade {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2PU");
    
    Person getperson (int id){
        EntityManager em = emf.createEntityManager();
        return null;
        
    }
}
