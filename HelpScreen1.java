import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import javax.swing.event.*;

/**
 * <h1>First Help Screen</h1>
 * <p>GUI for the First Help Screen</p>
 */
public class HelpScreen1 extends JPanel implements ActionListener{
	//Properties
	/** help screen background image*/	
	BufferedImage helpBG = null;
	/** example board image*/	
	BufferedImage help1 = null;
	/** example board image*/	
	BufferedImage help2 = null;
	/** example board image*/	
	BufferedImage help3 = null;
	
	/** main heading*/
	JEditorPane helpHeading;
	/** first text area*/	
	JEditorPane helpText;
	/** second text area*/	
	JEditorPane helpText2;
	/** continues to next help page*/	
	JButton continueButton;
	
	//Methods
	public void actionPerformed(ActionEvent evt){
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		// Images
		g.drawImage(helpBG, 0,0, null);
		g.drawImage(help1, 100,500, this);
		g.drawImage(help2, 375,499, this);
		g.drawImage(help3, 652,500, this);
	}
	// Constructor	
	/** constructor, load images, set state of JComponents*/	
	public HelpScreen1(){
		super();
		try{
			helpBG = ImageIO.read(new File("HelpBG.png"));
			help1 = ImageIO.read(new File("SampleHelpBoard1.png"));
			help2 = ImageIO.read(new File("SampleHelpBoard2.png"));
			help3 = ImageIO.read(new File("SampleHelpBoard3.png"));
		}catch(IOException e){
			System.out.println("Image Error");
		}
		helpHeading = new JEditorPane("text/html", "");
		helpHeading.setText("<h1>Help Page!!!</h1>");
		helpHeading.setEditable(false);
		helpHeading.setSize(200,100);
		helpHeading.setLocation(580,0);
		helpHeading.setOpaque(false);
		this.add(helpHeading);
		
		helpText = new JEditorPane("text/html", "");
		helpText.setText("<h1>Connecting to the Server: </h1> <br>Example IP Address: 123.114.3.25.6<br>    -     Make sure you have the 'server' player connect first!<br>    -     Make sure you have the 'client' player connect after, with the exact same IP address and Port!");
		helpText.setEditable(false);
		helpText.setSize(400,150);
		helpText.setLocation(100, 100);
		helpText.setOpaque(false);
		this.add(helpText);
		
		helpText2 = new JEditorPane("text/html", "");
		helpText2.setText("<h1>How to play Connect 4: </h1> <br>You and your opponents will take turns placing pieces on the board. The first person to get 4 pieces in a row wins (Vertically, Horizontally or Diagonally!) Here are examples of winning boards (for red):");
		helpText2.setEditable(false);
		helpText2.setSize(400,150);
		helpText2.setLocation(100, 300);
		helpText2.setOpaque(false);
		this.add(helpText2);
		
		continueButton = new JButton();
		continueButton.setSize(new Dimension(200, 100));
		continueButton.setLocation(1000, 500);
		continueButton.setText("Continue!");
		this.add(continueButton);
	}
}
