//ie. if Hamlet's coords are at something, and presses a

/*FILE FORMATTING
 * first line --> (n) number of sections of text
 * for each section (n)
 * --> first letter indicates speaker, third letter indicates number of lines (M)
 * --> next M lines are the actual text 
 * 
 * Hamlet = 0 / H
 * Ophelia = 1 / O
 * Gertrude = 2 / G
 * Polonius = 3 / P
 * Claudius1 = 4  / C
 * Claudius2 = 4 / C
 * Rosencrantz = 5 / R
 * Guildenstern = 8 / D
 * Laertes = 6 / L
 * Old Hamlet = 7 / K
 * 
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Dialogue {

	private Group dialogueGroup;
	private int x = 100;
	private int y = 500;
	private int xscale = 1600;
	private int yscale = 200;

	//location of images
	private String boxtemplateLocation = "G:\\My Drive\\Grade 12\\ics2\\HamletFinal\\src\\dialoguebox3.png"; //location of dialogue template
	private String fileName;

	//storing images
	private Image boxtemplate;

	//image viewer
	private ImageView boxtemplate_view = new ImageView();
	private Label speaker = new Label();
	private Label text = new Label();

	private int counter;
	private int numSwitch;
	private int[] speakerList;
	private String[] fullText;
	
	private int ClaudCheck = 1;

	public Dialogue(Group group)
	{
		try {
			dialogueGroup = group;
			loadImages();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void drawDialogue()
	{
		dialogueGroup.getChildren().clear();

		//sets up the box background
		boxtemplate_view.setImage(boxtemplate);
		boxtemplate_view.setFitWidth(xscale);
		boxtemplate_view.setFitHeight(yscale);
		boxtemplate_view.setTranslateX(x);
		boxtemplate_view.setTranslateY(y);

		//sets up the label for speaker
		speaker.setText("--speaker--");
		speaker.setFont(Font.font ("HelveticaNeue", 30));			
		speaker.setTranslateX(x+160);
		speaker.setTranslateY(y+10);
		speaker.setTextFill(Color.WHITE);

		text.setText("--insert text here--");
		text.setFont(Font.font ("HelveticaNeue", 16));			
		text.setTranslateX(x+100);
		text.setTranslateY(y+60);

		dialogueGroup.getChildren().addAll(boxtemplate_view, speaker, text);

	}

	public void updateDialogue(int personNum, Scene scene)
	{
		//if the person is Ophelia (1)
		if (personNum == 0)
			fileName = "G:\\My Drive\\Grade 12\\ics2\\HamletFinal\\src\\Hamlet.txt";
		if (personNum == 1)
			fileName = "G:\\My Drive\\Grade 12\\ics2\\HamletFinal\\src\\Ophelia.txt";
		if (personNum == 2)
			fileName = "G:\\My Drive\\Grade 12\\ics2\\HamletFinal\\src\\Gertrude.txt";
		if (personNum == 3)
			fileName = "G:\\My Drive\\Grade 12\\ics2\\HamletFinal\\src\\Polonius.txt";
		if (personNum == 4)
			if (ClaudCheck == 1)
			{
				fileName = "G:\\My Drive\\Grade 12\\ics2\\HamletFinal\\src\\Claudius1.txt";
				ClaudCheck = 2;
			}else
			{
				fileName = "G:\\My Drive\\Grade 12\\ics2\\HamletFinal\\src\\Claudius2.txt";
				ClaudCheck = 1;
			}
		if (personNum == 5)
			fileName = "G:\\My Drive\\Grade 12\\ics2\\HamletFinal\\src\\RosGuild.txt";
		if (personNum == 6)
			fileName = "G:\\My Drive\\Grade 12\\ics2\\HamletFinal\\src\\Laertes.txt";
		if (personNum == 7)
			fileName = "G:\\My Drive\\Grade 12\\ics2\\HamletFinal\\src\\OldHamlet.txt";


		//sets up the file for reading
		File file = new File(fileName);

		try {
			Scanner scan = new Scanner(file);

			numSwitch = Integer.valueOf(scan.nextLine());
			speakerList = new int[numSwitch];
			fullText = new String[numSwitch];
			counter = 0;

			for (int i=0; i<numSwitch; i++)			
			{
				String info = scan.nextLine();
				int numLines = Integer.valueOf(info.substring(2));
				String text1 = "";

				if (info.charAt(0) == 'H')
					speakerList[i] = 0;
				else if (info.charAt(0) == 'O')
					speakerList[i] = 1;
				else if (info.charAt(0) == 'G')
					speakerList[i] = 2;
				else if (info.charAt(0) == 'P')
					speakerList[i] = 3;
				else if (info.charAt(0) == 'C')
					speakerList[i] = 4;
				else if (info.charAt(0) == 'R')
					speakerList[i] = 5;
				else if (info.charAt(0) == 'D')
					speakerList[i] = 8;
				else if (info.charAt(0) == 'L')
					speakerList[i] = 6;
				else if (info.charAt(0) == 'K')
					speakerList[i] = 7;

				for (int j=0; j<numLines; j++)
				{
					text1 = text1 + scan.nextLine() + "\r\n";
				}

				fullText[i] = text1;
			}

			changeText();
			scan.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void changeText()
	{
		if (counter < numSwitch)
		{		
		int currentSpeaker = speakerList[counter];
		
		if(currentSpeaker == 0)
			speaker.setText("Hamlet");
		if(currentSpeaker == 1)
			speaker.setText("Ophelia");
		if(currentSpeaker == 2)
			speaker.setText("Gertrude");
		if(currentSpeaker == 3)
			speaker.setText("Polonius");
		if(currentSpeaker == 4)
			speaker.setText("Claudius");
		if(currentSpeaker == 5)
			speaker.setText("Rosencrantz");
		if(currentSpeaker == 8)
			speaker.setText("Guildenstern");
		if(currentSpeaker == 6)
			speaker.setText("Laertes");
		if(currentSpeaker == 7)
			speaker.setText("Old Hamlet");
		
		text.setText(fullText[counter]);
		}
		counter++;
		
		if(counter > numSwitch)
		{
			dialogueGroup.getChildren().clear();
			counter = 0;
		}
	}

	//loads all of images
	public void loadImages() throws FileNotFoundException
	{
		FileInputStream file = new FileInputStream(boxtemplateLocation);
		boxtemplate = new Image(file); 

	}

}
