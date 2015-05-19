package gui;

import interfaces.iBediener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import klassen.Spiel;
import klassen.Spieler;

public class EventHandler implements ActionListener{
	
	 JFrame frame;
	 DialogFenster dialogFenster;
	 SpielerAnzAuswahlDialog spielerAnzAuswahlDialog;
	 Spieler1AuswahlDialog spieler1AuswahlDialog;
	 Spieler2AuswahlDialog spieler2AuswahlDialog;
	 Spieler3AuswahlDialog spieler3AuswahlDialog;
	 Spieler4AuswahlDialog spieler4AuswahlDialog;
	 GuiSpielbrett guiSpielbrett;
	 iBediener b;
	 MenuTop top;
	 MenuDialogLaden menuDialog;
	 

		
	
	
	    public EventHandler(DialogFenster dialogFenster) {
			this.dialogFenster=dialogFenster;
		}	
		public EventHandler(SpielerAnzAuswahlDialog spielerAnzAuswahlDialog) {
			this.spielerAnzAuswahlDialog=spielerAnzAuswahlDialog;
		}	
		public EventHandler(Spieler1AuswahlDialog spieler1AuswahlDialog) {
			this.spieler1AuswahlDialog=spieler1AuswahlDialog;
		}
		public EventHandler(Spieler2AuswahlDialog spieler2AuswahlDialog) {
			this.spieler2AuswahlDialog=spieler2AuswahlDialog;
		}
		public EventHandler(Spieler3AuswahlDialog spieler3AuswahlDialog) {
			this.spieler3AuswahlDialog=spieler3AuswahlDialog;
		}
		public EventHandler(Spieler4AuswahlDialog spieler4AuswahlDialog) {
			this.spieler4AuswahlDialog=spieler4AuswahlDialog;
		}
		public EventHandler(GuiSpielbrett guiSpielbrett) {
			this.guiSpielbrett=guiSpielbrett;
		}
		
		public EventHandler(MenuTop top){
			this.top=top;
		}
		
		public EventHandler(MenuDialogLaden menuDialog){
			this.menuDialog=menuDialog;
		}
		
	
		
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd=e.getActionCommand();	
	
		//------------Start--------------
		if(cmd.equals("button")){
			dialogFenster.fra.setVisible(false);
			dialogFenster.fra.dispose();
            new SpielerAnzAuswahlDialog();
        }
		
		
		else if(cmd.equals("buttonWeiter")){
			spielerAnzAuswahlDialog.frame.setVisible(false);
			spielerAnzAuswahlDialog.frame.dispose();
			new Spieler1AuswahlDialog(spielerAnzAuswahlDialog);
		}	
		else if(cmd.equals("spielStarten")){
			String name = spieler1AuswahlDialog.getNameEingabe().getText();
			
			if(name==null || name.length()<2){
				JOptionPane.showMessageDialog(spieler1AuswahlDialog,
						"Name muss mindestens 2 Zeichen enthalten!", 
						"ERROR!",
						JOptionPane.ERROR_MESSAGE);
			}
				
			else if(spieler1AuswahlDialog.zahl()==1){
				
				spieler1AuswahlDialog.frame.setVisible(false);
				spieler1AuswahlDialog.frame.dispose();
				new GuiSpielbrett(spieler1AuswahlDialog,null,null,null);
				
			}
			
			else if(spieler1AuswahlDialog.zahl()!=1){
				
				spieler1AuswahlDialog.frame.setVisible(false);
				spieler1AuswahlDialog.frame.dispose();
				new Spieler2AuswahlDialog(spieler1AuswahlDialog);
				
			}
			
		}	
		
