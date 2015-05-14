package klassen;

import java.io.Serializable;

public class Spielfigur  implements Serializable {
	private static final long serialVersionUID = 1L; 
 
 
	private eFarben farbe;
	private int figurId;
	private Spielfeld feld;
	private Spieler player;
 
	
	/**
	 * Der Konstruktor
	 * @param farbe ist die Farbe der Spielfigur
	 */
	public Spielfigur(eFarben farbe, int figurId, Spielfeld feld) {
		this.setFigurId(figurId);
		this.setFarbe(farbe);
		this.setFeld(feld);
		this.setPlayer(player);
	}
 
 
	/**
	 * die Figur ID des jeweiligen Spielers wird gesetzt
	 * @param figurID ist die Spielfigur ID eines Spielers
	 */
	// -------Setter & Getter-----------
	public void setFigurId(int figurId) {
		if(figurId>=1&&figurId<=4){
			this.figurId = figurId;
		}
		else{
			throw new RuntimeException("Id darf nur von 1 bis 4 sein !");
		}
	}
	
	/**
	 * Die Figur ID des jeweiligen Spielers wird zurueck gegeben
	 * @return figurID ist die Spielfigur ID eines Spielers
	 */
	public int getFigurId() {
		return figurId;
	}
	
	/**
	 * die Farbe der Spielfigur wird zurueck gegeben
	 * @return farbe ist die Farbe der Spielfigur
	 */
	public eFarben getFarbe() {
		return farbe;
	}
	
	/**
	 * die Farbe der Spielfigur wird gesetzt
	 * @param farbe ist die Farbe der Spielfigur
	 */
	public void setFarbe(eFarben farbe){
		if(farbe==null){
			throw new RuntimeException("Eine Figur muss ein Farbe haben!");
		}
		this.farbe = farbe;
		
	}
	
	/**
	 * das Spielfeld der darauf stehenden Spielfigur wird zurueck gegeben
	 * @return spielfeld ist das momentane Spielfeld einer Spielfigur
	 */
	public Spielfeld getFeld() {		
		return feld;
	}
	
	/**
	 * das Spielfeld der darauf stehenden Spielfigur wird gesetzt
	 * @param spielfeld ist das momentane Spielfeld einer Spielfigur
	 */
	public void setFeld(Spielfeld feld){
//		if(feld==null){
//			throw new RuntimeException("figur hat kein feld !");
//		}
		
//		if(this.getFarbe()!=feld.getFarbe() && feld.getFarbe()!=null){
//			throw new RuntimeException("farbe muss gleich sein"); 
//		}
		
		
		this.feld = feld;
	}
	
	/**
	 * gibt den spieler der figur aus
	 * @return player ist der spieler von dieser figur
	 */
	public Spieler getPlayer() {
		return player;
	}

	/**
	 * setzt eine figur auf ein spieler
	 * @param player ist der spieler von dieser figur
	 */
	public void setPlayer(Spieler player) {
//		if (player==null){
//			throw new RuntimeException("Figur kann ohne Spieler nicht erzeugt werden !");
//		}
		this.player = player;
	}
	// -------------------------------
	
	
	
 
	@Override
	public String toString() {
		return 
				("Farbe: " + getFarbe() + 
				" | "+ "ID: "+ getFigurId()
//				+" --- "+"Position: "+ getFeld()//.getId()     // .getId() nicht kommentieren wen stack overflow kommt
				);			
	}




}