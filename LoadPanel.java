import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
   * LoadPanel Placeholder
   */		
public class LoadPanel extends JPanel{
	// Properties
	
	
	// Methods
	/**
   * generates images and shapes 
   * 
   * @param g painting tool
   */		
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		
		g.fillRect (0,0,2000,1000);
	}
	
	// Constructor
/**
   *  imports past (TBD)
   */		
	public LoadPanel(){
		super();
		
		
	}
}
