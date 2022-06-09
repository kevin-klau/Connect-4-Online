import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Connect4 implements ActionListener{
	// Properties
	JFrame theFrame = new JFrame ("Connect 4");
	MainPanel theMainPanel = new MainPanel ();
	
	JTextField theIPAsk = new JTextField ();
	JTextField thePortAsk = new JTextField ();
	JTextField theUserAsk = new JTextField ();
	
	// Methods
	public void actionPerformed (ActionEvent evt){

		
	}
	
	// Constructor
	public Connect4 () {
		// Main Panel
		theMainPanel.setPreferredSize (new Dimension (1280,720));
		theMainPanel.setLayout(null);
		
		// Ask for IP Adress, Port, and Username
		theIPAsk.setSize (820/2-50,40);
		theIPAsk.setLocation (50+50-25, 280+50+5);
		theIPAsk.setHorizontalAlignment (JTextField.CENTER);
		Font theAskFont = new Font("Calibri", Font.PLAIN, 20);
        theIPAsk.setFont(theAskFont);
		theMainPanel.add(theIPAsk);
		theIPAsk.addActionListener (this);
		
		thePortAsk.setSize (820/2-50,40);
		thePortAsk.setLocation (50+50 + 820/2-50+50-25, 280+50+5);
		thePortAsk.setHorizontalAlignment (JTextField.CENTER);
		theAskFont = new Font("Calibri", Font.PLAIN, 20);
        thePortAsk.setFont(theAskFont);
		theMainPanel.add(thePortAsk);
		thePortAsk.addActionListener (this);
		
		theUserAsk.setSize (820-50,40);
		theUserAsk.setLocation (50+25, 280+50+90+10+10);
		theUserAsk.setHorizontalAlignment (JTextField.CENTER);
		theAskFont = new Font("Calibri", Font.PLAIN, 20);
        theUserAsk.setFont(theAskFont);
		theMainPanel.add(theUserAsk);
		theUserAsk.addActionListener (this);
		
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
