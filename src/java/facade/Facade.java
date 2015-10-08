/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

//import entities.Company;
//import entities.Person;
import entities.Address;
import entities.CityInfo;
import entities.Company;
import entities.Hobby;
import entities.InfoEntity;
import entities.Person;
import entities.Phone;
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

    public CityInfo getCityInfoByZip(int zip){
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("CityInfo.findByZip");
        query.setParameter("zip", zip);
        query.setMaxResults(1);
        return (CityInfo)query.getSingleResult();
    }
    
    public void createPerson(String email, String firstName, String lastName, Address address, int zip, Phone phone, Hobby hobby) {
        EntityManager em = emf.createEntityManager();

        Person p = new Person(email, firstName, lastName);
        address.setCity(getCityInfoByZip(zip));
        p.addAddresses(address);
        p.addPhones(phone);
        p.addHobby(hobby);
        
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();

    }
    public Person createPerson(Person p, Address address, int zip, Phone phone, Hobby hobby) {
        EntityManager em = emf.createEntityManager();
        
        address.setCity(getCityInfoByZip(zip));
        p.addAddresses(address);
        p.addPhones(phone);
        p.addHobby(hobby);
        
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        return p;
    }

    public void createCompany(String email, String cName, int cvr, int numemployees, int marketvalue) {
        EntityManager em = emf.createEntityManager();
        Company c = new Company(email, cName, cvr, numemployees, marketvalue);
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }

    public void addPhone(InfoEntity info, Phone phone) {
        EntityManager em = emf.createEntityManager();
        info.addPhones(phone);
        em.getTransaction().begin();
        em.merge(info);
        em.getTransaction().commit();
    }

    public void AddAddress(InfoEntity info, Address address) {
        EntityManager em = emf.createEntityManager();
        info.addAddresses(address);
        em.getTransaction().begin();
        em.merge(info);
        em.getTransaction().commit();
    }

    Person getPerson(int id) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Person.findById");
        query.setParameter("id", id);
        query.setMaxResults(1);
        return (Person) query.getSingleResult();
    }

    Company getCompany(int id) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Company.findById");
        query.setParameter("id", id);
        query.setMaxResults(1);
        return (Company) query.getSingleResult();
    }

    public static void main(String[] args) {
        Facade facade = new Facade();
//        Persistence.generateSchema("CA2PU", null);
        
//        facade.createPerson("humli@gumli.dk", "hej", "svend");
//        Person p = facade.getPerson(1);
//        Phone phone = new Phone(12345678);
//        facade.addPhone(p,phone);
//        Address adress = new Address("tyroler stræde 5");
//        CityInfo city = facade.getCityInfoByZip(8210);
//        city.addAddresses(adress);
//        p.addAddresses(adress);
//        Person p2 = facade.getPerson(1);
//        System.out.println(p2.getPhones());
//        System.out.println(p2.getAddresses());
        
        Person p =  new Person("humli@gumli.dk", "hej", "svend");
        Address adress = new Address("tyroler stræde DAS54h 5");
        Phone phone = new Phone(12345674);
        Hobby hobby = new Hobby(1,"neger dræber");
        facade.createPerson(p,adress,8210,phone,hobby);
    }
}