		else if(cmd.equals("spielStarten2")){
			
			String name=spieler2AuswahlDialog.getNameEingabe().getText();
			
			if(name==null || name.length()<2){
				JOptionPane.showMessageDialog(spieler2AuswahlDialog,
						"Name muss mindestens 2 Zeichen enthalten !", 
						"ERROR!",
						JOptionPane.ERROR_MESSAGE);
			}
			
			else if(spieler2AuswahlDialog.getSpieler1().zahl()==2){
			spieler2AuswahlDialog.frame.setVisible(false);
			spieler2AuswahlDialog.frame.dispose();
			new GuiSpielbrett(spieler2AuswahlDialog.getSpieler1(),spieler2AuswahlDialog,
					null,null);
		}	
			
			else if(spieler2AuswahlDialog.getSpieler1().zahl()!=2){
				
				spieler2AuswahlDialog.frame.setVisible(false);
				spieler2AuswahlDialog.frame.dispose();
				new Spieler3AuswahlDialog(spieler2AuswahlDialog);
				
			}
			
		}
		
		
		else if(cmd.equals("spielStarten3")){
			
			String name=spieler3AuswahlDialog.getNameEingabe().getText();
			
			if(name==null || name.length()<2){
				JOptionPane.showMessageDialog(spieler3AuswahlDialog,
						"Name muss mindestens 2 Zeichen enthalten!", 
						"ERROR!",
						JOptionPane.ERROR_MESSAGE);
			}
			else if(spieler3AuswahlDialog.getSpieler2().getSpieler1().zahl()==3){
				spieler3AuswahlDialog.frame.setVisible(false);
				spieler3AuswahlDialog.frame.dispose();
				new GuiSpielbrett(spieler3AuswahlDialog.getSpieler2().getSpieler1(),
						spieler3AuswahlDialog.getSpieler2(),spieler3AuswahlDialog,null);
			}	
				
				else if(spieler3AuswahlDialog.getSpieler2().getSpieler1().zahl()!=3){
					
					spieler3AuswahlDialog.frame.setVisible(false);
					spieler3AuswahlDialog.frame.dispose();
					new Spieler4AuswahlDialog(spieler3AuswahlDialog);
					
				}
				
			}
		else if(cmd.equals("spielStarten4")){
			String name=spieler4AuswahlDialog.getNameEingabe().getText();
			
			if(name==null || name.length()<2){
				JOptionPane.showMessageDialog(spieler4AuswahlDialog,
						"Name muss mindestens 2 Zeichen enthalten!", 
						"ERROR!",
						JOptionPane.ERROR_MESSAGE);
			}
			else{
				spieler4AuswahlDialog.frame.setVisible(false);
				spieler4AuswahlDialog.frame.dispose();
				new GuiSpielbrett(spieler4AuswahlDialog.getSpieler3().getSpieler2().getSpieler1(),
						spieler4AuswahlDialog.getSpieler3().getSpieler2(),
						spieler4AuswahlDialog.getSpieler3(),spieler4AuswahlDialog);
			}
				
}
		
		
		else if(cmd.equals("wuerfeln")){
			guiSpielbrett.getSpiel().wuerfeln();
			guiSpielbrett.kiOderMensch();
			
			
			if(guiSpielbrett.getSpiel().getWuerfelZahl()==1){
				
				guiSpielbrett.getDiceLabel().setIcon(guiSpielbrett.getDice1());
				
			}
			
			if(guiSpielbrett.getSpiel().getWuerfelZahl()==2){
				
				guiSpielbrett.getDiceLabel().setIcon(guiSpielbrett.getDice2());
				
			}
			
			if(guiSpielbrett.getSpiel().getWuerfelZahl()==3){
				
				guiSpielbrett.getDiceLabel().setIcon(guiSpielbrett.getDice3());
				
			}
			if(guiSpielbrett.getSpiel().getWuerfelZahl()==4){
				
				guiSpielbrett.getDiceLabel().setIcon(guiSpielbrett.getDice4());
				
			}
			if(guiSpielbrett.getSpiel().getWuerfelZahl()==5){
				
				guiSpielbrett.getDiceLabel().setIcon(guiSpielbrett.getDice5());
				
			}
			if(guiSpielbrett.getSpiel().getWuerfelZahl()==6){
				
				guiSpielbrett.getDiceLabel().setIcon(guiSpielbrett.getDice6());
				
			}
			
		
			else if(cmd.equals("laufen")){			
				
				guiSpielbrett.laufKi();
				guiSpielbrett.getLaufen().setEnabled(false);
				guiSpielbrett.getFertig().setEnabled(true);
				for(JButton b:guiSpielbrett.getFelder()){	
					b.setDisabledIcon(b.getIcon());
				}
				
			
			}
		}
		
		
		
		else if(cmd.equals("feld")&&
				guiSpielbrett.getFertig().isEnabled()==false&&
				guiSpielbrett.hatButtonIcon(e)==true){
			
			guiSpielbrett.lauf(e);
			guiSpielbrett.getFertig().setEnabled(true);
			
			for(JButton b:guiSpielbrett.getFelder()){	
				b.setDisabledIcon(b.getIcon());
			}

//			gui.getWuerfeln().setEnabled(true);
		}
		

		else if(cmd.equals("beenden")){
			if(guiSpielbrett.getSpiel().ermittleGewinner()==true){
				Object[] options = {"ok!"};
				
                JOptionPane.showOptionDialog(null,"Du hast Gewonnen", "Gratuliere, das Spiel ist zu Ende",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, 
				null, options, options[0]);
                
				guiSpielbrett.getFertig().setEnabled(false);
				guiSpielbrett.getLaufen().setEnabled(false);
				guiSpielbrett.getWuerfeln().setEnabled(false);
				guiSpielbrett.unsButton();
				
			} 
		
			guiSpielbrett.getSpiel().beenden();
			guiSpielbrett.getFertig().setEnabled(false);
//			gui.getWuerfeln().setEnabled(true);
			guiSpielbrett.unsButton();
			
		}
		

		else if(cmd.equals("ser")){
			new MenuSpielSpeichern(MenuSpielSpeichern.ser);
		}
		else if(cmd.equals("csv")){
			new MenuSpielSpeichern(MenuSpielSpeichern.csv);
		}
		else if(cmd.equals("pdf")){
			new MenuSpielSpeichern(MenuSpielSpeichern.pdf);
		}
		

		
		
		
		
		
		
		
	}
		
	

}
