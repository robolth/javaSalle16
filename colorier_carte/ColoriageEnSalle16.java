package colorier_carte;

import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import javax.swing.JFileChooser;

// Cette classe initialise une carte (modèle), une vue et un controleur
public class ColoriageEnSalle16 {

	private Carte carte;
	private Vue vue;
	
	// Le constructeur prendra en argument l'adresse du fichier à colorer
	public ColoriageEnSalle16() throws IOException, InterruptedException{

		Parser parser = new Parser();
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Veuillez saisir l'adresse de la carte à colorier : ");
		
		
		JFileChooser dialogue = new JFileChooser();
		dialogue.showOpenDialog(null);
		System.out.println(dialogue.getSelectedFile());
		String adresse = dialogue.getSelectedFile().getAbsolutePath();
		
		if (parser.lecture(adresse))
		{
			this.carte = parser.getCarte();
			System.out.println("ColoriageEnSalle16.ColoriageEnSalle16() : instance de Carte créée");

//			parser.ecriture(adresse + "_colorie.txt");
		
		}
		else 
		{
		System.out.println("ColoriageEnSalle16 : la carte n'a pas pu être générée");	
		}
		
		vue = new Vue(this.carte);	
		
		this.carte.peindre();
		
		

		
		
//		new Controleur(vue);
	}
	
	
	public static void main(String[] args) throws IOException, InterruptedException {

		new ColoriageEnSalle16();
	
		
//		new ColoriageEnSalle16(args[0]);
	}

}
