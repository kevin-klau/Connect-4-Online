import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import javax.swing.event.*;

public class HelpScreen1 extends JPanel{
	//Properties
	BufferedImage helpBackground = null;
	BufferedImage help1 = null;
	BufferedImage help2 = null;
	BufferedImage help3 = null;
	
	//Methods
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		// Images
		g.drawImage(help1, 200,400, this);
		g.drawImage(help2, 400,400, this);
		g.drawImage(help3, 600,400, this);
}
	// Constructor	
	public HelpScreen1(){
		super();
		try{
			helpBackground = ImageIO.read(new File("HelpBG.png"));
			help1 = ImageIO.read(new File("SampleBoardHelp1.png"));
			help2 = ImageIO.read(new File("SampleBoardHelp2.png"));
			help3 = ImageIO.read(new File("SampleBoardHelp3.png"));
		}catch(IOException e){
			System.out.println("Image Error");
		}
	}
}
