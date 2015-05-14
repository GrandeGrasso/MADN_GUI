package klassen;

import java.io.Serializable;


 
public class KI_Aggressiv extends KI implements Serializable {
	private static final long serialVersionUID = 1L;
 
//	private boolean kannSchlagen = false;
//	private boolean kannLaufen = false;
//	private boolean kannRaus = false;
 
	/**
	 * der Konstruktor der Klasse KI Aggressiv
	 * @param spieler ist die KI 
	 */
 
	public KI_Aggressiv(Spiel spiel) {
		super(spiel);
		}
 
	/**
	 * die Methode ErmittleZuSpielendeFigur aus der Oberklasse KI wird �berschrieben
	 */
 
	@Override
	public Spielfigur ErmittleZuSpielendeFigur(Spieler aktuellerSpieler, int letzterWurf ){
		
		Spielfigur ergebnis = null;
		
		Spielfigur rausgeher = ErmittleKannRaus();
		Spielfigur schlaeger = ErmittleWertVonKannSchlagen();
		Spielfigur laeufer = ErmittleKannLaufenUndWer();
		
		
		
		if(kannSchlagen==true){
			ergebnis = schlaeger;
			}
		else if (kannRaus==true){
			ergebnis = rausgeher;
			}
		else if (kannLaufen==true){
			ergebnis = laeufer;
			}
		return ergebnis;
		}
	
	}