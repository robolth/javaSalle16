package javaSalle16;

public class Carte {

	private Pays[] pays;
	
	public Carte(){
		pays = new Pays[0];		
	}
	
	public Pays[] listerVoisins(Pays p){
		
		int index = 0;
		
		Pays[] result = new Pays[];
		
		for(Pays q:pays){
			if(p.estVoisin(q)){
				result[index] = q;
				index++;
			}
		}
		
		return result;
		
	}
	
	

	
	
	
	boolean peindre()
	{
		boolean result = false ;
		for (int index = 0 ; index < pays.length ; i++)
		{
			if colorier(pays[index]) 
			{
				result = true ;
			}
			else
			{
				result = false ;
				pays[index].paletteDisponible.resetPalette;
				pays[index-1].paletteDisponible.remove(pays[index-1].color);
				pays[index-1].dejaColorie = false ;
				index -= 2;
			}
		}
		return result ;
	}
	
	
	
}
