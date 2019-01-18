package ch.zhaw.roma.hibernate_test;

import ch.zhaw.roma.model.viewClasses.*;

import javax.persistence.*;


public class TestH {

    private static Author a1;
    private static Book b1;
    private static Book b2;


    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ch.zhaw.roma.jpa");

        createTestObjects();

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(a1);
        entityManager.persist(b1);
        entityManager.persist(b2);

        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public static void createTestObjects() {

        b1 = new Book();
        b1.setTitle("Das Urteil");
        b1.setISBN("1234-5678-9000");
        b1.setPriceEbookEUR(12.45);
        b1.setPriceHardcoverCHF(49.45);
        b1.setPriceHardcoverEUR(45.55);
        b1.setRoyalityQuote(7);


        b2 = new Book();
        b2.setTitle("Prometheus");
        b2.setISBN("5463-5431-7956");
        b2.setPriceEbookEUR(13.95);
        b2.setPriceHardcoverCHF(39.40);
        b2.setPriceHardcoverEUR(33.35);
        b2.setRoyalityQuote(7);


        a1 = new Author();
        a1.setGreeting("Herr");
        a1.setFirstName("Franz");
        a1.setLastName("Kafka");
        a1.setStreet1("Kaeferstrasse 42");
        a1.setCity("Prag");
        a1.setZipCode(666666);
        a1.setCountry("Tschechoslowakei");
        a1.addBook(b1);
        a1.addBook(b2);



    }

}
