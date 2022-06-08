import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Connect4{
	// Properties
	JFrame theFrame = new JFrame ("Connect 4");
	MainPanel theMainPanel = new MainPanel ();
	
	// Methods
	
	
	// Constructor
	public Connect4 () {
		// Main Panel
		theMainPanel.setPreferredSize (new Dimension (1280,720));
		
		// Frame
		theFrame.setContentPane(theMainPanel);
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theFrame.setVisible(true);
        theFrame.setResizable(false);

        theFrame.pack();
	}
	
	// Main Program
	public static void main (String[]args){
		new Connect4();
	}
}
