package tracer_carte;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public class Rectangle extends Rectangle2D
{
	private Panneau panneau;
//	public boolean selection ;
	
	public Rectangle(double x, double y, double cote)
	{
		super(x,y,cote,cote,cote,cote);
		selection = false;
		
		this.x = x > 0 ? x : 0 ;
		this.y = y > 0 ? y : 0 ;
		this.width = cote > 0 ? cote : 0 ;
		this.height = cote > 0 ? cote : 0 ;
	}
	
	void DrawCercle(Graphics g)
	{
		g.drawRoundRect((int) x, (int) y, (int) width, (int) height, (int) width, (int) height);
	}
	
	void DrawCarre(Graphics g)
	{
		g.drawRoundRect((int) x, (int) y, (int) width, (int) height, 0, 0);
	}
	
	public void deplace(int x, int y, Graphics g)
	{
		// centre de gravité
		int xG = 0, yG = 0;
		xG = (int) (this.x + this.width / 2.);
		yG = (int) (this.y + this.height / 2.);
		
		int dX, dY ;
		dX = x - xG;
		dY = y - yG;
		
		this.x += dX;
		this.y += dY;
		
		panneau.repaint();
	}
	void setPanneau(Panneau p) { panneau = p; }
}
