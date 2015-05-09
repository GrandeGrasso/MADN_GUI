package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EventHandler implements ActionListener{
	
	 JFrame frame;
	 DialogFenster dialogFenster;
	 SpielerAnzAuswahlDialog spielerAnzAuswahlDialog;
	 Spieler1AuswahlDialog spieler1AuswahlDialog;
	 Spieler2AuswahlDialog spieler2AuswahlDialog;
	 Spieler3AuswahlDialog spieler3AuswahlDialog;
	 Spieler4AuswahlDialog spieler4AuswahlDialog;
	 GuiSpielbrett guiSpielbrett;
	 
	 
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
			new Spieler1AuswahlDialog();
		}	
		else if(cmd.equals("spielStarten")){
			spieler1AuswahlDialog.frame.setVisible(false);
			spieler1AuswahlDialog.frame.dispose();
			new Spieler2AuswahlDialog();
		}	
		
		else if(cmd.equals("spielStarten2")){
			spieler2AuswahlDialog.frame.setVisible(false);
			spieler2AuswahlDialog.frame.dispose();
			new Spieler3AuswahlDialog();
		}	
		else if(cmd.equals("spielStarten3")){
			spieler3AuswahlDialog.frame.setVisible(false);
			spieler3AuswahlDialog.frame.dispose();
			new Spieler4AuswahlDialog();
		}	
		else if(cmd.equals("spielStarten4")){
			new GuiSpielbrett();
			
		}	
	}
	
	
	
	
	
	
	
	
	public boolean hatButtonIcon(ActionEvent e){
		JButton feld=(JButton) e.getSource();
		
		if(feld.getIcon()!=null){
			return true;
		}
		return false;
	}
	

}
