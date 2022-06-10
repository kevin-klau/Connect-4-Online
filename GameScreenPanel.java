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
	
	int intP1X = 106 + 358;
	int intP1Y = 70 + 435 + 100;
	
	int intP1XMove;
	int intP1YMove;
	
	
	
	
	//Methods
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage(BG, 0, 0, null);
		
		g.drawImage(Board, 240, 70 + 100, null);
		g.drawImage(Tray, 240 - 134, 70 + 435 + 100, null);
		
		g.drawImage(P1, intP1X-25, intP1Y-25, null);
		
		
		//Tile Move
	
		intP1X = intP1X  + intP1XMove;
		intP1Y = intP1Y  + intP1YMove;
			
	
	}
	//Constructor
	public GameScreenPanel(){
		super();
		
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
		
	}
	
		
		
}
		
		
		
		
		
