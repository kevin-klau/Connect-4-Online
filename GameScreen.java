import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.awt.Font;

import java.awt.image.*;
import javax.imageio.*;

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
	
	
	public void mouseMoved(MouseEvent evt){
		
	}
	
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
	
	
	
	public void keyReleased(KeyEvent evt){
	
	}
	
	
	public void keyPressed(KeyEvent evt){
	
	}
	
	public void keyTyped(KeyEvent evt){
	
	}
	
	
	public void mouseExited(MouseEvent evt){
		
	}
	public void mouseEntered(MouseEvent evt){
		
	}
	
	public void mouseReleased(MouseEvent evt){
		//Tile Drop Test and Variable Set
		if(evt.getX() == GSPanel.intP1X  && GSPanel.intP1X >= 240 + 22 && GSPanel.intP1X <= 240 + 22 + 65 && evt.getY() == GSPanel.intP1Y && GSPanel.intP1Y >= 170 - 25 && GSPanel.intP1Y <= 170 + 25){
			//GSPanel.intP1Y = 550 ;
			GSPanel.intStartDrop = 1;
			/*
			GSPanel.intDropped1 = GSPanel.intDropped1 -1;
			GSPanel.strSlot[GSPanel.intDropped1][0].equalsIgnoreCase("filled");
			
			System.out.println(GSPanel.strSlot[GSPanel.intDropped1][0]);
			System.out.println(GSPanel.intDropped1);
			*/
		}else if(evt.getX() == GSPanel.intP1X  && GSPanel.intP1X >= 240 + 22 + 65 && GSPanel.intP1X <= 240 + 22 + 65 + 65 && evt.getY() == GSPanel.intP1Y && GSPanel.intP1Y >= 170 - 25 && GSPanel.intP1Y <= 170 + 25 ){
			GSPanel.intP1Y = 550;
			GSPanel.intDropped2 = GSPanel.intDropped2 -1;
		}else if(evt.getX() == GSPanel.intP1X  && GSPanel.intP1X >= 327 + 65 && GSPanel.intP1X <= 392 + 65 && evt.getY() == GSPanel.intP1Y && GSPanel.intP1Y >= 170 - 25 && GSPanel.intP1Y <= 170 + 25 ){
			GSPanel.intP1Y = 550;
			GSPanel.intDropped3 = GSPanel.intDropped3 -1;
		}else if(evt.getX() == GSPanel.intP1X  && GSPanel.intP1X >= 392+65 && GSPanel.intP1X <= 457 + 65 && evt.getY() == GSPanel.intP1Y && GSPanel.intP1Y >= 170 - 25 && GSPanel.intP1Y <= 170 + 25 ){
			GSPanel.intP1Y = 550;
			GSPanel.intDropped4 = GSPanel.intDropped4 -1;
		}else if(evt.getX() == GSPanel.intP1X  && GSPanel.intP1X >= 457 + 65 && GSPanel.intP1X <= 522 + 65 && evt.getY() == GSPanel.intP1Y && GSPanel.intP1Y >= 170 - 25 && GSPanel.intP1Y <= 170 + 25 ){
			GSPanel.intP1Y = 550;
			GSPanel.intDropped5 = GSPanel.intDropped5 -1;
		}else if(evt.getX() == GSPanel.intP1X  && GSPanel.intP1X >= 522 + 65 && GSPanel.intP1X <= 587 + 65 && evt.getY() == GSPanel.intP1Y && GSPanel.intP1Y >= 170 - 25 && GSPanel.intP1Y <= 170 + 25 ){
			GSPanel.intP1Y = 550;
			GSPanel.intDropped6 = GSPanel.intDropped6 -1;
		}else if(evt.getX() == GSPanel.intP1X  && GSPanel.intP1X >= 587 + 65 && GSPanel.intP1X <= 652 + 65 && evt.getY() == GSPanel.intP1Y && GSPanel.intP1Y >= 170 - 25 && GSPanel.intP1Y <= 170 + 25 ){
			GSPanel.intP1Y = 550;
			GSPanel.intDropped7 = GSPanel.intDropped7 -1;
		}
	}
	
	public void mousePressed(MouseEvent evt){
	
			
		
	}
	
	public void mouseClicked(MouseEvent evt){
		
	}
	
	//Constructor
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
	public static void main(String[] args){
		new GameScreen();
	}








}
