import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.awt.Font;

import java.awt.image.*;
import javax.imageio.*;

import java.io.*;

public class GameScreenPanel extends JPanel{


	//Properties
	BufferedImage BG = null;
	BufferedImage Board = null;
	BufferedImage Tray = null;
	BufferedImage P1 = null;
	BufferedImage P2 = null;
	BufferedImage Blank = null;
	
	int intP1X = 106 + 358;
	int intP1Y = 70 + 435 + 100;
	
	int intP1XMove;
	int intP1YMove;
	
	//Array for Tile slots
	int intCount;
	int intCounter;
	String strSlot[][] = new String [6][7];
	
	//Tile Dropped Variables
	int intDropped1 = 6; 
	int intDropped2 = 6; 
	int intDropped3 = 6; 
	int intDropped4 = 6; 
	int intDropped5 = 6; 
	int intDropped6 = 6; 
	int intDropped7 = 6; 
	
	//Register Drop Variable
	int intStartDrop = 0;
	int intColumn;
	
	boolean blnPersonDropped = false;
	
	
	//Methods
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
		
		
		
		
		
