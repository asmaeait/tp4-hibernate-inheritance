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

![interfaces]
 
