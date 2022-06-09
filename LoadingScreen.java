import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import static java.lang.Math.*;

class LoadingScreen extends JPanel{

BufferedImage spinnerPiece;
int spinnerWidth = spinnerPiece.getWidth();
int spinnerHeight = spinnerPiece.getHeight();

BufferedImage newImage = new BufferedImage(spinnerWidth, spinnerHeight, BufferedImage.TYPE_INT_ARGB);

public void paintComponent(Graphics g){
	super.paintComponent(g);
	g.drawImage(spinnerPiece, 600, 25, this);
	Graphics2D g2d = (Graphics2D)g;
	g2d.rotate(Math.toRadians(10), spinnerWidth/2, spinnerHeight/2);
}

public LoadingScreen(){
		super();
		try{
			spinnerPiece = ImageIO.read(new File("D:/GitHub/ICSCPT2022/Themes/Halloween/P2.png"));
		}catch(IOException e){
			e.printStackTrace();
			System.out.println("Unable to load diagram");
		}
	}
	
}
