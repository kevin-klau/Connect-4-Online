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
	
	
	
	//Methods
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage(BG, 0, 0, null);
		
		g.drawImage(Board, 240, 70, null);
		g.drawImage(Tray, 240 - 134, 70 + 435, null);
	
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
		
		
		
		
		
