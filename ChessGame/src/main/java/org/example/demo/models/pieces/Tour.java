package org.example.demo.models.pieces;

public class Tour extends Piece {
    public Tour(boolean estBlanche) {
        super(estBlanche);
    }

    @Override
    public boolean peutBouger(Position posCourante, Position posDestination, Echiquier echiquier) {
        System.out.println("peutBouger tout");
        return true;
    }
}