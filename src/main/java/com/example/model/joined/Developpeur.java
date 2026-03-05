package com.example.model.joined;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;


@Entity
@Table(name = "developpeurs")
public class Developpeur extends Employe {

    private String langage;
    private String specialite;
    private Integer anneeExperience;

    public Developpeur() {
    }

    public Developpeur(String nom, String prenom, String email, LocalDate dateEmbauche,
                       String langage, String specialite, Integer anneeExperience) {
        super(nom, prenom, email, dateEmbauche);
        this.langage = langage;
        this.specialite = specialite;
        this.anneeExperience = anneeExperience;
    }

    public String getLangage() {
        return langage;
    }

    public void setLangage(String langage) {
        this.langage = langage;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public Integer getAnneeExperience() {
        return anneeExperience;
    }

    public void setAnneeExperience(Integer anneeExperience) {
        this.anneeExperience = anneeExperience;
    }

    @Override
    public String toString() {
        return "Developpeur{" +
                "id=" + getId() +
                ", nom='" + getNom() + '\'' +
                ", prenom='" + getPrenom() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", date d'mbauche=" + getDateEmbauche() +
                ", langage='" + langage + '\'' +
                ", specialite='" + specialite + '\'' +
                ", annee d'experience=" + anneeExperience +
                '}';
    }
}