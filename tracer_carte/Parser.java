package tracer_carte;

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
	private Collection collection ;

	public Parser (Collection c) //throws IOException
	{
		this.collection = c;
	}
		
		
// ********** DEBUT METHODE ECRITURE ***********

	// DEFINITION DU CONSTRUCTEUR DE LA METHODE LECTURE
	public boolean ecriture(String Carte) throws IOException
	{
		
		
		// PREPARATION DE L'ECRITURE DANS UN FICHIER CIBLE ENTRE EN ARGUMENT
		FileWriter resultat = new FileWriter(Carte) ;
		BufferedWriter tamponEcriture = new BufferedWriter(resultat) ;
		
		// VARIABLES UTILISEES POUR ATTRIBUER UN NOM AUX RECTANGLES
		String NomRectangle ;
		int index = 0 ;
		
		// ECRITURE DANS LE FICHIER CIBLE POUR TOUS LES PAYS P SE TROUVANT DANS L'INSTANCE "PAYS"				
		for (Rectangle r : this.collection.rectangles)
		{
			// ON ATTRIBUE UN NOM A CHACUN DES RECTANGLES
			NomRectangle = "P" + Integer.toString(index);
			
			// ON RECUPERE LES COORDONNEES DES RECTANGLES	
			tamponEcriture.write(NomRectangle + " " + Integer.toString(r.x) + " " + Integer.toString(r.y) + " " + Integer.toString(r.x+r.w) + " " + Integer.toString(r.h+r.y) + "\n") ;
			index ++ ;
		}
						
		tamponEcriture.flush() ;
		tamponEcriture.close() ;
		return true ;

	}

	public Collection getCollection()
	{
		return collection ;
	}

	
// ********** FIN METHODE ECRITURE ***********
	
}
