package tracer_carte;

import java.awt.Graphics;

public class Rectangle
{
	public int x, y, w, h, xInit, yInit;
	public boolean locked;
	
//	private Panneau panneau;

	
	public Rectangle(int xd, int yd, int xf, int yf)
	{
		this.locked = false;
		
		this.x = xd ;
		this.y = yd ;
		this.w = xf - xd ;
		this.h = yf - yd ;

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


	public boolean isInside(int x, int y)
	{
		if (x > this.x && x < (this.x + this.w) && y > this.y && y < (this.y + this.h))
		{
			return true;
		}
		return false;
	}

}
