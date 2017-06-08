package colorier_carte;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Panneau extends JPanel{

	public Carte carte;
	
	public Panneau(Carte newCarte){
		this.carte = newCarte;
		carte.setPanneau(this);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		for (Pays p: this.carte.getPays()){			

			g.setColor(p.getCouleur());
			g.fillRect(p.getXmin(),p.getYmin(),p.getXmax() - p.getXmin(),p.getYmax()-p.getYmin());
			
			g.setColor(Color.black);
			g.drawRect(p.getXmin(),p.getYmin(),p.getXmax() - p.getXmin(),p.getYmax()-p.getYmin());
			
		}
	}
	
}
