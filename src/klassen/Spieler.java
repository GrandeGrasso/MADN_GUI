package klassen;


import java.io.Serializable;
import java.util.ArrayList;

/**
 * Es wird ein Spieler erzeugt
 * @author Gruppe A2
 *
 */
public class Spieler implements Serializable {
	private static final long serialVersionUID = 1L; 
 
	private String name;
	private eFarben farbe;
	private Wuerfel wuerfel;
	private ArrayList <Spielfigur> figurlist;
	private int letzterWurf;
	private boolean hatBereitsGewuerfelt = false;
	private KI ki;
	private Spielfigur figur;
 
	/**
	 * Der Konstruktor der Klasse
	 * Wenn ein Spieler erzeugt wird, wird auch sofort ein Wuerfel miterzeugt, so wie die 4 Spielfiguren
	 * @param name ist der Name des Spielers
	 * @param farbe ist die Spielfigurfarbe des Spielers
	 */ 
	public Spieler(String name, eFarben farbe,KI ki) {
		this.setName(name);
		this.setFarbe(farbe);
		this.setKi(ki);
		wuerfel = new Wuerfel();
		
		figurlist = new ArrayList<Spielfigur>();
		hinzufuegen();
		
		
	}
	
	public KI getKi() {
		return ki;
	}

	public void setKi(KI ki) {
		this.ki = ki;
	}

	public void hinzufuegen(){
		for(int i=1; i<=4; i++){
	   		figurlist.add(new Spielfigur(this.getFarbe(), i, null));
	   	}
	}
	
	/**
	 * der Spieler wuerfelt mit dieser Methode
	 * @return (wuerfel.wuerfeln()) heisst es wird gewuerfelt die Methode wuerfeln wird aufgerufen
	 */
	public int wuerfeln() {
		letzterWurf = Wuerfel.werfen();
		hatBereitsGewuerfelt = true;
		return (letzterWurf);
	}
	
	public int getLetzterWurf() {
		return letzterWurf;
	}
 
	public boolean hatBereitsGewuerfelt() {
		return hatBereitsGewuerfelt;
	}
 
	public void setHatBereitsGewuerfelt(boolean hatGewuerfelt) {
		hatBereitsGewuerfelt = hatGewuerfelt;
	}
	
	/**
	 * Methode um zu sehen ob die Farbe schon von jemand anderen gewaehlt wurde
	 * @param farbe gewahlte Farbe eines Spielers
	 * @return boolsche Antwort
	 */
	public boolean istFarbeFrei(eFarben farbe){
		if (this.getFarbe()==farbe){
			return false;
	 	}
		
		else{
			return true;
		}
	}
 

 
	/**
	 * Spieler kann seine Farbe auswaehlen
	 * @param farbe die gewaehlte farbe
	 */
	public void farbeWaehlen(eFarben farbe){
		
		if (farbe==eFarben.BLAU){
			if(istFarbeFrei(farbe)==true){
				this.setFarbe(eFarben.BLAU);
			}
		} 
		
		else{
			throw new RuntimeException("Farbe Blau schon vergeben !");
		}
	 
		if (farbe==eFarben.GELB){
			if(istFarbeFrei(farbe)==true){
				this.setFarbe(eFarben.GELB);
			}
		} 
		
		else{
			throw new RuntimeException("Farbe Gelb schon vergeben !");
		}
	 
		if (farbe==eFarben.GRUEN){
			if(istFarbeFrei(farbe)==true){
				this.setFarbe(eFarben.GRUEN);
			}
		} 
		
		else{
			throw new RuntimeException("Farbe Gruen schon vergeben !");
		}
		
		if (farbe==eFarben.ROT){
			if(istFarbeFrei(farbe)==true){
				this.setFarbe(eFarben.ROT);
			}
		} 
		
		else{
			throw new RuntimeException("Farbe Rot schon vergeben !");
		}
	}

 
 
	//-------- Getter & Setter ---------
	
	/**
	 * der Name des Spielers wird zurueck gegeben
	 * @return name ist der Name des Spielers
	 */
	public String getName() {
		return name;
	}

	/**
	 * der Name des Spielers wird gesetzt
	 * @param name ist der Name des Spielers
	 */
	public void setName(String name) {
		if((name==null) || (name.length()<2)){
			throw new RuntimeException("Name muss mindestens 2 Zeichen enthalten!");
		}
		this.name = name;
	}

	/**
	 * die Farbe der Spieler wird zurueck gegeben
	 * @return farbe ist die Farbe eines Spielers
	 */
	public eFarben getFarbe() {
		return farbe;
	}
 
	/**
	 * die Farbe der Spielfigur wird gesetzt
	 * @param farbe ist die Farbe einer Spielfigur
	 */
	public void setFarbe(eFarben farbe) {
		if(farbe==null){
			throw new RuntimeException("Waehle eine Farbe !");
		}
		this.farbe = farbe;
	}
 
	/**
	 * der Wuerfel des Spielers wird zurueck gegeben
	 * @return wuerfel ist der Wuerfel des Spielers
	 */
	public Wuerfel getWuerfel() {
		
		System.out.println(this.getName()+" hat die zahl "+wuerfel+" gewuerfelt");
		return wuerfel;
	}
 
	/**
	 * der Wuerfel des Spielers wird gesetzt
	 * @param wuerfel ist der Wuerfel des Spielers
	 */
	public void setWuerfel(Wuerfel wuerfel) {
		if(wuerfel==null){
			throw new RuntimeException("Es muss ein wuerfel geben! ");
		}
		this.wuerfel = wuerfel;
	}
	
//	public int setWuerfelZahl(int wuerfelErg) {
//		return wuerfelErg= wuerfel.werfen();
//	}
	
	
	

	/**
	 * gibt die figur des spielers aus
	 * @return figur ist die Spielfigur des Spielers
	 */
	public Spielfigur getFigur() {
		return figur;
	}

	/**
	 * setzt die spielfigur des spielers
	 * @param figur ist die Spielfigur des Spielers
	 */
	public void setFigur(Spielfigur figur) {
		this.figur = figur;
	} 
	
	/**
	 * gibt die figuren des spielers aus
	 * @return figurlist sind die Spielfiguren des Spielers
	 */
	public ArrayList <Spielfigur> getFigurlist() {
		return figurlist;
	}

	/**
	 * setzt die spielfiguren des spielers
	 * @param figurlist sind die Spielfiguren des Spielers
	 */
	public void setFigurlist(ArrayList <Spielfigur> figurlist) {
		this.figurlist = figurlist;
	}
	

	//----------------------------------
	
	


	@Override
	public String toString() {
		return 
		("Name: " + this.getName() +
		" Farbe: " + this.getFarbe()+
		"\n"+
		"FIGUR: " +getFigurlist()+"\n" //"figuren anzahl "+getFigurenAnz()+"\n"+
//		"Die Zahl "+wuerfeln()+ " wurde gewuerfelt"
//		"Figuren des Spielers: " +"\n"+ getFigur()
		);
	}

	
}