package ca.mv.projet.models.pieces;

import ca.mv.projet.models.Echiquier;
import ca.mv.projet.models.cases.CaseVide;
import ca.mv.projet.models.cases.Position;

public class Fou extends Piece {

    public Fou(boolean estBlanche) {
        super(estBlanche);
    }

    @Override
    public boolean peutBouger(Position posCourante, Position posDestination, Echiquier echiquier) {
        // Vérifiez d'abord si la destination est sur la même diagonale que la position actuelle du fou
        if (!estSurDiagonal(posCourante, posDestination)) {
            return false; // Le fou ne peut se déplacer que sur une diagonale
        }

        // Ensuite, vérifiez si le chemin jusqu'à la destination est libre (aucune pièce entre la position actuelle et la destination)
        int diffSurX = Integer.signum(posDestination.getX() - posCourante.getX());
        int diffSurY = Integer.signum(posDestination.getY() - posCourante.getY());
        int x = posCourante.getX() + diffSurX;
        int y = posCourante.getY() + diffSurY;
        while (x != posDestination.getX() && y != posDestination.getY()) {
            // Vérifiez si la case est vide
            if (!(echiquier.getCaseParPosition(x, y) instanceof CaseVide)) {
                return false; // Il y a une pièce sur le chemin du fou
            }
            x += diffSurX;
            y += diffSurY;
        }

        // Si aucune pièce n'occupe le chemin jusqu'à la destination, le mouvement est valide
        return true;
    }


    public boolean estSurDiagonal(Position posCourante, Position posDestination){
        // TODO : à tester
        int diffSurX = posDestination.getX() - posCourante.getX();
        int diffSurY = posDestination.getY() - posCourante.getY();

        return Math.abs(diffSurX) == Math.abs(diffSurY);
    }
}
