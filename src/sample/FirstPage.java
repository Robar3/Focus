package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class FirstPage extends Application {
    Stage stage1;
    public void start(Stage oneStage){
        stage1=oneStage;
        oneStage.setTitle("Focus");
        FlowPane rootPane =new FlowPane(10,0);
        rootPane.setAlignment(Pos.CENTER);
        Scene hi =new Scene(rootPane,600,300);
        oneStage.setScene(hi);
        Label a =new Label("Представляю вам свой фокус, \n" +
                "для продолжения нажмите пробел");
        rootPane.getChildren().add(a);


    }
    public Stage page1(){
        return stage1;
    }
}
