package tracer_carte;

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
		vue.selectionner(e.getX(), e.getY(), true);
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		vue.selectionner(e.getX(), e.getY(), false);
	}
	
	@Override public void mouseClicked(MouseEvent arg0) {} 
	@Override public void mouseEntered(MouseEvent arg0) {} 
	@Override public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mouseDragged(MouseEvent e) { vue.mouvement(e.getX(), e.getY()); }

	@Override
	public void mouseMoved(MouseEvent e) {} 
}
