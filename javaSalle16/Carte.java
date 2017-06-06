
<<<<<<< HEAD
public class Carte {

=======
// IMPORT DES BIBLIOTHEQUES NECESSAIRES
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Carte 
{
>>>>>>> branch 'master' of https://github.com/robolth/javasalle16
	private Pays[] pays;
	
	public Carte()
	{
		pays = new Pays[0];		
	}

	
<<<<<<< HEAD
	// renvoie un tableau des pays voisins du pays passÃ© en argument
	public Pays[] listerVoisins(Pays p){
=======
	
// ********** DEBUT METHODE LECTURE ***********
	
	private String Carte ;

	// DEFINITION DU CONSTRUCTEUR DE LA METHODE LECTURE
	public boolean Lecture(String Carte) throws IOException
	{
		this.Carte = Carte ;
	
		// VERIFICATION QUE LE FICHIER SOURCE EXISTE (TRY + CATCH)
		try
		{
			// PREPARATION DE LA LECTURE DU FICHIER SOURCE ENTRE EN ARGUMENT
			BufferedReader tamponLecture = new BufferedReader(new FileReader(Carte)) ;
			String ligne ;
			
			// INITIALISATION DE L'INDEX DU TABLEAU "PAYS"
			int index = 0 ;
			
			// LECTURE DU FICHIER SOURCE
			while ((ligne = tamponLecture.readLine()) != null)
			{
				// UTILISATION DU SEPARATEUR " " POUR RECUPERER LES DIFFERENTS ELEMENTS
				StringTokenizer donnee = new StringTokenizer(ligne," ") ;
				
				// RECUPERATION DU NOM ET DES COORDONNEES
				String nom = donnee.nextToken() ;
				String xmin = donnee.nextToken() ;
				String ymin = donnee.nextToken() ;
				String xmax = donnee.nextToken() ;
				String ymax = donnee.nextToken() ;
				//System.out.println("nom pays: " + nom + ", coordonnees : " + xmin + ", " + ymin + ", " + xmax + ", " + ymax + '\n') ;
				
				// CREATION D'UNE INSTANCE PAYS DANS LA CASE N° "INDEX" DU TABLEAU "PAYS"
				this.Pays[index] = new Pays(nom, xmin, ymin, xmax, ymax) ;
				index ++ ;
			}
			
			tamponLecture.close() ;
			
			return true ;
		}
		
		// AFFICHAGE D'UN MESSAGE D'ERREUR SI LE FICHIER EN ENTREE N'EXISTE PAS
		catch (FileNotFoundException e)
		{
			System.out.println(e.getMessage());
			
			return false ;
		}
	}

// ********** FIN METHODE LECTURE ***********
	

	
// ********** DEBUT METHODE ECRITURE ***********

	private String CartePeinte ;

	// DEFINITION DU CONSTRUCTEUR DE LA METHODE LECTURE
	public boolean Ecriture(String CartePeinte)
	{
		this.CartePeinte = CartePeinte ;

		// PREPARATION DE L'ECRITURE DANS UN FICHIER CIBLE ENTRE EN ARGUMENT
		FileWriter resultat = new FileWriter(CartePeinte) ;
		BufferedWriter tamponEcriture = new BufferedWriter(resultat) ;
					
		// RECUPERATION DES PAYS A PARTIR DU TABLEAU "PAYS"
		int index = 0 ;
					
		while (Pays[index])
		{
			tamponEcriture.write(nom + " " + xmin + " " + ymin + " " + xmax + " " + ymax + " " + couleur + '\n') ;
			index ++ ;
		}
					
		tamponEcriture.flush() ;
		tamponEcriture.close() ;
		
		return true ;
	}
	
// ********** FIN METHODE ECRITURE ***********
	
	
	public Pays[] listerVoisins(Pays p)
	{
		
>>>>>>> branch 'master' of https://github.com/robolth/javasalle16
		int index = 0;
		Pays[] result = new Pays[];
		
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
		public Pays[] paysVoisins = listerVoisins(pays) ;
		
		// ON PARCOURT LA LISTE DES PAYS VOISINS
		for ( Pays paysVoisin : paysVoisins )
		{
			// SI LE PAYS VOISIN EST DEJA COLORIE ON ENLEVE SA COULEUR DE LA PALETTE DES COULEURS DISPOS
			if ( paysVoisin.getdejaColorie == true )
				palette.remove(paysVoisin.getCouleur); 
		}
		
		// S'IL Y A DES COULEURS POSSIBLES DANS LA PALETTE, ON COLORIE LE 
		// PAYS AVEC LA PREMIERE COULEUR DISPONIBLE ET ON RENVOIE TRUE
		if (pays.getPaletteDisponible.length != 0)
		{
			pays.setCouleur(pays.getPaletteDisponible[0]);
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
