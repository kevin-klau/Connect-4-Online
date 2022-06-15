import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.*;

/**
 * <h1>Connect 4</h1>
 * This is a program for Connect 4 game with LAN connectivity<p>
 * You can open a server and a client to play over a network
 * @author  Kevin Lau, Fergus Chu, Chris Ng
 * @version 1.0
 * @since   2022-06-12
 */
public class Connect4 implements ActionListener, KeyListener, MouseMotionListener, MouseListener{
	// Properties
	// Main JCompoennts
	JFrame theFrame = new JFrame ("Connect 4");
	MainPanel theMainPanel = new MainPanel ();
	Timer theTimer = new Timer (1000/60, this);
	LoadPanel theLoadPanel = new LoadPanel ();
	GameScreenPanel GSPanel = new GameScreenPanel();
	
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
	
	// Load Panel Components
	JButton theReturnHomeButton = new JButton ("Return To Home");
	
	// GamePanel Components
	JTextField theChatEnterField = new JTextField ();
	JTextArea theChatBox = new JTextArea();
	JScrollPane theScroll = new JScrollPane(theChatBox);
	
	// Methods
/**
   * <p>Invokes repaint everytime theTimer triggers ActionEvent/p>
   */
	public void actionPerformed (ActionEvent evt){
		// Add the repaint function
		if (evt.getSource() == theTimer){
			if (theFrame.getContentPane() == theMainPanel){
				theMainPanel.repaint();
			}else if (theFrame.getContentPane() == theLoadPanel){
				theLoadPanel.repaint();
			}else if (theFrame.getContentPane() == GSPanel){
				GSPanel.repaint();
			}
		
		// If they use the JComboBox to change themes
		}else if (evt.getSource() == theThemesList){
			// Change it so the theme changes
			theMainPanel.strThemes = (String)theThemesList.getSelectedItem();
			theMainPanel.blnImagesLoadOnce = false;
			
			theLoadPanel.strThemes = (String)theThemesList.getSelectedItem();
			theLoadPanel.blnImagesLoadOnce = false;
			
			GSPanel.strThemes = (String)theThemesList.getSelectedItem();
			GSPanel.blnImagesLoadOnce = false;
			
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
					ssm.sendText ("connect,client,"+ theUserAsk.getText());
					// Send to Load Screen
					theFrame.setContentPane(theLoadPanel);
					theFrame.pack();
					
					// Make the Player Counter 2 in the load screen
					theLoadPanel.intNumberOfPlayersLoadedIn = 2;
					
					// Send to Game Screen
					theFrame.setContentPane (GSPanel);
					theFrame.pack();
				}
			}else if (strPersonConnect.equalsIgnoreCase ("Server")){
				// Connect Server
				ssm = new SuperSocketMaster(Integer.parseInt(thePortAsk.getText()), this);
				blnConnected = ssm.connect();
				if (blnConnected){
					ssm.sendText ("connect,server,"+ theUserAsk.getText());
					// Send to Load Screen
					theFrame.setContentPane(theLoadPanel);
					theFrame.pack();
				}
			}
			
			
		}else if (evt.getSource() == ssm){
			// Make the code go into an array
			String strSSMText[];
			strSSMText = ssm.readText().split(",");
			// connect, kevin, win
			//strSSMText[0] = connect;
			//strSSMText[1]= kevin;
			//strSSMText[2] = win;
			
			if (strSSMText[0].equalsIgnoreCase ("connect") && strSSMText[1].equalsIgnoreCase ("client")){
				// If the client connects to the server, make it show up in the loading screen
				theLoadPanel.intNumberOfPlayersLoadedIn = 2;
				// Send to Game Screen
				theFrame.setContentPane (GSPanel);
				theFrame.pack();
				
			}else if (strSSMText[0].equalsIgnoreCase ("disconnect") && strSSMText[1].equalsIgnoreCase ("server")){
				// If the server disconnects, disconnect and send everyone back to the home screen
				System.out.println ("Sent back to home because server disonnected");
				theFrame.setContentPane (theMainPanel);
				theFrame.pack();
				ssm.disconnect();
				
			}else if (strSSMText[0].equalsIgnoreCase ("disconnect") && strSSMText[1].equalsIgnoreCase ("client")){
				// If the client disconnects, send the counter back to 1
				System.out.println ("The client disconnected");
				theLoadPanel.intNumberOfPlayersLoadedIn = 1;
				
			}else if (strSSMText[0].equalsIgnoreCase ("chat")){
				// If they receive the chat messages, add it to the chat box
				theChatBox.append (" "+strSSMText[1]+": "+strSSMText[2]+"\n");
			}
			
			// If they get ssm text just print it out for now
			System.out.println (ssm.readText());
			
		}else if (evt.getSource() == theReturnHomeButton){
			// If they click the go back to home button in the loading screen, disconnect them and send them back home
			theFrame.setContentPane (theMainPanel);
			theConnectButton.setEnabled(false);
			theFrame.pack();
			
			// Disconnect them from SSM
			ssm.sendText ("disconnect,"+strPersonConnect+","+theUserAsk.getText());
			ssm.disconnect();
			
		}else if (evt.getSource() == theChatEnterField){
			// If they use the chat function, send it over to the network and add it in the chatbox
			ssm.sendText ("chat,"+theUserAsk.getText()+","+theChatEnterField.getText()); 
			theChatBox.append (" "+theUserAsk.getText()+": "+theChatEnterField.getText() + "\n");
			theChatEnterField.setText ("");
			
		}
		
	}
	
	/**
   * <p>Not in use</p>
   */	
	public void mouseMoved(MouseEvent evt){
		
	}
