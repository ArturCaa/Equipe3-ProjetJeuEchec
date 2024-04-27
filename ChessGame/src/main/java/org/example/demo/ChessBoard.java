package org.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ChessBoard extends Application {
    GridPane board = new GridPane();
    private static final int BOARD_SIZE = 8;

    @Override
    public void start(Stage primaryStage) throws Exception {
        imgBoard();
        primaryStage.setScene(new Scene(board, 400, 400));
        primaryStage.setTitle("Chess Game");
        primaryStage.show();
    }

    private void imgBoard() {
        Background green = new Background(new BackgroundFill(Color.DARKGREEN, CornerRadii.EMPTY, Insets.EMPTY));
        Background white = new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY));
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                StackPane carre = new StackPane();
                carre.setBackground((row + col) % 2 == 0 ? white : green);
                board.add(carre, col, row);
                carre.prefWidthProperty().bind(board.widthProperty().divide(BOARD_SIZE));
                carre.prefHeightProperty().bind(board.heightProperty().divide(BOARD_SIZE));

                if (row == 6) {
                    ImageView pionBlanc = new ImageView(getClass().getResource("Pieces/pion_b.png").toExternalForm());
                    carre.getChildren().add(pionBlanc);
                }
                else if (row == 1) {
                    ImageView pionNoire = new ImageView(getClass().getResource("Pieces/pion_n.png").toExternalForm());
                    carre.getChildren().add(pionNoire);
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
