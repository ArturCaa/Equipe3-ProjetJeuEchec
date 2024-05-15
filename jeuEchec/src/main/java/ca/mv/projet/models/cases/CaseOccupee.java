package ca.mv.projet.models.cases;


import ca.mv.projet.models.Echiquier;
import ca.mv.projet.models.pieces.Piece;

public class CaseOccupee extends Case {

    private Piece piece;

    public CaseOccupee(Position position, Piece piece) {
        super(position, piece);
        this.piece = piece;
    }

    public boolean peutBouger(Position position, Position posDestination, Echiquier echiquier) {
        return piece.peutBouger(position, posDestination, echiquier);
    }
}
