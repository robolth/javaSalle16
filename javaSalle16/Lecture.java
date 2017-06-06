package javaSalle16;

//IMPORT DES BIBLIOTHEQUES NECESSAIRES
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


//CREATION DE LA CLASSE LECTURE
public class Lecture 
{
	// DEFINITION DES PARAMETRES UTILISES PAR LA CLASSE LECTURE
	private String Carte ;
	private String CartePeinte ;

	// DEFINITION DU CONSTRUCTEUR DE LA CLASSE LECTURE (QUI DOIT PORTER LE MEME NOM)
	public Lecture(String Carte, String CartePeinte) throws IOException
	{
		// AFFECTATION DES PARAMETRES DE L'INSTANCE UTILISEE EN ENTREE VERS LES VARIABLES
		this.Carte = Carte ;
		this.CartePeinte = CartePeinte ;
	
		// VERIFICATION QUE LE FICHIER EXISTE (TRY + CATCH)
		try
		{
			// PREPARATION DE LA LECTURE DU FICHIER SOURCE ENTRE EN ARGUMENT
			BufferedReader tamponLecture = new BufferedReader(new FileReader(Carte)) ;
			String ligne ;
			
			// LECTURE DU FICHIER SOURCE
			while ((ligne = tamponLecture.readLine()) != null)
			{
				System.out.println(ligne) ;
				
				// UTILISATION DU SEPARATEUR " " POUR RECUPERER LES DIFFERENTS ELEMENTS
				StringTokenizer donnee = new StringTokenizer(ligne," ") ;
				
				// RECUPERATION DU NOM ET DES COORDONNEES
				String nom = donnee.nextToken() ;
				String xmin = donnee.nextToken() ;
				String ymin = donnee.nextToken() ;
				String xmax = donnee.nextToken() ;
				String ymax = donnee.nextToken() ;
				System.out.println("nom pays: " + nom + ", coordonnees : " + xmin + ", " + ymin + ", " + xmax + ", " + ymax + '\n') ;
				
				// CREATION D'UNE NOUVELLE INSTANCE DE LA CLASSE "PAYS A PARTIR DES ARGUMENTS RECUPERES DU FICHIER SOURCE "CARTE"
				 // new Pays(String nom, int xmin, int, ymin, int xmax, int ymax) ;
			}
			tamponLecture.close() ;
		}
		
		// AFFICHAGE D'UN MESSAGE D'ERREUR SI LE FICHIER N'EXISTE PAS
		catch (FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void main(String[] args)
	{
		try
		{
			new Lecture("src/Carte_15.txt", "./CartePeinte.txt") ;
		}
		
		catch (IOException e)
		{
			e.getMessage() ;
		}
	}

}
