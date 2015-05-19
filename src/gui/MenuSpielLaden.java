package gui;


import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import Datenaustausch.DatenzugriffSerialisiert;
import interfaces.iBediener;
import interfaces.iDatenzugriff;

public class MenuSpielLaden extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JLabel jl = new JLabel("");
	private JFileChooser jfc;
	private String pfad;
	private String datei = "";
	private boolean richtigerDateityp = false;
	private iDatenzugriff load;
	private iBediener sp;

	public MenuSpielLaden() {
		super("Spiel Laden");
		JPanel jp = new JPanel();
		this.add(jl);
		this.setContentPane(jp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(false);

		jfc = new JFileChooser();
		
		int status = jfc.showOpenDialog(this);
		
		if (status == JFileChooser.APPROVE_OPTION) {
			File f = jfc.getSelectedFile();
			pfad = f.getAbsolutePath();
			datei = f.getName();
			
			if (datei.endsWith(".csv") || datei.endsWith(".ser")) {
				richtigerDateityp = true;

			} else {
				Object[] options = { "OK" };
				JOptionPane.showOptionDialog(this,"Falsche Datei versucht zu laden!\nZul�ssige Formate: '.csv' oder '.ser'!","Achtung!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE, null, options,options[0]);
				this.setVisible(false); // verschwinden lassen
				this.dispose();
				new MenuSpielLaden();
				return;
			}

		} else if (status == JFileChooser.CANCEL_OPTION) {
			this.setEnabled(false);
			this.setVisible(false); // verschwinden lassen
			this.dispose(); // abr�umen
			new MenuSpielLaden();
		}
		
		if(richtigerDateityp){
//			if(pfad.endsWith(".csv")){
//				pfad = pfad.substring(0, pfad.length()-4);
//				SchiffeVersenken s = SchiffeVersenken.loadGameCsv(pfad);
//				SchiffeVersenken.setSchiffeVersenken(s);
//				this.dispose();
//				new SpielfeldSpielzug();
//			}
			if(pfad.endsWith(".ser")){
				//pfad = pfad.substring(0, pfad.length()-4);
//				SchiffeVersenken s = SchiffeVersenken.loadGameSer(pfad);
//				Object zugriff = load.laden(pfad);
				DatenzugriffSerialisiert d = new DatenzugriffSerialisiert();
				d.laden(pfad);
				this.dispose();
//				SchiffeVersenken.setSchiffeVersenken(s);
				this.dispose();
				new GuiSpielbrett(null, null, null, null);
			}
		}
	}
}
