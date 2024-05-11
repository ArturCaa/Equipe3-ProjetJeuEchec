package ca.mv.projet;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.beans.binding.Bindings;


import java.awt.*;
import java.io.IOException;


public class ApplicationJeu extends Application {
    Jeu jeu;
    Grille grille;

    private TextField textFieldJoueur1;
    private TextField textFieldJoueur2;
    private Label label1;
    private Label label2;

    @Override
    public void start(Stage stage) throws IOException {
        // TODO: compléter et remplacer par le code approprié
        //  pour ajouter toutes les composantes de la scene
        //  décommenter le code en commentaire au bon moment pour que le code compile
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        HBox root = (HBox) fxmlLoader.load();

        VBox firstVBox = (VBox) root.lookup("#firstVBox");
        VBox secondVBox = (VBox) root.lookup("#secondVBox");
        textFieldJoueur1 = (TextField) firstVBox.lookup("#textFieldJoueur1");
        textFieldJoueur2 = (TextField) firstVBox.lookup("#textFieldJoueur2");
        label1 = (Label) secondVBox.lookup("#label1");
        label2 = (Label) secondVBox.lookup("#label2");

        jeu = new Jeu();
        grille = new Grille(jeu);
        grille.dessinerTuiles();
        firstVBox.getChildren().add(grille.grid);

        label1.textProperty().bind(textFieldJoueur1.textProperty());
        label2.textProperty().bind(textFieldJoueur2.textProperty());


        Scene scene = new Scene(root, Utilities.SCENE_WIDTH, Utilities.SCENE_HIEGHT);
        stage.setTitle("Jeu d'échec");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}