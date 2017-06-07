package javaSalle16;

// Cette classe initialise une carte (modèle), une vue et un controleur
public class ColoriageEnSalle16 {

	private Carte carte;
// private Vue vue;
	
	
	// Le constructeur prendra en argument l'adresse du fichier à colorer
	public ColoriageEnSalle16(String adresse){
		carte = new Carte(adresse);
//		vue = new Vue(carte);
//		new Controleur(vue);
	}
	
	
	public static void main(String[] args) {

		new ColoriageEnSalle16(args[0]);
	}

}
