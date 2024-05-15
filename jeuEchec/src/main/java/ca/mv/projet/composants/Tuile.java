package ca.mv.projet.composants;

import ca.mv.projet.Jeu;
import ca.mv.projet.models.Echiquier;
import ca.mv.projet.models.Joueur;
import ca.mv.projet.models.cases.Position;
import ca.mv.projet.models.pieces.Piece;
import javafx.fxml.FXML;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static ca.mv.projet.Utilities.TAILLE_TUILE;

public class Tuile extends StackPane {
    Jeu jeu;
    Position position;
    static Position posSource;

    @FXML
    static PieceImage image;

    Echiquier echiquier = new Echiquier();

    public Tuile(boolean estCaseBlanche) {
        Rectangle rectangle = creerCaree(estCaseBlanche);
        this.getChildren().add(rectangle);
        ajouterEvenementsTuile();
    }

    public Tuile(int ligne, int colonne, Jeu jeu) {
        boolean estCaseBlanche = (ligne + colonne) % 2 == 0;
        this(estCaseBlanche);
        this.position = new Position(ligne, colonne);
        this.jeu = jeu;
    }

    public Rectangle creerCaree(boolean estCaseBlanche) {
        Rectangle rectangle = new Rectangle(TAILLE_TUILE, TAILLE_TUILE);
        if (estCaseBlanche) {
            rectangle.setFill(Color.WHITE);
        } else {
            rectangle.setFill(Color.DARKGREEN);
        }
        return rectangle;
    }

    public void ajouterEvenementsTuile() {
        // Gestion évènement au drag
        this.setOnMouseDragged(mouseEvent -> ajouterEvenementsTuileSourisDragged());

        this.setOnDragOver(event -> ajouterEvenementsTuileFinDrag(event));

        // Gestion évènement au drop
        this.setOnDragDropped(event -> ajouterEvenementsTuileDragDrop(event));
    }

    private void ajouterEvenementsTuileSourisDragged() {
        if (this.getChildren().size() == 2) {
            image = (PieceImage) this.getChildren().get(1);
        }
        posSource = this.position;
    }

    public Tuile getTuileParPosition(Position destPos) {
        GridPane parent = (GridPane) (this.getParent());

        return (Tuile) parent.getChildren().get(destPos.convertirEnIndex());
    }

    public void ajouterEvenementsTuileFinDrag(DragEvent event) {
        if (event.getGestureSource() != this && event.getDragboard().hasImage()) {
            // TODO: ajouter le code approprié si nécessaire
            event.acceptTransferModes(TransferMode.MOVE);
        }
        event.consume();
    }

    // TODO : Complétez le code manquant
    public void ajouterEvenementsTuileDragDrop(DragEvent event) {
        Dragboard db = event.getDragboard();
        if (db.hasImage()) {
            Joueur playerActuel = jeu.joueurActuel();
            if ((playerActuel.isJoueurEstBlanc() && image.getPiece().isEstBlanc()) || (!playerActuel.isJoueurEstBlanc() && !image.getPiece().isEstBlanc())){
                if (echiquier.estValidMouve(position, posSource)){
                    echiquier.setCaseParPosition(position, posSource);
                    jeu.passerTour();
                }
                else {
                    System.out.println("Le mouvement est invalid");
                }

                if(this.getChildren().size()==2){
                    PieceImage imageMangee = (PieceImage) this.getChildren().remove(1);
                }

                this.getChildren().add(image);
                // TODO : appeler setCaseParPosition qui remplace le contenu de la case destination par celui de la case source
                // et met la case source a une case vide
                event.setDropCompleted(true);
            } else {
                event.setDropCompleted(false);
            }

        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    @Override
    public String toString() {
        return "Tuile{" +
                ", children= " + getChildren() +
                "} " + super.toString();

    }
}