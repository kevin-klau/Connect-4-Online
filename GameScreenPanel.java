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
public class GameScreenPanel extends JPanel{


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
	
	// Player 1 XY Properties
	/** default piece x-coordinate*/
	int intP1X = 106 + 358 + 30;
	/** default piece y-coordinate*/
	int intP1Y = 70 + 435 + 100 + 30;
	
	/** player 1 x-coordinate movement*/	
	int intP1XMove;
	/** player 1 y-coordinate movement*/	
	int intP1YMove;
	
	
	
	// Player 2 XY Properties
	/** default piece x-coordinate*/
	int intP2X = 106 + 358 + 30;
	/** default piece y-coordinate*/
	int intP2Y = 70 + 435 + 100 + 30;
	
	/** player 1 x-coordinate movement*/	
	int intP2XMove;
	/** player 1 y-coordinate movement*/	
	int intP2YMove;
	
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
	
	//Tile Drop Animation Variables P2
	/** player 2 y-coordinate drop animation*/	
	int intP2DropYFinal;
	/** player 2 y-coordinate drop animation*/	
	int intP2DropY = 170;
	
	//Register Drop Variable
	/** registered drop property*/
	int intStartDrop = 0;
	/** registered drop property*/
	int intColumn;
	/** allows for player to drop*/
	boolean blnPerson1Dropped = false;
	/** indicates to the program when to do the animation*/
	boolean blnDrawAnimationP1 = true;
	/** allows for player to drop*/
	boolean blnPerson2Dropped = false;
	/** indicates to the program when to do the animation*/
	boolean blnDrawAnimationP2 = true;
	
	//Turns
	/** player turn variable, starts at 1*/	
	int intPlayer = 1;
	
	
	//Methods
/**
   * <p>Paint Component
   * Draws the images in the GUI</p>
   */	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
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
		if(intPlayer == 1){
			g.drawImage(P1, intP1X-25, intP1Y-25, null);	
		}
		if(intPlayer == 2){
			g.drawImage(P2, intP2X-25, intP2Y-25, null);	
		}	
		
		// Add the Chat Text Thing
		g.setColor (new Color (240,240,240));
		g.fillRect (1280-300,0,300,100);
		g.setColor (Color.BLACK);
		g.drawRect (1280-300,0,299,100);
		Font newFont = new Font ("Calibri", Font.PLAIN, 90);
		g.setFont (newFont);
		g.drawString ("Chat:", 1280-250,80);
		
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
		
		//P1
		if(intPlayer == 1){
			//Tile Move P1
			intP1X = intP1X  + intP1XMove;
			intP1Y = intP1Y  + intP1YMove;
			
			//Registering Drop
			// Check Which row to drop it in
			if(blnPerson1Dropped == true){
				for (intCount = 5; intCount >= 0; intCount--){
					if(strSlot[intCount][intColumn].equalsIgnoreCase ("empty")){
						strSlot[intCount][intColumn] = "almost filled P1";
						intP1DropYFinal = intCount * (14 + 50) + 31 + 170;
						intCount = -1;
					}
				}
				blnPerson1Dropped = false;
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
					if(strSlot[intCount][intColumn].equalsIgnoreCase ("almost filled P1")){
						strSlot[intCount][intColumn] = "filled P1";
						intCount = -1;
						intPlayer = 2;
					}
				}
			}

					
				
			//Drawing the Filled Slots
			for(intCounter = 0; intCounter < 6; intCounter++){
				for(intCount = 0; intCount < 7; intCount++){
					if(strSlot[intCounter][intCount].equalsIgnoreCase("filled P1")){
						g.drawImage(P1, intCount * (14 + 50) + 31 + 240 , intCounter * (14 + 50) + 31 + 170 , null);
					}if(strSlot[intCounter][intCount].equalsIgnoreCase("filled P2")){
						g.drawImage(P2, intCount * (14 + 50) + 31 + 240 , intCounter * (14 + 50) + 31 + 170 , null);
							
					}
				}
			}
			
			
			//Winning If Statements
			
