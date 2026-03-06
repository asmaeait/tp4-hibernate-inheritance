# TP Hibernate : Implémentation des Stratégies d'Héritage JPA

Ce projet implémente les trois stratégies principales de mapping de l'héritage avec **JPA / Hibernate** et une base de données **H2** en mémoire.

##  Objectifs du TP
* Configurer un projet Maven avec Hibernate.
* Implémenter les hiérarchies de classes avec les annotations `@Inheritance`.
* Comprendre les différences structurelles en base de données pour chaque stratégie.
* Tester les requêtes polymorphiques et les opérations CRUD.

---

##  Stack Technique
* **Java:** 8 ou supérieur
* **ORM:** Hibernate 5.6.5.Final
* **BBD:** H2 (In-Memory)
* **Build:** Maven

---

## Stratégies Implémentées

### 1. SINGLE_TABLE (Véhicules)
Toute la hiérarchie est stockée dans une seule table `vehicules`.
* **Classes :** `Vehicule` (abstraite), `Voiture`, `Moto`.
* **Annotation :** `@Inheritance(strategy = InheritanceType.SINGLE_TABLE)`
* **Logique :** Utilisation d'une colonne de discrimination `type_vehicule` pour distinguer les types.

### 2. JOINED (Employés)
Chaque classe a sa propre table. Les tables filles ne contiennent que les attributs spécifiques.
* **Classes :** `Employe` (abstraite), `Developpeur`, `Manager`.
* **Annotation :** `@Inheritance(strategy = InheritanceType.JOINED)`
* **Logique :** Jointures SQL entre la table mère (`employes`) et les tables filles pour reconstituer l'objet.

### 3. TABLE_PER_CLASS (Produits)
Chaque classe concrète a sa propre table contenant tous les attributs (communs + spécifiques).
* **Classes :** `Produit` (abstraite), `Livre`, `Electronique`.
* **Annotation :** `@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)`
* **Logique :** Pas de table pour la classe mère. Utilisation de `UNION` lors des requêtes globales.

---

## Configuration du projet

### Dépendances Maven (pom.xml)
Le projet utilise les dépendances standards pour JPA, Hibernate Core, et le driver H2.
```xml
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-core</artifactId>
    <version>5.6.5.Final</version>
</dependency>
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <version>2.1.214</version>
</dependency>
```
## Aperçu des Résultats

Voici les captures d'écran illustrant le bon fonctionnement des tests et la structure de la base de données :
On peut voir dans la console les logs Hibernate générant les schémas et les résultats des requêtes polymorphiques.


<img width="918" height="225" alt="10" src="https://github.com/user-attachments/assets/fc03cb98-1642-4d1b-9d60-c6d7fa64538f" />
<img width="534" height="306" alt="9" src="https://github.com/user-attachments/assets/e714d05a-9ee6-4349-808c-17a92b7edc78" />
<img width="571" height="414" alt="8" src="https://github.com/user-attachments/assets/7a09f9f1-d43c-4775-b277-0d152572c89c" />

<img width="812" height="274" alt="6" src="https://github.com/user-attachments/assets/7af1f6c1-d640-40fd-b6b6-2ccc7c3065f7" />
<img width="726" height="331" alt="5" src="https://github.com/user-attachments/assets/5efb15ca-b123-48c8-8982-7db223850036" />

<img width="742" height="368" alt="4" src="https://github.com/user-attachments/assets/d95d1b24-deaf-4e86-b61e-e7c9ccf810b0" />
<img width="579" height="301" alt="3" src="https://github.com/user-attachments/assets/212b1c92-22ef-4a1f-b010-3ca3caee9076" />
<img width="573" height="378" alt="2" src="https://github.com/user-attachments/assets/06475332-dce5-4731-8035-4072d3871c8d" />

<img width="606" height="376" alt="1" src="https://github.com/user-attachments/assets/b65e3fd9-e72b-4dd8-bf0f-d37616b86eed" />
<img width="933" height="326" alt="15" src="https://github.com/user-attachments/assets/c607eff5-1ec3-4fa1-bfd5-bbddd3747404" />
<img width="928" height="276" alt="14" src="https://github.com/user-attachments/assets/5be1fdfa-c585-4053-a403-81f95011599e" />

<img width="929" height="288" alt="13" src="https://github.com/user-attachments/assets/a5a449b1-c344-41b9-b3b8-5b830bf97973" />
<img width="625" height="372" alt="12" src="https://github.com/user-attachments/assets/a24ece5b-c0fc-4ab2-a9fb-c0048d0ccb11" />
<img width="922" height="288" alt="11" src="https://github.com/user-attachments/assets/c32861da-8bde-462d-8ad9-a0fcbbcddca7" />

 ---
## ✍️ Auteur
**[Asma] [Ait Elmahjoub]**
