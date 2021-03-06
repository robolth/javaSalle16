package tracer_carte;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class Controleur implements MouseListener, MouseMotionListener
{
	private Vue vue ;
	
	Controleur (Vue vue)
	{
		this.vue = vue;
		vue.setListener(this);
	}
	
	@Override
	public void mousePressed(MouseEvent e) 
	{
		System.out.println("Controleur.mousePressed() : " + e.getX() + " " + e.getY());
		
		vue.panneau.collection.ajouter(new Rectangle(e.getX(),e.getY(),e.getX(),e.getY()));
		
/*		vue.panneau.collection.getLatestRectangle().x = e.getX();
		vue.panneau.collection.getLatestRectangle().y = e.getY();
		vue.panneau.collection.getLatestRectangle().xInit = e.getX();
		vue.panneau.collection.getLatestRectangle().yInit = e.getY();
*/	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		
		if	(			!vue.panneau.collection.contains(e.getX(), e.getY()) 
				&& 	!vue.panneau.collection.intersects(this.vue.panneau.collection.getLatestRectangle())
			) {
			vue.panneau.collection.rectangles[vue.panneau.collection.rectangles.length - 1].locked = true;
		}	
		else {
			vue.panneau.collection.getLatestRectangle().resetLastCoordinates();					
			vue.panneau.collection.rectangles[vue.panneau.collection.rectangles.length - 1].locked = true;
			vue.panneau.repaint();
			
		}
		
		
		
		
//		vue.panneau.collection.rectangles[vue.panneau.collection.rectangles.length - 1].locked = true;	
//		getLatestRectangle().locked = true;
		
//		if(vue.panneau.collection.isInside())
//		vue.tracerRectangle(e.getX(), e.getY()); 
	}
	
	@Override public void mouseClicked(MouseEvent arg0) {} 
	@Override public void mouseEntered(MouseEvent arg0) {} 
	@Override public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mouseDragged(MouseEvent e) {

		
		if	(			!vue.panneau.collection.contains(e.getX(), e.getY()) 
				&& 	!vue.panneau.collection.intersects(this.vue.panneau.collection.getLatestRectangle())
			) {
			vue.panneau.collection.getLatestRectangle().updateLastCoordinates();
				vue.tracerRectangle(e.getX(), e.getY());
		}	
		else {
			vue.panneau.collection.getLatestRectangle().resetLastCoordinates();			


//			Graphics g = panneau.getGraphics();
			
//			this.vue.panneau.collection.getLatestRectangle().redimensionner(xFinal,yFinal, g);

			vue.panneau.repaint();
			

		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {} 
}
