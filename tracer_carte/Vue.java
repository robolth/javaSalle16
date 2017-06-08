package tracer_carte;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.MouseListener;

public class Vue extends JFrame
{
	public Panneau panneau ;

	
	public Vue()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Dessinez vos pays");
		setSize(1000, 1000);
		panneau = new Panneau();
		setContentPane(panneau);
		
		setVisible(true);
	}

	public void setListener(Controleur controleur) 
	{
		panneau.addMouseListener(controleur);
		panneau.addMouseMotionListener(controleur);	
	}
	
	public void tracer()
	{
		
	}
	
	public void tracerRectangle(int x, int y) 
	{
		System.out.println("Vue.tracerRectangle()");
		Graphics g = panneau.getGraphics();

		if (true) { panneau.collection.redimensionner(panneau.collection.rectangles.length - 1,x,y,g); }
	}
}




