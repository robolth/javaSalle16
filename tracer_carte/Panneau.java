package tracer_carte;

import java.awt.Graphics;
import java.io.IOException;

import javax.swing.JPanel;



public	class Panneau extends JPanel
	{
		
		public Collection collection;
		
		public Panneau()
		{
			collection = new Collection();
			collection.setPanneau(this);
		}
		
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);

			for (Rectangle r : this.collection.rectangles)
			{
			
				g.drawRect((int) r.x, (int) r.y, (int) r.w, (int) r.h);

			}
			
			
		}
	}

