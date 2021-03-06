package colorier_carte;

import java.awt.Color;
import java.io.IOException;
import java.util.Scanner;


public class Carte 
{
	private Pays[] pays;
	
	private Panneau panneau;
	
	private int sleepTime = 100;
	
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
	
	void setPanneau(Panneau p){
		panneau = p;
	}
	

// FONCTION QUI CHERCHE UNE COULEUR POUR COLORIER UN PAYS
// SI ELLE TROUVE UNE COULEUR QUI N'EST PAS EN CONFLIT AVEC CELLES DES PAYS
// VOISINS, LA FONCTION RENVOIE TRUE. SI AUCUNE COULEUR NE PEUT ETRE UTILISEE
// ELLE RENVOIE FALSE.

	public String getColorName(Color c) {

		if (c == Color.blue) {return "bleu";}
		if (c == Color.red) {return "rouge";}
		if (c == Color.yellow) {return "jaune";}
		if (c == Color.green) {return "vert";}
		return "erreur";
	}
	
	public boolean colorier (Pays pays) throws InterruptedException
	{
//		System.out.println("Carte.colorier()");
		Pays[] paysVoisins = listerVoisins(pays) ;
		
		
//		System.out.println("Carte.colorier() :" + pays.getNom() + " a " + paysVoisins.length + " pays voisins");
		
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
			
			System.out.println("Carte.colorier(" + pays.getNom()+ ") : " + getColorName(pays.getCouleur()));			
//			System.out.println("Carte.colorier() -> true");			
			
			Thread.sleep(sleepTime);
			this.panneau.repaint();
			
			return true ;
		}
		
		// S'IL N'Y A PAS DE COULEUR DISPONIBLE, ON RENVOIE FALSE
		else
		{
			System.out.println("Carte.colorier(" + pays.getNom()+ ") : aucune couleur disponible");			
//			System.out.println("Carte.colorier() -> false");		
			
			pays.setCouleur(Color.gray);
			
			Thread.sleep(sleepTime);
			this.panneau.repaint();
			
			
			return false;
		}
		
	}
	

	
	
	// colorie l'ensemble des pays de la carte
	boolean peindre() throws InterruptedException
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
	
	public int getWidth(){	
		int maxResult = 0;
		int minResult = 0;
		for(Pays p:this.pays){
			if(p.getXmax()>maxResult){
				maxResult = p.getXmax();
			}
			if(p.getXmin()<minResult){
				minResult = p.getXmin();
			}			
		}
		return maxResult + minResult;
	}
	
	public int getHeight(){	
		int maxResult = 0;
		int minResult = 0;
		for(Pays p:this.pays){
			if(p.getYmax()>maxResult){
				maxResult = p.getYmax();
			}
			if(p.getYmin()<minResult){
				minResult = p.getYmin();
			}
		}
		return maxResult + minResult;
	}
	
	
}
