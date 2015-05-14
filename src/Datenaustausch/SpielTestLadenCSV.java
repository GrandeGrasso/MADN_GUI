package Datenaustausch;

import klassen.Spiel;
import interfaces.iDatenzugriff;



public class SpielTestLadenCSV {
	public static void main(String[] args) {
		iDatenzugriff d =new DatenzugriffSerialisiert();
		//d= new DatenzugriffSerialisiert();
		Spiel s = (Spiel)d.laden("test6.csv");
		
	}
}
