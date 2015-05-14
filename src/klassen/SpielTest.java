package klassen;


public class SpielTest {

	public static void main(String[] args) {
		
		Spiel spiel1 = new Spiel();
		
		Spieler rot=new Spieler("Koko",eFarben.ROT,new KI_Aggressiv(spiel1));
		Spieler blau=new Spieler("Moko",eFarben.BLAU,new KI_Defensiv(spiel1));
		
//		Spieler rot=new Spieler("molo",FarbEnum.ROT,null);
//		Spieler blau=new Spieler("lolo",FarbEnum.BLAU,null);
		
//		Spieler gruen=new Spieler("Kati",FarbEnum.GRUEN,null);
//		Spieler gelb=new Spieler("Ray",FarbEnum.GELB,null);
			
		spiel1.nimmtTeil(rot);
		spiel1.nimmtTeil(blau);
//		spiel1.nimmtTeil(spieler3);
//		spiel1.nimmtTeil(spieler4);

		spiel1.spielStart();
//		rot.wuerfeln();
//		System.out.println(rot.getLetzterWurf());
//		System.out.println(k1.ErmittleZuSpielendeFigur(rot, 6));
		
		
		//------------------KI LAEUFT---------------------------
		
		spiel1.setWuerfelZahl(6);		
		spiel1.laufen(rot.getKi().ErmittleZuSpielendeFigur(rot,spiel1.getWuerfelZahl()).getFigurId());
		spiel1.setWuerfelZahl(5);
		spiel1.laufen(rot.getKi().ErmittleZuSpielendeFigur(rot,spiel1.getWuerfelZahl()).getFigurId());
		spiel1.beenden();
		
		spiel1.setWuerfelZahl(6);
		spiel1.laufen(blau.getKi().ErmittleZuSpielendeFigur(blau,spiel1.getWuerfelZahl()).getFigurId());
		spiel1.setWuerfelZahl(1);		
		spiel1.laufen(blau.getKi().ErmittleZuSpielendeFigur(blau,spiel1.getWuerfelZahl()).getFigurId());
		spiel1.beenden();
		spiel1.setWuerfelZahl(6);		
		spiel1.laufen(rot.getKi().ErmittleZuSpielendeFigur(rot,spiel1.getWuerfelZahl()).getFigurId());
		spiel1.setWuerfelZahl(3);
//
//		spiel1.laufen(rot.getKi().ErmittleZuSpielendeFigur(rot,spiel1.getWuerfelZahl()).getFigurId());
		
		//---------------ENDE----------
		
		
//		spiel1.beenden();
		
//		spiel1.setWuerfelZahl(35);
//		spiel1.laufen(rot.getKi().ErmittleZuSpielendeFigur(rot,spiel1.getWuerfelZahl()).getFigurId());
//		spiel1.setWuerfelZahl(6);
//		spiel1.laufen(rot.getKi().ErmittleZuSpielendeFigur(rot,spiel1.getWuerfelZahl()).getFigurId());
//		spiel1.beenden();
//		
//		spiel1.setWuerfelZahl(6);
//		spiel1.laufen(zuSpielendeFigur.getFigurId());
//		spiel1.setWuerfelZahl(1);
//		spiel1.laufen(zuSpielendeFigur.getFigurId());
//		spiel1.beenden();
//		
//		spiel1.setWuerfelZahl(6);
//		spiel1.laufen(zuSpielendeFigur.getFigurId());
		
//		spiel1.laufen(zuSpielendeFigur.getFigurId());
//		spiel1.beenden();
//		
		
		
		
		//----------------------SPIELER LAEUFT---------------------
		
		
//		spiel1.setWuerfelZahl(6);
//		spiel1.laufen(1);
//		spiel1.setWuerfelZahl(35);
//		spiel1.laufen(1);
//		spiel1.beenden();
//		
//		spiel1.setWuerfelZahl(6);
//		spiel1.laufen(1);
//		spiel1.setWuerfelZahl(35);
//		spiel1.laufen(1);
//		spiel1.beenden();
//		
//		spiel1.setWuerfelZahl(7);
//		spiel1.laufen(1);
//		spiel1.beenden();
//		
//		spiel1.setWuerfelZahl(6);
//		spiel1.laufen(2);
//		spiel1.setWuerfelZahl(1);
//		spiel1.laufen(2);
//		spiel1.beenden();
//		
//		spiel1.setWuerfelZahl(6);
//		spiel1.laufen(2);
//		spiel1.setWuerfelZahl(11);
//		spiel1.laufen(2);
//		spiel1.beenden();
//		
//		spiel1.setWuerfelZahl(5);
//		spiel1.laufen(1);
//		spiel1.beenden();
//		
//		spiel1.setWuerfelZahl(29);
//		spiel1.laufen(2);
//		spiel1.beenden();
//		
//		spiel1.setWuerfelZahl(2);
//		spiel1.laufen(1);
//		spiel1.beenden();
//		
//		spiel1.setWuerfelZahl(6);
//		spiel1.laufen(3);
//		spiel1.setWuerfelZahl(41); //ueberholen ueberpruefen
//		spiel1.laufen(3);
//		spiel1.setWuerfelZahl(1);
//		spiel1.laufen(1);
//		spiel1.setWuerfelZahl(2);
//		spiel1.laufen(2);
//		spiel1.setWuerfelZahl(41);
//		spiel1.laufen(3);
//		spiel1.setWuerfelZahl(6);
//		spiel1.laufen(4);
//		spiel1.setWuerfelZahl(40);
//		spiel1.laufen(4);
//		spiel1.beenden();
//		
		//-------------------ENDE----------------
		
//		System.out.println(spiel1.getBrett().getEndRot());
		
		
		
	}

}