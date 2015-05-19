package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

	public class MenuTop extends JPanel{
	
	
	private static final long serialVersionUID = 1L;
	
	JMenuBar menuBar;
	JMenu datei,speichern;
	JMenuItem pdf,mail,ser,csv;
	JPanel pnlOben;
	private JLabel lblHeader;
	GuiSpielbrett gui;

	
	
	public MenuTop(){
		
		pnlOben = new JPanel();
		pnlOben.setLayout(new GridLayout(0,1,5,5));
		
		menuBar = new JMenuBar();
		
		datei= new JMenu("Datei");
		menuBar.add(datei);
		
		speichern = new JMenu("Speichern");
		datei.add(speichern);
		
		pdf= new JMenuItem("PDF");
		speichern.add(pdf);
		
		ser = new JMenuItem("Serial");
		speichern.add(ser);
		
		csv = new JMenuItem("CSV");
		speichern.add(csv);
		
		mail = new JMenuItem("send Mail");
		speichern.add(mail);
		
	
		
		lblHeader = new JLabel ("Das Original Brettspiel");
		lblHeader.setFont(lblHeader.getFont().deriveFont(Font.BOLD+ Font.ITALIC,30));
		lblHeader.setForeground(Color.WHITE);
		lblHeader.setOpaque(true);
		lblHeader.setBackground(Color.BLACK);
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		

		
		
		
		pnlOben.add(menuBar);
		pnlOben.add(lblHeader);
		addListener() ;
		
		
	}
	
	private void addListener() {
		
		ser.addActionListener(new EventHandler(this));
		ser.setActionCommand("ser");
		csv.addActionListener(new EventHandler(this));
		csv.setActionCommand("csv");
		pdf.addActionListener(new EventHandler(this));
		pdf.setActionCommand("pdf");
	
		
		
	}
	

	 
	 }
