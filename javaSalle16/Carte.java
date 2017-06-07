package javaSalle16;

import java.io.IOException;

public class Carte 
{
	private Pays[] pays;
	
	public Carte()
	{
		pays = new Pays[0];
	}
	
	public Pays[] listerVoisins(Pays p)
	{
		int index = 0;
		int nombreDePaysVoisins = 0;
		
		for(Pays q:pays)
		{
			if(p.estVoisin(q))
			{
				nombreDePaysVoisins++;
			}
		}
		
		Pays[] result = new Pays[nombreDePaysVoisins];
		
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
		System.out.println("Carte.colorier()");
		Pays[] paysVoisins = listerVoisins(pays) ;
		
		
		System.out.println( pays.getNom() + " a " + paysVoisins.length + " pays voisins");
		
		// ON PARCOURT LA LISTE DES PAYS VOISINS
		for ( Pays paysVoisin : paysVoisins )
		{			
			// SI LE PAYS VOISIN EST DEJA COLORIE ON ENLEVE SA COULEUR DE LA PALETTE DES COULEURS DISPOS
			if ( paysVoisin.getDejaColorie() == true ) 
			{
//				System.out.println("	" + paysVoisin.getCouleur() + " n'est plus dispobible");
				pays.paletteDisponible.remove(paysVoisin.getCouleur());
				
			}
		}

		// S'IL Y A DES COULEURS POSSIBLES DANS LA PALETTE, ON COLORIE LE 
		// PAYS AVEC LA PREMIERE COULEUR DISPONIBLE ET ON RENVOIE TRUE
		if (!pays.paletteDisponible.estVide())
		{	
			pays.setCouleur(pays.paletteDisponible.premiereCouleurDisponible());
			pays.setDejaColorie(true) ;
			
			System.out.println("	pays colorié en " + pays.getCouleur());			
//			System.out.println("Carte.colorier() -> true");			
			return true ;
		}
		
		// S'IL N'Y A PAS DE COULEUR DISPONIBLE, ON RENVOIE FALSE
		else
		{
			System.out.println("	Aucune couleur restant disponible");			
//			System.out.println("Carte.colorier() -> false");		
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
		
		System.out.println("Carte.peindre() -> " + result);
		return result ;
	}
	
	void ajouterPays(Pays newPays)
	{
		Pays[] tempPays = new Pays[this.pays.length+1];
		for (int index = 0 ; index < this.pays.length ; index++)
		{
			tempPays[index] = this.pays[index];
			
		}
		tempPays[this.pays.length] = newPays;
		this.pays = tempPays;
		
		
	}

	public Pays[] getPays()
	{
		return this.pays;
	}
	
	
}
