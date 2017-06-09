package tracer_carte;

import java.io.IOException;

public class TracageEnSalle16 
{
	private Vue vue ;
	public TracageEnSalle16()
	{
		vue = new Vue();
		new Controleur(vue);	
	}
	
	public static void main (String [] args) throws IOException
	{
		new TracageEnSalle16() ;
	}
}
