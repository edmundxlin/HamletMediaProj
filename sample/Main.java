package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;


public class Main extends Application {
    public int resX = 1000; //resolution width
    public int resY = 1000; //resolution height
    
    Hamlet ham1 = new Hamlet(); //instantiates class for Hamlet's movement
	private Group hamletGroup = new Group();    //group for displaying hamlet, will be in mainGame AnchorPane
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        //Variables.
        int b1W = 100; //buttons 1-2, width and height
        int b1H = 100;
        int b2W = 100;
        int b2H = 100;
        int b1X = 400; //buttons 1-2, x and y
        int b1Y = 300;
        int b2X = 400;
        int b2Y = 430;

        Button button1 = new Button(); //new game button
        Button button2 = new Button(); //exit button
        AnchorPane root = new AnchorPane(); //add nodes/children to this to display on main menu
        AnchorPane mainGame = new AnchorPane(); //add nodes/children to this to display on main game
        Scene mainScene = new Scene(mainGame, resX, resY); //main game scene
        Scene scene = new Scene(root, resX, resY); //main menu scene
        Text mainTitle = new Text();
        //*********************

        //main menu title
        mainTitle.setText("HAMLET THE GAME");
        mainTitle.setLayoutX(50);
        mainTitle.setLayoutY(200);
        mainTitle.setFont(Font.font ("HelveticaNeue", 100));
        mainTitle.setFill(Color.BLACK);
        //*****************

        scene.getStylesheets().add("sample/mainmenu.css");
        primaryStage.setTitle("Hamlet!");

        //new game button i.e. enter game or whatever
        String styles =
                "-fx-background-color: #ffffff;" +
                        "-fx-border-color: #ffffff; " +
                            "-fx-font-size: 20;";
        button1.setText("ENTER");
        button1.setStyle(styles);
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
        button2.setStyle(styles);
        button2.setPrefWidth(b2W);
        button2.setPrefHeight(b2H);
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit(); //exits game
            }
        });
        //******************

        //button x, y
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

        ham1.characterMovement(primaryStage, mainScene); //method for Hamlet's motion
		mainGame.getChildren().addAll(hamletGroup);
		
		new AnimationTimer() {
			
			long lastUpdate = 0;
			
			@Override
			public void handle(long now) 
			{
				if (now - lastUpdate >= 16000000)
				{
					ham1.drawHamlet(hamletGroup);
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
