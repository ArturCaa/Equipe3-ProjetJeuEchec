package ca.mv.projet.models.pieces;

import ca.mv.projet.models.Echiquier;
import ca.mv.projet.models.cases.Position;

public class Reine extends Piece {

    public Reine(boolean estBlanche) {
        super(estBlanche);
    }

    @Override
    public boolean peutBouger(Position posCourante, Position posDestination, Echiquier echiquier) {
        // TODO: remplacer par le code approprié
        if (estSurDiagonal(posCourante, posDestination) || posCourante.getX() == posDestination.getX() || posCourante.getY() == posDestination.getY()) {
            bougerSurDiagonal(posCourante, posDestination, echiquier);
            bougerSurOrthogonal(posCourante, posDestination, echiquier);
            return true;
        }


        System.out.println("La reine ne peut pas bouger");
        return false;
    }
}
