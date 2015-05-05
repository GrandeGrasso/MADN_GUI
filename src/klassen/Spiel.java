package klassen;


import interfaces.iBediener;

import java.io.Serializable;
import java.util.*;
/**
 * Ein ganzes Spiel wird erzeugt
 * @author Gruppe A2
 */
public class Spiel implements iBediener , Serializable {
	private static final long serialVersionUID = 1L;

	
	
	private Spieler spielerAmZug;
	private ArrayList <Spieler> spielerlist;
	private Spielbrett brett;
	private int spielerAnzahl;
	private Integer wuerfelZahl;
	

 

	/**
	 * der Konstruktor der Klasse Spiel es wird ein neues Spielbrett erzeugt es
	 * wird geprueft ob eine gueltige Anzahl an Spielern angegeben wurde
	 * 
	 * @param spielerAnz ist die ausgewaehlte Spieleranzahl
	 */
	public Spiel() {
		
		spielerlist=new ArrayList<Spieler>();
		brett = new Spielbrett();
	}
	
	public void nimmtTeil(Spieler pl){
		
		if(pl==null){
			throw new RuntimeException("es nimmt kein Spieler teil !");
		}
		
		
		setSpielerAmZug(pl);
		
		spielerlist.add(pl); // add(0<--index vom spieler,spieler);
		spielerAnzahl++;
		System.out.println("Teilnehmer: --> "+pl.getName());
		
		
		
	}
	
	public void testen(){
		
		System.out.println(spielerAmZug.getName());
		
		
	}
	
	



//	@Override
//	public void spielerwaehltfarbe(FarbEnum farbe) {
//		for (Spieler i: spielerlist) {
//			
//			spielerlist.farbeWaehlen(farbe);
//			spielerlist.
//		}
//	}

 

 
	@Override
	public void spielStart(){
		if ((spielerlist.size()==0)){
			throw new RuntimeException ("Es nimmt noch kein Spieler teil !");
		}
		
		int k=0;
		do{
			if (spielerlist.get(k).getFarbe()==eFarben.ROT){
				int i=0;
				for(Spielfigur b:spielerlist.get(k).getFigurlist()){
					b=spielerlist.get(k).getFigurlist().get(i);
					brett.getStartRot().get(i).setFigur(b);
					i++;
				}
				System.out.println("StartBox Bereit ROT ");
			}
			else if (spielerlist.get(k).getFarbe()==eFarben.BLAU){
				int i=0;
				for(Spielfigur b:spielerlist.get(k).getFigurlist()){
					b=spielerlist.get(k).getFigurlist().get(i);
					brett.getStartBlau().get(i).setFigur(b);
					i++;
				}
				System.out.println("StartBox Bereit BLAU ");
			}
			else if (spielerlist.get(k).getFarbe()==eFarben.GRUEN){
				int i=0;
				for(Spielfigur b:spielerlist.get(k).getFigurlist()){
					b=spielerlist.get(k).getFigurlist().get(i);
					brett.getStartGruen().get(i).setFigur(b);
					i++;
				}
				System.out.println("StartBox Bereit GRUEN ");
			}
			else if (spielerlist.get(k).getFarbe()==eFarben.GELB){
				int i=0;
				for(Spielfigur b:spielerlist.get(k).getFigurlist()){
					b=spielerlist.get(k).getFigurlist().get(i);
					brett.getStartGelb().get(i).setFigur(b);
					i++;
				}
				System.out.println("StartBox Bereit GELB ");
			}
			k++;
		}while(k<spielerAnzahl);
		
		System.out.println("!!! START !!!");
		
		setSpielerAmZug(spielerlist.iterator().next());
		
		
		
		
	}
	



