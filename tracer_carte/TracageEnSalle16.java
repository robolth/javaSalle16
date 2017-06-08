package tracer_carte;

public class TracageEnSalle16 
{
	private Vue vue ;

	public TracageEnSalle16()
	{
		vue = new Vue();
		new Controleur(vue);
	}
	
	public static void main (String [] args)
	{
		new TracageEnSalle16() ;
	}
}
