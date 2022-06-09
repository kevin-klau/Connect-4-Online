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
	
	
	
	//Methods
	
	
	//Constructor
	public GameScreenPanel(){
		super();
		
		try{
			BG = ImageIO.read(new File ("BG.png"));
		}catch(IOException e){
			System.out.println("Invalid picture");
		}
		
	}
	
		
		
}
		
		
		
		
		
