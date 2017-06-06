package javaSalle16;

public class Pays 
{

	
	private String nom;
	private int xmin, ymin, xmax, ymax;
	private Color couleur;
	private boolean dejaColorie ;
	private Palette paletteDisponible;

	boolean estVoisin (Pays paysATester) /* prevoir le cas : le pays n'est pas voisin de lui-même */
		{
		boolean result ;
		/*Pays[i] PaysAtester */
		return result ;
		}
		
	public Pays(String nom, int xmin, int ymin, int xmax, int ymax)
		{
			 Palette paletteDisponible=new Palette();
			 Color couleur=this.paletteDisponible[0];
			 boolean dejaColorie = false ;
			 this.nom=nom;
			 this.xmin = xmin;
			 this.ymin = ymin;
			 this.xmax = xmax;
			 this.ymax = ymax;
			 
		}
	
	
	/*---------------------------------------*/
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

}
