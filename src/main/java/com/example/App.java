package com.example;

import com.example.model.joined.Developpeur;
import com.example.model.joined.Employe;
import com.example.model.joined.Manager;
import com.example.model.singletable.Moto;
import com.example.model.singletable.Vehicule;
import com.example.model.singletable.Voiture;
import com.example.model.tableperclass.Electronique;
import com.example.model.tableperclass.Livre;
import com.example.model.tableperclass.Produit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Création de l'EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-inheritance");

        try {
            // Test de SINGLE_TABLE
            System.out.println("\n---- Test de la stratégie SINGLE_TABLE ----");
            testSingleTable(emf);

            // Test de JOINED
            System.out.println("\n---- Test de la stratégie JOINED ----");
            testJoined(emf);

            // Test de TABLE_PER_CLASS
            System.out.println("\n---- Test de la stratégie TABLE_PER_CLASS ----");
            testTablePerClass(emf);

        } finally {
            // Fermeture de l'EntityManagerFactory
            emf.close();
        }
    }

    private static void testSingleTable(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            // Création des véhicules
            System.out.println("Création des véhicules...");

            Voiture voiture1 = new Voiture(
                    "Honda", "100", LocalDate.of(2021, 1, 9), 15000.0,
                    5, true, "Essence"
            );

            Voiture voiture2 = new Voiture(
                    "Peugeot", "308", LocalDate.of(2019, 3, 10), 18000.0,
                    5, true, "Diesel"
            );

            Moto moto1 = new Moto(
                    "Honda", "CBR", LocalDate.of(2021, 7, 20), 12000.0,
                    540, "Manuelle"
            );

            // Persistance
            em.persist(voiture1);
            em.persist(voiture2);
            em.persist(moto1);

            em.getTransaction().commit();
            System.out.println("Véhicules créés avec succès !");

            // Requêtes polymorphiques
            em.clear();

            System.out.println("\nRécupération de tous les véhicules :");
            List<Vehicule> vehicules = em.createQuery("SELECT v FROM Vehicule v", Vehicule.class)
                    .getResultList();
            vehicules.forEach(System.out::println);

            System.out.println("\nRécupération de toutes les voitures :");
            List<Voiture> voitures = em.createQuery("SELECT v FROM Voiture v", Voiture.class)
                    .getResultList();
            voitures.forEach(System.out::println);

            System.out.println("\nRécupération de toutes les motos :");
            List<Moto> motos = em.createQuery("SELECT m FROM Moto m", Moto.class)
                    .getResultList();
            motos.forEach(System.out::println);

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    private static void testJoined(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            //  des employés
            System.out.println("Création des employés...");

            Developpeur dev1 = new Developpeur(
                    "Ait Elmahjoub", "Asma", "asma.ait@example.com", LocalDate.of(2025, 5, 20),
                    "python", "fullstack", 1
            );

            Developpeur dev2 = new Developpeur(
                    "Sara", "Ali", "sara.ali2@example.com", LocalDate.of(2020, 3, 10),
                    "Java", "Backend", 2
            );

            Manager manager1 = new Manager(
                    "Ahmed", "Imad", "ahmed.imad@example.com", LocalDate.of(2019, 7, 20),
                    "IT", 10, 5000.0
            );

            // Persistance
            em.persist(dev1);
            em.persist(dev2);
            em.persist(manager1);

            em.getTransaction().commit();
            System.out.println("Employés créés avec succès !");

            // Requêtes polymorphiques
            em.clear();

            System.out.println("\nRécupération de tous les employés :");
            List<Employe> employes = em.createQuery("SELECT e FROM Employe e", Employe.class)
                    .getResultList();
            employes.forEach(System.out::println);

            System.out.println("\nRécupération de tous les développeurs :");
            List<Developpeur> devs = em.createQuery("SELECT d FROM Developpeur d", Developpeur.class)
                    .getResultList();
            devs.forEach(System.out::println);

            System.out.println("\nRécupération de tous les managers :");
            List<Manager> managers = em.createQuery("SELECT m FROM Manager m", Manager.class)
                    .getResultList();
            managers.forEach(System.out::println);

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    private static void testTablePerClass(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            // Création des produits
            System.out.println("Création des produits...");

            Livre livre1 = new Livre(
                    "Dracula", 30.99, "Un classique de fantasy",
                    "I.W.W Tolkien", "978-20757658", 1200, "Pocket"
            );

            Livre livre2 = new Livre(
                    "Harry Potter", 44.87, "Roman fantastique pour jeunes",
                    "J.K. Rowling", "978-2070643028", 800, "Gallimard"
            );

            Electronique elec1 = new Electronique(
                    "Smartphone Ultra s8", 4099.99, "Smartphone haut de gamme",
                    "Samsung", "S21", 24, "Écran 6.2\", 128Go, 24Go RAM"
            );

            // Persistance
            em.persist(livre1);
            em.persist(livre2);
            em.persist(elec1);

            em.getTransaction().commit();
            System.out.println("Produits créés avec succès !");

            // Requêtes polymorphiques
            em.clear();

            System.out.println("\nRécupération de tous les produits :");
            List<Produit> produits = em.createQuery("SELECT p FROM Produit p", Produit.class)
                    .getResultList();
            produits.forEach(System.out::println);

            System.out.println("\nRécupération de tous les livres :");
            List<Livre> livres = em.createQuery("SELECT l FROM Livre l", Livre.class)
                    .getResultList();
            livres.forEach(System.out::println);

            System.out.println("\nRécupération de tous les produits électroniques :");
            List<Electronique> elecs = em.createQuery("SELECT e FROM Electronique e", Electronique.class)
                    .getResultList();
            elecs.forEach(System.out::println);

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}