/**
   * <p>Pickup of Pieces</p>
   */		
	public void mouseDragged(MouseEvent evt){
		if (theFrame.getContentPane() == GSPanel){	
			if(GSPanel.intPlayer == 1){
				//Moving tile Player
				GSPanel.intP1X = evt.getX();
				GSPanel.intP1Y = evt.getY();
			}
		}
	}
	
	
/**
   * <p>Not in use</p>
   */	
	public void keyReleased(KeyEvent evt){
	
	}
	
/**
   * <p>Not in use</p>
   */	
	public void keyPressed(KeyEvent evt){
	
	}
/**
   * <p>Not in use</p>
   */	
	public void keyTyped(KeyEvent evt){
	
	}
	
/**
   * <p>Not in use</p>
   */	
	public void mouseExited(MouseEvent evt){
		
	}
/**
   * <p>Not in use</p>
   */	
	public void mouseEntered(MouseEvent evt){
		
	}
/**
   * <p>Dropping of Pieces</p>
   */	
	public void mouseReleased(MouseEvent evt){
		if (theFrame.getContentPane() == GSPanel){
			//Player drop
			if(GSPanel.intPlayer == 1){
				GSPanel.intP1X = evt.getX();
				if(GSPanel.intP1X >= 240 + 22 && GSPanel.intP1X <= 240 + 22 + 65 && evt.getY() == GSPanel.intP1Y && GSPanel.intP1Y >= 170 - 25 && GSPanel.intP1Y <= 170 + 25){
					GSPanel.intColumn = 0;
					GSPanel.blnPerson1Dropped = true;
					//Repositioning tile after use
					GSPanel.intP1X = 106 + 358 + 30;
					GSPanel.intP1Y = 70 + 435 + 100 + 30;
				}else if(GSPanel.intP1X >= 240 + 22 + 65 && GSPanel.intP1X <= 240 + 22 + 65 + 65 && evt.getY() == GSPanel.intP1Y && GSPanel.intP1Y >= 170 - 25 && GSPanel.intP1Y <= 170 + 25 ){
					GSPanel.intColumn = 1;
					GSPanel.blnPerson1Dropped = true;
					GSPanel.intP1X = 106 + 358 + 30;
					GSPanel.intP1Y = 70 + 435 + 100 + 30;
				}else if(GSPanel.intP1X >= 327 + 65 && GSPanel.intP1X <= 392 + 65 && evt.getY() == GSPanel.intP1Y && GSPanel.intP1Y >= 170 - 25 && GSPanel.intP1Y <= 170 + 25 ){
					GSPanel.intColumn = 2;
					GSPanel.blnPerson1Dropped = true;
					GSPanel.intP1X = 106 + 358 + 30;
					GSPanel.intP1Y = 70 + 435 + 100 + 30;
				}else if(GSPanel.intP1X >= 392+65 && GSPanel.intP1X <= 457 + 65 && evt.getY() == GSPanel.intP1Y && GSPanel.intP1Y >= 170 - 25 && GSPanel.intP1Y <= 170 + 25 ){
					GSPanel.intColumn = 3;
					GSPanel.blnPerson1Dropped = true;
					GSPanel.intP1X = 106 + 358 + 30;
					GSPanel.intP1Y = 70 + 435 + 100 + 30;
				}else if(GSPanel.intP1X >= 457 + 65 && GSPanel.intP1X <= 522 + 65 && evt.getY() == GSPanel.intP1Y && GSPanel.intP1Y >= 170 - 25 && GSPanel.intP1Y <= 170 + 25 ){
					GSPanel.intColumn = 4;
					GSPanel.blnPerson1Dropped = true;
					GSPanel.intP1X = 106 + 358 + 30;
					GSPanel.intP1Y = 70 + 435 + 100 + 30;
				}else if(GSPanel.intP1X >= 522 + 65 && GSPanel.intP1X <= 587 + 65 && evt.getY() == GSPanel.intP1Y && GSPanel.intP1Y >= 170 - 25 && GSPanel.intP1Y <= 170 + 25 ){
					GSPanel.intColumn = 5;
					GSPanel.blnPerson1Dropped = true;
					GSPanel.intP1X = 106 + 358 + 30;
					GSPanel.intP1Y = 70 + 435 + 100 + 30;
				}else if(GSPanel.intP1X >= 587 + 65 && GSPanel.intP1X <= 652 + 65 && evt.getY() == GSPanel.intP1Y && GSPanel.intP1Y >= 170 - 25 && GSPanel.intP1Y <= 170 + 25 ){
					GSPanel.intColumn = 6;
					GSPanel.blnPerson1Dropped = true;
					GSPanel.intP1X = 106 + 358 + 30;
					GSPanel.intP1Y = 70 + 435 + 100 + 30;
				}
			}
		}
		
		
	}
