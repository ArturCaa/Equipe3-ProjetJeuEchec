package ca.mv.projet;

import ca.mv.projet.models.Echiquier;
import ca.mv.projet.models.Joueur;

//Todo un copteur qui vas initialiser le tour de chaque couleur si c'est paire c'est blanc si c'est impaire c'est noir
public class Jeu {
    public Echiquier echiquier;

    int tours = 0;
    Joueur joueur1;
    Joueur joueur2;

    public Jeu() {
        this.echiquier = new Echiquier();

        this.joueur1 = new Joueur("Joueur 1");
        this.joueur2 = new Joueur("Joueur 2");

        this.tours = 0;
    }

//    public String getCouleur(){
//        if(tours % 2 == 0){
//
//        }
//        else {
//
//        }
//    }

    public void passerTour(){
        tours++;
    }


}


