//package gui;
//
//
//import interfaces.iBediener;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.File;
//
//import javax.swing.JFileChooser;
//import javax.swing.JOptionPane;
//import javax.swing.filechooser.FileFilter;
//import javax.swing.filechooser.FileNameExtensionFilter;
//
//
//
//public class SaveAL implements ActionListener{
//	private JFileChooser fileChoos2=new JFileChooser();
//	private static FileFilter f= new FileNameExtensionFilter("PDF", "pdf");
//	private static FileFilter f1= new FileNameExtensionFilter("Serialisierung", "ser");
//	private static FileFilter f2= new FileNameExtensionFilter("CSV", "txt");
//	private iBediener sv;
//		private Oben gui;
//	
//	public SaveAL(SchiffeVersenken sv,Oben gui){
//		this.sv=sv;
//		this.gui=gui;
//		
//	}
//	
//	@Override
//	public void actionPerformed(ActionEvent arg0) {
////		if(sv.getAnzSpieler()!=2){
////			gui.fehler("Es kann erst gespeichert werden wenn beide Spieler angemeldet sind!");
////		}else{
//		fileChoos2.setAcceptAllFileFilterUsed(false);
//		fileChoos2.addChoosableFileFilter(f);
//		fileChoos2.addChoosableFileFilter(f1);
//		fileChoos2.addChoosableFileFilter(f2);
//		
//		int rückgabeWert=fileChoos2.showSaveDialog(gui);
//		if(rückgabeWert == JFileChooser.APPROVE_OPTION){
//			File file=fileChoos2.getSelectedFile();
//			boolean ja=false;
//			
//			File ftest=new File(file.getAbsolutePath());
//			if(fileChoos2.getFileFilter()==f1){
//				ftest=new File(file.getAbsolutePath()+".ser");
//			}
//			if(fileChoos2.getFileFilter()==f2){
//				ftest=new File(file.getAbsolutePath()+".txt");
//			}
//			if(fileChoos2.getFileFilter()==f){
//				ftest=new File(file.getAbsolutePath()+".pdf");
//			}
//			if(ftest.isFile()){
//				int rück=JOptionPane.showConfirmDialog(fileChoos2,"Eine Datei mit diesem Namen existiert bereits. \nMöchten Sie den Spielstand überschreiben?",
//						"Speichern", JOptionPane.YES_NO_OPTION);
//				if(rück==JOptionPane.NO_OPTION){
//					
//					this.update(sv);
//
//					return;
//					
//				}
//				ja=true;
//			}else{
//				try{
//					if(file.createNewFile()){
//						if(file.isFile()){
//							file.delete();
//							ja=true;
//							this.update(sv);
//						}
//					}
//				}catch(Exception e){
//					gui.fehler("Ungültiger Speicherort","Speichern");
//					//this.ButtonSpeichern_Clicked();
//				}
//				
//			}
//			if(ja){
//				if(fileChoos2.getFileFilter()==f1){
//					this.sv.speichernSerial(file.getAbsolutePath());
//				}
//				if(fileChoos2.getFileFilter()==f2){
//					this.sv.speichernCSV(file.getAbsolutePath());
//				}
//				if(fileChoos2.getFileFilter()==f){
//					this.sv.speichernPDF(file.getAbsolutePath(),true);
//				}
//			}
//		}		
////	}
//	}
//	
//	public void update(SchiffeVersenken sv){
//		gui.update(sv);
//	}
//}
