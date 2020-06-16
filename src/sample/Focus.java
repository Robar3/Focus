package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;


public class Focus extends Application {

    Label a,b;
    Class<?> clazz =this.getClass();
    InputStream input =clazz.getResourceAsStream("/sample/pictures/bubni.png");
    InputStream input2 =clazz.getResourceAsStream("/sample/pictures/piki.png");
    InputStream input3 =clazz.getResourceAsStream("/sample/pictures/chervi.png");
    InputStream input4 =clazz.getResourceAsStream("/sample/pictures/galka.png");
    InputStream input5 =clazz.getResourceAsStream("/sample/pictures/kresti.png");

    Image bubni = new Image(input,50,50,false,false);
    Image piki = new Image(input2,50,50,false,false);
    Image chervi = new Image(input3,50,50,false,false);
    Image galka = new Image(input4,50,50,false,false);
    Image kresti = new Image(input5,50,50,false,false);
    Label otv;
    public void start(Stage oneStage){
        oneStage.setTitle("Focus");
        FlowPane rootPane =new FlowPane(10,0);
        rootPane.setAlignment(Pos.CENTER);
        Scene hi =new Scene(rootPane,600,300);
        oneStage.setScene(hi);
        Label a =new Label("Представляю вам свой фокус, \n" +
                "для продолжения нажмите пробел");
        rootPane.getChildren().add(a);
        oneStage.show();
       hi.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCharacter().equals(" ")){
                    Stage twoStage = new Stage();
                    twoStage.setTitle("Focus");
                    FlowPane rootPane2 =new FlowPane(10,10);
                    rootPane2.setAlignment(Pos.CENTER);
                    Scene zagadka =new Scene(rootPane2,600,300);
                    twoStage.setScene(zagadka);
                    b =new Label("Загадайте число от 10 до 100, \n" +
                            "затем отнимите от загаданного числа сумму его цифр,\n" +
                            "запомните полученное число\n " +
                            "и запомните символ со следующей картинки соответствующий вашему числу" +
                            "\nдля продолжения нажмите пробел");
                    rootPane2.getChildren().add(b);
                    twoStage.show();
                    oneStage.close();
                    zagadka.setOnKeyTyped(new EventHandler<KeyEvent>() {
                        @Override
                        public void handle(KeyEvent event) {
                            if (event.getCharacter().equals(" ")){
                                Stage kartinka =new Stage();
                                kartinka.setTitle("Focus");
                                GridPane rootPane3 = new GridPane();
                                for (int i = 0; i < 11; i++) {
                                    ColumnConstraints column1 = new ColumnConstraints();
                                    column1.setPercentWidth(50);
                                    rootPane3.getColumnConstraints().add(column1);
                                }
                                for (int i = 0; i < 9; i++) {
                                    RowConstraints row1 =new RowConstraints();
                                    row1.setPercentHeight(50);
                                    rootPane3.getRowConstraints().add(row1);

                                }

                                rootPane3.setGridLinesVisible(true);
                                Scene viborKartinki =new Scene(rootPane3,1000,700);
                                kartinka.setScene(viborKartinki);
                                int z=0;
                                int f=1;
                                int i=0;
                                int[] ttt=new int[100];
                                ArrayList<Integer> hj=new ListOtvetov().otvetList();
                                String n="";
                                int index=0;
                                int d=0;
                                for (i = 0; i < 11; i++) {
                                    boolean pq=false;
                                    ImageView bubn=new ImageView(bubni);
                                    ImageView pik=new ImageView(piki);
                                    ImageView krest=new ImageView(kresti);
                                    ImageView cherv=new ImageView(chervi);
                                    ImageView galk=new ImageView(galka);
                                    ArrayList<ImageView> arr=new ArrayList<ImageView>();
                                    arr.add(bubn);
                                    arr.add(pik);
                                    arr.add(krest);
                                    arr.add(cherv);
                                    arr.add(galk);
                                    Random randomPicture=new Random();
                                    index=randomPicture.nextInt(arr.size());
                                    ttt[f-1]=index;
                                    n=Integer.toString(f);
                                    for (int x = 0; x < hj.size(); x++) {
                                        if (hj.get(x).equals(f)){
                                            pq=true;
                                            break;
                                        }
                                    }
                                   if (pq){
                                            String uu=Integer.toString(f);
                                            Label otvet= new Label(uu,arr.get(ttt[8]));
                                            otvet.setContentDisplay(ContentDisplay.TOP);
                                            int aa= f/10;
                                            int aaa=f%10-1;
                                            rootPane3.add(otvet,i,z);
                                            otv=new Label(" - Загаданная вами картинка!!!",arr.get(ttt[8]));

                                    }else {

                                    Label ss=new Label(n,arr.get(index));
                                    ss.setContentDisplay(ContentDisplay.TOP);
                                    rootPane3.add(ss,i,z);}
                                    f++;

                                    if (i==10){
                                        z++;
                                        i=-1;
                                    }
                                    if (z==9){
                                        break;
                                    }
                                }
                                kartinka.show();
                                twoStage.close();
                                viborKartinki.setOnKeyTyped(new EventHandler<KeyEvent>() {
                                    @Override
                                    public void handle(KeyEvent event) {
                                        if (event.getCharacter().equals(" ")){
                                            Stage fin=new Stage();
                                            fin.setTitle("Focus");
                                            FlowPane flowPane=new FlowPane(10,10);
                                            flowPane.setAlignment(Pos.CENTER);
                                            Scene scene=new Scene(flowPane,600,300);
                                            fin.setScene(scene);
                                            flowPane.getChildren().add(otv);
                                            fin.show();
                                            kartinka.close();
                                        }
                                    }
                                });

                            }

                        }
                    });
                }

        }

    });
    }
    public static void main(String[] args) {
        launch(args);
    }
}
