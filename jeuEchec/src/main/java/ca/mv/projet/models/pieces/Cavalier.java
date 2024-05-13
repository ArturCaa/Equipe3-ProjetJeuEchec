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
//        System.out.println("peutBouger cavalier");
//        return true;
        int diffSurX = Math.abs(posDestination.getX() - posCourante.getX());
        int diffSurY = Math.abs(posDestination.getY() - posCourante.getY());

        return (diffSurX == 2 && diffSurY == 1) || (diffSurX == 1 && diffSurY == 2);
    }
}
