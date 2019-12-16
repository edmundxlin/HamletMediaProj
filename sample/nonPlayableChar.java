
import javafx.scene.shape.Rectangle;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.paint.Color;
import javafx.scene.layout.AnchorPane;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;




public class nonPlayableChar {
    private int xPos = 0;
    private int yPos = 0;
    private int scaledimagesizex = 250;
    private int scaledimagesizey = 250;
    private boolean isReverse = false;
    
    private FileInputStream ghostFile;
    private	FileInputStream bodyFile;

    public nonPlayableChar(int x, int y) {
        this.xPos = x;
        this.yPos = y;

    }



    public void drawChar(String image1, String image2, AnchorPane root) {
    	try {
			ghostFile = new FileInputStream(image1);
	    	bodyFile = new FileInputStream(image2);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	
        Image imageGhost = new Image(ghostFile);
        Image imageBody = new Image(bodyFile);
        ImageView iv1 = new ImageView();
        ImageView iv2 = new ImageView();

        iv1.setImage(imageGhost);
        iv2.setImage(imageBody);



        iv1.setFitWidth(this.scaledimagesizex);
        iv1.setFitHeight(this.scaledimagesizey);
        iv2.setFitWidth(this.scaledimagesizex + 50);
        iv2.setFitHeight(this.scaledimagesizey + 50);

        iv1.setX(this.xPos);
        iv1.setY(this.yPos);

        iv2.setX((double)(this.xPos - 40));
        iv2.setY((double) (this.yPos + this.scaledimagesizey - 40));


        if (isReverse == true){
            iv1.setScaleX(-1);
        }
        if (isReverse == false){
            iv1.setScaleX(1);
        }
        root.getChildren().add(iv1);
        root.getChildren().add(iv2);
    }
    public void setIsReverse(boolean bool){
        isReverse = bool;
    }


    public void drawBoxes(Hamlet hammy, AnchorPane root){
        Rectangle ghostbox = new Rectangle();
        Rectangle bodybox = new Rectangle();
        ghostbox.setX(xPos +45);
        ghostbox.setY(yPos);
        ghostbox.setWidth(135);
        ghostbox.setHeight(250);
        bodybox.setX(xPos+32);
        bodybox.setY(yPos+ this.scaledimagesizey + 20);
        bodybox.setWidth(250);
        bodybox.setHeight(100);
        bodybox.setStroke(Color.BLACK);
        ghostbox.setStroke(Color.BLACK);
        ghostbox.setFill(Color.TRANSPARENT);
        bodybox.setFill(Color.TRANSPARENT);
        root.getChildren().add(ghostbox);
        root.getChildren().add(bodybox);
    }



    public void setxPos(int x){
        xPos = x;
    }
    public void setyPos(int y){
        yPos = y;
    }
    public int getxPos(){
        return this.xPos;
    }

    public int getyPos(){
        return this.yPos;
    }
    public void getDialogue(){
        System.out.println("Wtf");
    }

    public void setDialogue(File file) {

    }
}
