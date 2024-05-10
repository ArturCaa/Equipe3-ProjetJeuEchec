package ca.mv.projet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;


public class ApplicationJeu extends Application {
    Jeu jeu;
    Grille grille;
    TextField textFieldjoueur1;
    TextField textFieldjoueur2;

    @Override
    public void start(Stage stage) throws IOException {
        // TODO: compléter et remplacer par le code approprié
        //  pour ajouter toutes les composantes de la scene
        //  décommenter le code en commentaire au bon moment pour que le code compile
        textFieldjoueur1 = new TextField();
        textFieldjoueur1.setPromptText("Joueur 1");
        textFieldjoueur2 = new TextField();
        textFieldjoueur2.setPromptText("Joueur 2");


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        HBox root = (HBox) fxmlLoader.load();
//        root.getChildren().get(0);


        //HBox root = new HBox();
        jeu = new Jeu();
        grille = new Grille(jeu);
        grille.dessinerTuiles();
        root.getChildren().add(grille.grid);
        Scene scene = new Scene(root, Utilities.SCENE_WIDTH, Utilities.SCENE_HIEGHT);
        stage.setTitle("Jeu d'échec");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}