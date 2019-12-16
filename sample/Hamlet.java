
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Hamlet {

	//used for the screen coordinates of Hamlet
	private int xCoord = 0;
	private int yCoord = 0;

	private int walkingSpeed = 10;
	private int counter = 0; //animation counter, keeps track of which image is used
	private boolean isMoving = false;
	private boolean isReverse= false;


	//folder location of Hamlet sprites & list to hold them once loaded
	private String folderName = "G:\\My Drive\\Grade 12\\ics2\\HamletFinal\\src\\";
	private Image[] hamletList = new Image[14];

	private ImageView Hamlet_view = new ImageView();
	private int xlength = 250;
	private int ylength = 250;


	//constructor class
	public Hamlet()
	{
		try {
			loadHamlet(folderName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//loads all of Hamlet's images
	public void loadHamlet(String folderName) throws FileNotFoundException
	{
		for (int i=1; i<10; i++)
		{
			FileInputStream file = new FileInputStream(folderName + "Frame00" + i + ".png");
			hamletList[i-1] = new Image(file);
		}

		for (int i=10; i<=14; i++)
		{
			FileInputStream file = new FileInputStream(folderName + "Frame0" + i + ".png");
			hamletList[i-1] = new Image(file);
		}
	}
	public void checkDirection(){
		if (isReverse == true){
			Hamlet_view.setScaleX(-1);
		}

		if (isReverse == false){
			Hamlet_view.setScaleX(1);
		}
	}


	public void setHamletXY(int x, int y){
		this.xCoord = x;
		yCoord= y;
	}
	//draws hamlet to screen
	public void drawHamlet(Group hamletGroup)
	{
		if (counter >= 14)
		{
			counter = 0;
		}

		hamletGroup.getChildren().clear();

		Hamlet_view.setFitHeight(ylength);
		Hamlet_view.setFitWidth(xlength);
		Hamlet_view.setImage(hamletList[counter]);
		Hamlet_view.setTranslateX(xCoord);
		Hamlet_view.setTranslateY(yCoord);

		if (isMoving)
		{
			counter++;
		}else
		{
			counter = 13;
		}

		
		hamletGroup.getChildren().addAll(Hamlet_view);
	}


	public int getHeight() {
		return ylength;
	}
	public int getWidth(){
		return xlength;
	}
	public int getxCoord()
	{
		return xCoord;
	}

	public int getyCoord()
	{
		return yCoord;
	}

	public void setxCoord(int n){
		xCoord = n;
	}
	public void setyCoord(int n){
		yCoord = n;
	}

	public void setMoving(boolean bool){
		isMoving = bool;
	}

	public void setReverse(boolean bool){
		isReverse = bool;
	}

	public void setCounter(int n){
		counter = n;
	}


	public int getWalkingSpeed(){
		return walkingSpeed;
	}
	public void setWalkingSpeed(int a){
		walkingSpeed = a;
	}
}