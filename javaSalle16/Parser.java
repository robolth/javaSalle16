package javaSalle16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Parser
{
	private Pays[] pays ;

		public Parser ()
	{
		
	}
	
	// ********** DEBUT METHODE LECTURE ***********

	// DEFINITION DU CONSTRUCTEUR DE LA METHODE LECTURE
	public boolean Lecture(String Carte) throws IOException
	{
		
		// VERIFICATION QUE LE FICHIER SOURCE EXISTE (TRY + CATCH)
		try
		{
			// PREPARATION DE LA LECTURE DU FICHIER SOURCE ENTRE EN ARGUMENT
			BufferedReader tamponLecture = new BufferedReader(new FileReader(Carte)) ;
			
			// UTILISATION D'UNE VARIABLE POUR LES LIGNES DU FICHIER SOURCE
			String ligne = "erreur" ;
				
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
				
				int xm = Integer.parseInt(xmin) ;
				int ym = Integer.parseInt(ymin) ;
				int xM = Integer.parseInt(xmax) ;
				int yM = Integer.parseInt(ymax) ;
				
				
				//System.out.println("nom pays: " + nom + ", coordonnees : " + xmin + ", " + ymin + ", " + xmax + ", " + ymax + '\n') ;
					
				// CREATION D'UNE INSTANCE PAYS DANS LA CASE N� "INDEX" DU TABLEAU "PAYS"
				this.pays[index] = new Pays(nom, xm, ym, xM, yM) ;
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


	// DEFINITION DU CONSTRUCTEUR DE LA METHODE LECTURE
	public boolean Ecriture(String CartePeinte) throws IOException
	{


		// PREPARATION DE L'ECRITURE DANS UN FICHIER CIBLE ENTRE EN ARGUMENT
		FileWriter resultat = new FileWriter(CartePeinte) ;
		BufferedWriter tamponEcriture = new BufferedWriter(resultat) ;
						
						
		for (Pays p : this.pays)
		{
			tamponEcriture.write(p.getNom() + " " + p.getXmin() + " " + p.getYmin() + " " + p.getXmax() + " " + p.getYmax() + " " + p.getCouleur() + '\n') ;
	
		}
						
		tamponEcriture.flush() ;
		tamponEcriture.close() ;
			
		return true ;
	}
		
	// ********** FIN METHODE ECRITURE ***********

	
}
