package colorier_carte;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.geom.Rectangle2D;

public class Pays 
{

	private String nom;
	private int xmin, ymin, xmax, ymax;
	private int xminv, yminv, xmaxv, ymaxv;
	private Color couleur; /*getter */
	private boolean dejaColorie ; /*getter */
	public Palette paletteDisponible;

	
	public Pays(String nom, int xmin, int ymin, int xmax, int ymax)
	{		
		super();
		paletteDisponible=new Palette();
		couleur = Color.gray;

		dejaColorie = false ;
		
		 this.nom=nom;
		 this.xmin = xmin;
		 this.ymin = ymin;
		 this.xmax = xmax;
		 this.ymax = ymax;
		 
		 
//		this.setRect(xmin,ymin,(xmax-xmin),(ymax-ymin));
		 
	}

	boolean estVoisin (Pays paysATester) /* prevoir le cas : le pays n'est pas voisin de lui-même */
		{		
		boolean result = false; 
		xminv = paysATester.xmin;
		yminv = paysATester.ymin;
		xmaxv = paysATester.xmax;
		ymaxv = paysATester.ymax;
		
		/*comparaison de toutes les coordonnées entre elles, pour les x puis les y */
		if ( yminv==ymax || ymaxv == ymin)
		{
			if 	(	(xminv < xmin && xminv < xmax && xmaxv > xmin && xmaxv < xmax) 
				||	(xminv > xmin && xminv < xmax && xmaxv > xmin && xmaxv < xmax) 
				||	(xminv > xmin && xminv < xmax && xmaxv > xmin && xmaxv > xmax)
				|| 	(xminv < xmin && xminv < xmax && xmaxv > xmin && xmaxv > xmax) 
				|| 	(xminv == xmin && xminv < xmax && xmaxv > xmin && xmaxv == xmax)
				|| 	(xminv == xmin && xminv < xmax && xmaxv > xmin && xmaxv < xmax)
				|| 	(xminv > xmin && xminv < xmax && xmaxv > xmin && xmaxv == xmax)
				||	(xminv < xmin && xminv < xmax && xmaxv > xmin && xmaxv == xmax)
				||	(xminv == xmin && xminv < xmax && xmaxv > xmin && xmaxv > xmax)
				)
			{
				result = true ;
			}
		}
		
		if ( xminv==xmax || xmaxv == xmin)
		{
			if	(	(yminv < ymin && yminv < ymax && ymaxv > ymin && ymaxv < ymax)
				||	(yminv > ymin && yminv < ymax && ymaxv > ymin && ymaxv < ymax)
				||	(yminv > ymin && yminv < ymax && ymaxv > ymin && ymaxv > ymax)
				|| 	(yminv < ymin && yminv < ymax && ymaxv > ymin && ymaxv > ymax) 
				|| 	(yminv == ymin && yminv < ymax && ymaxv > ymin && ymaxv == ymax)
				|| 	(yminv == ymin && yminv < ymax && ymaxv > ymin && ymaxv < ymax)
				|| 	(yminv > ymin && yminv < ymax && ymaxv > ymin && ymaxv == ymax)
				||	(yminv < ymin && yminv < ymax && ymaxv > ymin && ymaxv == ymax)
				||	(yminv == ymin && yminv < ymax && ymaxv > ymin && ymaxv > ymax)
				)
			{
				result = true ;
			}
		}
	
		
//			System.out.println(this.nom + ".estVoisin(" + paysATester.getNom() +") -> " + result);
		
			return result ;
		}

	public boolean getDejaColorie()
	{
		return dejaColorie ;
	}

	public Color getCouleur()
	{
		return couleur ;
	}
	
	public void setDejaColorie(boolean b)
	{
		this.dejaColorie = b;
	}

	public void setCouleur(Color c)
	{
		if(this.paletteDisponible.contains(c)) {
			this.couleur = c;
		}				
	}	
	
	



	public String getNom()
	{
		return nom ;
	}
	
	public int getXmin()
	{
		return xmin ;
	}
	
	public int getYmin()
	{
		return ymin ;
	}
	
	public int getXmax()
	{
		return xmax ;
	}
	
	public int getYmax()
	{
		return ymax ;
	}

}
