package javaSalle16;

import java.awt.Color;

public class Palette {

	public Color[] couleurs;

	public Palette(){
		
		couleurs = new Color[] {Color.blue, Color.green, Color.yellow, Color.red};
		
	}
	
	
	public void remove(Color couleur){
			
		Color[] tempCouleurs = new Color[this.couleurs.length - 1];
		
		for(int i=0; i < couleurs.length; i++) {
			if(couleurs[i]==couleur){				
				for(int j = i; j < couleurs.length -1; j++){
					
					
					couleurs[j] = couleurs[j+1];
					
					
					
				}
								
			}			
		}		

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
	
	
}
