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
        if (estSurDiagonal(posCourante, posDestination)) {
            bougerSurDiagonal(posCourante, posDestination, echiquier);
            return true;
        }
        System.out.println("Le fou ne peut pas bouger");
        return false;
    }

    public boolean estSurDiagonal(Position posCourante, Position posDestination){
        // TODO : à tester
        int diffSurX = posDestination.getX() - posCourante.getX();
        int diffSurY = posDestination.getY() - posCourante.getY();

        return Math.abs(diffSurX) == Math.abs(diffSurY);
    }
}
