
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.AnchorPane;

public class background {
	
    String map = "G:\\My Drive\\Grade 12\\ics2\\HamletFinal\\src\\map.png";
    FileInputStream file;
    Image image;
    ImageView iv2 = new ImageView();
    int xCoord =-( (3840 -800 ) /2);
    int yCoord = ((2160 - 800) / 2)  -1500;

    public background(){
    	try {
			file = new FileInputStream(map);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	image = new Image(file);
        iv2.setImage(image);
        iv2.setFitWidth(3840);
        iv2.setFitHeight(2160);
    }

    public int getxCoord(){
        return xCoord;
    }
    public void setX(int x){
        xCoord = x;
    }
    public int getyCoord(){
        return yCoord;
    }
    public void setY(int y){
        yCoord = y;
    }

    public void drawBackground(AnchorPane root){
        iv2.setX(xCoord);
        iv2.setY(yCoord);
        root.getChildren().add(iv2);
    }



}
