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
	int intNumberOfPlayersLoadedIn = 1;
	// Font Properties
	/** font of title*/	
	Font TitleFont;
	// Image Properties
	/** background image */
	BufferedImage Background;
	/** player 1 piece image */
	BufferedImage P1Piece;
	// Theme Properties
	/** theme selected, default by default */
	String strThemes = "Default";
	/** allowed theme change */	
	Boolean blnImagesLoadOnce = false;
	
	// Animation Properties
	int intBlinkCount = 0;
	int intBlinkCounter = 0;
	
	// Methods
	/**
   * generates images and shapes 
   * 
   * @param g painting tool
   */		
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		
		// Draw the background
		g.drawImage (Background,0,0,this);
		
		// Draw the "Waiting for Players (1/2) function"
		g.setColor (Color.WHITE);
		g.fillRect (100,50,1080, 200-25-15-10);
		TitleFont = new Font("Arial", Font.BOLD, 80);
		g.setFont (TitleFont);
		g.setColor (Color.BLACK);
		g.drawString ("Waiting for Players (" + intNumberOfPlayersLoadedIn + "/2)...", 165-15,150);
		
		// Load the images, if the theme changes, it'll change along as well
		if (blnImagesLoadOnce == false){
			try{
				Background = ImageIO.read(new File("Themes/"+strThemes+"/BG.png"));
				P1Piece = ImageIO.read (new File ("Themes/"+strThemes+"/LoadingIcon.png"));
			}catch(IOException e){
				System.out.println("IMAGE UNABLE TO LOAD");
			}
			blnImagesLoadOnce = true;
		}
		
		// Draw the ... blinking function blinks every 30 frames / 0.5 seconds
		intBlinkCounter++;
		
		// Every 30 seconds it blinks
		if (intBlinkCounter == 30){
			intBlinkCounter = 0;
			intBlinkCount++;
		}
		
		// Every time it reaches 3 pieces it resets
		if (intBlinkCount == 4){
			intBlinkCount = 0;
		}
		
		// Draw the Pieces
		int intBlinker = intBlinkCount; 
		while (intBlinker >= 0){
			if (intBlinker < 3){
				g.drawImage (P1Piece, 250+intBlinker*300, 300, this);
				intBlinker--;
			}else{
				intBlinker = -1;
			}
		}
	}
	
	// Constructor
/**
   *  imports past (TBD)
   */		
	public LoadPanel(){
		super();
		
		
	}
}
