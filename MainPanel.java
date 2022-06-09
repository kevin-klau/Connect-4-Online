import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class MainPanel extends JPanel {
	// Properties
	BufferedImage Background;
	BufferedImage P1Piece;
	
	Font TitleFont;
	
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
	}
	
	// Constructor
	public MainPanel(){
		super();
		
		try{
			Background = ImageIO.read(new File("Themes/Default/BG.png"));
			P1Piece = ImageIO.read (new File ("Themes/Default/P1.png"));
		}catch(IOException e){
			System.out.println("IMAGE UNABLE TO LOAD");
		}
	}
}