/**
   * <p>Not in use</p>
   */	
	public void mousePressed(MouseEvent evt){
		
	}
/**
   * <p>Not in use</p>
   */	
	public void mouseClicked(MouseEvent evt){
		
	}
	
	// Constructor
/**
   * <p>Connect 4 GUI elements</p>
   */
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
		
		// The Load Panel
		theLoadPanel.setPreferredSize (new Dimension (1280,720));
		theLoadPanel.setLayout(null);
		
		// Create the Return Home Button
		theReturnHomeButton.setSize (400, 60);
		theReturnHomeButton.setLocation (440, 600);
		theReturnHomeButton.setHorizontalAlignment (JTextField.CENTER);
		theReturnHomeButton.addActionListener (this);
		theButtonFont = new Font ("Arial", Font.PLAIN, 40);
		theReturnHomeButton.setFont (theButtonFont);
		theLoadPanel.add (theReturnHomeButton);
		
		// Game Screen Panel
		GSPanel.setPreferredSize (new Dimension (1280,720));
		GSPanel.setLayout(null);
		GSPanel.addMouseMotionListener(this);
		GSPanel.addMouseListener(this);
		
		// Make the JTextField where they enter text
		theChatEnterField.setSize (300,25);
		theChatEnterField.setLocation (1280-300,720-25);
		theChatEnterField.addActionListener (this);
		GSPanel.add(theChatEnterField);
		
		// Make the Chat Box
		theScroll.setSize (300,720-25-100);
		theScroll.setLocation (1280-300, 100);
		GSPanel.add (theScroll);
		
		
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
/**
   * Main Program
   * @param args TBD
   */		
	public static void main (String[]args){
		new Connect4();
	}
}