	/**
	 * Zuweisung der Startposition der jeweiligen Spielfiguren der Spieler
	 *  in Abhaengigkeit der Farbe
	 *  @param spieler ist die liste der figuren 
	 *  @param figur ist die Spielfigur die zu bewegen ist
	 */
	public void startPosZuweisen(Spieler spieler, int figur){
		
		
		
			if (spieler.getFarbe() == eFarben.ROT){
				Spielfigur farbeFigur=this.brett.getStartRot().get(figur-1).getFigur();
				int figurBox=this.brett.getStartRot().indexOf(farbeFigur.getFeld());
				Spielfeld rausFeld=this.brett.getWeg().get(0);
				
				if(rausFeld.istFeldBelegt()==false){
					rausFeld.setFigur(farbeFigur);
					this.brett.getStartRot().get(figurBox).setFigur(null);
					System.out.println(spieler.getName()+" deine Figur: "+farbeFigur.getFigurId()+" startet bei Feld: "+rausFeld.getId());
				}//spieler nicht spielerAmZug
				else if(rausFeld.istFeldBelegt()==true){
					if(rausFeld.getFigur().getFarbe()!=farbeFigur.getFarbe()){
						this.schlagen(0);
//						rausFeld.setFigur(farbeFigur);
//						this.brett.getStartRot().get(figurBox).setFigur(null);
					}else{
						System.out.println("nicht gleichzeitig rausgehen bitte !");
					}
					
				}
			}
			
			else if (spieler.getFarbe() == eFarben.BLAU){
				Spielfigur farbeFigur=this.brett.getStartBlau().get(figur-1).getFigur();
				int figurBox=this.brett.getStartBlau().indexOf(farbeFigur.getFeld());
				Spielfeld rausFeld=this.brett.getWeg().get(10);
				
				if(rausFeld.istFeldBelegt()==false){
					rausFeld.setFigur(farbeFigur);
					this.brett.getStartBlau().get(figurBox).setFigur(null);
					System.out.println(spieler.getName()+" deine Figur: "+farbeFigur.getFigurId()+" startet bei Feld: "+rausFeld.getId());
				}
				else if(rausFeld.istFeldBelegt()==true){
					if(rausFeld.getFigur().getFarbe()!=farbeFigur.getFarbe()){
						this.schlagen(10);
					}else{
						System.out.println("nicht gleichzeitig rausgehen bitte !");
					}
					
				}
			}
			
		
		
	}
	
	/**
	 * Eine Spielfigur eines Gegners wird geschlagen falls man auf das selbe
	 * Spielfeld kommt
	 * @param feldId ist das feld wo die Figur die geschlagen wird und zurueck in die Startbox kommt
	 */
	public void schlagen(int feldId) {
		Spielfigur schlageFigur = brett.getWeg().get(feldId-1).getFigur();
		
		if(schlageFigur==null){
			throw new RuntimeException("es gibt keine figur zu schlagen");
		}
		
		if (schlageFigur.getFarbe() == eFarben.ROT) {
			int i = 0;
			if (brett.getStartRot().get(i).getFigur() == null){
				brett.getStartRot().get(i+1).setFigur(schlageFigur);
				this.brett.getWeg().get(feldId-1).setFigur(null);
				System.out.println("ROTE Figur geschlagen");
			} else {
				i++;				
			}
		}
		
		else if (schlageFigur.getFarbe() == eFarben.BLAU) {
			int i = 0;
			if (brett.getStartBlau().get(i).getFigur() == null){
				brett.getStartBlau().get(i+1).setFigur(schlageFigur);
				this.brett.getWeg().get(feldId-1).setFigur(null);
				System.out.println("BLAUE Figur geschlagen");
			} else {
				i++;				
			}
		}
		
		else if (schlageFigur.getFarbe() == eFarben.GRUEN) {
			int i = 0;
			if (brett.getStartGruen().get(i).getFigur() == null){
				brett.getStartGruen().get(i+1).setFigur(schlageFigur);
				this.brett.getWeg().get(feldId-1).setFigur(null);
				System.out.println("GRUENE Figur geschlagen");
			} else {
				i++;				
			}
		}
		
		else if (schlageFigur.getFarbe() == eFarben.GELB) {
			int i = 0;
			if (brett.getStartGelb().get(i).getFigur() == null){
				brett.getStartGelb().get(i+1).setFigur(schlageFigur);
				this.brett.getWeg().get(feldId-1).setFigur(null);
				System.out.println("GELBE Figur geschlagen");
			} else {
				i++;				
			}
		}
	}
	
//	public Spieler spielerAmZug(){
//		for(Spieler a: spielerlist){
//			spielerAmZug=a;
//			
//		}
//		return spielerAmZug;
//	}
	
