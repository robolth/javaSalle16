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

// fonction qui cherche une couleur pour colorier un pays
// si elle trouve une couleur qui n'est pas en conflit avec celles des pays
// voisins, la fonction renvoie true. Si aucune couleur ne peut etre utilisee
// elle renvoie false.
	
	public boolean colorier (Pays pays)
	{
		// liste des pays voisins
		
	}
	
	
	
}
