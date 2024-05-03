package main.java.ca.mv.projet;

import main.java.ca.mv.projet.models.Echiquier;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class Grille {

    private final Echiquier echiquier;
    @FXML
    GridPane grid;
    // TODO: ajouter les attributs manquants

    public Grille(Echiquier echiquier) {
        creerGrille();
        this.echiquier = echiquier;
    }

    private void creerGrille() {
        // TODO: ajouter le code approprié
          for (int ligne = 0; ligne < NB_CASES_COTE; ligne++) {
            for (int colonne = 0; colonne < NB_CASES_COTE; colonne++) {
                StackPane stackPane = new StackPane();
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
