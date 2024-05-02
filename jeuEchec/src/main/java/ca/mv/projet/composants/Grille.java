package ca.mv.projet.composants;

import ca.mv.projet.models.Echiquier;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import static ca.mv.projet.Utilities.NB_CASES_COTE;

public class Grille {

    private final Echiquier echiquier;
    @FXML
    GridPane grid;
    // TODO: ajouter les attributs manquants
    


    public Grille(Echiquier echiquier) {
        this.echiquier = echiquier;
        this.grid = new GridPane();
        creerGrille();
    }
    public GridPane getGrid() {
        return grid;
    }
    private void creerGrille() {
        // TODO: ajouter le code approprié
        for (int ligne = 0; ligne < NB_CASES_COTE; ligne++) {
            for (int colonne = 0; colonne < NB_CASES_COTE; colonne++) {
                StackPane stackPane = new StackPane();
                stackPane.setStyle("-fx-background-color: " + ((ligne + colonne) % 2 == 0 ? "white" : "darkgreen"));
                grid.add(stackPane, colonne, ligne);
            }
        }
    }

    public ImageView creerImageView(int colonne, int ligne, StackPane stackPane) {
        ImageView imgPieces = new ImageView((getClass().getResource("images/pieces/" +
                echiquier.getCaseParPosition(ligne, colonne).getPiece()
                        .getImage()).toExternalForm()));
        stackPane.getChildren().add(imgPieces);
        imgPieces.fitWidthProperty().bind(stackPane.widthProperty().subtract(8));
        imgPieces.fitHeightProperty().bind(stackPane.heightProperty().subtract(8));

        return imgPieces;
    }

    // TODO: ajouter les méthodes manquantes
}
