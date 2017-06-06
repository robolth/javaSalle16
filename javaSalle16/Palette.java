package javaSalle16;

import java.awt.Color;

public class Palette {

	private Color[] couleurs;

	public Palette(){
		
		couleurs = new Color[] {Color.blue, Color.green, Color.yellow, Color.red};
	}
	
	
	public void remove(Color couleur){
		
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
	
	
}
