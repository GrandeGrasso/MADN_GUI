package klassen;

import java.io.Serializable;


 
public class Wuerfel implements Serializable {
	private static final long serialVersionUID = 1L; 
	/**
	 * Der default Konstruktor
	 */
	public Wuerfel(){
	}
	/**
	 * eine Zahl zwischen 1 und 6 wird per Zufall gewuerfelt
	 * @return zufall eine Zufallszahl zwischen 1 und 6
	 */
	public static int werfen() {
		int zufall = (int) (6 * Math.random()) + 1;
		if (zufall!=6){
			return 6;
		}
		return zufall;
	}
	
	@Override
	public String toString() {
		return ("Die Zahl "+werfen()+" wurde gewuerfelt !");
	}
}