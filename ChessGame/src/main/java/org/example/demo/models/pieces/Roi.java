package org.example.demo.models.pieces;

public class Roi extends Piece {
    public Roi(boolean estBlanche) {
        super(estBlanche);
    }

    @Override
    public boolean peutBouger(Position posCourante, Position posDestination, Echiquier echiquier) {
        // TODO: remplacer par le code approprié
        // Implémenter la logique spécifique du déplacement du Roi
        System.out.println("peutBouger roi");
        return true;
    }
}