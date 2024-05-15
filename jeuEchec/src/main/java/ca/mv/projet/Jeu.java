package ca.mv.projet;

import ca.mv.projet.composants.Tuile;
import ca.mv.projet.models.Echiquier;
import ca.mv.projet.models.Joueur;
import ca.mv.projet.models.pieces.Piece;

//Todo un copteur qui vas initialiser le tour de chaque couleur si c'est paire c'est blanc si c'est impaire c'est noir
public class Jeu {

    public Echiquier echiquier;

    public Piece piece;
    public Tuile tuile;

    int tours = 0;
    Joueur joueur1;
    Joueur joueur2;

    public Jeu() {
        this.echiquier = new Echiquier();

        this.joueur1 = new Joueur("Joueur 1");
        this.joueur2 = new Joueur("Joueur 2");

        this.tours = 0;
    }


    public void passerTour(){
        tours++;
    }

    public Joueur joueurActuel(){
        return (tours % 2 == 0) ? joueur1 : joueur2;
    }

    public int getTours() {
        return tours;
    }

    public void setTours(int tours) {
        this.tours = tours;
    }
}


