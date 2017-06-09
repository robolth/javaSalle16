package colorier_carte;

import java.awt.Color;

public class Palette {

	public Color[] couleurs;

	public Palette(){
		
		couleurs = new Color[] {Color.blue, Color.green, Color.yellow, Color.red};
		
	}
	
	public Color premiereCouleurDisponible(){
		
		for(Color c : this.couleurs) {
			if(c == Color.red || c == Color.blue || c == Color.green || c == Color.yellow){				
				return c;							
			}
		}		
		System.out.println("Palette.premiereCouleurDisponible() : ERREUR");
		return Color.gray;
	}
	
	
	public void printCouleurs(){
		for(Color c : this.couleurs) {
			System.out.println("Palette.printCouleurs : " + c);
		}	
		
	}
	
	
	public void remove(Color couleurARetirer){

//		System.out.println("Palette.remove(" + couleurARetirer + ")");		
//		this.printCouleurs();		
		for(int index = 0 ; index < this.couleurs.length; index++) {
			if(this.couleurs[index] == couleurARetirer){				
				this.couleurs[index] = Color.gray;							
			}			
		}
	
//		System.out.println("\nAprès remove");		
//		this.printCouleurs();		
		
		//Color[] tempCouleurs = new Color[this.couleurs.length - 1];

// DEPRECATED
/*		for(int i=0; i < couleurs.length; i++) {
			if(couleurs[i]==couleur){				
				for(int j = i; j < couleurs.length -1; j++){
					
					
					couleurs[j] = couleurs[j+1];
					
					
					
				}
								
			}			
		}		
*/
	}
	
	public void reset(){
		couleurs = new Color[] {Color.blue, Color.green, Color.yellow, Color.red};
	}
	
	public boolean contains(Color c){
		for(Color d : couleurs) {
			if(d == c){
				return true;
			}			
		}		
		return false;
	}
	
	public boolean estVide()
	{
		for (Color c : this.couleurs)
		{
			if (c == Color.red || c == Color.blue || c == Color.green || c == Color.yellow)
			{
				return false;
			}
				
		}
		return true;
	}
	
	
}
