package colorier_carte;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Vue extends JFrame {
	

	private Panneau panneau;
	
	public Vue(Carte carte){
				
		setTitle("Coloriage de carte");
		setSize((int)(1.2*carte.getWidth()),(int)(1.2*carte.getHeight()));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panneau = new Panneau(carte);
		setContentPane(panneau);
//		panneau.setBackground(Color.cyan);
		
		setVisible(true);
		
	}
	
/*
	public void setListener(Controleur controleur){		
		panneau.addMouseMotionListener(controleur);
	}
	
	public void mouvement(int x, int y){
		Graphics g = panneau.getGraphics();
		panneau.triangle.deplace(x, y, g);
	}
*/
	
	
}
