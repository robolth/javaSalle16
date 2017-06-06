

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class CarteLocal 
{

	private Pays[] pays;
	
	public CarteLocal()
	{
		pays = new Pays[0];		
	}

	
	
// ********** DEBUT METHODE LECTURE ***********
	
	// DEFINITION DES PARAMETRES UTILISES PAR LA METHODE LECTURE
	private String Carte ;

	// DEFINITION DU CONSTRUCTEUR DE LA METHODE LECTURE
	public void Lecture(String Carte) throws IOException
	{
		this.Carte = Carte ;
	
		// VERIFICATION QUE LE FICHIER EXISTE (TRY + CATCH)
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
				
				// CREATION D'UNE INSTANCE PAYS DANS LA CASE INDEX DU TABLEAU "PAYS"
				this.Pays[index] = new Pays(nom, xmin, ymin, xmax, ymax) ;
				index ++ ;
			}
			tamponLecture.close() ;
		}
		
		// AFFICHAGE D'UN MESSAGE D'ERREUR SI LE FICHIER EN ENTREE N'EXISTE PAS
		catch (FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
	}

// ********** FIN METHODE LECTURE ***********
	
	
	
	public Pays[] listerVoisins(Pays p)
	{
		
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