	public void beenden(){
		
		eFarben e = spielerAmZug.getFarbe();
		
		if(this.ermittleGewinner()==true){
			System.out.println(spielerAmZug.getName()+ " HAT GEWONNEN !");
		}
		
		else{
			
			switch (spielerAnzahl) {
				
				case 2:
				if (e == eFarben.ROT) {
					for (Spieler i : spielerlist) {
						if (i.getFarbe() == eFarben.BLAU) {
							setSpielerAmZug(i);
						}
					}
				}
				if (e == eFarben.BLAU) {
					for (Spieler i : spielerlist) {
						if (i.getFarbe() == eFarben.ROT) {
							setSpielerAmZug(i);
						}
					}
				}
				break;
				
				case 3:
				if (e == eFarben.BLAU) {
					for (Spieler i : spielerlist) {
						if (i.getFarbe() == eFarben.GRUEN) {
							setSpielerAmZug(i);
						}
					}
				}
				break;
				
				case 4:
				if (e == eFarben.GRUEN) {
					for (Spieler i : spielerlist) {
						if (i.getFarbe() == eFarben.GELB) {
							setSpielerAmZug(i);
						}
					}
				}
				break;
			}	
		}
	}
	

	
	
	public boolean moechteLaufen() {
		
		boolean x = false;
		
		if(getWuerfelZahl()<6){
			return true;
		}
		return x;
		
	}
	

	
	public int bestand(ArrayList<Spielfeld> liste){
		
		int i=0;
		for(Spielfeld a:liste){
			
			if(a.getFigur()!=null){
				i++;		
			}		
		}
		return i;
	}
	
	public boolean istEndfeldVoll(ArrayList<Spielfeld> liste){
		if(bestand(liste)==4){
			return true;
		}
		return false;
		
	}
	
	public boolean ermittleGewinner(){
		if(	istEndfeldVoll(brett.getEndRot())==true||
			istEndfeldVoll(brett.getEndBlau())==true||
			istEndfeldVoll(brett.getEndGruen())==true||
			istEndfeldVoll(brett.getEndGelb())==true){
			return true;
		}
		return false;
	}
	
	
	public boolean istFigurDrin(ArrayList<Spielfeld> liste,int figurId){
		
		for(Spielfeld b:liste){
			if(b.getFigur()!=null){
				if(b.getFigur().getFigurId()==figurId){
					return true;
				}
			}
		}
		return false;
	}
	
	public int letztePosRechnen(ArrayList<Spielfeld> liste, Spielfigur figur){
		
		int letztePos=liste.indexOf(figur.getFeld());
		
		return letztePos;
	}
	
