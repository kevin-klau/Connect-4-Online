import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.awt.Font;

import java.awt.image.*;
import javax.imageio.*;

import java.io.*;
/**
 * <h1>Game Screen Frontend</h1>
 * <p>GUI for the Game Screen</p>
 */
public class HelpPanel2 extends JPanel{
	//Properties
	// Image Properties
	/** background image*/	
	BufferedImage BG = null;
	/** board image*/	
	BufferedImage Board = null;
	/** tray image*/	
	BufferedImage Tray = null;
	/** player 1 image*/	
	BufferedImage P1 = null;
	/** player 2 image*/	
	BufferedImage P2 = null;
	/** blank image*/	
	/** Boolean to indicate when to update images */
	boolean blnImagesLoadOnce = false;
	/** Theme indicator */
	String strThemes = "Default";
	
	/** main heading*/
	JEditorPane helpHeading;
	/** first text area*/	
	JEditorPane helpText;
	/** second text area*/	
	JEditorPane helpText2;
	/** third text area*/	
	JEditorPane helpText3;
	
	
	// Player 1 XY Properties
	/** default piece x-coordinate*/
	int intP1X = 106 + 358 + 30;
	/** default piece y-coordinate*/
	int intP1Y = 70 + 435 + 100 + 30;
	
	/** player 1 x-coordinate movement*/	
	int intP1XMove;
	/** player 1 y-coordinate movement*/	
	int intP1YMove;
	
	// Tile Properties
	//Array for Tile slots
	/** tile array property*/	
	int intCount;
	/** tile array property*/	
	int intCounter;
	/** array creation*/	
	String strSlot[][] = new String [6][7];
	
	//Tile Drop Animation Variables P1
	/** player 1 y-coordinate drop animation*/	
	int intP1DropYFinal;
	/** player 1 y-coordinate drop animation*/	
	int intP1DropY = 170;
	
	//Register Drop Variable
	/** registered drop property*/
	int intStartDrop = 0;
	/** registered drop property*/
	int intColumn;
	/** allows for player to drop*/
	boolean blnPersonDropped = false;
	/** indicates to the program when to do the animation*/
	boolean blnDrawAnimationP1 = true;
	/** indicates when the player releases a piece*/
	boolean blnPlayerReleasedMouse = false;
	/** indicates when it is the player turn*/
	boolean blnPlayerTurn = true;
	
	
	//Methods
/**
   * <p>Paint Component
   * Draws the images in the GUI</p>
   */	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		if (blnPlayerReleasedMouse == true){
			// Calculate which column it is dropped in
			if(intP1X >= 240 + 22 && intP1X <= 240 + 22 + 65 && intP1Y >= 170 - 25 && intP1Y <= 170 + 25){
				intColumn = 0;
			}else if(intP1X >= 240 + 22 + 65 &&intP1X <= 240 + 22 + 65 + 65 && intP1Y >= 170 - 25 && intP1Y <= 170 + 25 ){
				intColumn = 1;
			}else if(intP1X >= 327 + 65 && intP1X <= 392 + 65 && intP1Y >= 170 - 25 && intP1Y <= 170 + 25 ){
				intColumn = 2;
			}else if(intP1X >= 392+65 && intP1X <= 457 + 65 && intP1Y >= 170 - 25 && intP1Y <= 170 + 25 ){
				intColumn = 3;
			}else if(intP1X >= 457 + 65 && intP1X <= 522 + 65 && intP1Y >= 170 - 25 && intP1Y <= 170 + 25 ){
				intColumn = 4;
			}else if(intP1X >= 522 + 65 && intP1X <= 587 + 65 && intP1Y >= 170 - 25 && intP1Y <= 170 + 25 ){
				intColumn = 5;
			}else if(intP1X >= 587 + 65 && intP1X <= 652 + 65 && intP1Y >= 170 - 25 && intP1Y <= 170 + 25 ){
				intColumn = 6;
			}
			
			blnPersonDropped = true;
			//Repositioning tile after use
			intP1X = 106 + 358 + 30;
			intP1Y = 70 + 435 + 100 + 30;
			
			blnPlayerReleasedMouse = false;
		}
		
		//Images
		if (blnImagesLoadOnce == false){
			try{
				BG = ImageIO.read(new File ("Themes/"+strThemes+"/BG.png"));
				Board = ImageIO.read(new File ("Themes/"+strThemes+"/Board.png"));
				Tray = ImageIO.read(new File ("Themes/"+strThemes+"/Tray.png"));
				P1 = ImageIO.read(new File ("Themes/"+strThemes+"/P1.png"));
				P2 = ImageIO.read(new File ("Themes/"+strThemes+"/P2.png"));
			}catch(IOException e){
				System.out.println("Invalid picture");
			}
			blnImagesLoadOnce = true;
		}
		
