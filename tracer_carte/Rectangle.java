package tracer_carte;

import java.awt.Graphics;

public class Rectangle

{
	public int x, y, w, h, xInit, yInit, lastX, lastY, lastW, lastH;
	public boolean locked;
	
//	private Panneau panneau;

	
	public Rectangle(int xd, int yd, int xf, int yf)
	{
		this.locked = false;
		
		this.x = this.lastX = xd ;
		this.y = this.lastY = yd ;
		this.w = this.lastW = xf - xd ;
		this.h = this.lastH = yf - yd ;

		xInit = xd ;
		yInit = yd ;
		
	}

	public Rectangle()
	{
		super();
	}
		
	public boolean redimensionner(int xFinal, int yFinal, Graphics g)
	{
	
		if (locked) return false;
		
		
		System.out.println("Rectangle.redimensionner() : " + xFinal + " " + yFinal);
		System.out.println("Rectangle.redimensionner() : " + this.x + " " + this.y);

		this.w = Math.abs(xFinal - xInit);
		this.h = Math.abs(yFinal - yInit);
		
		if (xFinal < xInit)
		{
			this.x = xFinal;
		}
		else
		{
			this.x = xInit;
		}
		
		
		if (yFinal < yInit)
		{
			this.y = yFinal;
		}
		else
		{
			this.y = yInit;
		}
		
		return true;
		
	}

	public boolean contains(int x, int y)
	{
		if (x > this.x && x < (this.x + this.w) && y > this.y && y < (this.y + this.h))
		{
			return true;
		}
		return false;
	}

	public boolean doesNotIntersects(Rectangle r)
	{
		if ( 		(r.y <= this.y && r.y + r.h <= this.y)
				||	(r.y >= this.y + this.h && r.y + r.h >= this.y + this.h)
				|| 	(r.x <= this.x && r.x + r.w <= this.x)
				||	(r.x >= this.x + this.w && r.x + r.w >= this.x + this.w)
				)
		{
			return true;
		}
		return false;
	}
	
	
	public void updateLastCoordinates(){
		this.lastX = this.x;
		this.lastY = this.y;
		this.lastW = this.w;
		this.lastH = this.h;
	}
	
	public void resetLastCoordinates(){
		this.x = this.lastX;
		this.y = this.lastY;
		this.w = this.lastW;
		this.h = this.lastH;
	}	
	
	
	
}