	public boolean kannUeberhoeln(ArrayList<Spielfeld> liste,int altePos, int neuePos){
		
		for(Spielfeld a:liste.subList(altePos, neuePos)){
			if(liste.indexOf(a)<neuePos){				
				if(a.istFeldBelegt()==true){
					return false;
				}
			}
		}
		return true;
	}
	
	
	/**
	 * die Spielfigur eines Spielers laeuft
	 * @param figurId ist, welche figur laufen moechte
	 */
	public void laufen(int figurId){
		
		Spielfigur nowFigur=spielerAmZug.getFigurlist().get(figurId-1);
		int letztePos=getBrett().getWeg().indexOf(nowFigur.getFeld());
		int letzterWurf= getWuerfelZahl();//spielerAmZug.getLetzterWurf();
		int neuePos=letztePos + letzterWurf;
		int indexMax=39;
		Spielfeld startRot=this.brett.getWeg().get(0);
		Spielfeld startBlau=this.brett.getWeg().get(10);
		
		// die if abfrage schaut welche farbe die figur hat
		if (nowFigur.getFarbe()==eFarben.ROT){
			
			//zum ersten mal raus kommen 
			if (letzterWurf==6&&this.bestand(this.getBrett().getStartRot())==4){
				this.startPosZuweisen(spielerAmZug, figurId);
				System.out.println("Du darfst nochmal wuerfeln");
			}
			
			//der spieler moechte raus gehen aber er hat keine 6 gewuerfelt 
			else if (letzterWurf!=6&&this.bestand(this.getBrett().getStartRot())==4){
				System.out.println("Du musst erst 6 wuerfeln um zu starten");
			}
			
			//verucht eine andere figur rauszugehen wen er keine 6 gewuerfelt hat == false
			else if (letzterWurf!=6&&this.bestand(this.getBrett().getStartRot())<=4&&this.istFigurDrin(this.getBrett().getStartRot(), figurId)==true){
				System.out.println("Du musst erst 6 wuerfeln um raus zugehen");
			}
			
			//der spieler wuerfelt 6 und das startfeld von rot ist besetzt 
			else if(letzterWurf==6&&this.bestand(this.getBrett().getStartRot())<4&&startRot.istFeldBelegt()==true&&this.istFigurDrin(this.brett.getStartRot(), figurId)==true){
				//die if abfrage schaut ob die figur die gleiche farbe hat wie deine figur
				if(startRot.getFigur().getFarbe()==nowFigur.getFarbe()){
					System.out.println("Du musst dich erst weg bewegen");		
				}
				else if(startRot.getFigur().getFarbe()!=nowFigur.getFarbe()){
					System.out.println("Figur auf startfeld von rot geschlagen");
					this.schlagen(1);
				}
			}
			
			//Bringt eine neue figur raus 
			else if(letzterWurf==6&&this.bestand(this.getBrett().getStartRot())<4&&startRot.istFeldBelegt()==false&&this.istFigurDrin(this.brett.getStartRot(), figurId)==true){
//				System.out.println("Wahele eine figur um raus zu gehen oder\nmit einer anderen weiter zu laufen");
				
				if (this.istFigurDrin(this.getBrett().getStartRot(), figurId)==true){
					this.startPosZuweisen(spielerAmZug, figurId);
					System.out.println("Du darfst nochmal wuerfeln");
				}
			}
			
			//-----------LAUFEN-----------
			else if(this.bestand(this.getBrett().getStartRot())<4&&this.istFigurDrin(this.brett.getStartRot(), figurId)!=true){
				if(neuePos<=indexMax&&letztePos>=0){
					
					Spielfeld neuesFeld=getBrett().getWeg().get(neuePos);
					if(neuesFeld.istFeldBelegt()==false){
						neuesFeld.setFigur(nowFigur);
						getBrett().getWeg().get(letztePos).setFigur(null);
						System.out.println("Deine Figur: "+nowFigur.getFigurId()+" sitzt auf dem Feld: "+neuesFeld.getId());
					}		
					else if(neuesFeld.istFeldBelegt()==true){	
						if(neuesFeld.getFigur().getFarbe()!=nowFigur.getFarbe()){
							this.schlagen(neuePos+1);
							neuesFeld.setFigur(nowFigur);
							getBrett().getWeg().get(letztePos).setFigur(null);
							System.out.println("Deine Figur: "+nowFigur.getFigurId()+" sitzt auf dem Feld: "+neuesFeld.getId());	
						}else{
							System.out.println("du kannst nicht deine figur schlagen !");
						}	
					}
				}
				//ins ENDFELD reingehen
				else {
					
					int differenz = neuePos-indexMax;
					int endPos=getBrett().getEndRot().indexOf(nowFigur.getFeld());
					neuePos=endPos+letzterWurf;
					
					//diese if abfrage ist wen figur im endfeld drin ist und weiter laeuft
					if(differenz<=4&&neuePos<brett.getEndRot().size()&&this.istFigurDrin(brett.getEndRot(), figurId)==true){
						Spielfeld endFeld=getBrett().getEndRot().get(neuePos);
						
						if(endFeld.getFigur()==null){
							if(this.kannUeberhoeln(this.brett.getEndRot(),endPos+1, neuePos)==true){
								endFeld.setFigur(nowFigur);
								brett.getEndRot().get(endPos).setFigur(null);
								System.out.println("Deine Figur: "+nowFigur.getFigurId()+ " sitzt auf dem Feld: "+getBrett().getEndRot().get(neuePos).getId());
							}else{
								System.out.println("Du kannst nicht ueberholen !");
							}
						}else{
							System.out.println("Feld ist besetzt !");
						}
					}
					//diese if abfrage ist wen figur von weg ins endfeld drin rein will
					else if(differenz<=4&&differenz>0){
						Spielfeld endFeld=getBrett().getEndRot().get(differenz-1);
						
						if(endFeld.getFigur()==null){
							if(this.kannUeberhoeln(this.brett.getEndRot(),0, differenz-1)==true){
								endFeld.setFigur(nowFigur);
								brett.getWeg().get(letztePos).setFigur(null);
								System.out.println("Deine Figur: "+nowFigur.getFigurId()+ " sitzt auf dem Feld: "+getBrett().getEndRot().get(differenz-1).getId());
							}else{
								System.out.println("Du kannst nicht ueberholen !");
							}
						}else{
							System.out.println("Feld ist besetzt !");
						}
					}
					
					else{
						System.out.println("Du kannst mit der Figur nicht weitergehen !");
					}
				}
			}
		}
		
		
		
		// ------------------------BLAU---------------------------
		else if (nowFigur.getFarbe()==eFarben.BLAU){
			
			//zum ersten mal raus kommen 
			if (letzterWurf==6&&this.bestand(this.getBrett().getStartBlau())==4){
				this.startPosZuweisen(spielerAmZug, figurId);
				System.out.println("Du darfst nochmal wuerfeln");
			}
			
			//der spieler moechte raus gehen aber er hat keine 6 gewuerfelt 
			else if (letzterWurf!=6&&this.bestand(this.getBrett().getStartBlau())==4){
				System.out.println("Du musst erst 6 wuerfeln um zu starten");
			}
			
			//verucht eine andere figur rauszugehen wen er keine 6 gewuerfelt hat == false
			else if (letzterWurf!=6&&this.bestand(this.getBrett().getStartBlau())<=4&&this.istFigurDrin(this.getBrett().getStartBlau(), figurId)==true){
				System.out.println("Du musst erst 6 wuerfeln um raus zugehen");
			}
			
			//der spieler wuerfelt 6 und das startfeld von rot ist besetzt 
			else if(letzterWurf==6&&this.bestand(this.getBrett().getStartBlau())<4&&startBlau.istFeldBelegt()==true){
				//die if abfrage schaut ob die figur die gleiche farbe hat wie deine figur
				if(startBlau.getFigur().getFarbe()==nowFigur.getFarbe()){
					System.out.println("Du musst dich erst weg bewegen");
				}
				else if(startBlau.getFigur().getFarbe()!=nowFigur.getFarbe()){
					System.out.println("Figur auf startfeld von rot geschlagen");
					this.schlagen(11);
				}
			}
			
			//Bringt eine neue figur raus 
			else if(letzterWurf==6&&this.bestand(this.getBrett().getStartBlau())<4&&startBlau.istFeldBelegt()==false&&this.istFigurDrin(this.brett.getStartBlau(), figurId)==true){
//					System.out.println("Wahele eine figur um raus zu gehen oder\nmit einer anderen weiter zu laufen !!");
				if (this.istFigurDrin(this.getBrett().getStartBlau(), figurId)==true){
					this.startPosZuweisen(spielerAmZug, figurId);
					System.out.println("Du darfst nochmal wuerfeln");
				}
			}
			
			//-----------LAUFEN-----------
			else if(this.bestand(this.getBrett().getStartRot())<4&&this.istFigurDrin(this.brett.getStartBlau(), figurId)!=true){
				if(neuePos>=11&&neuePos<=39&&letztePos>=10){
					Spielfeld neuesFeld=getBrett().getWeg().get(neuePos);
					if(neuesFeld.istFeldBelegt()==false){
						neuesFeld.setFigur(nowFigur);
						getBrett().getWeg().get(letztePos).setFigur(null);
						System.out.println("Deine Figur: "+nowFigur.getFigurId()+" sitzt auf dem Feld: "+neuesFeld.getId());
					}		
					else if(neuesFeld.istFeldBelegt()==true){	
						if(neuesFeld.getFigur().getFarbe()!=nowFigur.getFarbe()){
							this.schlagen(neuePos+1);
							neuesFeld.setFigur(nowFigur);
							getBrett().getWeg().get(letztePos).setFigur(null);
							System.out.println("Deine Figur: "+nowFigur.getFigurId()+" sitzt auf dem Feld: "+neuesFeld.getId());
						}
						else{
							System.out.println("du kannst nicht deine figur schlagen !");
						}	
					}
				}
				//hier kommst du rein wen du ueber das maximum gehst (ueberschreitest feld 40)
				else{	
					int newIndex=((neuePos-indexMax)-1);
					int wegMaxBlau = 9;
					
					if(newIndex<0)
						newIndex=neuePos;
						
						Spielfeld neuesFeld2=this.brett.getWeg().get(newIndex);
						
						//von feld 1 bis zum feld 10 laufen
						if(newIndex>=0&&newIndex<=9&&this.istFigurDrin(this.brett.getEndBlau(), figurId)==false){
						
							if(neuesFeld2.istFeldBelegt()==false){
								neuesFeld2.setFigur(nowFigur);
								brett.getWeg().get(letztePos).setFigur(null);
								System.out.println("Deine Figur: "+nowFigur.getFigurId()+" sitzt auf dem Feld: "+neuesFeld2.getId());
							}
							
							else if(neuesFeld2.istFeldBelegt()==true){
								if(neuesFeld2.getFigur().getFarbe()!=nowFigur.getFarbe()){
									this.schlagen(neuePos+1);
									neuesFeld2.setFigur(nowFigur);
									brett.getWeg().get(letztePos).setFigur(null);
									System.out.println("Deine Figur: "+nowFigur.getFigurId()+" sitzt auf dem Feld: "+neuesFeld2.getId());
								}
								else{
									System.out.println("du kannst deine figur nicht schlagen !");
								}	
							}
						}
						//ins ENDFELD reingehen
						else {
						
							int differenz = neuePos-wegMaxBlau;
							int endPos=getBrett().getEndBlau().indexOf(nowFigur.getFeld());
							neuePos=endPos+letzterWurf;
							
							//diese if abfrage ist wen figur im endfeld drin ist und weiter laeuft
							if(differenz<=4&&neuePos<brett.getEndBlau().size()&&this.istFigurDrin(brett.getEndBlau(), figurId)==true){
								Spielfeld endFeld=getBrett().getEndBlau().get(neuePos);
								
								if(endFeld.getFigur()==null){
									if(this.kannUeberhoeln(this.brett.getEndBlau(),endPos+1, neuePos)==true){
										endFeld.setFigur(nowFigur);
										brett.getEndBlau().get(endPos).setFigur(null);
										System.out.println("Deine Figur: "+nowFigur.getFigurId()+ " sitzt auf dem Feld: "+getBrett().getEndBlau().get(neuePos).getId());
									}else{
										System.out.println("Du kannst nicht ueberholen !");
									}
								}else{
									System.out.println("Feld ist besetzt !");
								}
							}
							//diese if abfrage ist wen figur von weg ins endfeld drin rein will
							else if(differenz<=4&&differenz>0){
								Spielfeld endFeld=getBrett().getEndBlau().get(differenz-1);
								
								if(endFeld.getFigur()==null){
									if(this.kannUeberhoeln(this.brett.getEndBlau(),0, differenz-1)==true){
										endFeld.setFigur(nowFigur);
										brett.getWeg().get(letztePos).setFigur(null);
										System.out.println("Deine Figur: "+nowFigur.getFigurId()+ " sitzt auf dem Feld: "+getBrett().getEndBlau().get(differenz-1).getId());
									}else{
										System.out.println("Du kannst nicht ueberholen !");
									}
								}else{
									System.out.println("Feld ist besetzt !");
								}
							}
								
							else{
								System.out.println("Du kannst mit der Figur nicht weitergehen !");
							}
					}
				}
			}
		}
	}	




	



