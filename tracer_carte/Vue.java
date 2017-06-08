package tracer_carte;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.MouseListener;

public class Vue extends JFrame
{
	private Panneau panneau ;
	
	Vue()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Dessin 2D");
		setSize(200, 200);
		panneau = new Panneau();
		setContentPane(panneau);
		
		setVisible(true);
	}

	public void setListener(Controleur controleur) 
	{
		panneau.addMouseListener(controleur);
		panneau.addMouseMotionListener(controleur);	
	}
	
	public void selectionner(int x, int y, boolean clic)
	{
		if(clic) 
		{
			if (panneau.triangle.contains(x,y))
			{
			panneau.triangle.selection = panneau.triangle.contains(x,y);
			}
			if (panneau.carre.contains(x,y))
			{
				panneau.carre.selection = panneau.carre.contains(x,y);
			}
			if (panneau.cercle.contains(x,y))
			{
				panneau.cercle.selection = panneau.cercle.contains(x,y);
			}
		}
		else 
			{
			panneau.triangle.selection = false;
			panneau.carre.selection = false;
			panneau.cercle.selection = false;
			}
	
	}

	public void mouvement(int x, int y) 
	{
		Graphics g = panneau.getGraphics();
		if (panneau.triangle.selection) panneau.triangle.deplace(x,y,g);
		else if (panneau.cercle.selection) panneau.cercle.deplace(x,y,g);
		else if (panneau.carre.selection) panneau.carre.deplace(x,y,g);
	}
}




