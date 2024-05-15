package ca.mv.projet.models.pieces;

import ca.mv.projet.models.Echiquier;
import ca.mv.projet.models.cases.Position;

public class Roi extends Piece {
    public Roi(boolean estBlanche) {
        super(estBlanche);
    }

    @Override
    public boolean peutBouger(Position posCourante, Position posDestination, Echiquier echiquier) {
        int pasX = Math.abs(posDestination.getX() - posCourante.getX());
        int pasY = Math.abs(posDestination.getY() - posCourante.getY());

        if ((pasX <= 1 && pasY == 0) || (pasY <= 1 && pasX == 0) || (pasX <= 1 && pasY <= 1)) {
            if (estSurDiagonal(posCourante, posDestination) || posCourante.getX() == posDestination.getX() || posCourante.getY() == posDestination.getY()) {
                bougerSurDiagonal(posCourante, posDestination, echiquier);
                bougerSurOrthogonal(posCourante, posDestination, echiquier);
                return true;
            }
        }
        System.out.println("Le roi ne peut pas bouger");
        return false;
    }
}


