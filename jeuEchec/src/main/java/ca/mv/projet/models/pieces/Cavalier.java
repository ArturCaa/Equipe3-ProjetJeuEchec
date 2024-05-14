package ca.mv.projet.models.pieces;

import ca.mv.projet.models.Echiquier;
import ca.mv.projet.models.cases.Position;

public class Cavalier extends Piece {

    public Cavalier(boolean estBlanche) {
        super(estBlanche);
    }

    @Override
    public boolean peutBouger(Position posCourante, Position posDestination, Echiquier echiquier) {
        // TODO: remplacer par le code approprié

        int diffSurX = Math.abs(posDestination.getX() - posCourante.getX());
        int diffSurY = Math.abs(posDestination.getY() - posCourante.getY());
        if ((diffSurX == 2 && diffSurY == 1) || (diffSurX == 1 && diffSurY == 2)){
            return true;
        }
        System.out.println("Le chevalier ne peut pas bouger");
        return false;
    }
}
