import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.awt.Font;

import java.awt.image.*;
import javax.imageio.*;
/**
 * <h1>Game Screen Backend</h1>
 * Backend for the Game Screen
 */
public class HelpPanel implements ActionListener, KeyListener, MouseMotionListener, MouseListener{

	//Properties
	JFrame theFrame = new JFrame("Connect4");
	HelpScreen2 theHelpPanel = new HelpScreen2();
	Timer theTimer = new Timer(1000/60, this);
	
	//Methods
	public void actionPerformed(ActionEvent evt){
		if(evt.getSource() == theTimer){
			theHelpPanel.repaint();
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

		//Moving tile Player
		theHelpPanel.intP1X = evt.getX();
		theHelpPanel.intP1Y = evt.getY();
		
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
		//Player drop
		if(theHelpPanel.intPlayer == 1){
			theHelpPanel.intP1X = evt.getX();
			if(theHelpPanel.intP1X >= 240 + 22 && theHelpPanel.intP1X <= 240 + 22 + 65 && evt.getY() == theHelpPanel.intP1Y && theHelpPanel.intP1Y >= 170 - 25 && theHelpPanel.intP1Y <= 170 + 25){
				theHelpPanel.intColumn = 0;
				theHelpPanel.blnPerson1Dropped = true;
				//Repositioning tile after use
				theHelpPanel.intP1X = 106 + 358 + 30;
				theHelpPanel.intP1Y = 70 + 435 + 100 + 30;
			}else if(theHelpPanel.intP1X >= 240 + 22 + 65 && theHelpPanel.intP1X <= 240 + 22 + 65 + 65 && evt.getY() == theHelpPanel.intP1Y && theHelpPanel.intP1Y >= 170 - 25 && theHelpPanel.intP1Y <= 170 + 25 ){
				theHelpPanel.intColumn = 1;
				theHelpPanel.blnPerson1Dropped = true;
				theHelpPanel.intP1X = 106 + 358 + 30;
				theHelpPanel.intP1Y = 70 + 435 + 100 + 30;
			}else if(theHelpPanel.intP1X >= 327 + 65 && theHelpPanel.intP1X <= 392 + 65 && evt.getY() == theHelpPanel.intP1Y && theHelpPanel.intP1Y >= 170 - 25 && theHelpPanel.intP1Y <= 170 + 25 ){
				theHelpPanel.intColumn = 2;
				theHelpPanel.blnPerson1Dropped = true;
				theHelpPanel.intP1X = 106 + 358 + 30;
				theHelpPanel.intP1Y = 70 + 435 + 100 + 30;
			}else if(theHelpPanel.intP1X >= 392+65 && theHelpPanel.intP1X <= 457 + 65 && evt.getY() == theHelpPanel.intP1Y && theHelpPanel.intP1Y >= 170 - 25 && theHelpPanel.intP1Y <= 170 + 25 ){
				theHelpPanel.intColumn = 3;
				theHelpPanel.blnPerson1Dropped = true;
				theHelpPanel.intP1X = 106 + 358 + 30;
				theHelpPanel.intP1Y = 70 + 435 + 100 + 30;
			}else if(theHelpPanel.intP1X >= 457 + 65 && theHelpPanel.intP1X <= 522 + 65 && evt.getY() == theHelpPanel.intP1Y && theHelpPanel.intP1Y >= 170 - 25 && theHelpPanel.intP1Y <= 170 + 25 ){
				theHelpPanel.intColumn = 4;
				theHelpPanel.blnPerson1Dropped = true;
				theHelpPanel.intP1X = 106 + 358 + 30;
				theHelpPanel.intP1Y = 70 + 435 + 100 + 30;
			}else if(theHelpPanel.intP1X >= 522 + 65 && theHelpPanel.intP1X <= 587 + 65 && evt.getY() == theHelpPanel.intP1Y && theHelpPanel.intP1Y >= 170 - 25 && theHelpPanel.intP1Y <= 170 + 25 ){
				theHelpPanel.intColumn = 5;
				theHelpPanel.blnPerson1Dropped = true;
				theHelpPanel.intP1X = 106 + 358 + 30;
				theHelpPanel.intP1Y = 70 + 435 + 100 + 30;
			}else if(theHelpPanel.intP1X >= 587 + 65 && theHelpPanel.intP1X <= 652 + 65 && evt.getY() == theHelpPanel.intP1Y && theHelpPanel.intP1Y >= 170 - 25 && theHelpPanel.intP1Y <= 170 + 25 ){
				theHelpPanel.intColumn = 6;
				theHelpPanel.blnPerson1Dropped = true;
				theHelpPanel.intP1X = 106 + 358 + 30;
				theHelpPanel.intP1Y = 70 + 435 + 100 + 30;
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
	
	//Constructor
/**
   * HelpPanel<p>
   * Layout setup
   */		
	public HelpPanel(){
		theHelpPanel.setPreferredSize(new Dimension(1280, 720));
		theHelpPanel.addMouseMotionListener(this);
		theHelpPanel.addMouseListener(this);
		theFrame.setContentPane(theHelpPanel);
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.pack();
		theFrame.setVisible(true);
		theFrame.setResizable(false);
		theFrame.addKeyListener(this);
		theTimer.start();
		


	}
	//Main Method
/**
   * Main Program
   * @param args TBD
   */		
	public static void main(String[] args){
		new HelpPanel();
	}








}
