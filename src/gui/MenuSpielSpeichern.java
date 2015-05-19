package gui;

import java.io.File;

import interfaces.iDatenzugriff;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import Datenaustausch.DatenzugriffSerialisiert;

public class MenuSpielSpeichern extends JFrame{
	
	
	private static final long serialVersionUID = 1L;
	public static final int csv = 0;
	public static final int ser = 1;
	public static final int pdf = 2;
	public static boolean sf;
	private int format;
	private int status;

	private JFileChooser _fileChooser = new JFileChooser();
	public String pfad;

	
	public MenuSpielSpeichern(int format){
		this.format = format;
		speichern();
	}


	private void speichern() {
			if(format == csv){
				
				_fileChooser.setFileFilter(new FileNameExtensionFilter("*.csv","csv"));
				
	         
				status = _fileChooser.showSaveDialog(this);
				if(status == JFileChooser.APPROVE_OPTION){
					File f = _fileChooser.getSelectedFile();
					pfad = f.getAbsolutePath();
					f.getName();
					if(pfad.endsWith(".csv")){
						pfad = pfad.substring(0, pfad.length()-4);
					}
//					sp.saveGameSer(pfad);
//					SchiffeVersenken.getGame().saveGameCsv(pfad);
					Object options [] = {"OK"};
					JOptionPane.showOptionDialog(getJFrame(),"CSV-Datei erfolgreich gespeichert!", "Erfolg!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				}else{
					return;
				}
				
				
			}else if(format == ser){
				
				_fileChooser.setFileFilter(new FileNameExtensionFilter("*.ser","ser"));
				status = _fileChooser.showSaveDialog(this);
				if(status == JFileChooser.APPROVE_OPTION){
				File f = _fileChooser.getSelectedFile();
				pfad = f.getAbsolutePath();
				f.getName();

				if(pfad.endsWith(".ser")){
					pfad = pfad.substring(0, pfad.length()-4);
				}
//				System.out.println("HALLO");
				this.saveGameSer(pfad);
//				System.out.println(brett.getSpiel());
				
//				SchiffeVersenken.getGame().saveGameSer(pfad);
				Object options [] = {"OK"};
				JOptionPane.showOptionDialog(getJFrame(),"Serialisierte Datei erfolgreich gespeichert!", "Erfolg!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				System.out.println(pfad);
				}else{
					return;
				}
	}
				else if (format == pdf){
			
				_fileChooser.setFileFilter(new FileNameExtensionFilter("*.pdf","pdf"));
				status = _fileChooser.showSaveDialog(this);
				if(status == JFileChooser.APPROVE_OPTION){
				File f = _fileChooser.getSelectedFile();
				pfad = f.getAbsolutePath();
				f.getName();
				if(pfad.endsWith(".pdf")){
					pfad = pfad.substring(0, pfad.length()-4);
				}
		  		if(sf){
//		  			SchiffeVersenken.getGame().saveGamePdf(pfad,true);
		  		}else{
//		  			SchiffeVersenken.getGame().saveGamePdf(pfad,false);
		  		}
		  		Object options [] = {"OK"};
				JOptionPane.showOptionDialog(getJFrame(),"PDF-Datei erfolgreich gespeichert!", "Erfolg!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				}else{
					return;
				}
				
			}else{
				throw new RuntimeException("Falsche Wert�bergabe beim Speichern!");
				}
			
				
	}

	private JFrame getJFrame() {
		return this;
	}
	public void saveGameSer(String pfad){
		iDatenzugriff serialisieren = new DatenzugriffSerialisiert();
		serialisieren.speichern(GuiSpielbrett.gibSpielZurueck(),pfad+".ser");
	}
	
	
	
	

}
