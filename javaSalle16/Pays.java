package javaSalle16;

import java.awt.Color;

public class Pays 
{

	private String nom;
	private int xmin, ymin, xmax, ymax;
	private int xminv, yminv, xmaxv, ymaxv;
	private Color couleur; /*getter */
	private boolean dejaColorie ; /*getter */
	public Palette paletteDisponible;

	


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
		if (	(xminv < xmin && xminv < xmax && xmaxv > xmin && xmaxv < xmax) 
				||	(xminv > xmin && xminv < xmax && xmaxv > xmin && xmaxv < xmax) 
				||	(xminv > xmin && xminv < xmax && xmaxv > xmin && xmaxv > xmax)
				|| 	(xminv < xmin && xminv < xmax && xmaxv > xmin && xmaxv > xmax) 
				|| 	(xminv == xmin && xminv == xmax && xmaxv == xmin && xmaxv == xmax)
				|| 	(xminv == xmin && xminv < xmax && xmaxv > xmin && xmaxv < xmax)
				|| 	(xminv > xmin && xminv < xmax && xmaxv > xmin && xmaxv == xmax)
				)
				{
				result = true ;
				}
		}
		else 
		{
			if ( xminv==xmax || xmaxv == xmin)
			{
			if(	(yminv < ymin && yminv < ymax && ymaxv > ymin && ymaxv < ymax)
		
				||	(yminv > ymin && yminv < ymax && ymaxv > ymin && ymaxv < ymax)
				||	(yminv > ymin && yminv < ymax && ymaxv > ymin && ymaxv > ymax)
				|| 	(yminv < ymin && yminv < ymax && ymaxv > ymin && ymaxv > ymax) 
				|| 	(yminv == ymin && yminv == ymax && ymaxv == ymin && ymaxv == ymax)
				|| 	(yminv == ymin && yminv < ymax && ymaxv > ymin && ymaxv < ymax)
				|| 	(yminv > ymin && yminv < ymax && ymaxv > ymin && ymaxv == ymax)
					)
				{
				result = true ;
				}
			}
		}
			return result ;
		}
		
	public Pays(String nom, int xmin, int ymin, int xmax, int ymax)
		{		
			paletteDisponible=new Palette();
			couleur = Color.BLACK;

			dejaColorie = false ;
			
			 this.nom=nom;
			 this.xmin = xmin;
			 this.ymin = ymin;
			 this.xmax = xmax;
			 this.ymax = ymax;
			 
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
	
	
	/* public static void main(String[] args) 
	{
		// � compl�ter si n�cessaire

	} */
	
}
