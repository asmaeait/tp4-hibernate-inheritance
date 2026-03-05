package com.example.model.singletable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("VOITURE")
public class Voiture extends Vehicule {

    @NotNull(message = "Veuillez renseigner le nombre de portes.")
    @Min(value = 2, message = "Veuillez saisir un nombre de portes ≥ 2.")
    @Max(value = 5, message = "Veuillez saisir un nombre de portes ≤ 5")
    private Integer nombrePortes;

    private Boolean climatisation;

    private String typeCarburant;

    public Voiture() {
    }

    public Voiture(String marque, String modele, LocalDate anneeFabrication, Double prix,
                   Integer nombrePortes, Boolean climatisation, String typeCarburant) {
        super(marque, modele, anneeFabrication, prix);
        this.nombrePortes = nombrePortes;
        this.climatisation = climatisation;
        this.typeCarburant = typeCarburant;
    }

    public Integer getNombrePortes() {
        return nombrePortes;
    }

    public void setNombrePortes(Integer nombrePortes) {
        this.nombrePortes = nombrePortes;
    }

    public Boolean getClimatisation() {
        return climatisation;
    }

    public void setClimatisation(Boolean climatisation) {
        this.climatisation = climatisation;
    }

    public String getTypeCarburant() {
        return typeCarburant;
    }

    public void setTypeCarburant(String typeCarburant) {
        this.typeCarburant = typeCarburant;
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "id=" + getId() +
                ", marque='" + getMarque() + '\'' +
                ", modele='" + getModele() + '\'' +
                ", anneeFabrication=" + getAnneeFabrication() +
                ", prix=" + getPrix() +
                ", nombrePortes=" + nombrePortes +
                ", climatisation=" + climatisation +
                ", typeCarburant='" + typeCarburant + '\'' +
                '}';
    }
}