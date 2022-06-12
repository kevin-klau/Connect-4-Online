import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class LoadPanel extends JPanel{
	// Properties
	
	
	// Methods
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		
		g.fillRect (0,0,2000,1000);
	}
	
	// Constructor
	public LoadPanel(){
		super();
		
		
	}
}
