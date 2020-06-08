/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.ivor.model;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 *
 * @author Phyrexian
 */
public class HibernateHandler {

    private static SessionFactory sessionFactory;

    static {
        try {

            Configuration configuration = new Configuration();

            configuration.configure()
                    .addAnnotatedClass(Kategorija.class)
                    .addAnnotatedClass(Kosarica.class)
                    .addAnnotatedClass(Osoba.class)
                    .addAnnotatedClass(Placanje.class)
                    .addAnnotatedClass(PovijestPrijave.class)
                    .addAnnotatedClass(Proizvod.class)
                    .addAnnotatedClass(Stavka.class);

            sessionFactory = configuration.buildSessionFactory();

        } catch (Throwable ex) {
            ex.printStackTrace();;
        }
    }

    public static Session getSession() throws HibernateException {
        return sessionFactory.openSession();
    }

    public List<Kategorija> dohvatiKategorije() {
        try (Session session = getSession()) {

            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from Kategorija");
            List<Kategorija> kategorije = (List<Kategorija>) query.list();
            tx.commit();

            return kategorije;
        }
    }

    public List<Proizvod> dohvatiProizvode() {
        try (Session session = getSession()) {

            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from Proizvod");
            List<Proizvod> proizvodi = (List<Proizvod>) query.list();
            tx.commit();

            return proizvodi;
        }

    }

    public Proizvod dohvatiProizvod(int id) {
        try (Session session = getSession()) {

            Transaction tx = session.beginTransaction();
            Proizvod proizvod = session.byId(Proizvod.class).getReference(id);
            tx.commit();

            return proizvod;
        }

    }
    
        public List<Osoba> dohvatiOsobe() {
        try (Session session = getSession()) {

            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from Osoba");
            List<Osoba> osobe = (List<Osoba>) query.list();
            tx.commit();

            return osobe;
        }

    }
        
          public boolean provjeriKorisnickoImeDuplikat(String username) {
         try (Session session = getSession()) {

            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from Osoba");
            List<Osoba> osobe = (List<Osoba>) query.list();
            tx.commit();
            
             if (osobe.stream().anyMatch((osoba) -> (osoba.getUsername().equals(username)))) {
                 return true;
             }

            return false;
        }
          }
         
          public Osoba provjeriLogin(String username, String password) {
         try (Session session = getSession()) {

            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from Osoba");
            List<Osoba> osobe = (List<Osoba>) query.list();
            tx.commit();
            
            for(Osoba osoba : osobe){
                if(osoba.getUsername().equals(username) && osoba.getPassword().equals(password)){
                    return osoba;
                }
            }

            return null;
        }
 }
   

    public void noviKorisnik(Osoba osoba) {
        try (Session session = getSession()) {

            Transaction tx = session.beginTransaction();
            session.save(osoba);
            tx.commit();

        }

    }
    
    
    public List<Placanje> dohvatiVrstePlacanja() {
        try (Session session = getSession()) {

            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from Placanje");
            List<Placanje> vrstePlacanja = (List<Placanje>) query.list();
            tx.commit();

            return vrstePlacanja;
        }

    }

}
