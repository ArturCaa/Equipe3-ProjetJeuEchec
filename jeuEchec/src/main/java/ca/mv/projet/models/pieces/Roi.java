package ca.mv.projet.models.pieces;

import ca.mv.projet.models.Echiquier;
import ca.mv.projet.models.cases.Position;

public class Roi extends Piece {
    public Roi(boolean estBlanche) {
        super(estBlanche);
    }

    @Override
    public boolean peutBouger(Position posCourante, Position posDestination, Echiquier echiquier) {
        int diffX = Math.abs(posDestination.getX() - posCourante.getX());
        int diffY = Math.abs(posDestination.getY() - posCourante.getY());

        if ((diffX <= 1 && diffY == 0) || (diffY <= 1 && diffX == 0) || (diffX <= 1 && diffY <= 1)) {
            Piece pieceDestination = echiquier.getCaseParPosition(posDestination).getPiece();
            if (pieceDestination == null || pieceDestination.estBlanc != this.estBlanc){
                return true;
            }
        }
        System.out.println("Le roi ne peut pas bouger");
        return false;
    }
}


