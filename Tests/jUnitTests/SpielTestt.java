//package jUnitTests;
//
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//
//import klassen.Spiel;
//import klassen.Spieler;
//import klassen.Wuerfel;
//import klassen.eFarben;
//
//public class SpielTestt {
//
//	/** Hier wird getestet, ob die Anzahl der Spieler mehr als 4 ist.
//	 * 
//	 */
//	@Test
//	public void addSpieler(){
//		Spiel s= new Spiel();
//		int zaheler = 0;
//		s.addSpieler("Yunus", eFarben.ROT);
//		zaheler=+1;
//		s.addSpieler("Kathi", eFarben.BLAU);
//		zaheler=+1;
//		s.addSpieler("Steff", eFarben.GRUEN);
//		zaheler=+1;
//		s.addSpieler("Akin", eFarben.GELB);
//		zaheler=+1;
//		assertTrue(zaheler<4);
//		
//	}
//	
//	/** Hier wird getestet, ob das Spiel startet.
//	 * 
//	 */
//	
//	@Test
//	public void starteSpiel() {
//		Spiel sb = new Spiel();
//		assertTrue(sb != null);	
//		}
//	
//	
//	/** Hier wird getestet, ob man wuerfeln kann.
//	 * 
//	 */
//	@Test
//	public void wuerfeln(){
//		
//		Wuerfel werfen= new Wuerfel();
//		
//			assertTrue(werfen !=null);
//	}
//	
//	/** Hier wird getestet, ob die Spieler überhaupt zum Zug kommen.
//	 * 
//	 */
//	
//	@Test
//	public void werIstAmZug(){
//		
//		Spiel zug = new Spiel();
//		int counter= 4;
//		for (int i=0;i<counter;i++){
//			assertTrue(zug !=null);
//		}
//	}
//	
//	/** Hier wird geprueft, ob das Spiel beendet wird.
//	 * 
//	 */
//	
//	@Test
//	public void beendeSpiel() {
//		Spiel sb = new Spiel();
//		assertTrue(sb != null);	
//		}
//	
//	/** Hier wird getestet, dass zwei Spieler niemals die selbe Farbe haben duerfen.
//	 * 
//	 */
//	
//	@Test
//	public void FigurAnSpieler(){
//		Spieler s1 = new Spieler("Yunus", eFarben.BLAU);
//		Spieler s2 = new Spieler("Kathi", eFarben.ROT);
//		assertTrue(s1.getFarbe() != s2.getFarbe());
//	}
//	
////	@Test
////	public void sortiere(){
////	int spielerMax =3;
////		String []sortiert = new String[spielerMax];
////		sortiert[0]= eFarben.ROT;
////		sortiert[1]= eFarben.BLAU;
////		sortiert[2]= eFarben.GRUEN;
////		sortiert[3]= eFarben.GELB;
////		
////		assertTrue(sortiert[0] == eFarben.ROT && sortiert[1] == eFarben.BLAU && 
////				sortiert[2] == eFarben.GRUEN && sortiert[3] == eFarben.GELB);
////	}
//	
//}
