import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * <h1>Connect 4</h1>
 * This class gives Java students the ability to quickly open a Java network socket<p>
 * @author  Kevin Lau, Fergus Chu, Chris Ng
 * @version 1.0
 * @since   2022-06-12
 */
public class Connect4 implements ActionListener{
	// Properties
	JFrame theFrame = new JFrame ("Connect 4");
	MainPanel theMainPanel = new MainPanel ();
	Timer theTimer = new Timer (1000/60, this);
	
	JTextField theIPAsk = new JTextField ();
	JTextField thePortAsk = new JTextField ();
	JTextField theUserAsk = new JTextField ();
	
	JButton theConnectServerButton = new JButton ("Create Server");
	JButton theConnectClientButton = new JButton ("Connect as Client");
	
	JComboBox<String> theThemesList;
	
	String strTheme = "Default";
	
	// Methods
	public void actionPerformed (ActionEvent evt){
		// Add the repaint function
		if (evt.getSource() == theTimer){
			theMainPanel.repaint();
		
		
		// If they use the JComboBox to change themes
		}else if (evt.getSource() == theThemesList){
			// Change it so the theme changes
			theMainPanel.strThemes = (String)theThemesList.getSelectedItem();
			theMainPanel.blnImagesLoadOnce = false;
		}
		
		
		
		
	}
	
	// Constructor
	public Connect4 () {
		// Main Panel
		theMainPanel.setPreferredSize (new Dimension (1280,720));
		theMainPanel.setLayout(null);
		
		// Ask for IP Adress
		theIPAsk.setSize (820/2-50,40);
		theIPAsk.setLocation (50+50-25, 280+50+5+20);
		theIPAsk.setHorizontalAlignment (JTextField.CENTER);
		Font theAskFont = new Font("Calibri", Font.PLAIN, 20);
        theIPAsk.setFont(theAskFont);
		theMainPanel.add(theIPAsk);
		theIPAsk.addActionListener (this);
		
		// Ask for port
		thePortAsk.setSize (820/2-50,40);
		thePortAsk.setLocation (50+50 + 820/2-50+50-25, 280+50+5+20);
		thePortAsk.setHorizontalAlignment (JTextField.CENTER);
		theAskFont = new Font("Calibri", Font.PLAIN, 20);
        thePortAsk.setFont(theAskFont);
		theMainPanel.add(thePortAsk);
		thePortAsk.addActionListener (this);
		
		// Ask for user
		theUserAsk.setSize (820-50,40);
		theUserAsk.setLocation (50+25, 280+50+90+10+20);
		theUserAsk.setHorizontalAlignment (JTextField.CENTER);
		theAskFont = new Font("Calibri", Font.PLAIN, 20);
        theUserAsk.setFont(theAskFont);
		theMainPanel.add(theUserAsk);
		theUserAsk.addActionListener (this);  
		
		// Create Server Button
		theConnectServerButton.setSize (400-40, 40);
		theConnectServerButton.setLocation (55+20, 530+20);
		theConnectServerButton.setHorizontalAlignment (JTextField.CENTER);
		theMainPanel.add(theConnectServerButton);
		theConnectServerButton.addActionListener (this);
		Font theButtonFont = new Font ("Arial", Font.PLAIN, 25);
		theConnectServerButton.setFont (theButtonFont);
		
		// Connect Client Buton
		theConnectClientButton.setSize (400-40, 40);
		theConnectClientButton.setLocation (55+20+410, 530+20);
		theConnectClientButton.setHorizontalAlignment (JTextField.CENTER);
		theMainPanel.add(theConnectClientButton);
		theConnectClientButton.addActionListener (this);
		theButtonFont = new Font ("Arial", Font.PLAIN, 25);
		theConnectClientButton.setFont (theButtonFont);
		
		// Add the JCombo Box to list the themes
		// Open the themes.txt File
		BufferedReader themestxt = null;
		try {
			themestxt = new BufferedReader (new FileReader ("themes.txt"));
		}catch (FileNotFoundException e){
			System.out.println ("FILE NOT FOUND ERROR");
		}		
		
		// Count how many themes there are
		int intCountThemes=0;
		String strHold="";
		if (themestxt != null){
			try{
				while (strHold != null){
					strHold = themestxt.readLine();
					intCountThemes++;
				}
				intCountThemes = intCountThemes - 1;
			}catch (IOException e){
				System.out.println ("ERROR READING FROM FILE");
			}
		}
		
		// Close File
		try{
			themestxt.close();
		}catch (IOException e){
			System.out.println ("ERROR CLOSING FILE");
		}
		
		// Create String to hold the theme names
		String[] strThemes = new String [intCountThemes];
		
		// Load the theme names into the array
		// Open Array
		try {
			themestxt = new BufferedReader (new FileReader ("Themes.txt"));
		}catch (FileNotFoundException e){
			System.out.println ("FILE NOT FOUND ERROR");
		}		
		
		// Count how many themes there are
		int intCount;
		for (intCount = 0; intCount < intCountThemes; intCount ++){
			try{
				strThemes[intCount] = themestxt.readLine();
			}catch (IOException e){
				System.out.println ("ERROR READING FROM FILE");
			}
		}
		
		// Close File
		try{
			themestxt.close();
		}catch (IOException e){
			System.out.println ("ERROR CLOSING FILE");
		}
		
		// Set JComboBox
		theThemesList = new JComboBox<>(strThemes);
		theThemesList.setLocation (970,290);
		theThemesList.setEditable (false);
		theThemesList.addActionListener (this);
		theThemesList.setVisible (true);
		theThemesList.setSize (250,30);
		//theThemesList.setAlignmentX (JComboBox.CENTER);
		theMainPanel.add (theThemesList);
		
		// Send the Theme information to all the other panels (REMEMBER TO ADD THIS WHEN COORDINATING)
		//theMainPanel.
		
		// Frame
		theFrame.setContentPane(theMainPanel);
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theFrame.setVisible(true);
        theFrame.setResizable(false);
        

        theFrame.pack();
        
        // Timer
        theTimer.start();
	}
	
	// Main Program
	public static void main (String[]args){
		new Connect4();
	}
}
