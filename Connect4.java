import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.*;

public class Connect4 implements ActionListener{
	// Properties
	// Main JCompoennts
	JFrame theFrame = new JFrame ("Connect 4");
	MainPanel theMainPanel = new MainPanel ();
	Timer theTimer = new Timer (1000/60, this);
	
	// SuperSocketMaster
	SuperSocketMaster ssm;
	
	// Main Panel Components
	JTextField theIPAsk = new JTextField ();
	JTextField thePortAsk = new JTextField ();
	JTextField theUserAsk = new JTextField ();
	JButton theConnectServerButton = new JButton ("Create Server");
	JButton theConnectClientButton = new JButton ("Connect as Client");
	JComboBox<String> theThemesList;
	JButton theConnectButton = new JButton ("Play!!!");
	String strTheme = "Default";
	String strPersonConnect = "";
	
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
			
		}else if (evt.getSource() == theConnectServerButton){
			// Indicate whether or not they are connecting as a server or client
			if (!theUserAsk.getText().equalsIgnoreCase ("")){
				strPersonConnect = "Server";
				theConnectButton.setEnabled (true);
			}
			
		}else if (evt.getSource() == theConnectClientButton){
			// Indicate whether or not they are connecting as a server or client
			if (!theUserAsk.getText().equalsIgnoreCase ("")){
				strPersonConnect = "Client";
				theConnectButton.setEnabled (true);	
			}
			
		}else if (evt.getSource() == theConnectButton){
			boolean blnConnected;
			// Connect to SuperSocket Master
			if (strPersonConnect.equalsIgnoreCase ("Client")){
				// Connect Client
				ssm = new SuperSocketMaster(theIPAsk.getText(), Integer.parseInt(thePortAsk.getText()), this);
				blnConnected = ssm.connect();
				if (blnConnected){
					ssm.sendText ("connect, client, "+ theUserAsk.getText());
				}
			}else if (strPersonConnect.equalsIgnoreCase ("Server")){
				// Connect Server
				ssm = new SuperSocketMaster(Integer.parseInt(thePortAsk.getText()), this);
				blnConnected = ssm.connect();
				if (blnConnected){
					ssm.sendText ("connect, server, "+ theUserAsk.getText());
				}
			}
			
		}else if (evt.getSource() == ssm){
			// If they get ssm text
			System.out.println (ssm.readText());
			
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
		theThemesList.setLocation (970,290+40);
		theThemesList.setEditable (false);
		theThemesList.addActionListener (this);
		theThemesList.setVisible (true);
		theThemesList.setSize (250,40);
		Font theThemeChooseFont = new Font("Arial", Font.PLAIN, 20);
        theThemesList.setFont(theThemeChooseFont);
		theMainPanel.add (theThemesList);
		
		// Set the Connect Play Button
		theConnectButton.setSize (600, 65);
		theConnectButton.setLocation (160, 620);
		theConnectButton.setHorizontalAlignment (JTextField.CENTER);
		theMainPanel.add(theConnectButton);
		theConnectButton.setEnabled (false);
		theConnectButton.addActionListener (this);
		theButtonFont = new Font ("Arial", Font.PLAIN, 50);
		theConnectButton.setFont (theButtonFont);
		
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
