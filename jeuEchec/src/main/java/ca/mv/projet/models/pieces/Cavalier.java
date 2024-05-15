package ca.mv.projet.models.pieces;

import ca.mv.projet.models.Echiquier;
import ca.mv.projet.models.cases.Position;

public class Cavalier extends Piece {

    public Cavalier(boolean estBlanche) {
        super(estBlanche);
    }

    @Override
    public boolean peutBouger(Position posCourante, Position posDestination, Echiquier echiquier) {

        int pasX = Math.abs(posDestination.getX() - posCourante.getX());
        int pasY = Math.abs(posDestination.getY() - posCourante.getY());
        if ((pasX == 2 && pasY == 1) || (pasX == 1 && pasY == 2)){
            return true;
        }
        System.out.println("Le chevalier ne peut pas bouger");
        return false;
    }
}
