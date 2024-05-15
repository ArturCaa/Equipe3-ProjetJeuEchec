package ca.mv.projet;

import ca.mv.projet.composants.PieceImage;
import ca.mv.projet.composants.Tuile;
import ca.mv.projet.models.Echiquier;
import ca.mv.projet.models.cases.Case;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

import static ca.mv.projet.Utilities.NB_CASES_COTE;

public class Grille {

    private final Echiquier echiquier;
    private final Jeu jeu;
    @FXML
    GridPane grid;

    public Grille(Jeu jeu) {
        creerGrille();
        this.jeu = jeu;
        this.echiquier = jeu.echiquier;
    }

    private void creerGrille() {
        grid = new GridPane();
    }

    public void dessinerTuiles() {
        for (int ligne = 0; ligne < NB_CASES_COTE; ligne++) {
            for (int colonne = 0; colonne < NB_CASES_COTE; colonne++) {
                Tuile tuile = new Tuile(colonne + 1, ligne + 1, jeu);
                grid.add(tuile, colonne, ligne);
                Case currentCase = echiquier.getCaseParPosition(ligne, colonne);
                if (currentCase.getPiece() != null) {
                    creerPieceImage(colonne, ligne, tuile);
                }
            }
        }
    }

    public Tuile creerPieceImage(int colonne, int ligne, Tuile tuile) {
        try{
            String imgUrl = getClass().getResource(Utilities.PIECES_IMG_URL +
                    echiquier.getCaseParPosition(ligne, colonne).getPiece()
                            .getImage()).toExternalForm();
            PieceImage imgPieces = new PieceImage(imgUrl, tuile.widthProperty().subtract(Utilities.IMAGE_MARGIN));
            tuile.getChildren().add(imgPieces);
        } catch (NullPointerException e){
            System.err.println(e.getMessage());
        }

        return tuile;
    }

    // TODO: ajouter les méthodes manquantes
}
