package tracer_carte;

import java.awt.Graphics;
import java.io.IOException;

public class Collection {
	
	Rectangle[] rectangles;
	
	private Panneau panneau;
	
	
	public Collection()
	{
		rectangles = new Rectangle[0];
	}
	
	public boolean contains(int x, int y)
	{
		
		for (Rectangle r : this.rectangles)
		{
			if (r.locked && r.contains(x, y))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean intersects(Rectangle r)
	{
		
		for (Rectangle q : this.rectangles)
		{
			if (q.locked && !q.doesNotIntersects(r))
			{
				return true;
			}
		}
		return false;
	}	
	
	public boolean ajouter(Rectangle r)
	{
		if (	this.intersects(r)
				
/*					this.contains(r.x, r.y) 
				|| this.contains(r.x+r.w, r.y)
				|| this.contains(r.x, r.y+r.h)
				|| this.contains(r.x+r.w, r.y+r.h)				
*/
		
	
	
		) {
			return false;
		}
			
			
			
		Rectangle[] temp = new Rectangle[this.rectangles.length + 1];
		
		for (int index = 0 ; index < this.rectangles.length ; index++)
		{
			temp[index] = rectangles[index];
		
		}
		temp[this.rectangles.length] = r;
		this.rectangles = temp;
		
		return true;
	}
	
	public boolean effacerDernierRectangle()
	{
		if (this.rectangles.length == 0) return false;	
			
		Rectangle[] temp = new Rectangle[this.rectangles.length - 1];
		
		for (int index = 0 ; index < this.rectangles.length -1 ; index++)
		{
			temp[index] = rectangles[index];
		}
		this.rectangles = temp;		
		return true;
	}
	
	void setPanneau(Panneau p) { panneau = p; }
	
	public Rectangle getLatestRectangle(){
		return this.rectangles[this.rectangles.length - 1];
	}
	
	void redimensionner(int index, int xFinal, int yFinal, Graphics g)
	{
		rectangles[index].redimensionner(xFinal,yFinal, g);
		panneau.repaint();
	}
	
}
