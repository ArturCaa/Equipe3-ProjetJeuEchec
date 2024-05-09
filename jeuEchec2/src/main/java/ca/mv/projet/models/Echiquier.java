package ca.mv.projet.models;

import ca.mv.projet.Utilities;
import ca.mv.projet.models.cases.Case;
import ca.mv.projet.models.cases.CaseOccupee;
import ca.mv.projet.models.cases.CaseVide;
import ca.mv.projet.models.cases.Position;
import ca.mv.projet.models.pieces.*;

public class Echiquier {

    private Case[][] plateau;

    public Echiquier() {
        this.plateau = new Case[Utilities.NB_CASES_COTE][Utilities.NB_CASES_COTE]; // Échiquier 8x8
        instancierCasesVides();
        placerPiecesInitSurPlateau();
    }

    private void instancierCasesVides() {
        // TODO: ajouter le code approprié
        for (int i = 0; i < Utilities.NB_CASES_COTE; i++) {
            for (int j = 0; j < Utilities.NB_CASES_COTE; j++) {
                plateau[i][j] = new CaseVide(new Position(i, j));
            }
        }
    }

    private void placerPiecesInitSurPlateau() {
        // Initialisation des pièces sur le plateau
        // Placer les pions
        placerPions();
        // placer les cavaliers
        placerCavaliers();
        // Placer les tours
        placerTours();
        // placer les fous
        placerFous();
        // Placer le roi
        placerRoi();
        // Placer la reine
        placerReine();
    }

    public void placerPions(){
        for(int i = Utilities.PREMIERE_POS; i < Utilities.NB_CASES_COTE; i++){
            Position positionInitialeBlanc = new Position(1, i);
            Position positionInitialeNoir = new Position(Utilities.DERNIERE_POS - 1, i);
            plateau[1][i] = new CaseOccupee(positionInitialeBlanc,
                    new Pion(false, positionInitialeBlanc)); // Pion noir
            plateau[Utilities.DERNIERE_POS - 1][i] = new CaseOccupee(positionInitialeNoir,
                    new Pion(true, positionInitialeNoir)); // Pion blanc
        }
    }

    public void placerFous(){
        plateau[Utilities.PREMIERE_POS][2] = new CaseOccupee(new Position(Utilities.PREMIERE_POS, 2),
                new Fou(false)); // Fou noir
        plateau[Utilities.PREMIERE_POS][Utilities.DERNIERE_POS - 2] = new CaseOccupee(new Position(Utilities.PREMIERE_POS, Utilities.DERNIERE_POS - 2),
                new Fou(false)); // Fou noir
        plateau[Utilities.DERNIERE_POS][2] = new CaseOccupee(new Position(Utilities.DERNIERE_POS, 2),
                new Fou(true)); // Fou blanc
        plateau[Utilities.DERNIERE_POS][Utilities.DERNIERE_POS - 2] = new CaseOccupee(new Position(Utilities.DERNIERE_POS, Utilities.DERNIERE_POS - 2),
                new Fou(true)); // Fou blanc
    }

    public void placerRoi(){
        plateau[Utilities.PREMIERE_POS][4] = new CaseOccupee(new Position(Utilities.PREMIERE_POS, 4),
                new Roi(false)); // Roi noir en D1
        plateau[Utilities.DERNIERE_POS][4] = new CaseOccupee(new Position(Utilities.DERNIERE_POS, 4),
                new Roi(true)); // Roi blanc en D8
    }

    public void placerReine(){
        plateau[Utilities.PREMIERE_POS][3] = new CaseOccupee(new Position(Utilities.PREMIERE_POS, 3),
                new Reine(false)); // Reine noire en E1
        plateau[Utilities.DERNIERE_POS][3] = new CaseOccupee(new Position(Utilities.DERNIERE_POS, 3),
                new Reine(true)); // Reine blanche en E8
    }

    public void placerCavaliers() {
        plateau[Utilities.PREMIERE_POS][1] = new CaseOccupee(new Position(Utilities.PREMIERE_POS,1),
                new Cavalier(false)); // Cavalier noir
        plateau[Utilities.PREMIERE_POS][Utilities.DERNIERE_POS - 1] = new CaseOccupee(new Position(Utilities.PREMIERE_POS, Utilities.DERNIERE_POS - 1),
                new Cavalier(false)); // Cavalier noir
        plateau[Utilities.DERNIERE_POS][1] = new CaseOccupee(new Position(Utilities.DERNIERE_POS, 1),
                new Cavalier(true)); // Cavalier blanc
        plateau[Utilities.DERNIERE_POS][Utilities.DERNIERE_POS - 1] = new CaseOccupee(new Position(Utilities.DERNIERE_POS, Utilities.DERNIERE_POS - 1),
                new Cavalier(true)); // Cavalier blanc
    }

    public void placerTours(){
        plateau[Utilities.PREMIERE_POS][Utilities.PREMIERE_POS] = new CaseOccupee(new Position(Utilities.PREMIERE_POS, Utilities.PREMIERE_POS),
                new Tour(false)); // Tour noir en A1
        plateau[Utilities.PREMIERE_POS][Utilities.DERNIERE_POS] = new CaseOccupee(new Position(Utilities.PREMIERE_POS, Utilities.DERNIERE_POS),
                new Tour(false)); // Tour noir en H1
        plateau[Utilities.DERNIERE_POS][Utilities.PREMIERE_POS] = new CaseOccupee(new Position(Utilities.DERNIERE_POS, Utilities.PREMIERE_POS),
                new Tour(true)); // Tour blanche en A8
        plateau[Utilities.DERNIERE_POS][Utilities.DERNIERE_POS] =
                new CaseOccupee(new Position(Utilities.DERNIERE_POS, Utilities.DERNIERE_POS),
                        new Tour(true)); // Tour blanche en H8
    }

    public Case getCaseParPosition(Position position){
        return plateau[position.getX()][position.getY()];
    }

    public Case getCaseParPosition(int xPosition, int yPosition){
        return plateau[xPosition][yPosition];
    }

    public void setCaseParPosition(Position posCourante, Position posDestination){
        plateau[posDestination.getX()][posDestination.getY()] = getCaseParPosition(posCourante);
        plateau[posCourante.getX()][posCourante.getY()] = new CaseVide(posCourante);
    }

    public Case getCaseParCoordonees(double xPixels, double yPixels) {
        int posX = Utilities.convertirPixelEnPos(xPixels) - 1;
        int posY = Utilities.convertirPixelEnPos(yPixels) - 1;

        return getCaseParPosition(posY, posX);
    }

    public boolean estValidMouve(Position posCourante, Position posDestination){
        Case caseCourante = getCaseParPosition(posCourante);
        Case caseDestination = getCaseParPosition(posDestination);

        return peutBouger(caseCourante.getPiece(), posCourante, posDestination)
                && peutCapturer(caseCourante, caseDestination);
    }

    public boolean peutCapturer(Case caseCourante, Case caseDestination) {
        return caseCourante.getPiece().peutCapturer(caseDestination.getPiece());
    }

    public boolean peutBouger(Piece pieceCourante, Position positionCourante, Position posDestination) {
        return pieceCourante.peutBouger(positionCourante, posDestination, this);
    }
}