		//Asset Drawings
		g.drawImage(BG, 0, 0, null);
		g.drawImage(Board, 240, 70 + 100, null);
		g.drawImage(Tray, 240 - 134, 70 + 435 + 100, null);
		g.drawImage(P1, intP1X-25, intP1Y-25, null);	
		
		// Add the Chat Text Thing
		g.setColor (new Color (240,240,240));
		g.fillRect (100,30,780,110);
		
		//Drawing Static Tiles on Tray
		g.drawImage(P2, 494, 635, null);
		g.drawImage(P1, 494, 615, null);
		g.drawImage(P1, 469, 610, null);
		g.drawImage(P2, 469, 610, null);
		g.drawImage(P2, 520, 635, null);
		g.drawImage(P1, 520, 615, null);
		g.drawImage(P1, 440, 615, null);
		g.drawImage(P2, 440, 635, null);
		g.drawImage(P2, 410, 635, null);
		g.drawImage(P2, 400, 635, null);
		g.drawImage(P1, 410, 615, null);
		g.drawImage(P1, 400, 615, null);
		g.drawImage(P1, 540, 615, null);
		g.drawImage(P2, 540, 635, null);
		
		// Calculate which row to drop it in
		if(blnPersonDropped == true){
			for (intCount = 5; intCount >= 0; intCount--){
				if(strSlot[intCount][intColumn].equalsIgnoreCase ("empty")){
					strSlot[intCount][intColumn] = "almost filled";
					intP1DropYFinal = intCount * (14 + 50) + 31 + 170;
					intCount = -1;
				}
			}
			blnPersonDropped = false;
			blnDrawAnimationP1 = true;
			intP1DropY = 170;
		}
		
		// Draw Animation
		if (blnDrawAnimationP1 == true){
			if (intP1DropY <= intP1DropYFinal){
				g.drawImage(P1, intColumn * (14 + 50) + 31 + 240 , intP1DropY, null);
				g.drawImage(Board, 240, 70 + 100, null);
				intP1DropY = intP1DropY + 10;
			}else{
				blnDrawAnimationP1 = false;
			}
		}
		
		// Make the array filled
		if (blnDrawAnimationP1 == false){
			for (intCount = 5; intCount >= 0; intCount--){
				if(strSlot[intCount][intColumn].equalsIgnoreCase ("almost filled")){
					strSlot[intCount][intColumn] = "filled P1";
					intCount = -1;
				}
			}
		}
		
		// Drawing the Pieces on the board
		for(intCounter = 0; intCounter < 6; intCounter++){
			for(intCount = 0; intCount < 7; intCount++){
				if(strSlot[intCounter][intCount].equalsIgnoreCase("filled P1")){
					g.drawImage(P1, intCount * (14 + 50) + 31 + 240 , intCounter * (14 + 50) + 31 + 170 , null);						
				}
			}
		}	
	}
/**
   * <p>Load Connect4 board as empty, Read Images</p>
   */	
	//Constructor
	public HelpPanel2(){
		super();		
		//Array Slots Set as Empty by Default
		for(intCounter = 0; intCounter < 6; intCounter++){
			for(intCount = 0; intCount < 7; intCount++){
				strSlot[intCounter][intCount] = "empty";
			}
		}
		helpHeading = new JEditorPane("text/html", "");
		helpHeading.setText("<font face=\"Arial\" size=\"15\">How to Play:</font>");
		helpHeading.setEditable(false);
		helpHeading.setSize(250,100);
		helpHeading.setLocation(980,50);
		helpHeading.setOpaque(false);
		this.add(helpHeading);
		
		helpText = new JEditorPane("text/html", "");
		helpText.setText("<font face=\"Arial\" size=\"5\">1. When it is your turn, put your <br> mouse over this area and drag <br> a piece</font>");
		helpText.setEditable(false);
		helpText.setSize(400,150);
		helpText.setLocation(980, 100);
		helpText.setOpaque(false);
		this.add(helpText);
		
		helpText2 = new JEditorPane("text/html", "");
		helpText2.setText("<font face=\"Arial\" size=\"5\">2. Drag the piece to your desired <br> column, and release the mouse</font>");
		helpText2.setEditable(false);
		helpText2.setSize(400,150);
		helpText2.setLocation(980, 200);
		helpText2.setOpaque(false);
		this.add(helpText2);
		
		helpText3 = new JEditorPane("text/html", "");
		helpText3.setText("<font face=\"Arial\" size=\"5\">3. Enjoy!</font>");
		helpText3.setEditable(false);
		helpText3.setSize(400,150);
		helpText3.setLocation(980, 300);
		helpText3.setOpaque(false);
		this.add(helpText3);	
	}
	
		
		
}
		
		
		
		
		

