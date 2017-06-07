package javaSalle16;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Parser
{
	private Carte carte ;

	public Parser () throws IOException
	{
		carte = new Carte();
	}
	
	// ********** DEBUT METHODE LECTURE ***********

	// DEFINITION DU CONSTRUCTEUR DE LA METHODE LECTURE
	public boolean lecture(String Carte) throws IOException
	{
		
		// VERIFICATION QUE LE FICHIER SOURCE EXISTE (TRY + CATCH)
		try
		{
			// PREPARATION DE LA LECTURE DU FICHIER SOURCE ENTRE EN ARGUMENT
			BufferedReader tamponLecture = new BufferedReader(new FileReader(Carte)) ;
			
			// UTILISATION D'UNE VARIABLE POUR LES LIGNES DU FICHIER SOURCE
			String ligne = "erreur" ;
				
			// LECTURE DU FICHIER SOURCE
			while ((ligne = tamponLecture.readLine()) != null)
			{
				// UTILISATION DU SEPARATEUR " " POUR RECUPERER LES DIFFERENTS ELEMENTS
				StringTokenizer donnee = new StringTokenizer(ligne," ") ;

				// RECUPERATION DU NOM ET DES COORDONNEES SE TROUVANT DANS LE FICHIER SOURCE
				String nom = donnee.nextToken() ;
				String xmin = donnee.nextToken() ;
				String ymin = donnee.nextToken() ;
				String xmax = donnee.nextToken() ;
				String ymax = donnee.nextToken() ;
				
				// TRANSFORMATION DES COORDONNEES DE STRING A INT POUR ETRE COMPREHENSIBLE PAR LA CLASSE "PAYS"
				int xm = Integer.parseInt(xmin) ;
				int ym = Integer.parseInt(ymin) ;
				int xM = Integer.parseInt(xmax) ;
				int yM = Integer.parseInt(ymax) ;
					
				System.out.println("[PARSER] nom pays: " + nom + ", coordonnees : " + xmin + ", " + ymin + ", " + xmax + ", " + ymax) ;
					
				// CREATION D'UNE INSTANCE PAYS
				Pays tempPays = new Pays(nom, xm, ym, xM, yM);
				this.carte.ajouterPays(tempPays) ;
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
	public boolean ecriture(String CartePeinte) throws IOException
	{
		// PREPARATION DE L'ECRITURE DANS UN FICHIER CIBLE ENTRE EN ARGUMENT
		FileWriter resultat = new FileWriter(CartePeinte) ;
		BufferedWriter tamponEcriture = new BufferedWriter(resultat) ;
		
		// UTILISATION DE L'INDEX POUR L'ORDRE DE COLORIAGE
		int indexColoriage = 0 ;
						
		// ECRITURE DANS LE FICHIER CIBLE POUR TOUS LES PAYS P SE TROUVANT DANS L'INSTANCE "PAYS"				
		for (Pays p : this.carte.getPays())
		{
			// TRANSFORMATION DE LA DONNEE COULEUR EN CODE COULEUR COMPREHENSIBLE PAR LA MACRO EXCEL
			Color couleur = p.getCouleur() ;
			int codeCouleur = 0 ;

			if (couleur == Color.red ) { codeCouleur = 1 ; } 
			if (couleur == Color.blue ) { codeCouleur = 2 ; }
			if (couleur == Color.yellow ) { codeCouleur = 3 ; }
			if (couleur == Color.red ) { codeCouleur = 4 ; }
			else { codeCouleur = 1 ; }
			
			// ON DIVISE LES VALEURS PAR 10 AFIN DE RESPECTER LE FORMAT DE LA MACRO EXCEL ET ON AJOUTE UN INDEX D'ORDRE DE COLORIAGE			
			tamponEcriture.write(p.getNom() + "	" + p.getXmin()/10 + " 	" + p.getYmin()/10 + " 	" + p.getXmax()/10 + " 	" + p.getYmax()/10 + " 	" + codeCouleur + " 	" + indexColoriage + '\n') ;
			indexColoriage ++ ;
		}
						
		tamponEcriture.flush() ;
		tamponEcriture.close() ;
		return true ;
	}

	public Carte getCarte()
	{
		return carte ;
	}
	
// ********** FIN METHODE ECRITURE ***********
	
}
