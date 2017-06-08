package tracer_carte;

import java.awt.Graphics;
import javax.swing.JPanel;


public	class Panneau extends JPanel
	{
		
		public Rectangle[] rectangles;

		public Panneau()
		{
			triangle = new Triangle();
			triangle.setPanneau (this);
			
			cercle = new Rectangle(10.,10., 100.);
			cercle.setPanneau(this);
			
			carre = new Rectangle(120.,120., 80.);
			carre.setPanneau(this);
		}
		
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawPolygon(triangle);
			cercle.DrawCercle(g);
			carre.DrawCarre(g);
		}
	}

