package Datenaustausch;

import klassen.Spiel;
import interfaces.iDatenzugriff;



/**
 * klasse zum testen ob CSV geladen werden kann
 * @author Gruppe A2
 *
 */
public class SpielTestLadenCSV {
	public static void main(String[] args) {
		iDatenzugriff d =new DatenzugriffSerialisiert();
		//d= new DatenzugriffSerialisiert();
		Spiel s = (Spiel)d.laden("test6.csv");
		
	}
}
