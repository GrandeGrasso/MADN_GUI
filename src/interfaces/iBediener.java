package interfaces;

import klassen.Spieler;
import klassen.FarbEnum;


public interface iBediener {

	void laufen(int figurId);
	void setWuerfelZahl(Integer wuerfelZahl);
	void wuerfeln();
	void beenden();
	void spielStart();
	void nimmtTeil(Spieler pl);
	void newSpieler(String name, String Farbe, String KI);
//	String updatePos(int indexSpielerAmzug, int figurID);
	String updatePos(int figurID);
	String giveList(int figurID);
	String farbePlayer();
	int ermittleSpielerAmZug();
	int gibFigurKi();
	boolean ermittleGewinner();
	Integer getWuerfelZahl();
	

}

