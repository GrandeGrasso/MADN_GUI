package Datenaustausch;

import klassen.eFarben;
import klassen.Spiel;
import klassen.Spieler;
import interfaces.iDatenzugriff;



/**
 * Klasse zum testen von speichern
 * @author Gruppe A2
 *
 */
public class SpielTestSpeichern {
	public static void main(String []args){
		iDatenzugriff d=new DatenzugriffSerialisiert();
		Spiel spiel1=new Spiel();
		Spieler s1=new Spieler("Kati",eFarben.ROT, null);
		spiel1.nimmtTeil(s1);
		
		spiel1.spielStart();
		d.speichern(spiel1, "test.ser");
		
		System.out.println(spiel1.getBrett());
	}

}
