package javaSalle16;

import java.io.IOException;

public class Carte 
{
	private Pays[] pays;
	
	public Carte(String adresse) throws IOException
	{
	
		Parser parser = new Parser();
		if (parser.lecture(adresse))
		{
			this.pays = parser.getPays();
			System.out.println("Carte : génération de la carte terminée");
		}
		else 
		{
		System.out.println("Carte : la carte n'a pas pu être générée");	
		}
	}


	
	public Pays[] listerVoisins(Pays p)
	{
		int index = 0;
		Pays[] result = new Pays[0];
		
		for(Pays q:pays)
		{
			if(p.estVoisin(q))
			{
				result[index] = q;
				index++;
			}
		}
		return result;
	}

// FONCTION QUI CHERCHE UNE COULEUR POUR COLORIER UN PAYS
// SI ELLE TROUVE UNE COULEUR QUI N'EST PAS EN CONFLIT AVEC CELLES DES PAYS
// VOISINS, LA FONCTION RENVOIE TRUE. SI AUCUNE COULEUR NE PEUT ETRE UTILISEE
// ELLE RENVOIE FALSE.

	
	public boolean colorier (Pays pays)
	{
		Pays[] paysVoisins = listerVoisins(pays) ;
		
		// ON PARCOURT LA LISTE DES PAYS VOISINS
		for ( Pays paysVoisin : paysVoisins )
		{
			// SI LE PAYS VOISIN EST DEJA COLORIE ON ENLEVE SA COULEUR DE LA PALETTE DES COULEURS DISPOS
			if ( paysVoisin.getDejaColorie() == true ) 
			{
				pays.paletteDisponible.remove(paysVoisin.getCouleur()); 
			}
		}
		
		// S'IL Y A DES COULEURS POSSIBLES DANS LA PALETTE, ON COLORIE LE 
		// PAYS AVEC LA PREMIERE COULEUR DISPONIBLE ET ON RENVOIE TRUE
		if (pays.paletteDisponible.couleurs.length != 0)
		{
			pays.setCouleur(pays.paletteDisponible.couleurs[0]);
			pays.setDejaColorie(true) ;
			return true ;
		}
		
		// S'IL N'Y A PAS DE COULEUR DISPONIBLE, ON RENVOIE FALSE
		else
		{
			return false;
		}
	}
	

	
	
	// colorie l'ensemble des pays de la carte
	boolean peindre()
	{
		boolean result = false ;
		for (int index = 0 ; index < pays.length ; index++)
		{
			if (colorier(pays[index]) )
			{
				result = true ;
			}
			else
			{
				result = false ;
				pays[index].paletteDisponible.reset();
				pays[index-1].paletteDisponible.remove(pays[index-1].getCouleur());
				pays[index-1].setDejaColorie(false);
				index -= 2;
			}
		}
		return result ;
	}
	
	
	
}
