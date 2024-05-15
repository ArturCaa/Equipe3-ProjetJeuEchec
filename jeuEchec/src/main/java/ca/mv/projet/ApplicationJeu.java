package ca.mv.projet;

import ca.mv.projet.models.Echiquier;
import ca.mv.projet.models.cases.Position;
import ca.mv.projet.models.pieces.*;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.beans.binding.Bindings;
import javafx.scene.text.Text;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;



public class ApplicationJeu extends Application {
    Jeu jeu;
    Grille grille;

    private TextField textFieldJoueur1;
    private TextField textFieldJoueur2;
    private Label label1;
    private Label label2;
    private Button resetButton;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        HBox root = (HBox) fxmlLoader.load();

        VBox firstVBox = (VBox) root.lookup("#firstVBox");
        VBox secondVBox = (VBox) root.lookup("#secondVBox");

        textFieldJoueur1 = (TextField) firstVBox.lookup("#textFieldJoueur1");
        textFieldJoueur2 = (TextField) firstVBox.lookup("#textFieldJoueur2");
        resetButton = (Button) firstVBox.lookup("#resetButton");
        label1 = (Label) secondVBox.lookup("#label1");
        label2 = (Label) secondVBox.lookup("#label2");

        jeu = new Jeu();
        grille = new Grille(jeu);
        grille.dessinerTuiles();
        firstVBox.getChildren().add(grille.grid);

        label1.textProperty().bind(textFieldJoueur1.textProperty());
        label2.textProperty().bind(textFieldJoueur2.textProperty());


        resetButton.setOnAction(event -> {
            // Réinitialisation du jeu
            jeu = new Jeu();
            grille = new Grille(jeu);
            grille.dessinerTuiles();
            firstVBox.getChildren().remove(1); // Supprime l'ancienne grille
            firstVBox.getChildren().add(grille.grid); // Ajoute la nouvelle grille

            // Réinitialisation des noms des joueurs
            textFieldJoueur1.clear();
            textFieldJoueur2.clear();
            label1.textProperty().unbind();
            label2.textProperty().unbind();
            label1.setText("Joueur 1");
            label2.setText("Joueur 2");
            label1.textProperty().bind(textFieldJoueur1.textProperty());
            label2.textProperty().bind(textFieldJoueur2.textProperty());
        });


        Scene scene = new Scene(root, Utilities.SCENE_WIDTH, Utilities.SCENE_HIEGHT);
        stage.setTitle("Jeu d'échec");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        Echiquier echiquier = new Echiquier();

        // Position de départ et d'arrivée pour tester la tour
        Position posCourante = new Position(0, 0); // Position de départ
        Position posDestination = new Position(0,1 ); // Position d'arrivée

        // Création d'une tour
        Roi roi = new Roi(true); // Tour blanche

        // Appel de la méthode peutBouger pour la tour
        boolean peutBouger = roi.peutBouger(posCourante, posDestination, echiquier);

        // Affichage du résultat
        if (peutBouger) {
            System.out.println("Le roi peut bouger sur la case de destination.");
        } else {
            System.out.println("La roi ne peut pas bouger sur la case de destination.");
        }

        launch();
    }
}