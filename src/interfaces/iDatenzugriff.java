package interfaces;


/**
 * Interface zum laden und speichern eines spiels 
 * @author Gruppe A2
 *
 */
public interface iDatenzugriff 
{
	public Object laden(String filename);
	void speichern(Object spiel, String filename);
}
