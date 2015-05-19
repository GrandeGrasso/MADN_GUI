package Datenaustausch;



import interfaces.iDatenzugriff;


import java.io.PrintWriter;

import klassen.FarbEnum;
import klassen.Spiel;
import klassen.Spieler;
public class SpielTestSpeichernCSV {
	public static void main(String[] args) {
		PrintWriter pw = null;
		iDatenzugriff d=new DatenzugriffSerialisiert();
		Spiel spiel1=new Spiel();
		Spieler s1=new Spieler("Kati",FarbEnum.BLAU, null);
	
		spiel1.nimmtTeil(s1);
//		spiel1.nimmtTeil(s1);
		
		
		spiel1.spielStart();

		System.out.println("Hallo");
		d.speichern(spiel1, "test6.csv");
	}
}
