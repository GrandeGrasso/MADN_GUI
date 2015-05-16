package gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfWriter;

import interfaces.iDatenzugriff;

/**
 * Diese Klasse bildet die PDF ab.

 */
public class DatenzugriffPDF implements iDatenzugriff {
	
	private FileOutputStream fileOut;
	 Document document;


	@Override
	public Object laden(String filename)  {
		
		System.err.println("Aus einer PDF datei kann das Spiel nicht geladen werden");
		return null;									
		//aus PDF kann nicht geladen werden


	}

	@Override
	public void speichern(Object spiel, String filename) {
		
		try{
			document.add((Element) spiel);
		}
		catch(DocumentException e){
			System.err.println("Fehler bei Dokumenterzeugung: "+e);
		}
		
	}
	
	public void oeffnen(File f) throws DocumentException, FileNotFoundException {
		try{
			document=new Document();
			fileOut=new FileOutputStream(f);
			PdfWriter.getInstance(document, fileOut);
			document.open();
		}catch(DocumentException e){
			System.err.println("Fehler bei Dokumenterzeugung: "+e);
		}catch(FileNotFoundException e){
			System.err.println("Datei nicht gefunden: "+e);
		}
		
		
	}

	public void schliessen(File f) throws IOException {
		try{
			document.close();
			fileOut.close();
		}
		catch(IOException e){
			System.err.println("Fehler bei Ein-/Ausgabe: "+e);
		}
		
	}


		
		
	}

	

