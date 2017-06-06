package javaSalle16;

import java.awt.Color;

// test Francois est-ce que tu me recois ???

public class Carte {

	private Pays[] pays;
	public Pays[] paysVoisins;
	
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

// fonction qui cherche une couleur pour colorier un pays
// si elle trouve une couleur qui n'est pas en conflit avec celles des pays
// voisins, la fonction renvoie true. Si aucune couleur ne peut etre utilisee
// elle renvoie false.
	
	public boolean colorier (Pays pays)
	{
		paysVoisins = listerVoisins(pays) ;
		for ( Pays paysVoisin : paysVoisins )
		{
//			couleurPays=getCouleur(paysVoisin);
			if ( paysVoisin.getdejaColorie == true )
			for ( Palette palette : pays.paletteDisponible )
			{
				palette.remove(getCouleur(paysVoisin)); 
			}
		}
		
		
//	pour r dans pays_voisin, si r.dejacolorie == true ;
//	this.palette.remove(r.color);
//	retruen false ;
//	
//	sinon p.couleur = palettedispo[]
//			p.dejacolorie = true ;
	
	// si p.palette.dispo vide
	}
	

	
	
	
	boolean peindre()
	{
		boolean result = false ;
		for (int index = 0 ; index < pays.length ; i++)
		{
			if colorier(pays[index]) {}
			else
			{
				pays[index].paletteDisponible.resetPalette;
				pays[index-1].paletteDisponible.remove(pays[index-1].color);
				pays[index-1].dejaColorie = false ;
				index -= 2;
			}
		}
		
		
		return 
	}
	
	
	
}
