package ca.mv.projet;

import ca.mv.projet.models.Echiquier;
import ca.mv.projet.models.Joueur;
import javafx.scene.paint.Color;

public class Jeu {
    // TODO: ajouter le code manquant
    Echiquier echiquier;
    Joueur joueur1;
    Joueur joueur2;

    public Jeu() {
        // TODO: ajouter le code et les paramètres appropriés
        this.echiquier = new Echiquier();

        this.joueur1 = new Joueur("Joueur 1", Color.WHITE);
        this.joueur2 = new Joueur("Joueur 2", Color.BLACK);
    }

    public Echiquier getEchiquier() {
        return echiquier;
    }
    public Joueur getJoueur1() {
        return joueur1;
    }
    public Joueur getJoueur2() {
        return joueur2;
    }

    public boolean estCaseBlanche(int ligne, int colonne) {
        return false;
    }
}

