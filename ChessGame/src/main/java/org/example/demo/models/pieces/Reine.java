package org.example.demo.models.pieces;

public class Reine extends Piece {

    public Reine(boolean estBlanche) {
        super(estBlanche);
    }

    @Override
    public boolean peutBouger(Position posCourante, Position posDestination, Echiquier echiquier) {
        // TODO: remplacer par le code approprié
        System.out.println("peutBouger reine");
        return true;
    }
}