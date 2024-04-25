package org.example.chessgame;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ChessBoard extends Application {
    private static final int BOARD_SIZE = 8;

    @Override
    public void start(Stage stage) throws Exception {
        GridPane board = new GridPane();
        board.setGridLinesVisible(true);

        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                Rectangle rect = new Rectangle();
                rect.widthProperty().bind(board.widthProperty().divide(BOARD_SIZE));
                rect.heightProperty().bind(board.heightProperty().divide(BOARD_SIZE));
                rect.setFill((row + col) % 2 == 0 ? Color.WHITE : Color.DARKGREEN);
                board.add(rect, col, row);
            }
        }
        Scene scene = new Scene(board);
        stage.setScene(scene);
        stage.setTitle("Chess Game");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

