package javaSalle16;

import java.io.IOException;

// Cette classe initialise une carte (modèle), une vue et un controleur
public class ColoriageEnSalle16 {

	private Carte carte;
// private Vue vue;
	
	
	// Le constructeur prendra en argument l'adresse du fichier à colorer
	public ColoriageEnSalle16(String adresse) throws IOException{

		Parser parser = new Parser();
		if (parser.lecture(adresse))
		{
			this.carte = parser.getCarte();
			System.out.println("ColoriageEnSalle16 : génération de la carte terminée");
			this.carte.peindre();
			parser.ecriture(adresse + "_colorie.txt");
		
		}
		else 
		{
		System.out.println("ColoriageEnSalle16 : la carte n'a pas pu être générée");	
		}
		
	
//		vue = new Vue(carte);
//		new Controleur(vue);
	}
	
	
	public static void main(String[] args) throws IOException {

		new ColoriageEnSalle16("/Users/mathieujuttet/Desktop/Cartes/Carte_0.txt");
	
		
//		new ColoriageEnSalle16(args[0]);
	}

}
