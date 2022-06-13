import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.awt.Font;

import java.awt.image.*;
import javax.imageio.*;
/**
 * <h1>Game Screen Backend</h1>
 * Backend for the Game Screen<p>
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
		
	/*
		//Test Move a tile X
		int intX = evt.getX();
		int intY = evt.getY();
		if(intX > GSPanel.intP1X + 50){
			GSPanel.intP1XMove = +10;
		}else if(intX <= GSPanel.intP1X){
			GSPanel.intP1XMove = -10;
		}else{
			GSPanel.intP1XMove = 0;
		}
		
		//Test Move a tile Y
		if(intY > GSPanel.intP1Y + 50){
			GSPanel.intP1YMove = +10;
		}else if(intY <= GSPanel.intP1Y){
			GSPanel.intP1YMove = -10;
		}else{
			GSPanel.intP1YMove = 0;
		}
		*/
		//Moving tile
		GSPanel.intP1X = evt.getX();
		GSPanel.intP1Y = evt.getY();
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
		//Tile Drop Test and Variable Set
		if(evt.getX() == GSPanel.intP1X  && GSPanel.intP1X >= 240 + 22 && GSPanel.intP1X <= 240 + 22 + 65 && evt.getY() == GSPanel.intP1Y && GSPanel.intP1Y >= 170 - 25 && GSPanel.intP1Y <= 170 + 25){
			GSPanel.intColumn = 0;
			GSPanel.blnPersonDropped = true;
		}else if(evt.getX() == GSPanel.intP1X  && GSPanel.intP1X >= 240 + 22 + 65 && GSPanel.intP1X <= 240 + 22 + 65 + 65 && evt.getY() == GSPanel.intP1Y && GSPanel.intP1Y >= 170 - 25 && GSPanel.intP1Y <= 170 + 25 ){
			GSPanel.intColumn = 1;
			GSPanel.blnPersonDropped = true;
		}else if(evt.getX() == GSPanel.intP1X  && GSPanel.intP1X >= 327 + 65 && GSPanel.intP1X <= 392 + 65 && evt.getY() == GSPanel.intP1Y && GSPanel.intP1Y >= 170 - 25 && GSPanel.intP1Y <= 170 + 25 ){
			GSPanel.intColumn = 2;
			GSPanel.blnPersonDropped = true;
		}else if(evt.getX() == GSPanel.intP1X  && GSPanel.intP1X >= 392+65 && GSPanel.intP1X <= 457 + 65 && evt.getY() == GSPanel.intP1Y && GSPanel.intP1Y >= 170 - 25 && GSPanel.intP1Y <= 170 + 25 ){
			GSPanel.intColumn = 3;
			GSPanel.blnPersonDropped = true;
		}else if(evt.getX() == GSPanel.intP1X  && GSPanel.intP1X >= 457 + 65 && GSPanel.intP1X <= 522 + 65 && evt.getY() == GSPanel.intP1Y && GSPanel.intP1Y >= 170 - 25 && GSPanel.intP1Y <= 170 + 25 ){
			GSPanel.intColumn = 4;
			GSPanel.blnPersonDropped = true;
		}else if(evt.getX() == GSPanel.intP1X  && GSPanel.intP1X >= 522 + 65 && GSPanel.intP1X <= 587 + 65 && evt.getY() == GSPanel.intP1Y && GSPanel.intP1Y >= 170 - 25 && GSPanel.intP1Y <= 170 + 25 ){
			GSPanel.intColumn = 5;
			GSPanel.blnPersonDropped = true;
		}else if(evt.getX() == GSPanel.intP1X  && GSPanel.intP1X >= 587 + 65 && GSPanel.intP1X <= 652 + 65 && evt.getY() == GSPanel.intP1Y && GSPanel.intP1Y >= 170 - 25 && GSPanel.intP1Y <= 170 + 25 ){
			GSPanel.intColumn = 6;
			GSPanel.blnPersonDropped = true;
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
