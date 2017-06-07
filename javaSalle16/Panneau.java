package javaSalle16;

import java.awt.Graphics;
import javax.swing.JPanel;

public class Panneau extends JPanel{

	public Carte carte;
	
	public Panneau(){
		carte = new Carte();
		carte.setPanneau(this);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		for (Pays p: this.carte.getPays()){
			g.drawRect(p.getX(),p.getY(),p.getWidth(),p.getHeight());
		}
	}
	
}
