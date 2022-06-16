import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.awt.Font;

import java.awt.image.*;
import javax.imageio.*;

import java.io.*;
/**
 * <h1>Help Screen 2</h1>
 * <p>GUI for the Second Help Screen</p>
 */
public class HelpScreen2 extends JPanel implements ActionListener{

	//Properties
	/** main heading*/
	JEditorPane helpHeading;
	/** first text area*/	
	JEditorPane helpText;
	/** second text area*/	
	JEditorPane helpText2;
	/** third text area*/	
	JEditorPane helpText3;
	
	//Methods
	
	public void actionPerformed(ActionEvent evt){
		
	}
/**
   * <p>Load second help screen assets</p>
   */	
	//Constructor
	public HelpScreen2(){
		super();
		helpHeading = new JEditorPane("text/html", "");
		helpHeading.setText("<h1>How to Play:</h1>");
		helpHeading.setEditable(false);
		helpHeading.setSize(200,100);
		helpHeading.setLocation(1080,0);
		helpHeading.setOpaque(false);
		this.add(helpHeading);
		
		helpText = new JEditorPane("text/html", "");
		helpText.setText("1. When it is your turn, put your <br> mouse over this area and drag <br> a piece");
		helpText.setEditable(false);
		helpText.setSize(400,150);
		helpText.setLocation(1080, 100);
		helpText.setOpaque(false);
		this.add(helpText);
		
		helpText2 = new JEditorPane("text/html", "");
		helpText2.setText("2. Drag the piece to your desired <br> column, and release the mouse");
		helpText2.setEditable(false);
		helpText2.setSize(400,150);
		helpText2.setLocation(1080, 300);
		helpText2.setOpaque(false);
		this.add(helpText2);
		
		helpText3 = new JEditorPane("text/html", "");
		helpText3.setText("3. Enjoy!");
		helpText3.setEditable(false);
		helpText3.setSize(400,150);
		helpText3.setLocation(1080, 500);
		helpText3.setOpaque(false);
		this.add(helpText3);							
	}
}		

		
		
		
		
		
