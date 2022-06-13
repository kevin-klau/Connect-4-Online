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
	BufferedImage Blank = null;
	
	// Player 1 XY Properties
	/** default piece x-coordinate*/
	int intP1X = 106 + 358;
	/** default piece y-coordinate*/
	int intP1Y = 70 + 435 + 100;
	
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
	
	//Tile Drop Animation Variables
	int intP1DropYFinal;
	int intP1DropY = 170;
	
	//Register Drop Variable
	/** registed drop property*/
	int intStartDrop = 0;
	/** registed drop property*/
	int intColumn;
	/** allows for player to drop*/
	boolean blnPersonDropped = false;
	
	
	//Methods
/**
   * <p>Paint Component
   * Draws the images in the GUI</p>
   */	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		//Asset Drawings
		g.drawImage(BG, 0, 0, null);
		
		g.drawImage(Board, 240, 70 + 100, null);
		g.drawImage(Tray, 240 - 134, 70 + 435 + 100, null);
		
		g.drawImage(P1, intP1X-25, intP1Y-25, null);
		
		
		//Tile Move
		intP1X = intP1X  + intP1XMove;
		intP1Y = intP1Y  + intP1YMove;
		
		//Registering Drop
		// Check Which row to drop it in
		if(blnPersonDropped == true){
			for (intCount = 5; intCount >= 0; intCount--){
				if(strSlot[intCount][intColumn].equalsIgnoreCase ("empty")){
                    strSlot[intCount][intColumn] = "filled";
                    intCount = -1;
                    intP1DropYFinal = intCount * (14 + 50) + 31 + 170;
                    
                    //Drop animation attempt
                    //for(intP1DropY = 170; intP1DropY <= intP1DropYFinal; intP1DropY++){
					g.drawImage(P1, intColumn * (14 + 50) + 31 + 240 , intP1DropY++ , null);
						
					//}
                }
            }
            blnPersonDropped = false;
		}

            // draw the thing code
            // CODE HERE
            
            // Send move over network
				
			
		//Filling Slots
	
		for(intCounter = 0; intCounter < 6; intCounter++){
			for(intCount = 0; intCount < 7; intCount++){
				if(strSlot[intCounter][intCount].equalsIgnoreCase("filled")){
					g.drawImage(P1, intCount * (14 + 50) + 31 + 240 , intCounter * (14 + 50) + 31 + 170 , null);
						
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
		
		
		//Images
		try{
			BG = ImageIO.read(new File ("BG.png"));
		}catch(IOException e){
			System.out.println("Invalid picture");
		}
		
		try{
			Board = ImageIO.read(new File ("Board.png"));
		}catch(IOException e){
			System.out.println("Invalid picture");
		}
		
		try{
			Tray = ImageIO.read(new File ("Tray.png"));
		}catch(IOException e){
			System.out.println("Invalid picture");
		}
		
		try{
			P1 = ImageIO.read(new File ("P1.png"));
		}catch(IOException e){
			System.out.println("Invalid picture");
		}
		
		try{
			P2 = ImageIO.read(new File ("P2.png"));
		}catch(IOException e){
			System.out.println("Invalid picture");
		}
		
		try{
			Blank = ImageIO.read(new File ("Blank.png"));
		}catch(IOException e){
			System.out.println("Invalid picture");
		}
		
	}
	
		
		
}
		
		
		
		
		
