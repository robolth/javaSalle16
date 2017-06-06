package javaSalle16;

// test Francois est-ce que tu me recois ???

public class Carte {

	private Pays[] pays;
	
	public Carte(){
		pays = new Pays[];		
	}
	
	public Pays[] listerVoisins(Pays p){
		
		int index = 0;
		
		Pays[] result = new Pays[];
		
		for(Pays q:pays){
			if(p.estVoisin(q)){
				result[index] = q;
				index++;
			}
		}
		
		return result;
		
	}
	
	
	
	
	
}
