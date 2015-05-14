package Datenaustausch;

import klassen.Spiel;
import interfaces.iDatenzugriff;



public class SpielTestLaden {
	

	public static void main(String[] args) {
		iDatenzugriff d =new DatenzugriffSerialisiert();
		//d= new DatenzugriffSerialisiert();
		Spiel s = (Spiel)d.laden("test.ser");
		//iBediener p = (Spiel) d.laden();
		
	}

}
