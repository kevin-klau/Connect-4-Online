import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class MainPanel extends JPanel{
	// Properties
	Font TitleFont;
	Font TextFont;
	
	BufferedImage Background;
	BufferedImage P1Piece;
	String strThemes = "Default";
	Boolean blnImagesLoadOnce = false;
	
	// Methods
	public void paintComponent (Graphics g){
		super.paintComponent(g);	
		
		// Draw the Background
		g.drawImage (Background, 0,0,this);
		
		// Draw the Connect 4 Title
		g.setColor (new Color (225,242,135));
		g.fillRect (150,50,980,200);
		
		g.setColor (Color.RED);
		TitleFont = new Font("Arial", Font.BOLD, 180);
		g.setFont (TitleFont);
		g.drawString ("Connect 4", 200,210);
		
		// Add the Area where you ask for IP Adress, Port, And User
		g.setColor (Color.WHITE);
		g.fillRect (50,280+20, 820, 230);
		g.setColor (Color.BLACK);
		TextFont = new Font("Arial", Font.BOLD, 25);
		g.setFont (TextFont);
		g.drawString ("IP Address:", 190,320+20);
		g.drawString ("Port:", 635,320+20);
		g.drawString ("Username:", 390, 410+10+5+20);
		
		// Add the Border between the area and theme chooser
		g.setColor (Color.BLACK);
		g.fillRect (900, 280, 5, 350-30);
		
		// Add the Piece Prewview
		g.drawImage (P1Piece, 955,350+40,this);
		
		// Load the images, if the theme changes, it'll change along as well
		if (blnImagesLoadOnce == false){
			try{
				Background = ImageIO.read(new File("Themes/"+strThemes+"/BG.png"));
				P1Piece = ImageIO.read (new File ("Themes/"+strThemes+"/PreviewIcon.png"));
			}catch(IOException e){
				System.out.println("IMAGE UNABLE TO LOAD");
			}
			blnImagesLoadOnce = true;
		}
		
	}
	
	// Constructor
	public MainPanel(){
		super();
		
		
	}
}
