package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application {
    Label a;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Focus");
        primaryStage.setScene(new Scene(root, 300, 275));
        a = new Label("Представляю вам свой фокус.");
        root.getChildrenUnmodifiable().add(a);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
