import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class MainPanel extends JPanel {
	// Properties
	BufferedImage Image;
	
	
	// Methods
	public void paintComponent (Graphics g){
		super.paintComponent(g);	
		g.drawImage (Image, 0,0,this);
	}
	
	// Constructor
	public MainPanel(){
		super();
		
		try{
			Image = ImageIO.read(new File("Themes/Halloween/P1.png"));
		}catch(IOException e){
			System.out.println("IMAGE UNABLE TO LOAD");
		}
	}
}
