package ca.mv.projet.models.pieces;

import ca.mv.projet.models.Echiquier;
import ca.mv.projet.models.cases.Position;

public class Tour extends Piece {
    public Tour(boolean estBlanche) {
        super(estBlanche);
    }

    @Override
    public boolean peutBouger(Position posCourante, Position posDestination, Echiquier echiquier) {

        if(posCourante.getX() == posDestination.getX() || posCourante.getY() == posDestination.getY()){
            bougerSurOrthogonal(posCourante, posDestination,echiquier);
            return true;
        }

        System.out.println("peutBouger ne peut pas bouger");
        return false;
    }
}
