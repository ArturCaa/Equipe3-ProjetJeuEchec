package ca.mv.projet.models;

import ca.mv.projet.composants.Tuile;
import ca.mv.projet.models.pieces.Piece;

public class Joueur{
    private String nom;

    Piece piece;
    public boolean estBlanc;
    
    public Joueur(String nom){

        this.nom = nom;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isJoueurEstBlanc() {
        return estBlanc;
    }



}
