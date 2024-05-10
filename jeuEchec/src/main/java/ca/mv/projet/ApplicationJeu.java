package ca.mv.projet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;


public class ApplicationJeu extends Application {
    Jeu jeu;
    Grille grille;

    @Override
    public void start(Stage stage) throws IOException {
        // TODO: compléter et remplacer par le code approprié
        //  pour ajouter toutes les composantes de la scene
        //  décommenter le code en commentaire au bon moment pour que le code compile
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        HBox root = (HBox) fxmlLoader.load();
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