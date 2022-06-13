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
public class GameScreen implements ActionListener, KeyListener, MouseMotionListener, MouseListener{

	//Properties
	JFrame theFrame = new JFrame("Connect4");
	GameScreenPanel GSPanel = new GameScreenPanel();
	Timer theTimer = new Timer(1000/60, this);
	
	//Methods
	public void actionPerformed(ActionEvent evt){
		if(evt.getSource() == theTimer){
			GSPanel.repaint();
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
		
	
		//Moving tile P1
		if(GSPanel.intPlayer == 1){
			GSPanel.intP1X = evt.getX();
			GSPanel.intP1Y = evt.getY();
		}
		
		//Moving tile P2
		if(GSPanel.intPlayer == 2){
			GSPanel.intP2X = evt.getX();
			GSPanel.intP2Y = evt.getY();
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
		//P1 Drop
		if(GSPanel.intPlayer == 1){
			GSPanel.intP1X = evt.getX();
			if(GSPanel.intP1X >= 240 + 22 && GSPanel.intP1X <= 240 + 22 + 65 && evt.getY() == GSPanel.intP1Y && GSPanel.intP1Y >= 170 - 25 && GSPanel.intP1Y <= 170 + 25){
				GSPanel.intColumn = 0;
				GSPanel.blnPerson1Dropped = true;
			}else if(GSPanel.intP1X >= 240 + 22 + 65 && GSPanel.intP1X <= 240 + 22 + 65 + 65 && evt.getY() == GSPanel.intP1Y && GSPanel.intP1Y >= 170 - 25 && GSPanel.intP1Y <= 170 + 25 ){
				GSPanel.intColumn = 1;
				GSPanel.blnPerson1Dropped = true;
			}else if(GSPanel.intP1X >= 327 + 65 && GSPanel.intP1X <= 392 + 65 && evt.getY() == GSPanel.intP1Y && GSPanel.intP1Y >= 170 - 25 && GSPanel.intP1Y <= 170 + 25 ){
				GSPanel.intColumn = 2;
				GSPanel.blnPerson1Dropped = true;
			}else if(GSPanel.intP1X >= 392+65 && GSPanel.intP1X <= 457 + 65 && evt.getY() == GSPanel.intP1Y && GSPanel.intP1Y >= 170 - 25 && GSPanel.intP1Y <= 170 + 25 ){
				GSPanel.intColumn = 3;
				GSPanel.blnPerson1Dropped = true;
			}else if(GSPanel.intP1X >= 457 + 65 && GSPanel.intP1X <= 522 + 65 && evt.getY() == GSPanel.intP1Y && GSPanel.intP1Y >= 170 - 25 && GSPanel.intP1Y <= 170 + 25 ){
				GSPanel.intColumn = 4;
				GSPanel.blnPerson1Dropped = true;
			}else if(GSPanel.intP1X >= 522 + 65 && GSPanel.intP1X <= 587 + 65 && evt.getY() == GSPanel.intP1Y && GSPanel.intP1Y >= 170 - 25 && GSPanel.intP1Y <= 170 + 25 ){
				GSPanel.intColumn = 5;
				GSPanel.blnPerson1Dropped = true;
			}else if(GSPanel.intP1X >= 587 + 65 && GSPanel.intP1X <= 652 + 65 && evt.getY() == GSPanel.intP1Y && GSPanel.intP1Y >= 170 - 25 && GSPanel.intP1Y <= 170 + 25 ){
				GSPanel.intColumn = 6;
				GSPanel.blnPerson1Dropped = true;
			}
		}
		
		//P2 Drop
		if(GSPanel.intPlayer == 2){
			GSPanel.intP2X = evt.getX();
			if(GSPanel.intP2X >= 240 + 22 && GSPanel.intP2X <= 240 + 22 + 65 && evt.getY() == GSPanel.intP2Y && GSPanel.intP2Y >= 170 - 25 && GSPanel.intP2Y <= 170 + 25){
				GSPanel.intColumn = 0;
				GSPanel.blnPerson2Dropped = true;
			}else if(GSPanel.intP2X >= 240 + 22 + 65 && GSPanel.intP2X <= 240 + 22 + 65 + 65 && evt.getY() == GSPanel.intP2Y && GSPanel.intP2Y >= 170 - 25 && GSPanel.intP2Y <= 170 + 25 ){
				GSPanel.intColumn = 1;
				GSPanel.blnPerson2Dropped = true;
			}else if(GSPanel.intP2X >= 327 + 65 && GSPanel.intP2X <= 392 + 65 && evt.getY() == GSPanel.intP2Y && GSPanel.intP2Y >= 170 - 25 && GSPanel.intP2Y <= 170 + 25 ){
				GSPanel.intColumn = 2;
				GSPanel.blnPerson2Dropped = true;
			}else if(GSPanel.intP2X >= 392+65 && GSPanel.intP2X <= 457 + 65 && evt.getY() == GSPanel.intP2Y && GSPanel.intP2Y >= 170 - 25 && GSPanel.intP2Y <= 170 + 25 ){
				GSPanel.intColumn = 3;
				GSPanel.blnPerson2Dropped = true;
			}else if(GSPanel.intP2X >= 457 + 65 && GSPanel.intP2X <= 522 + 65 && evt.getY() == GSPanel.intP2Y && GSPanel.intP2Y >= 170 - 25 && GSPanel.intP2Y <= 170 + 25 ){
				GSPanel.intColumn = 4;
				GSPanel.blnPerson2Dropped = true;
			}else if(GSPanel.intP2X >= 522 + 65 && GSPanel.intP2X <= 587 + 65 && evt.getY() == GSPanel.intP2Y && GSPanel.intP2Y >= 170 - 25 && GSPanel.intP2Y <= 170 + 25 ){
				GSPanel.intColumn = 5;
				GSPanel.blnPerson2Dropped = true;
			}else if(GSPanel.intP2X >= 587 + 65 && GSPanel.intP2X <= 652 + 65 && evt.getY() == GSPanel.intP2Y && GSPanel.intP2Y >= 170 - 25 && GSPanel.intP2Y <= 170 + 25 ){
				GSPanel.intColumn = 6;
				GSPanel.blnPerson2Dropped = true;
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
   * GameScreen<p>
   * Layout setup
   */		
	public GameScreen(){
		GSPanel.setPreferredSize(new Dimension(1280, 720));
		GSPanel.addMouseMotionListener(this);
		GSPanel.addMouseListener(this);
		theFrame.setContentPane(GSPanel);
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
		new GameScreen();
	}








}