			for(intCounter = 0; intCounter < 6; intCounter++){
				for(intCount = 0; intCount < 7; intCount++){
					//Statement so that array won't go out of bounds
					if(intCount < 4){
						//Statement so that you win if conditions met
						if(strSlot[intCounter][intCount].equalsIgnoreCase("filled P1") && strSlot[intCounter][intCount + 1].equalsIgnoreCase("filled P1") && strSlot[intCounter][intCount + 2].equalsIgnoreCase("filled P1") && strSlot[intCounter][intCount + 3].equalsIgnoreCase("filled P1") ){
							System.out.println("You win horizontal");
						}
					}if(intCounter < 3){
						if(strSlot[intCounter][intCount].equalsIgnoreCase("filled P1") && strSlot[intCounter + 1][intCount].equalsIgnoreCase("filled P1") && strSlot[intCounter +2][intCount].equalsIgnoreCase("filled P1") && strSlot[intCounter + 3][intCount].equalsIgnoreCase("filled P1") ){
							System.out.println("You win Vertical");
						}
					}if(intCount < 4 && intCounter < 3){
						if(strSlot[intCounter][intCount].equalsIgnoreCase("filled P1") && strSlot[intCounter+1][intCount+1].equalsIgnoreCase("filled P1") && strSlot[intCounter+2][intCount+2].equalsIgnoreCase("filled P1") && strSlot[intCounter+3][intCount+3].equalsIgnoreCase("filled P1") ){
							System.out.println("You win diagonal left");
						}	
					}if(intCount > 2 && intCounter < 3){
						if(strSlot[intCounter][intCount].equalsIgnoreCase("filled P1") && strSlot[intCounter +1][intCount-1].equalsIgnoreCase("filled P1") && strSlot[intCounter+2][intCount-2].equalsIgnoreCase("filled P1") && strSlot[intCounter+3][intCount-3].equalsIgnoreCase("filled P1") ){
							System.out.println("You win diagonal right");
						}	
					}
					
				}
			}
		}
		
		
		//P2
		
		if(intPlayer == 2){
			//Tile Move P2
			intP2X = intP2X  + intP2XMove;
			intP2Y = intP2Y  + intP2YMove;
			
			//Registering Drop
			// Check Which row to drop it in
			if(blnPerson2Dropped == true){
				for (intCount = 5; intCount >= 0; intCount--){
					if(strSlot[intCount][intColumn].equalsIgnoreCase ("empty")){
						strSlot[intCount][intColumn] = "almost filled P2";
						intP2DropYFinal = intCount * (14 + 50) + 31 + 170;
						intCount = -1;
					}
				}
				blnPerson2Dropped = false;
				blnDrawAnimationP2 = true;
				intP2DropY = 170;
			}
			
			// Draw Animation
			if (blnDrawAnimationP2 == true){
				if (intP2DropY <= intP2DropYFinal){
					g.drawImage(P2, intColumn * (14 + 50) + 31 + 240 , intP2DropY, null);
					g.drawImage(Board, 240, 70 + 100, null);
					intP2DropY = intP2DropY + 10;
				}else{
					blnDrawAnimationP2 = false;
				}
			}
			
			// Make the array filled
			if (blnDrawAnimationP2 == false){
				for (intCount = 5; intCount >= 0; intCount--){
					if(strSlot[intCount][intColumn].equalsIgnoreCase ("almost filled P2")){
						strSlot[intCount][intColumn] = "filled P2";
						intCount = -1;
						intPlayer = 1;
					}
				}
			}

					
				
			//Drawing the Filled Slots
			for(intCounter = 0; intCounter < 6; intCounter++){
				for(intCount = 0; intCount < 7; intCount++){
					if(strSlot[intCounter][intCount].equalsIgnoreCase("filled P2")){
						g.drawImage(P2, intCount * (14 + 50) + 31 + 240 , intCounter * (14 + 50) + 31 + 170 , null);
					}
					if(strSlot[intCounter][intCount].equalsIgnoreCase("filled P1")){
						g.drawImage(P1, intCount * (14 + 50) + 31 + 240 , intCounter * (14 + 50) + 31 + 170 , null);
									
					}
				}
			}
			
			
			//Winning If Statements
			
			for(intCounter = 0; intCounter < 6; intCounter++){
				for(intCount = 0; intCount < 7; intCount++){
					//Statement so that array won't go out of bounds
					if(intCount < 4){
						//Statement so that you win if conditions met
						if(strSlot[intCounter][intCount].equalsIgnoreCase("filled P2") && strSlot[intCounter][intCount + 1].equalsIgnoreCase("filled P2") && strSlot[intCounter][intCount + 2].equalsIgnoreCase("filled P2") && strSlot[intCounter][intCount + 3].equalsIgnoreCase("filled P2") ){
							System.out.println("You win horizontal");
						}
					}if(intCounter < 3){
						if(strSlot[intCounter][intCount].equalsIgnoreCase("filled P2") && strSlot[intCounter + 1][intCount].equalsIgnoreCase("filled P2") && strSlot[intCounter +2][intCount].equalsIgnoreCase("filled P2") && strSlot[intCounter + 3][intCount].equalsIgnoreCase("filled P2") ){
							System.out.println("You win Vertical");
						}
					}if(intCount < 4 && intCounter < 3){
						if(strSlot[intCounter][intCount].equalsIgnoreCase("filled P2") && strSlot[intCounter+1][intCount+1].equalsIgnoreCase("filled P2") && strSlot[intCounter+2][intCount+2].equalsIgnoreCase("filled P2") && strSlot[intCounter+3][intCount+3].equalsIgnoreCase("filled P2") ){
							System.out.println("You win diagonal left");
						}	
					}if(intCount > 2 && intCounter < 3){
						if(strSlot[intCounter][intCount].equalsIgnoreCase("filled P2") && strSlot[intCounter +1][intCount-1].equalsIgnoreCase("filled P2") && strSlot[intCounter+2][intCount-2].equalsIgnoreCase("filled P2") && strSlot[intCounter+3][intCount-3].equalsIgnoreCase("filled P2") ){
							System.out.println("You win diagonal right");
						}	
					}
					
				}
			}
		}
		
	}
/**
   * <p>Load Connect4 board as empty, Read Images</p>
   */	
	//Constructor
	public GameScreenPanel(){
		super();
		
		//Array Slots Set as Empty by Default
		for(intCounter = 0; intCounter < 6; intCounter++){
			for(intCount = 0; intCount < 7; intCount++){
				strSlot[intCounter][intCount] = "empty";
							
			}
		}
		
	}
	
		
		
}
		
		
		
		
		
