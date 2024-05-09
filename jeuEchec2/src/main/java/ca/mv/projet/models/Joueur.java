package ca.mv.projet.models;

import javafx.scene.paint.Color;

public class Joueur {
    // TODO: ajouter les attributs manquants
    private String nom;
    private Color couleur;

    public Joueur(String nom, Color couleur){
        // TODO: ajouter le code approprié
        this.nom = nom;
        this.couleur = couleur;
    }

    // TODO: ajouter les méthodes manquantes
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public Color getCouleur() {
        return couleur;
    }
    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }
}

