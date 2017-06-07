package javaSalle16;

import java.io.IOException;
import java.util.Scanner;

// Cette classe initialise une carte (modèle), une vue et un controleur
public class ColoriageEnSalle16 {

	private Carte carte;
	private Vue vue;
	
	
	// Le constructeur prendra en argument l'adresse du fichier à colorer
	public ColoriageEnSalle16() throws IOException{

		Parser parser = new Parser();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir l'adresse de la carte à colorier : ");
		String adresse = sc.nextLine();
		
		if (parser.lecture(adresse))
		{
			this.carte = parser.getCarte();
			System.out.println("ColoriageEnSalle16 : génération de la carte terminée");

			parser.ecriture(adresse + "_colorie.txt");
		
		}
		else 
		{
		System.out.println("ColoriageEnSalle16 : la carte n'a pas pu être générée");	
		}
		
		vue = new Vue(this.carte);	
		
		this.carte.peindre();
		
		

		
		
//		new Controleur(vue);
	}
	
	
	public static void main(String[] args) throws IOException {

		new ColoriageEnSalle16();
	
		
//		new ColoriageEnSalle16(args[0]);
	}

}
