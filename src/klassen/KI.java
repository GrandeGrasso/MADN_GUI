package klassen;

/**
 * eine Klasse fuer die KI
 * @author A2
 *
 */
 
import java.io.Serializable;
import java.util.ArrayList;
 
 abstract class KI implements Serializable{
	private static final long serialVersionUID = 1L;
 
	private Spiel spiel;
	private Spieler spieler;
	private Spielfigur figur;
	private Spielbrett brett;
	private ArrayList <Integer> wegUebrig = new ArrayList <Integer>();
	protected boolean kannSchlagen = false;
	protected boolean kannLaufen = false;
	protected boolean kannRaus = false;
 
 
	/**
	 * der Konstruktor der Klasse mit der Komposition zu Spieler
	 * @param spieler ist der Spieler
	 */
 
	public KI (Spiel spiel){
		this.setKannSchlagen(kannSchlagen);
		this.setKannLaufen(kannLaufen);
		this.setKannRaus(kannRaus);
		this.setSpiel(spiel);
		
		}
 
	/**
	 * Vorgangsberechnungen des naechsten Zuges der KI
	 */
	public abstract Spielfigur ErmittleZuSpielendeFigur(Spieler aktuellerSpieler, int letzterWurf );
 
 
//	 GETTER SETTER ANFANG--------
 
	/**
	 * das Spiel wird zurueck gegeben
	 * @return spiel ist das Spiel
	 */
	public Spiel getSpiel() {
		return spiel;
	}
 
	/**
	 * das Spiel wird gesetzt
	 * @param spiel ist das Spiel
	 */
 
	public void setSpiel(Spiel spiel) {
		this.spiel = spiel;
	}
 
	/**
	 * die boolsche Antwort ob geschlagen werden kann wird zurueck gegeben
	 * @return kannSchlagen ist die boolsche Antwort ob geschlagen werden kann
	 */
 
	public boolean getKannSchlagen(){
		return kannSchlagen;
	}
	/**
	 * die boolsche Antwort ob geschlagen werden kann wird gesetzt
	 * @param kannSchlagen ist die boolsche Antwort ob geschlagen werden kann
	 */
 
 
	public void setKannSchlagen(boolean kannSchlagen){
		this.kannSchlagen=kannSchlagen;
	}
 /**
  * die boolsche Antwort ob gelaufen werden kann wird zurueck gegeben
  * @return kannLaufen ist die boolsche Antwort ob gelaufen werden kann
  */
	public boolean getKannLaufen(){
		return kannLaufen;
	}
 
	/**
	 * die boolsche Antwort ob gelaufen werden kann wird gesetzt
	 * @param kannLaufen ist die boolsche Antwort ob gelaufen werden kann
	 */
 
	public void setKannLaufen(boolean kannLaufen){
		this.kannLaufen=kannLaufen;
	}
 
	/**
	 * die boolsche Antwort ob man rausgehen kann wird zurueck gegeben
	 * @return kannRaus ist die boolsche Antwort ob rausgegangen werden kann
	 */
 
	public boolean getKannRaus(){
		return kannRaus;
	}
 
	/**
	 * die boolsche Antwort ob man rausgehen kann wird gesetzt
	 * @param kannRaus ist die boolsche Antwort ob rausgegangen werden kann
	 */
 
	public void setKannRaus(boolean kannRaus){
		this.kannRaus=kannRaus;
	}
 
	/**
	 * der Spieler wird zurueckgegeben
	 * @return spieler ist der Spieler
	 */
	public Spieler getSpieler(){
		return this.spieler;
	}
 
//	GETTER & SETTER ENDE--------
 
	/**
	 * mit dieser Methode wird ermittelt ob der Spieler am Zug also die KI in richtung Endfeld laufen kann 
	 * @return ergebnis ist das Ergebnis welche Spielfigur bewegt werden soll
	 */
	public Spielfigur ErmittleKannLaufenUndWer() {
		Spielfigur ergebnis= null;
		try{
			if (this.spiel.getSpielerAmZug().getFarbe() == eFarben.ROT) {
				if (this.spiel.bestand(this.spiel.getBrett().getStartRot()) == 4) {
					kannLaufen=false;
					} else if (this.spiel.bestand(this.spiel.getBrett().getStartRot()) == 3) {
						
						for(Spielfeld feld : this.spiel.getBrett().getWeg()){
							
							if(feld.istFeldBelegt()==true&&feld.getFigur().getFarbe()==this.spiel.getSpielerAmZug().getFarbe()){
							
								ergebnis = feld.getFigur();
								kannLaufen=true;
								break;
							
							}else{
									kannLaufen=false;
									
									
									
									
							}		}
						
						} else if (this.spiel.bestand(this.spiel.getBrett().getStartRot())== 2) {
							Spielfigur b;
							int wegMax = 39;
							for (Spielfeld a : this.spiel.getBrett().getWeg()) {
								if (this.spiel.getBrett().getFeld().istFeldBelegt() == true) {
									if (this.figur.getFarbe() == eFarben.ROT) {
										b = a.getFigur();
										int c = a.getBrett().getWeg().indexOf(b);
										// int wegUebrig_k = wegMax-c;
										wegUebrig.add(wegMax - c);
										}
									}
								if (wegUebrig.get(0) < wegUebrig.get(1)) {
									ergebnis = this.spiel.getBrett().getWeg().get(wegMax - wegUebrig.get(0)).getFigur();
									//spiel.laufen(this.brett.getWeg().get(wegMax - wegUebrig.get(0)).getFigur().getId());
									} else {
										ergebnis = this.spiel.getBrett().getWeg().get(wegMax - wegUebrig.get(1)).getFigur();
										}
								}
							kannLaufen=true;
							} else if (this.spiel.bestand(this.spiel.getBrett().getStartRot()) == 1) {
								int min = 0;
								Spielfigur b;
								int wegMax = 39;
								for (Spielfeld a : this.spiel.getBrett().getWeg()) {
									if (this.spiel.getBrett().getFeld().istFeldBelegt() == true) {
										if (this.figur.getFarbe() == eFarben.ROT) {
											b = a.getFigur();
											int c = a.getBrett().getWeg().indexOf(b);
											// int wegUebrig_k = wegMax-c;
											wegUebrig.add(wegMax - c);
											}
										}
									min = this.wegUebrig.get(0);
									if (min > this.wegUebrig.get(1)) {
										//min = this.wegUebrig.get(1);
										ergebnis = this.spiel.getBrett().getWeg().get(this.wegUebrig.get(1)).getFigur();
										} else {
											ergebnis = null;
											//return;
											}
									if (min > this.wegUebrig.get(2)) {
										ergebnis = this.spiel.getBrett().getWeg().get(this.wegUebrig.get(2)).getFigur();
										//min = this.wegUebrig.get(2);
										} else {
											ergebnis = null;
											}
									//spiel.laufen(min);
									}
								kannLaufen=true;
								} else if (this.spiel.bestand(this.spiel.getBrett().getStartRot()) == 0) {
									int min = 0;
									Spielfigur b;
									int wegMax = 39;
									for (Spielfeld a : this.spiel.getBrett().getWeg()) {
										if (this.spiel.getBrett().getFeld().istFeldBelegt() == true) {
											if (this.figur.getFarbe() == eFarben.ROT) {
												b = a.getFigur();
												int c = a.getBrett().getWeg().indexOf(b);
												// int wegUebrig_k = wegMax-c;
												wegUebrig.add(wegMax - c);
												}
											}
										min = this.wegUebrig.get(0);
										if (min >this.wegUebrig.get(1)) {
											//min = this.wegUebrig.get(1);
											ergebnis = this.spiel.getBrett().getWeg().get(this.wegUebrig.get(1)).getFigur();
											} else {
												ergebnis = null;
												}
										if (min > this.wegUebrig.get(2)) {
											//min = this.wegUebrig.get(2);
											ergebnis = this.spiel.getBrett().getWeg().get(this.wegUebrig.get(2)).getFigur();
											} else {
												ergebnis = null;
												}
										if (min > this.wegUebrig.get(3)) {
											//min = this.wegUebrig.get(3);
											ergebnis = this.spiel.getBrett().getWeg().get(this.wegUebrig.get(3)).getFigur();
											} else {
												ergebnis = null;
												}
										//spiel.laufen(min);
										}
									kannLaufen=true;
									}
				
				}else if (this.spiel.getSpielerAmZug().getFarbe() == eFarben.BLAU) {
					if (this.spiel.bestand(this.spiel.getBrett().getStartBlau()) == 4) {
						kannLaufen=false;
						} else if (this.spiel.bestand(this.spiel.getBrett().getStartBlau()) == 3) {
							for(Spielfeld feld : this.spiel.getBrett().getWeg()){
								if(feld.istFeldBelegt()&&feld.getFigur().getFarbe()==this.spiel.getSpielerAmZug().getFarbe()){
									ergebnis = feld.getFigur();
									kannLaufen=true;
									break;
									}
								}
							} else if (this.spiel.bestand(this.spiel.getBrett().getStartBlau())== 2) {
								Spielfigur b;
								int wegMax = 39;
								for (Spielfeld a : this.spiel.getBrett().getWeg()) {
									if (this.spiel.getBrett().getFeld().istFeldBelegt() == true) {
										if (this.figur.getFarbe() == eFarben.BLAU) {
											b = a.getFigur();
											int c = a.getBrett().getWeg().indexOf(b);
											// int wegUebrig_k = wegMax-c;
											wegUebrig.add(wegMax - c);
											}
										}
									if (wegUebrig.get(0) < wegUebrig.get(1)) {
										ergebnis = this.spiel.getBrett().getWeg().get(wegMax - wegUebrig.get(0)).getFigur();
										//spiel.laufen(this.brett.getWeg().get(wegMax - wegUebrig.get(0)).getFigur().getId());
										} else {
											ergebnis = this.spiel.getBrett().getWeg().get(wegMax - wegUebrig.get(1)).getFigur();
											}
									}
								kannLaufen=true;
								} else if (this.spiel.bestand(this.spiel.getBrett().getStartBlau()) == 1) {
									int min = 0;
									Spielfigur b;
									int wegMax = 39;
									for (Spielfeld a : this.spiel.getBrett().getWeg()) {
										if (this.spiel.getBrett().getFeld().istFeldBelegt() == true) {
											if (this.figur.getFarbe() == eFarben.BLAU) {
												b = a.getFigur();
												int c = a.getBrett().getWeg().indexOf(b);
												// int wegUebrig_k = wegMax-c;
												wegUebrig.add(wegMax - c);
												}
											}
										min = this.wegUebrig.get(0);
										if (min > this.wegUebrig.get(1)) {
											//min = this.wegUebrig.get(1);
											ergebnis = this.spiel.getBrett().getWeg().get(this.wegUebrig.get(1)).getFigur();
											} else {
												ergebnis = null;
												//return;
												}
										if (min > this.wegUebrig.get(2)) {
											ergebnis =this.spiel.getBrett().getWeg().get(this.wegUebrig.get(2)).getFigur();
											//min = this.wegUebrig.get(2);
											} else {
												ergebnis = null;
												}
										//spiel.laufen(min);
										}
									kannLaufen=true;
									} else if (this.spiel.bestand(this.spiel.getBrett().getStartBlau()) == 0) {
										int min = 0;
										Spielfigur b;
										int wegMax = 39;
										for (Spielfeld a :this.spiel.getBrett().getWeg()) {
											if (this.spiel.getBrett().getFeld().istFeldBelegt() == true) {
												if (this.figur.getFarbe() == eFarben.BLAU) {
													b = a.getFigur();
													int c = a.getBrett().getWeg().indexOf(b);
													// int wegUebrig_k = wegMax-c;
													wegUebrig.add(wegMax - c);
													}
												}
											min = this.wegUebrig.get(0);
											if (min >this.wegUebrig.get(1)) {
												//min = this.wegUebrig.get(1);
												ergebnis =this.spiel.getBrett().getWeg().get(this.wegUebrig.get(1)).getFigur();
												} else {
													ergebnis = null;
													}
											if (min > this.wegUebrig.get(2)) {
												//min = this.wegUebrig.get(2);
												ergebnis =this.spiel.getBrett().getWeg().get(this.wegUebrig.get(2)).getFigur();
												} else {
													ergebnis = null;
													}
											if (min > this.wegUebrig.get(3)) {
												//min = this.wegUebrig.get(3);
												ergebnis = this.spiel.getBrett().getWeg().get(this.wegUebrig.get(3)).getFigur();
												} else {
													ergebnis = null;
													}
											//spiel.laufen(min);
											}
										kannLaufen=true;
										}
					
					}else if (this.spiel.getSpielerAmZug().getFarbe() == eFarben.GRUEN) {
						if (this.spiel.bestand(this.spiel.getBrett().getStartGruen()) == 4) {
							kannLaufen=false;
							} else if (this.spiel.bestand(this.spiel.getBrett().getStartGruen()) == 3) {
								for(Spielfeld feld :this.spiel.getBrett().getWeg()){
									if(feld.istFeldBelegt()&&feld.getFigur().getFarbe()==this.spiel.getSpielerAmZug().getFarbe()){
										ergebnis = feld.getFigur();
										kannLaufen=true;
										break;
										}
									}
								} else if (this.spiel.bestand(this.spiel.getBrett().getStartGruen())== 2) {
									Spielfigur b;
									int wegMax = 39;
									for (Spielfeld a : this.spiel.getBrett().getWeg()) {
										if (this.spiel.getBrett().getFeld().istFeldBelegt() == true) {
											if (this.figur.getFarbe() == eFarben.GRUEN) {
												b = a.getFigur();
												int c = a.getBrett().getWeg().indexOf(b);
												// int wegUebrig_k = wegMax-c;
												wegUebrig.add(wegMax - c);
												}
											}
										if (wegUebrig.get(0) < wegUebrig.get(1)) {
											ergebnis = this.spiel.getBrett().getWeg().get(wegMax - wegUebrig.get(0)).getFigur();
											//spiel.laufen(this.brett.getWeg().get(wegMax - wegUebrig.get(0)).getFigur().getId());
											} else {
												ergebnis =this.spiel.getBrett().getWeg().get(wegMax - wegUebrig.get(1)).getFigur();
												}
										}
									kannLaufen=true;
									} else if (this.spiel.bestand(this.spiel.getBrett().getStartGruen()) == 1) {
										int min = 0;
										Spielfigur b;
										int wegMax = 39;
										for (Spielfeld a : this.spiel.getBrett().getWeg()) {
											if (this.spiel.getBrett().getFeld().istFeldBelegt() == true) {
												if (this.figur.getFarbe() == eFarben.GRUEN) {
													b = a.getFigur();
													int c = a.getBrett().getWeg().indexOf(b);
													// int wegUebrig_k = wegMax-c;
													wegUebrig.add(wegMax - c);
													}
												}
											min = this.wegUebrig.get(0);
											if (min > this.wegUebrig.get(1)) {
												//min = this.wegUebrig.get(1);
												ergebnis = this.spiel.getBrett().getWeg().get(this.wegUebrig.get(1)).getFigur();
												} else {
													ergebnis = null;
													//return;
													}
											if (min > this.wegUebrig.get(2)) {
												ergebnis =this.spiel.getBrett().getWeg().get(this.wegUebrig.get(2)).getFigur();
												//min = this.wegUebrig.get(2);
												} else {
													ergebnis = null;
													}
											//spiel.laufen(min);
											}
										kannLaufen=true;
										} else if (this.spiel.bestand(this.spiel.getBrett().getStartGruen()) == 0) {
											int min = 0;
											Spielfigur b;
											int wegMax = 39;
											for (Spielfeld a : this.spiel.getBrett().getWeg()) {
												if (this.spiel.getBrett().getFeld().istFeldBelegt() == true) {
													if (this.figur.getFarbe() == eFarben.GRUEN) {
														b = a.getFigur();
														int c = a.getBrett().getWeg().indexOf(b);
														// int wegUebrig_k = wegMax-c;
														wegUebrig.add(wegMax - c);
														}
													}
												min = this.wegUebrig.get(0);
												if (min >this.wegUebrig.get(1)) {
													//min = this.wegUebrig.get(1);
													ergebnis = this.spiel.getBrett().getWeg().get(this.wegUebrig.get(1)).getFigur();
													} else {
														ergebnis = null;
														}
												if (min > this.wegUebrig.get(2)) {
													//min = this.wegUebrig.get(2);
													ergebnis = this.spiel.getBrett().getWeg().get(this.wegUebrig.get(2)).getFigur();
													} else {
														ergebnis = null;
														}
												if (min > this.wegUebrig.get(3)) {
													//min = this.wegUebrig.get(3);
													ergebnis =this.spiel.getBrett().getWeg().get(this.wegUebrig.get(3)).getFigur();
													} else {
														ergebnis = null;
														}
												//spiel.laufen(min);
												}
											kannLaufen=true;
											}
						
						}else if (this.spiel.getSpielerAmZug().getFarbe() == eFarben.GELB) {
							if (this.spiel.bestand(this.spiel.getBrett().getStartGelb()) == 4) {
								kannLaufen=false;
								} else if (this.spiel.bestand(this.spiel.getBrett().getStartGelb()) == 3) {
									for(Spielfeld feld : this.spiel.getBrett().getWeg()){
										if(feld.istFeldBelegt()&&feld.getFigur().getFarbe()==this.spiel.getSpielerAmZug().getFarbe()){
											ergebnis = feld.getFigur();
											kannLaufen=true;
											break;
											}
										}
									} else if (this.spiel.bestand(this.spiel.getBrett().getStartGelb())== 2) {
										Spielfigur b;
										int wegMax = 39;
										for (Spielfeld a : this.spiel.getBrett().getWeg()) {
											if (this.spiel.getBrett().getFeld().istFeldBelegt() == true) {
												if (this.figur.getFarbe() == eFarben.GELB) {
													b = a.getFigur();
													int c = a.getBrett().getWeg().indexOf(b);
													// int wegUebrig_k = wegMax-c;
													wegUebrig.add(wegMax - c);
													}
												}
											if (wegUebrig.get(0) < wegUebrig.get(1)) {
												ergebnis =this.spiel.getBrett().getWeg().get(wegMax - wegUebrig.get(0)).getFigur();
												//spiel.laufen(this.brett.getWeg().get(wegMax - wegUebrig.get(0)).getFigur().getId());
												} else {
													ergebnis =this.spiel.getBrett().getWeg().get(wegMax - wegUebrig.get(1)).getFigur();
													}
											}
										kannLaufen=true;
										} else if (this.spiel.bestand(this.spiel.getBrett().getStartGelb()) == 1) {
											int min = 0;
											Spielfigur b;
											int wegMax = 39;
											for (Spielfeld a :this.spiel.getBrett().getWeg()) {
												if (this.spiel.getBrett().getFeld().istFeldBelegt() == true) {
													if (this.figur.getFarbe() == eFarben.GELB) {
														b = a.getFigur();
														int c = a.getBrett().getWeg().indexOf(b);
														// int wegUebrig_k = wegMax-c;
														wegUebrig.add(wegMax - c);
														}
													}
												min = this.wegUebrig.get(0);
												if (min > this.wegUebrig.get(1)) {
													//min = this.wegUebrig.get(1);
													ergebnis = this.spiel.getBrett().getWeg().get(this.wegUebrig.get(1)).getFigur();
													} else {
														ergebnis = null;
														//return;
														}
												if (min > this.wegUebrig.get(2)) {
													ergebnis =this.spiel.getBrett().getWeg().get(this.wegUebrig.get(2)).getFigur();
													//min = this.wegUebrig.get(2);
													} else {
														ergebnis = null;
														}
												//spiel.laufen(min);
												}
											kannLaufen=true;
											} else if (this.spiel.bestand(this.spiel.getBrett().getStartGelb()) == 0) {
												int min = 0;
												Spielfigur b;
												int wegMax = 39;
												for (Spielfeld a : this.spiel.getBrett().getWeg()) {
													if (this.spiel.getBrett().getFeld().istFeldBelegt() == true) {
														if (this.figur.getFarbe() == eFarben.GELB) {
															b = a.getFigur();
															int c = a.getBrett().getWeg().indexOf(b);
															// int wegUebrig_k = wegMax-c;
															wegUebrig.add(wegMax - c);
															}
														}
													min = this.wegUebrig.get(0);
													if (min >this.wegUebrig.get(1)) {
														//min = this.wegUebrig.get(1);
														ergebnis =this.spiel.getBrett().getWeg().get(this.wegUebrig.get(1)).getFigur();
														} else {
															ergebnis = null;
															}
													if (min > this.wegUebrig.get(2)) {
														//min = this.wegUebrig.get(2);
														ergebnis =this.spiel.getBrett().getWeg().get(this.wegUebrig.get(2)).getFigur();
														} else {
															ergebnis = null;
															}
													if (min > this.wegUebrig.get(3)) {
														//min = this.wegUebrig.get(3);
														ergebnis =this.spiel.getBrett().getWeg().get(this.wegUebrig.get(3)).getFigur();
														} else {
															ergebnis = null;
															}
													//spiel.laufen(min);
													}
												kannLaufen=true;
												}
							}
			}
		catch(Exception e){
			e.getMessage();
			}
		return ergebnis;
		}
 
	/**
	 * es wird ermittelt ob der Spieler am Zug also die KI eine gegnerische Spielfigur schlagen kann
	 * @return ergebnis ist das Ergebnis welche Spielfigur bewegt werden soll
	 */
	public Spielfigur ErmittleWertVonKannSchlagen() {
		Spielfigur ergebnis= null;
		try{
			if (this.spiel.getSpielerAmZug().getFarbe() == eFarben.ROT) {
				if (this.spiel.bestand(this.spiel.getBrett().getStartRot()) == 4 && this.spiel.getWuerfelZahl()==6 && this.spiel.getBrett().getWeg().get(0).istFeldBelegt()==true) {
					ergebnis=this.spiel.getBrett().getStartRot().get(0).getFigur();
					kannSchlagen=true;
					
					} else if (this.spiel.bestand(this.spiel.getBrett().getStartRot()) == 3) {
						int z = this.spiel.getBrett().getWeg().indexOf(this.spiel.getSpielerAmZug().getFigurlist().get(0).getFeld());
						
						int posErg = this.spiel.getWuerfelZahl() + z;
						for(Spielfeld feld : this.spiel.getBrett().getWeg()){
							if(feld.istFeldBelegt()&&feld.getFigur().getFarbe()==this.spiel.getSpielerAmZug().getFarbe()){
								if (this.spiel.getBrett().getWeg().get(posErg).istFeldBelegt() == true) {
									if (this.spiel.getBrett().getWeg().get(posErg).getFigur().getFarbe() == this.spiel.getSpielerAmZug().getFarbe()) {
										kannSchlagen=false;
									} else {
											ergebnis = feld.getFigur();
											kannSchlagen = true;
											break;
											}
									}
								}
							} 
						} else if ((this.spiel.bestand(this.spiel.getBrett().getStartRot()) < 3) && (this.spiel.bestand(this.spiel.getBrett().getStartRot()) >= 0)) {
							//this.spiel.spielerAmZug().getFigurlist()
							for(Spielfigur figurLaeufer:this.spiel.getSpielerAmZug().getFigurlist()){
								int z = this.spiel.getBrett().getWeg().indexOf(figurLaeufer.getFeld());
								int posErg = this.spiel.getWuerfelZahl() + z;
								for (Spielfeld a : this.spiel.getBrett().getWeg()) {
									if (this.spiel.getBrett().getFeld().getFigur().getFarbe() == eFarben.ROT) 
									{
										if (this.spiel.getBrett().getWeg().get(posErg).istFeldBelegt() == true) 
										{
											if (this.spiel.getSpielerAmZug().getFigur().getFarbe() == this.spiel.getSpielerAmZug().getFarbe()) 
											{
												kannSchlagen=false;
											} 
											else
											{
												//this.spiel.schlagen(posErg);
												ergebnis= figurLaeufer;
												kannSchlagen = true;
												break;
											}
										}
										else
										{
											break;
										}
										}
									}
								if(kannSchlagen == true){
									ergebnis= figurLaeufer;
									break;
									}
								}
							}
				}else if (this.spiel.getSpielerAmZug().getFarbe() == eFarben.BLAU) {
					if (this.spiel.bestand(this.spiel.getBrett().getStartBlau()) == 4) {
						kannSchlagen=false;
						} else if (this.spiel.bestand(this.spiel.getBrett().getStartBlau()) == 3) {
							int z = this.spiel.getBrett().getWeg().indexOf(this.spiel.getSpielerAmZug().getFigur().getFeld());
							int posErg = this.spiel.getWuerfelZahl() + z;
							for(Spielfeld feld : this.spiel.getBrett().getWeg()){
								if(feld.istFeldBelegt()&&feld.getFigur().getFarbe()==this.spiel.getSpielerAmZug().getFarbe()){
									if (this.spiel.getBrett().getWeg().get(posErg).istFeldBelegt() == true) {
										if (this.spiel.getSpielerAmZug().getFigur().getFarbe() == this.spiel.getSpielerAmZug().getFarbe()) {
											kannSchlagen=false;
											} else {
												ergebnis = feld.getFigur();
												kannSchlagen = true;
												break;
												}
										}
									}
								} 
							} else if ((this.spiel.bestand(this.spiel.getBrett().getStartBlau()) < 3) && (this.spiel.bestand(this.spiel.getBrett().getStartBlau()) >= 0)) {
								//this.spiel.spielerAmZug().getFigurlist()
								for(Spielfigur figurLaeufer:this.spiel.getSpielerAmZug().getFigurlist()){
									int z = this.spiel.getBrett().getWeg().indexOf(figurLaeufer.getFeld());
									int posErg = this.spiel.getWuerfelZahl() + z;
									for (Spielfeld a :this.spiel.getBrett().getWeg()) {
										if (this.spiel.getBrett().getFeld().getFigur().getFarbe() == eFarben.BLAU) {
											if (this.spiel.getBrett().getWeg().get(posErg).istFeldBelegt() == true) {
												if (this.spiel.getSpielerAmZug().getFigur().getFarbe() == this.spiel.getSpielerAmZug().getFarbe()) {
													kannSchlagen=false;
													} else {
														//this.spiel.schlagen(posErg);
														ergebnis= figurLaeufer;
														kannSchlagen = true;
														break;
														}
												}else{
													break;
													}
											}
										}
									if(kannSchlagen == true){
										ergebnis= figurLaeufer;
										break;
										}
									}
								}
					}else if (this.spiel.getSpielerAmZug().getFarbe() == eFarben.GRUEN) {
						if (this.spiel.bestand(this.spiel.getBrett().getStartGruen()) == 4) {
							kannSchlagen=false;
							} else if (this.spiel.bestand(this.spiel.getBrett().getStartGruen()) == 3) {
								int z = this.spiel.getBrett().getWeg().indexOf(this.spiel.getSpielerAmZug().getFigur().getFeld());
								int posErg = this.spiel.getWuerfelZahl() + z;
								for(Spielfeld feld : this.spiel.getBrett().getWeg()){
									if(feld.istFeldBelegt()&&feld.getFigur().getFarbe()==this.spiel.getSpielerAmZug().getFarbe()){
										if (this.spiel.getBrett().getWeg().get(posErg).istFeldBelegt() == true) {
											if (this.spiel.getSpielerAmZug().getFigur().getFarbe() == this.spiel.getSpielerAmZug().getFarbe()) {
												kannSchlagen=false;
												} else {
													ergebnis = feld.getFigur();
													kannSchlagen = true;
													break;
													}
											}
										}
									} 
								} else if ((this.spiel.bestand(this.spiel.getBrett().getStartGruen()) < 3) && (this.spiel.bestand(this.spiel.getBrett().getStartGruen()) >= 0)) {
									//this.spiel.spielerAmZug().getFigurlist()
									for(Spielfigur figurLaeufer:this.spiel.getSpielerAmZug().getFigurlist()){
										int z =this.spiel.getBrett().getWeg().indexOf(figurLaeufer.getFeld());
										int posErg = this.spiel.getWuerfelZahl() + z;
										for (Spielfeld a :this.spiel.getBrett().getWeg()) {
											if (this.spiel.getBrett().getFeld().getFigur().getFarbe() == eFarben.GRUEN) {
												if (this.spiel.getBrett().getWeg().get(posErg).istFeldBelegt() == true) {
													if (this.spiel.getSpielerAmZug().getFigur().getFarbe() == this.spiel.getSpielerAmZug().getFarbe()) {
														kannSchlagen=false;
														} else {
															//this.spiel.schlagen(posErg);
															ergebnis= figurLaeufer;
															kannSchlagen = true;
															break;
															}
													}else{
														break;
														}
												}
											}
										if(kannSchlagen == true){
											ergebnis= figurLaeufer;
											break;
											}
										}
									}
						}else if (this.spiel.getSpielerAmZug().getFarbe() == eFarben.GELB) {
							if (this.spiel.bestand(this.spiel.getBrett().getStartGelb()) == 4) {
								kannSchlagen=false;
								} else if (this.spiel.bestand(this.spiel.getBrett().getStartGelb()) == 3) {
									int z =this.spiel.getBrett().getWeg().indexOf(this.spiel.getSpielerAmZug().getFigur().getFeld());
									int posErg = this.spiel.getWuerfelZahl() + z;
									for(Spielfeld feld :this.spiel.getBrett().getWeg()){
										if(feld.istFeldBelegt()&&feld.getFigur().getFarbe()==this.spiel.getSpielerAmZug().getFarbe()){
											if (this.spiel.getBrett().getWeg().get(posErg).istFeldBelegt() == true) {
												if (this.spiel.getSpielerAmZug().getFigur().getFarbe() == this.spiel.getSpielerAmZug().getFarbe()) {
													kannSchlagen=false;
													} else {
														ergebnis = feld.getFigur();
														kannSchlagen = true;
														break;
														}
												}
											}
										} 
									} else if ((this.spiel.bestand(this.spiel.getBrett().getStartGelb()) < 3) && (this.spiel.bestand(this.spiel.getBrett().getStartGelb()) >= 0)) {
										//this.spiel.spielerAmZug().getFigurlist()
										for(Spielfigur figurLaeufer:this.spiel.getSpielerAmZug().getFigurlist()){
											int z = this.spiel.getBrett().getWeg().indexOf(figurLaeufer.getFeld());
											int posErg = this.spiel.getWuerfelZahl() + z;
											for (Spielfeld a :this.spiel.getBrett().getWeg()) {
												if (this.spiel.getBrett().getFeld().getFigur().getFarbe() == eFarben.GELB) {
													if (this.spiel.getBrett().getWeg().get(posErg).istFeldBelegt() == true) {
														if (this.spiel.getSpielerAmZug().getFigur().getFarbe() == this.spiel.getSpielerAmZug().getFarbe()) {
															kannSchlagen=false;
															} else {
																//this.spiel.schlagen(posErg);
																ergebnis= figurLaeufer;
																kannSchlagen = true;
																break;
																}
														}else{
															break;
															}
													}
												}
											if(kannSchlagen == true){
												ergebnis= figurLaeufer;
												break;
												}
											}
										}
							}
			
			}catch(Exception e){
				e.getMessage();
				}
		return ergebnis;
		}
 
	/**
	 * es wird ermittelt ob eine Figur des Spielers Am Zug also die KI aus ihrer Startbox ins Spiel geholt werden kann
	 * @return ergebnis ist das Ergebnis welche Spielfigur bewegt werden soll
	 */
	public Spielfigur ErmittleKannRaus() {
		Spielfigur ergebnis= null;
 
		try{
			if (this.spiel.getSpielerAmZug().getFarbe() == eFarben.ROT) {
				if ((this.spiel.bestand(this.spiel.getBrett().getStartRot())<=4)&&(this.spiel.bestand(this.spiel.getBrett().getStartRot())>0)){
					for(Spielfeld figurRausgeher:this.spiel.getBrett().getStartRot() ){
						if(figurRausgeher.istFeldBelegt()==true){
					if (this.spiel.getWuerfelZahl() == 6) {
						if (this.spiel.getBrett().getWeg().get(0).getFigur() != null) {
							if (this.spiel.getBrett().getWeg().get(0).getFigur().getFarbe() == eFarben.ROT) {
								kannRaus=false;
								} else {
									//this.spiel.schlagen(1);
									//this.spiel.startPosZuweisen(spiel.getSpielerAmZug());
									
									kannRaus=true;
									ergebnis=figurRausgeher.getFigur();
									break;
									}
							} else {
								//this.spiel.startPosZuweisen(spiel.getSpielerAmZug());
								kannRaus = true;
								ergebnis=figurRausgeher.getFigur();
								break;
								}
					}
						//this.spiel.bewegen(feldzahl, true);
						} else {
							kannRaus=false;
							//this.spiel.spielerAmZug();
							}
					}
					} else if (this.spiel.bestand(this.spiel.getBrett().getStartRot()) == 0) {
						kannRaus=false;
						}
				}else if (this.spiel.getSpielerAmZug().getFarbe() == eFarben.BLAU) {
					if ((this.spiel.bestand(this.spiel.getBrett().getStartBlau())<=4)&&(this.spiel.bestand(this.spiel.getBrett().getStartBlau())>0)){
						for(Spielfeld figurRausgeher:this.spiel.getBrett().getStartBlau() ){
							if(figurRausgeher.istFeldBelegt()==true){
						if (this.spiel.getWuerfelZahl() == 6) {
							if (this.spiel.getBrett().getWeg().get(10).getFigur() != null) {
								if (this.spiel.getBrett().getWeg().get(10).getFigur().getFarbe() == eFarben.BLAU) {
									kannRaus=false;
									} else {
										//this.spiel.schlagen(1);
										//this.spiel.startPosZuweisen(spiel.getSpielerAmZug());
										kannRaus=true;
										ergebnis=figurRausgeher.getFigur();
										break;
										}
								} else {
									//this.spiel.startPosZuweisen(spiel.getSpielerAmZug());
									kannRaus = true;
									ergebnis=figurRausgeher.getFigur();
									break;
									}
						}//this.spiel.bewegen(feldzahl, true);
							} else {
								kannRaus=false;
								//this.spiel.spielerAmZug();
								}
						}
						} else if (this.spiel.bestand(this.spiel.getBrett().getStartBlau()) == 0) {
							kannRaus=false;
							}
					}else if (this.spiel.getSpielerAmZug().getFarbe() == eFarben.GRUEN) {
						if ((this.spiel.bestand(this.spiel.getBrett().getStartGruen())<=4)&&(this.spiel.bestand(this.spiel.getBrett().getStartGruen())>0)){
							for(Spielfeld figurRausgeher:this.spiel.getBrett().getStartGruen() ){
								if(figurRausgeher.istFeldBelegt()==true){
							if (this.spiel.getWuerfelZahl() == 6) {
								if (this.spiel.getBrett().getWeg().get(20).getFigur()  != null) {
									if (this.spiel.getBrett().getWeg().get(20).getFigur().getFarbe() == eFarben.GRUEN) {
										kannRaus=false;
										} else {
											//this.spiel.schlagen(1);
											//this.spiel.startPosZuweisen(spiel.getSpielerAmZug());
											kannRaus=true;
											ergebnis=figurRausgeher.getFigur();
											break;
											}
									} else {
										//this.spiel.startPosZuweisen(spiel.getSpielerAmZug());
										kannRaus = true;
										ergebnis=figurRausgeher.getFigur();
										break;
										}
							}//this.spiel.bewegen(feldzahl, true);
								} else {
									kannRaus=false;
									//this.spiel.spielerAmZug();
							}
								}
							} else if (this.spiel.bestand(this.spiel.getBrett().getStartGruen()) == 0) {
								kannRaus=false;
								}
						}else if (this.spiel.getSpielerAmZug().getFarbe() == eFarben.GELB) {
							if ((this.spiel.bestand(this.spiel.getBrett().getStartGelb())<=4)&&(this.spiel.bestand(this.spiel.getBrett().getStartGelb())>0)){
								for(Spielfeld figurRausgeher:this.spiel.getBrett().getStartGelb() ){
									if(figurRausgeher.istFeldBelegt()==true){
								if (this.spiel.getWuerfelZahl()== 6) {
									if (this.spiel.getBrett().getWeg().get(30).getFigur()  != null) {
										if (this.spiel.getBrett().getWeg().get(30).getFigur().getFarbe() == eFarben.GELB) {
											kannRaus=false;
											} else {
												//this.spiel.schlagen(1);
												//this.spiel.startPosZuweisen(spiel.getSpielerAmZug());
												kannRaus=true;
												ergebnis=figurRausgeher.getFigur();
												break;
												}
										} else {
											//this.spiel.startPosZuweisen(spiel.getSpielerAmZug());
											kannRaus = true;
											ergebnis=figurRausgeher.getFigur();
											break;
											}
								}//this.spiel.bewegen(feldzahl, true);
									} else {
										kannRaus=false;
										//this.spiel.spielerAmZug();
										}
								}
								} else if (this.spiel.bestand(this.spiel.getBrett().getStartGelb()) == 0) {
									kannRaus=false;
									}
							}
			
			}catch(Exception e){
				e.getMessage();
				}
		return ergebnis;
		}

	public Spielbrett getBrett() {
		return brett;
	}

	public void setBrett(Spielbrett brett) {
		this.brett = brett;
	}
	}