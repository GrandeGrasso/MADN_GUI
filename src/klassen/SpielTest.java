package klassen;


public class SpielTest {

	public static void main(String[] args) {
		
Spiel spiel1 = new Spiel();
		
		Spieler rot=new Spieler("Kathi",FarbEnum.ROT,new KI_Aggressiv(spiel1));

		
		spiel1.nimmtTeil(rot);
//		spiel1.nimmtTeil(blau);
//		spiel1.nimmtTeil(gruen);
//		spiel1.nimmtTeil(gelb);

		spiel1.spielStart();
//		rot.wuerfeln();

		
//		if(spiel1.getBrett().getWeg().get(0) instanceof JButton){
//			System.out.println("im button");
//		}
//		
//		if(rot.getFigurlist().get(0) instanceof ImageIcon){
//			System.out.println("im figur");
//		}
		
		
		
//		-------------------KI LAEUFT------------------------
//		spiel1.setWuerfelZahl(6);	
//		spiel1.laufen(spiel1.gibFigurKi());
//		
//		spiel1.setWuerfelZahl(3);
//		spiel1.laufen(spiel1.gibFigurKi());
//		
//		spiel1.setWuerfelZahl(6);	
//		spiel1.laufen(spiel1.gibFigurKi());
//		
//		spiel1.setWuerfelZahl(3);
//		spiel1.laufen(spiel1.gibFigurKi());
//		
//		spiel1.setWuerfelZahl(2);
//		spiel1.laufen(spiel1.gibFigurKi());
		
		
//		spiel1.laufen(rot.getKi().ermittleFigur().getId());
//		spiel1.beenden();
////		
		spiel1.setWuerfelZahl(6);
		spiel1.laufen(rot.getKi().ermittleFigur().getId());
//
		spiel1.setWuerfelZahl(3);
		spiel1.laufen(rot.getKi().ermittleFigur().getId());
		spiel1.setWuerfelZahl(6);
		spiel1.laufen(rot.getKi().ermittleFigur().getId());
//		spiel1.beenden();
//		
		spiel1.setWuerfelZahl(3);
		spiel1.laufen(rot.getKi().ermittleFigur().getId());
		spiel1.setWuerfelZahl(2);
		spiel1.laufen(rot.getKi().ermittleFigur().getId());
//		spiel1.setWuerfelZahl(6);
//		spiel1.laufen(rot.getKi().ermittleFigur().getId());
		
		
//		spiel1.setWuerfelZahl(39);
//		spiel1.laufen(rot.getKi().ermittleFigur().getId());
//		spiel1.setWuerfelZahl(1);
//		spiel1.laufen(rot.getKi().ermittleFigur().getId());
		
		
		
		
		
		
		
		
		
//		-----------------SPIELER LAEUFT---------------------
//		spiel1.setWuerfelZahl(6);
//		spiel1.laufen(1);
//		
//		spiel1.setWuerfelZahl(5);
//		spiel1.laufen(1);
////		System.out.println(spiel1.updatePos(0, 0));
//
//		spiel1.beenden();
////		
//		spiel1.setWuerfelZahl(6);
//		spiel1.laufen(0);
////		spiel1.setWuerfelZahl();
////		spiel1.laufen(0);
////		spiel1.beenden();
////		
//		spiel1.setWuerfelZahl(1);
//		spiel1.laufen(0);
//		spiel1.beenden();
////		
//		spiel1.setWuerfelZahl(7);
//		spiel1.laufen(1);
////		spiel1.setWuerfelZahl(1);
////		spiel1.laufen(2);
//		spiel1.beenden();
////		
//		spiel1.setWuerfelZahl(1);
//		spiel1.laufen(0);
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
////		spiel1.setWuerfelZahl(41); //ueberholen ueberpruefen
////		spiel1.laufen(3);
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
		
		
		
//		System.out.println(spiel1.getBrett().getEndRot());
		
		
		
	}

}