	/**
	 * das Spielbrett wird zurueckgegeben
	 * @return brett ist das Spielbrett
	 */
	public Spielbrett getBrett() {
		return this.brett;
	}
 
	/**
	 * das Spielbrett wird gesetzt
	 * @param brett ist das Spielbrett
	 */
	public void setBrett(Spielbrett brett) {
		this.brett = brett;
	}

	/**
	 * gibt den Spieler der gerade am Zug ist zurueck
	 * @return spielerAmZug der Spieler der am Zug ist
	 */
	public Spieler getSpielerAmZug() {
		
		return spielerAmZug;
	}
 
	/**
	 * der Spieler der gerade am Zug ist wird gesetzt
	 * @param spielerAmZug der Spieler der am Zug ist
	 */
	public void setSpielerAmZug(Spieler spielerAmZug) {
		this.spielerAmZug = spielerAmZug;
		System.out.println("-----"+spielerAmZug.getFarbe()+"----");
		
	}
 

	
	public ArrayList<Spieler> getSpielerlist() {
		return spielerlist;
	}

	public void setSpielerlist(ArrayList<Spieler> spielerlist) {
		this.spielerlist = spielerlist;
	}


	public Integer getWuerfelZahl() {
		return wuerfelZahl;
	}

	public void setWuerfelZahl(Integer wuerfelZahl) {
		
		
		
		if (wuerfelZahl!=null && wuerfelZahl >=1 ){
			System.out.println( spielerAmZug.getName()+" hat " + wuerfelZahl + " gewuerfelt");
		}
		this.wuerfelZahl = wuerfelZahl;
	}
	
	
	
//	@Override
//	public void wuerfeln() {
//		
//		setWuerfelZahl(spielerAmZug.getWuerfel().werfen());
//	}

	
 
}