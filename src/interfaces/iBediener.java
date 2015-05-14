package interfaces;

import klassen.Spieler;
import klassen.eFarben;


public interface iBediener {

//	void spielerwaehltfarbe(FarbEnum farbe);
	void spielStart();
//	void wuerfelnLassen();
//	void figurAuswaehlen(Spielfigur figur);
	void laufen(int figurId);
	void startPosZuweisen(Spieler spieler,int figur);
//	void wuerfeln();
	

}

