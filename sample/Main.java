
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    public int resX = 1600; //resolution widt
    public int resY = 900; //resolution height

    private Group hamletGroup = new Group();
    private Group dialogueGroup = new Group();
    background bg = new background();
    Hamlet ham1 = new Hamlet(); //instantiates class for Hamlet's movement
    Dialogue dia1 = new Dialogue(dialogueGroup);
    
  
    nonPlayableChar olhammy = new nonPlayableChar(-800, 20);
    nonPlayableChar hammy = new nonPlayableChar(2000, 600);
    nonPlayableChar rose = new nonPlayableChar(-400, 800);
    nonPlayableChar laer = new nonPlayableChar(-1500, 600);
    nonPlayableChar gert = new nonPlayableChar(1000,200);
    nonPlayableChar claud = new nonPlayableChar(-1000,800);
    nonPlayableChar oph = new nonPlayableChar(200, 400);
    nonPlayableChar polo = new nonPlayableChar(600, 600);
    @Override
    public void start(Stage primaryStage) throws Exception{
        //Variables.
        int b1W = 200; //buttons 1-2, width and height
        int b1H = 100;
        int b2W = 200;
        int b2H = 100;
        int b1X = 350; //buttons 1-2, x and y
        int b1Y =  550;
        int b2X = 850;
        int b2Y = 550;

        FileInputStream input = new FileInputStream("G:\\My Drive\\Grade 12\\ics2\\HamletFinal\\src\\coollogo_com-16400715.png");
        FileInputStream button = new FileInputStream("G:\\My Drive\\Grade 12\\ics2\\HamletFinal\\src\\hamlet-skull_300x300.png");
        
        Image image = new Image (input);
        Image buttonpic = new Image(button);
       
        ImageView imageview = new ImageView(image);
        ImageView b = new ImageView(buttonpic);
        
        Media m = new Media("G:\\My Drive\\Grade 12\\ics2\\HamletFinal\\src\\Medieval Folk Music - Camelot.mp3");
       MediaPlayer player = new MediaPlayer(m);
       MediaView mv = new MediaView(player);
        
        
        imageview.setFitHeight(resX/4);
        imageview.setFitWidth(resY);
        imageview.setX(resX/4 - 150);
        imageview.setY(resY/6);
       
        b.setFitHeight(50);
        b.setFitWidth(50);
       
        Button button1 = new Button("ENTER", b); //new game button
        Button button2 = new Button(); //exit button
        AnchorPane root = new AnchorPane(imageview); //add nodes/children to this to display on main menu
        root.setStyle("-fx-background-color: #000000");
       
        AnchorPane mainGame = new AnchorPane(mv); //add nodes/children to this to display on main game
        Scene mainScene = new Scene(mainGame, resX, resY); //main game scene
        Scene scene = new Scene(root, resX, resY); //main menu scene
        Text mainTitle = new Text();
        ham1.setxCoord((resX -250) / 2);
        ham1.setyCoord((resY -250) /2);
        
        root.getChildren().add(mv);
        player.setVolume(1.0);
        player.setCycleCount(MediaPlayer.INDEFINITE);
        player.play();
        //*********************

        scene.getStylesheets().add("mainmenu.css");
        primaryStage.setTitle("Hamlet: The Afterlife - ENG4U: Farin, Lin, Liu, Ruan");

        //new game button i.e. enter game or whatever
       
        String hover = " -fx-background-color: -fx-shadow-highlight-color, -fx-outer-border, -fx-inner-border, -fx-body-color;" +
        "    -fx-background-insets: 0 0 -1 0, 0, 1, 2;" +
        "    -fx-background-radius: 12px, 12px, 12px, 12px;" +
        "    -fx-padding: 0.333333em 0.666667em 0.333333em 0.666667em;" +
        "    -fx-text-fill: -fx-text-base-color;" +
        "    -fx-alignment: CENTER;" +
        "    -fx-content-display: LEFT;" +
        " -fx-font-size: 20px";
       
        button1.setStyle(hover);
        button1.setPrefWidth(b1W);
        button1.setPrefHeight(b1H);
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(mainScene); //sets scene to mainScene which is the main game
            }
        });
        //******************

        //button to exit
        button2.setText("EXIT"); //button to exit game
        button2.setStyle(hover);
        button2.setPrefWidth(b2W);
        button2.setPrefHeight(b2H);
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit(); //exits game
            }
        });
        //******************

        //button x, yx
        button1.setLayoutX(b1X);
        button1.setLayoutY(b1Y);
        button2.setLayoutX(b2X);
        button2.setLayoutY(b2Y);
        //*******************
        //adds buttons
        root.getChildren().add(button2);
        root.getChildren().add(button1);
        root.getChildren().add(mainTitle);
        //*******************


        String ophelia = "G:\\My Drive\\Grade 12\\ics2\\HamletFinal\\src\\ophelia.png";
        String o1 = "G:\\My Drive\\Grade 12\\ics2\\HamletFinal\\src\\opheliaghost.png";
        String polonius ="G:\\My Drive\\Grade 12\\ics2\\HamletFinal\\src\\polonius.png";
        String p1 = "G:\\My Drive\\Grade 12\\ics2\\HamletFinal\\src\\poloniusghost.png";
        String claudius ="G:\\My Drive\\Grade 12\\ics2\\HamletFinal\\src\\claudius.png";
        String c1 ="G:\\My Drive\\Grade 12\\ics2\\HamletFinal\\src\\claudiusghost.png";
        String rosie ="G:\\My Drive\\Grade 12\\ics2\\HamletFinal\\src\\roseandguild.png";
        String r1 ="G:\\My Drive\\Grade 12\\ics2\\HamletFinal\\src\\roseandguildghost.png";
        String gertty = "G:\\My Drive\\Grade 12\\ics2\\HamletFinal\\src\\gertrude.png";
        String g1 = "G:\\My Drive\\Grade 12\\ics2\\HamletFinal\\src\\gertrudeghost.png";
        String laertes = "G:\\My Drive\\Grade 12\\ics2\\HamletFinal\\src\\laertes.png";
        String l1 = "G:\\My Drive\\Grade 12\\ics2\\HamletFinal\\src\\laertesghost.png";
        String grave = "G:\\My Drive\\Grade 12\\ics2\\HamletFinal\\src\\grave.png";
        String oldham = "G:\\My Drive\\Grade 12\\ics2\\HamletFinal\\src\\OldHamlet.png";
        String blanko = "G:\\My Drive\\Grade 12\\ics2\\HamletFinal\\src\\blanko.png";

        nonPlayableChar[] npcs = new nonPlayableChar[]{hammy, oph, gert, polo, claud, rose, laer, olhammy};

        Controller control = new Controller();
        control.keyboardinput(ham1, npcs, bg,mainScene, dia1);
        //ham1.characterMovement(mainScene); //method for Hamlet's motion
        //oph.talkArea(ham1.getxCoord(), ham1.getyCoord(), mainScene);

        //bg.drawBackground(mainGame);


        new AnimationTimer(){
            long lastUpdate = 0;
            public void handle(long now){
                if (now - lastUpdate >= 16000000){
                    mainGame.getChildren().clear();
                    bg.drawBackground(mainGame);
                    mainGame.getChildren().addAll(hamletGroup);
                    ham1.drawHamlet(hamletGroup);
                    ham1.checkDirection();
                    if (rose.getxPos() + 250 > 0 && rose.getxPos() < 1600) {
                        rose.drawChar(r1, rosie, mainGame);
                    }
                    if (claud.getxPos() + 250 > 0 && claud.getxPos() < 1600) {
                        claud.drawChar(c1, claudius, mainGame);
                    }
                    if (oph.getxPos() + 250 > 0 && oph.getxPos() < 1600) {
                        oph.drawChar(o1, ophelia, mainGame);
                    }
                    if (polo.getxPos() + 250 > 0 && polo.getxPos() < 1600) {
                        polo.drawChar(p1, polonius, mainGame);
                    }
                    if (gert.getxPos() + 250 > 0 && gert.getxPos() < 1600) {
                        gert.drawChar(g1,gertty, mainGame);
                    }
                    if (laer.getxPos() + 250 > 0 && laer.getxPos() < 1600) {
                        laer.drawChar(l1,laertes,mainGame);
                    }
                    if (hammy.getxPos() + 250 > 0 && hammy.getxPos() < 1600) {
                        hammy.drawChar(grave, blanko, mainGame);
                    }
                    if (olhammy.getxPos() + 250 > 0 && olhammy.getxPos() < 1600) {
                        olhammy.drawChar(oldham, blanko, mainGame);
                    }
                   
                    mainGame.getChildren().addAll(dialogueGroup);
                    //polo.talkArea(ham1.getxCoord(), ham1.getyCoord(), mainGame);
                }
                lastUpdate = now;
            }
        }.start();

        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
   

    public static void main(String[] args) {
        launch(args);
    }
}
