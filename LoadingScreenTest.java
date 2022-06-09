import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class LoadingScreenTest{
	
	// Main Method
	public static void main(String[] args){
		JFrame theFrame = new JFrame("Last GUI");
		JPanel thePanel = new JPanel();
		JLabel imageLabel = new JLabel();
		
		ImageIcon spinner = new ImageIcon("halloweenspinner.gif");
		imageLabel.setIcon(spinner);
		thePanel.add(imageLabel, BorderLayout.PAGE_END);
		
		thePanel.setPreferredSize(new Dimension(800, 600));
		
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.getContentPane().add(thePanel, java.awt.BorderLayout.PAGE_END);
		theFrame.pack();
		theFrame.setVisible(true);
	
		
	}
}
