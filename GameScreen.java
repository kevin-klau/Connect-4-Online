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
