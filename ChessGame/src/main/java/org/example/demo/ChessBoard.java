package org.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.util.Scanner;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ChessBoard extends Application {
    // Tableau
    GridPane board = new GridPane();
    // Tableau size
    private static final int BOARD_SIZE = 8;


    @Override
    public void start(Stage primaryStage) throws Exception {
        // Section pour les noms des utilisateurs
        VBox userNameSection = new VBox();
        // Text
        userNameSection.setSpacing(10);
        Label player1 = new Label("Nom du joueur 1:");
        TextField player1TextField = new TextField();
        Label player2 = new Label("Nom du joueur 2:");
        TextField player2TextField = new TextField();
        userNameSection.getChildren().addAll(player1, player1TextField, player2, player2TextField);

        // Organisation des éléments dans la scène principale
        HBox root = new HBox();
        root.getChildren().addAll(board, userNameSection);

        imgBoard();
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.setTitle("Chess Game");
        primaryStage.show();
    }

    private void imgBoard() {
        // Couleur de l'échiquier
        Background green = new Background(new BackgroundFill(Color.DARKGREEN, CornerRadii.EMPTY, Insets.EMPTY));
        Background white = new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY));
        // Image + colonne + ligne + case de l'échiquier
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                StackPane stackpane = new StackPane();
                stackpane.setBackground((row + col) % 2 == 0 ? white : green);
                board.add(stackpane, col, row);
                stackpane.prefWidthProperty().bind(board.widthProperty().divide(BOARD_SIZE));
                stackpane.prefHeightProperty().bind(board.heightProperty().divide(BOARD_SIZE));

                // Ajout des pièces dans l'échiquier
                // Tour noir
                if (row == 0 && col == 0) {
                    ImageView tour_n = new ImageView(getClass().getResource("Pieces/tour_n.png").toExternalForm());
                    stackpane.getChildren().add(tour_n);
                }
                // Cavalier noir
                else if (row == 0 && col == 1) {
                    ImageView cavalier_n = new ImageView(getClass().getResource("Pieces/cavalier_n.png").toExternalForm());
                    stackpane.getChildren().add(cavalier_n);
                }
                // Fou noir
                else if (row == 0 && col == 2) {
                    ImageView fou_n = new ImageView(getClass().getResource("Pieces/fou_n.png").toExternalForm());
                    stackpane.getChildren().add(fou_n);
                }
                // Reine noir
                else if (row == 0 && col == 3) {
                    ImageView reine_n = new ImageView(getClass().getResource("Pieces/reine_n.png").toExternalForm());
                    stackpane.getChildren().add(reine_n);
                }
                // Roi noir
                else if (row == 0 && col == 4) {
                    ImageView roi_n = new ImageView(getClass().getResource("Pieces/roi_n.png").toExternalForm());
                    stackpane.getChildren().add(roi_n);
                }
                // Fou noir
                else if (row == 0 && col == 5) {
                    ImageView fou_n = new ImageView(getClass().getResource("Pieces/fou_n.png").toExternalForm());
                    stackpane.getChildren().add(fou_n);
                }
                // Cavalier noir
                else if (row == 0 && col == 6) {
                    ImageView cavalier_n = new ImageView(getClass().getResource("Pieces/cavalier_n.png").toExternalForm());
                    stackpane.getChildren().add(cavalier_n);
                }
                // Tour noir
                else if (row == 0 && col == 7) {
                    ImageView tour_n = new ImageView(getClass().getResource("Pieces/tour_n.png").toExternalForm());
                    stackpane.getChildren().add(tour_n);
                }
                // Pions noir
                else if (row == 1) {
                    ImageView pionNoire = new ImageView(getClass().getResource("Pieces/pion_n.png").toExternalForm());
                    stackpane.getChildren().add(pionNoire);
                }
                // Pions blanc
                else if (row == 6) {
                    ImageView pionBlanc = new ImageView(getClass().getResource("Pieces/pion_b.png").toExternalForm());
                    stackpane.getChildren().add(pionBlanc);
                }
                // Tour blanc
                else if (row == 7 && col == 0) {
                    ImageView tour_b = new ImageView(getClass().getResource("Pieces/tour_b.png").toExternalForm());
                    stackpane.getChildren().add(tour_b);
                }
                // Cavalier blanc
                else if (row == 7 && col == 1) {
                    ImageView cavalier_b = new ImageView(getClass().getResource("Pieces/cavalier_b.png").toExternalForm());
                    stackpane.getChildren().add(cavalier_b);
                }
                // Fou blanc
                else if (row == 7 && col == 2) {
                    ImageView fou_b = new ImageView(getClass().getResource("Pieces/fou_b.png").toExternalForm());
                    stackpane.getChildren().add(fou_b);
                }
                // Reine blanc
                else if (row == 7 && col == 3) {
                    ImageView reine_b = new ImageView(getClass().getResource("Pieces/reine_b.png").toExternalForm());
                    stackpane.getChildren().add(reine_b);
                }
                // Roi blanc
                else if (row == 7 && col == 4) {
                    ImageView roi_b = new ImageView(getClass().getResource("Pieces/roi_b.png").toExternalForm());
                    stackpane.getChildren().add(roi_b);
                }
                // Fou blanc
                else if (row == 7 && col == 5) {
                    ImageView fou_b = new ImageView(getClass().getResource("Pieces/fou_b.png").toExternalForm());
                    stackpane.getChildren().add(fou_b);
                }
                // Cavalier blanc
                else if (row == 7 && col == 6) {
                    ImageView cavalier_b = new ImageView(getClass().getResource("Pieces/cavalier_b.png").toExternalForm());
                    stackpane.getChildren().add(cavalier_b);
                }
                // Tour blanc
                else if (row == 7 && col == 7) {
                    ImageView tour_b = new ImageView(getClass().getResource("Pieces/tour_b.png").toExternalForm());
                    stackpane.getChildren().add(tour_b);
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
