package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import klassen.Spiel;
import klassen.Spielbrett;


public class GuiSpielbrett {

	
	JFrame frame = new JFrame();
	private JLabel imageBrett; 		
	private JLabel imageWuerfel;	
	private JLabel lblHeader;
	private JButton btnWuerfel;
	private JButton btnFigurZiehen;
	private JButton btnLaufen;
	private JPanel pnlAdd;
	private JPanel pnlRight;
	private JButton btnFertig;
	private JPanel pnlLeft;
	private JPanel pnlOben;
	
	private JLabel imageFigurRot;
	private JLabel imageFigurBlau;
	private JLabel imageFigurGelb;
	private JLabel imageFigurGruen;
	
	private JTextArea textArea;
	private JScrollPane scrollPane;
	
	private Spieler1AuswahlDialog spieler1;
	private Spieler2AuswahlDialog spieler2;
	private Spieler3AuswahlDialog spieler3;
	private Spieler4AuswahlDialog spieler4;
	

	private Spielbrett brett;
	private Spiel spiel;
	
	int [] zahl;
	
	
	private ArrayList<JButton>startRot;
	private ArrayList<JButton>startBlau;
	private ArrayList<JButton>startGruen;
	private ArrayList<JButton>startGelb;
	
	private ArrayList<JButton>endRot;
	private ArrayList<JButton>endBlau;
	private ArrayList<JButton>endGruen;
	private ArrayList<JButton>endGelb;
	
	private ArrayList<JButton> felder;
	
	JMenuBar menu;
	JMenu datei;
	JMenuItem speichern;
	
	JLabel sp1;
	JLabel sp2;
	JLabel sp3;
	JLabel sp4;
	

	ImageIcon figurRot1 =new ImageIcon("figurRot1.png");
	ImageIcon figurRot2=new ImageIcon("figurRot2.png");
	ImageIcon figurRot3 =new ImageIcon("figurRot3.png");
	ImageIcon figurRot4 =new ImageIcon("figurRot4.png");
	
	ImageIcon figurBlau1 =new ImageIcon("figurBlau1.png");
	ImageIcon figurBlau2=new ImageIcon("figurBlau2.png");
	ImageIcon figurBlau3 =new ImageIcon("figurBlau3.png");
	ImageIcon figurBlau4 =new ImageIcon("figurBlau4.png");
	
	ImageIcon figurGruen1 =new ImageIcon("figurGruen1.png");
	ImageIcon figurGruen2=new ImageIcon("figurGruen2.png");
	ImageIcon figurGruen3 =new ImageIcon("figurGruen3.png");
	ImageIcon figurGruen4 =new ImageIcon("figurGruen4.png");
	
	ImageIcon figurGelb1 =new ImageIcon("figurGelb1.png");
	ImageIcon figurGelb2=new ImageIcon("figurGelb2.png");
	ImageIcon figurGelb3 =new ImageIcon("figurGelb3.png");
	ImageIcon figurGelb4 =new ImageIcon("figurGelb4.png");
	
	
	
	
	
	
	public GuiSpielbrett(Spieler1AuswahlDialog spieler1,Spieler2AuswahlDialog spieler2,
			Spieler3AuswahlDialog spieler3,Spieler4AuswahlDialog spieler4){
	
	
		frame.setTitle("Mensch ärgere dich nicht"); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		zahl=new int[1];
		

		
		this.spieler1=spieler1;
		this.spieler2=spieler2;
		this.spieler3=spieler3;
		this.spieler4=spieler4;
		
//		addListener(); 
		createWidgets();
		addWidgets();
		
		spiel=new Spiel();
	
		frame.pack();
		addListener() ;
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	
	private  void addWidgets(){
		
		frame.getContentPane().setLayout(new BorderLayout(15,15));
		frame.getContentPane().add(BorderLayout.PAGE_START,pnlOben);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().add(BorderLayout.CENTER,imageBrett);
		frame.getContentPane().add(BorderLayout.LINE_END,pnlRight);
		frame.getContentPane().add(BorderLayout.LINE_START,pnlLeft);
		frame.getContentPane().add(BorderLayout.PAGE_END,scrollPane);
				
		
		
		pnlAdd.add(btnWuerfel);
		pnlAdd.add(btnFigurZiehen);
		pnlAdd.add(btnLaufen);
		
		
		
		pnlAdd.add(Box.createVerticalGlue());
		
//		pnlAdd.add(imageFigurRot);
//		pnlAdd.add(imageFigurBlau);
//		pnlAdd.add(imageFigurGelb);
//		pnlAdd.add(imageFigurGruen);
		
		
		
		
		pnlAdd.setMaximumSize(pnlAdd.getPreferredSize());
		pnlAdd.setAlignmentX(frame.LEFT_ALIGNMENT);
		
	
		
		pnlRight.add(pnlAdd);
		
		pnlRight.add(Box.createVerticalGlue());
		
		
		pnlRight.add(btnFertig);
		
		
		datei.add(speichern);
		menu.add(datei);
		pnlOben.add(lblHeader);

	
		pnlOben.add(menu);
	
		Message message = new Message(textArea);
		message.redirectOut();
		message.redirectErr(Color.red, null);
		message.setMessageLines(1000);
		
	
		//buttons fuer die roten Startfelder werden gesetzt
		startRot = new ArrayList<JButton>();
		for(int i=0; i<=3; i++){
			startRot.add(new JButton());
			imageBrett.add(startRot.get(i));
			startRot.get(i).setBorderPainted(false);
			startRot.get(i).setContentAreaFilled(false);
			startRot.get(i).addActionListener(new EventHandler(this));
			startRot.get(i).setActionCommand("feld");
		}
	
	
		startRot.get(0).setBounds(94, 19, 40, 50);
		startRot.get(1).setBounds(50, 19, 40, 50);
		startRot.get(2).setBounds(50,64, 40, 50);
		startRot.get(3).setBounds(94, 64,40, 50);
		
		
		// buttons fuer die blauen Startfelder werden gesetzt
		startBlau = new ArrayList<JButton>();
		
		for(int i=0; i<=3; i++){
			startBlau.add(new JButton());
			imageBrett.add(startBlau.get(i));
			startBlau.get(i).setBorderPainted(false);
			startBlau.get(i).setContentAreaFilled(false);
			startBlau.get(i).addActionListener(new EventHandler(this));
			startBlau.get(i).setActionCommand("feld");
		}
		startBlau.get(0).setBounds(475, 19, 40, 50);
		startBlau.get(1).setBounds(432, 19, 40, 50);
		startBlau.get(2).setBounds(432, 64, 40, 50);
		startBlau.get(3).setBounds(475, 63, 40, 50);
		
		
		// buttons fuer die gruenen Startfelder werden gesetzt
		startGruen = new ArrayList<JButton>();
		
		for(int i=0; i<=3; i++){
			startGruen.add(new JButton());
			imageBrett.add(startGruen.get(i));
			startGruen.get(i).setBorderPainted(false);
			startGruen.get(i).setContentAreaFilled(false);
			startGruen.get(i).addActionListener(new EventHandler(this));
			startGruen.get(i).setActionCommand("feld");
		}
		startGruen.get(0).setBounds(475, 400, 40, 50);
		startGruen.get(1).setBounds(432, 400, 40, 50);
		startGruen.get(2).setBounds(432, 445, 40, 50);
		startGruen.get(3).setBounds(475, 445, 40, 50);
		
		
		// buttons fuer die gelben Startfelder werden gesetzt
		startGelb = new ArrayList<JButton>();
		
		for(int i=0; i<=3; i++){
			startGelb.add(new JButton());
			imageBrett.add(startGelb.get(i));
			startGelb.get(i).setBorderPainted(false);
			startGelb.get(i).setContentAreaFilled(false);
			startGelb.get(i).addActionListener(new EventHandler(this));
			startGelb.get(i).setActionCommand("feld");
		}
		startGelb.get(0).setBounds(94, 400, 40, 50);
		startGelb.get(1).setBounds(50, 400, 40, 50);
		startGelb.get(2).setBounds(94, 445, 40, 50);
		startGelb.get(3).setBounds(50, 445, 40, 50);
		
		
		//endfelder
		endRot = new ArrayList<JButton>();
		
		for(int i=0; i<=3; i++){
			endRot.add(new JButton());
			imageBrett.add(endRot.get(i));
			endRot.get(i).setBorderPainted(true);
			endRot.get(i).setContentAreaFilled(false);
			endRot.get(i).addActionListener(new EventHandler(this));
			endRot.get(i).setActionCommand("feld");
		}
		endRot.get(0).setBounds(103,245,21, 27);
		endRot.get(1).setBounds(145,245,21, 27);
		endRot.get(2).setBounds(186, 245,21, 27);
		endRot.get(3).setBounds(229, 245,21, 27);
		
		endBlau = new ArrayList<JButton>();
		
		for(int i=0; i<=3; i++){
			endBlau.add(new JButton());
			imageBrett.add(endBlau.get(i));
			endBlau.get(i).setBorderPainted(true);
			endBlau.get(i).setContentAreaFilled(false);
			endBlau.get(i).addActionListener(new EventHandler(this));
			endBlau.get(i).setActionCommand("feld");
		}
		endBlau.get(0).setBounds(271, 71,21, 27);
		endBlau.get(1).setBounds(271, 115,21, 27);
		endBlau.get(2).setBounds(271, 159,21, 27);
		endBlau.get(3).setBounds(271, 203,21, 27);
		
		endGruen = new ArrayList<JButton>();
		
		for(int i=0; i<=3; i++){
			endGruen .add(new JButton());
			imageBrett.add(endGruen .get(i));
			endGruen .get(i).setBorderPainted(true);
			endGruen .get(i).setContentAreaFilled(false);
			endGruen .get(i).addActionListener(new EventHandler(this));
			endGruen .get(i).setActionCommand("feld");
		}
		endGruen .get(0).setBounds(441,245,21, 27);
		endGruen .get(1).setBounds(398,245,21, 27);
		endGruen .get(2).setBounds(354,245,21, 27);
		endGruen .get(3).setBounds(311,245,21, 27);
		
		endGelb = new ArrayList<JButton>();
		
		for(int i=0; i<=3; i++){
			endGelb .add(new JButton());
			imageBrett.add(endGelb.get(i));
			endGelb.get(i).setBorderPainted(true);
			endGelb.get(i).setContentAreaFilled(false);
			endGelb.get(i).addActionListener(new EventHandler(this));
			endGelb.get(i).setActionCommand("feld");
		}
		endGelb.get(0).setBounds(271, 410,21, 27);
		endGelb.get(1).setBounds(271, 368,21, 27);
		endGelb.get(2).setBounds(271, 326,21, 27);
		endGelb.get(3).setBounds(271, 284,21, 27);
		
//		felder
		felder=new ArrayList<JButton>();
		for(int i=0; i<=39;i++){
			felder.add(new JButton());
			imageBrett.add(felder.get(i));
			felder.get(i).setBorderPainted(true);
			felder.get(i).setContentAreaFilled(false);
			felder.get(i).addActionListener(new EventHandler(this));
			felder.get(i).setActionCommand("feld");
		}
		
		felder.get(0).setBounds(57, 200,25, 34);
		felder.get(1).setBounds(99, 200,25, 34);
		felder.get(2).setBounds(142, 200,25, 34);
		felder.get(3).setBounds(185,200,25, 34);
		felder.get(4).setBounds(227,200,25, 34);
		felder.get(5).setBounds(227,155,25, 34);
		felder.get(6).setBounds(227,111,25, 34);
		felder.get(7).setBounds(227,68,25, 34);
		felder.get(8).setBounds(227,26,25, 34);
		felder.get(9).setBounds(270,26,25, 34);
		felder.get(10).setBounds(312,26,25, 34);
		felder.get(11).setBounds(312,70,25, 34);
		felder.get(12).setBounds(312,113,25, 34);
		felder.get(13).setBounds(312,155,25, 34);
		felder.get(14).setBounds(312,196,25, 34);
		felder.get(15).setBounds(353,196,25, 34);
		felder.get(16).setBounds(397,196,25, 34);
		felder.get(17).setBounds(438,196,25, 34);
		felder.get(18).setBounds(482,196,25, 34);
		felder.get(19).setBounds(482,241,25, 34);
		felder.get(20).setBounds(482,280,25, 34);
		felder.get(21).setBounds(438,280,25, 34);
		felder.get(22).setBounds(396,280,25, 34);
		felder.get(23).setBounds(353,280,25, 34);
		felder.get(24).setBounds(311,280,25, 34);
		felder.get(25).setBounds(311,325,25, 34);
		felder.get(26).setBounds(311,368,25, 34);
		felder.get(27).setBounds(311,411,25, 34);
		felder.get(28).setBounds(311,453,25, 34);
		felder.get(29).setBounds(270,453,25, 34);
		felder.get(30).setBounds(228,453,25, 34);
		felder.get(31).setBounds(228,410,25, 34);
		felder.get(32).setBounds(228,367,25, 34);
		felder.get(33).setBounds(228,323,25, 34);
		felder.get(34).setBounds(228,282,25, 34);
		felder.get(35).setBounds(185,282,25, 34);
		felder.get(36).setBounds(142,282,25, 34);
		felder.get(37).setBounds(100,282,25, 34);
		felder.get(38).setBounds(58,282,25, 34);
		felder.get(39).setBounds(58,240,25, 34);
		
		
		
		
		// figuren werden von spieler 1 auf die startfelder
				// mit der entsprechenden Farbe gesetzt die er gewaehlt hat
				
				if(spieler1.zahl()==1){
					Color farbe1 = spieler1.farbAuswahl((String)spieler1.getFarbAuswahl().
							getSelectedItem());

					if(	farbe1 == Color.RED){
				// rote Spielfiguren werden auf rote Startfelder gesetzt 
				startRot.get(0).setIcon(figurRot1);
				startRot.get(1).setIcon(figurRot2);
				startRot.get(2).setIcon(figurRot3);
				startRot.get(3).setIcon(figurRot4);
				
				pnlAdd.add(imageFigurRot);
					}
				
					
					
					else if(farbe1 == Color.BLUE){
				// blaue Spielfiguren werden auf blaue Startfelder gesetzt 
				startBlau.get(0).setIcon(figurBlau1);
				startBlau.get(1).setIcon(figurBlau2);
				startBlau.get(2).setIcon(figurBlau3);
				startBlau.get(3).setIcon(figurBlau4);
				
				pnlAdd.add(imageFigurBlau);
					}
					
				
					else if( farbe1 == Color.GREEN){
				// gruene Spielfiguren werden auf gruene Startfelder gesetzt
				startGruen.get(0).setIcon(figurGruen1);
				startGruen.get(1).setIcon(figurGruen2);
				startGruen.get(2).setIcon(figurGruen3);
				startGruen.get(3).setIcon(figurGruen4);
				
				pnlAdd.add(imageFigurGruen);
					}
				
				
					else if(farbe1 == Color.ORANGE){
				// gelbe Spielfiguren werden auf gruene Startfelder gesetzt
				startGelb.get(0).setIcon(figurGelb1);
				startGelb.get(1).setIcon(figurGelb2);
				startGelb.get(2).setIcon(figurGelb3);
				startGelb.get(3).setIcon(figurGelb4);
				
				pnlAdd.add(imageFigurGelb);
				
				
					}
					
			}
				
				// figuren werden von spieler 2 auf die startfelder
				// mit der entsprechenden Farbe gesetzt die er gewaehlt hat
				if(spieler1.zahl()==2){
					Color farbe1 = spieler1.farbAuswahl((String)spieler1.getFarbAuswahl().
							getSelectedItem());
					Color farbe2 = spieler2.farbAuswahl((String)spieler2.getFarbAuswahl().
							getSelectedItem());
					
					
					
					if(	farbe1 == Color.RED ||farbe2 == Color.RED ){
						// rote Spielfiguren werden auf rote Startfelder gesetzt 
						startRot.get(0).setIcon(figurRot1);
						startRot.get(1).setIcon(figurRot2);
						startRot.get(2).setIcon(figurRot3);
						startRot.get(3).setIcon(figurRot4);
						
						pnlAdd.add(imageFigurRot);
							}
						
							
							
							if(farbe1 == Color.BLUE || farbe2 == Color.BLUE){
						// blaue Spielfiguren werden auf blaue Startfelder gesetzt 
						startBlau.get(0).setIcon(figurBlau1);
						startBlau.get(1).setIcon(figurBlau2);
						startBlau.get(2).setIcon(figurBlau3);
						startBlau.get(3).setIcon(figurBlau4);
						
						pnlAdd.add(imageFigurBlau);
							}
							
						
							if( farbe1 == Color.GREEN|| farbe2 == Color.GREEN){
						// gruene Spielfiguren werden auf gruene Startfelder gesetzt
						startGruen.get(0).setIcon(figurGruen1);
						startGruen.get(1).setIcon(figurGruen2);
						startGruen.get(2).setIcon(figurGruen3);
						startGruen.get(3).setIcon(figurGruen4);
						
						pnlAdd.add(imageFigurGruen);
							}
						
						
							if(farbe1 == Color.ORANGE || farbe2 == Color.ORANGE){
						// gelbe Spielfiguren werden auf gruene Startfelder gesetzt
						startGelb.get(0).setIcon(figurGelb1);
						startGelb.get(1).setIcon(figurGelb2);
						startGelb.get(2).setIcon(figurGelb3);
						startGelb.get(3).setIcon(figurGelb4);
						
						pnlAdd.add(imageFigurGelb);
						
						
							}
							
					}
				
				// figuren werden von spieler 3 auf die startfelder
				// mit der entsprechenden Farbe gesetzt die er gewaehlt hat
				
				if(spieler1.zahl()==3){
					Color farbe1 = spieler1.farbAuswahl((String)spieler1.
							getFarbAuswahl().getSelectedItem());
					Color farbe2 = spieler2.farbAuswahl((String)spieler2.
							getFarbAuswahl().getSelectedItem());
					Color farbe3 = spieler3.farbAuswahl((String)spieler3.
							getFarbAuswahl().getSelectedItem());
					
					if(farbe1 == Color.RED||farbe2 == Color.RED||farbe3 == Color.RED){
						// rote Spielfiguren werden auf rote Startfelder gesetzt 
						startRot.get(0).setIcon(figurRot1);
						startRot.get(1).setIcon(figurRot2);
						startRot.get(2).setIcon(figurRot3);
						startRot.get(3).setIcon(figurRot4);
						
						pnlAdd.add(imageFigurRot);
					}
					if(farbe1 == Color.BLUE||farbe2== Color.BLUE||farbe3== Color.BLUE){
						// rote Spielfiguren werden auf blaue Startfelder gesetzt 
						startBlau.get(0).setIcon(figurBlau1);
						startBlau.get(1).setIcon(figurBlau2);
						startBlau.get(2).setIcon(figurBlau3);
						startBlau.get(3).setIcon(figurBlau4);
						
						pnlAdd.add(imageFigurBlau);
					}
					if(farbe1 == Color.GREEN||farbe2 == Color.GREEN||farbe3 == Color.GREEN){
						// rote Spielfiguren werden auf gruene Startfelder gesetzt 
						startGruen.get(0).setIcon(figurGruen1);
						startGruen.get(1).setIcon(figurGruen2);
						startGruen.get(2).setIcon(figurGruen3);
						startGruen.get(3).setIcon(figurGruen4);
						
						pnlAdd.add(imageFigurGruen);
					}
					if(farbe1 == Color.ORANGE||farbe2 == Color.ORANGE||farbe3 == Color.ORANGE){
						// rote Spielfiguren werden auf gelbe Startfelder gesetzt 
						startGelb.get(0).setIcon(figurGelb1);
						startGelb.get(1).setIcon(figurGelb2);
						startGelb.get(2).setIcon(figurGelb3);
						startGelb.get(3).setIcon(figurGelb4);
						
						pnlAdd.add(imageFigurGelb);
					}
				}
				
				// figuren werden von spieler 3 auf die startfelder
				// mit der entsprechenden Farbe gesetzt die er gewaehlt hat
				
				if(spieler1.zahl()==4){
					Color farbe1 = spieler1.farbAuswahl((String)spieler1.
							getFarbAuswahl().getSelectedItem());
					Color farbe2 = spieler2.farbAuswahl((String)spieler2.
							getFarbAuswahl().getSelectedItem());
					Color farbe3 = spieler3.farbAuswahl((String)spieler3.
							getFarbAuswahl().getSelectedItem());
					Color farbe4 = spieler4.farbAuswahl((String)spieler4.
							getFarbAuswahl().getSelectedItem());
					
					if(farbe1 == Color.RED||farbe2 == Color.RED||farbe3 == Color.RED||farbe4 == Color.RED){
						// rote Spielfiguren werden auf rote Startfelder gesetzt 
						startRot.get(0).setIcon(figurRot1);
						startRot.get(1).setIcon(figurRot2);
						startRot.get(2).setIcon(figurRot3);
						startRot.get(3).setIcon(figurRot4);
						
						pnlAdd.add(imageFigurRot);
					}
					if(farbe1 == Color.BLUE||farbe2== Color.BLUE||farbe3 == Color.BLUE||farbe4== Color.BLUE){
						// rote Spielfiguren werden auf blaue Startfelder gesetzt 
						startBlau.get(0).setIcon(figurBlau1);
						startBlau.get(1).setIcon(figurBlau2);
						startBlau.get(2).setIcon(figurBlau3);
						startBlau.get(3).setIcon(figurBlau4);
						
						pnlAdd.add(imageFigurBlau);
					}
					if(farbe1 == Color.GREEN||farbe2 == Color.GREEN||farbe3 == Color.GREEN||farbe4 == Color.GREEN){
						// rote Spielfiguren werden auf gruene Startfelder gesetzt 
						startGruen.get(0).setIcon(figurGruen1);
						startGruen.get(1).setIcon(figurGruen2);
						startGruen.get(2).setIcon(figurGruen3);
						startGruen.get(3).setIcon(figurGruen4);
						
						pnlAdd.add(imageFigurGruen);
					}
					if(farbe1 == Color.ORANGE||farbe2 == Color.ORANGE||farbe3 == Color.YELLOW||farbe4 == Color.ORANGE){
						// rote Spielfiguren werden auf gelbe Startfelder gesetzt 
						startGelb.get(0).setIcon(figurGelb1);
						startGelb.get(1).setIcon(figurGelb2);
						startGelb.get(2).setIcon(figurGelb3);
						startGelb.get(3).setIcon(figurGelb4);
						
						pnlAdd.add(imageFigurGelb);
					}
				}
			
		
		

//		if(spieler1.zahl()==4){
//			pnlAdd.add(imageFigurRot);
//			pnlAdd.add(imageFigurBlau);
//			pnlAdd.add(imageFigurGelb);
//			pnlAdd.add(imageFigurGruen);
//		}
//		else if(spieler1.zahl()==3){
//		pnlAdd.add(imageFigurRot);
//		pnlAdd.add(imageFigurBlau);
//		pnlAdd.add(imageFigurGelb);
//		
//		}
//		else if(spieler1.zahl()==2){
//			pnlAdd.add(imageFigurRot);
//			pnlAdd.add(imageFigurBlau);
//		
//			
//		}
//		else if(spieler1.zahl()==1){
//			pnlAdd.add(imageFigurRot);
//			
//		}
//		
		
		
		
		
	}
		
		
	
		
		
		
	
	
	
	

	private void createWidgets(){
		
		lblHeader = new JLabel ("Das Original Brettspiel");
		lblHeader.setFont(lblHeader.getFont().deriveFont(Font.BOLD+ Font.ITALIC,30));
		lblHeader.setForeground(Color.WHITE);
		lblHeader.setOpaque(true);
		lblHeader.setBackground(Color.BLACK);
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		imageBrett = new JLabel(new ImageIcon("brett1.jpg")); 		
		imageWuerfel = new JLabel(new ImageIcon("wuerfel5.jpg"));
		
		imageFigurRot = new JLabel(new ImageIcon("figurRotBild.png")); 
		imageFigurRot.setToolTipText("Spieler Rot");
		imageFigurBlau = new JLabel(new ImageIcon("figurBlauBild.png"));
		imageFigurBlau.setToolTipText("Spieler Blau");
		
		imageFigurGelb = new JLabel(new ImageIcon("figurGelbBild.png"));
		imageFigurGelb.setToolTipText("Spieler Gelb");
		
		imageFigurGruen = new JLabel(new ImageIcon("figurGruenBild.png"));
		imageFigurGruen.setToolTipText("Spieler Gruen");
		
		

		btnWuerfel= new JButton("würfeln");
		btnLaufen= new JButton("laufen");
		btnFigurZiehen= new JButton("ziehe Figur");
		btnFertig = new JButton("Fertig");
		
		btnFertig.setAlignmentX(frame.LEFT_ALIGNMENT);
		
		
		pnlAdd= new JPanel();
		pnlAdd.setLayout(new GridLayout(0,1,5,5));
		
		pnlRight= new JPanel();
		pnlRight.setLayout(new BoxLayout(pnlRight,BoxLayout.PAGE_AXIS));
		pnlRight.setBackground(Color.BLACK);
		pnlRight.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
		pnlAdd.setBackground(Color.BLACK);
		
		pnlLeft = new JPanel();
		pnlLeft.add(imageWuerfel);
		pnlLeft.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
		pnlLeft.setBackground(Color.BLACK);
	

		textArea = new JTextArea();
		textArea.setFont(textArea.getFont().deriveFont(Font.BOLD+ Font.ITALIC,20));
		textArea.setEditable(false);
		
		scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(120,80));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
	
		
		pnlOben = new JPanel();
		pnlOben.setLayout(new GridLayout(0,1,5,5));
		
		menu = new JMenuBar();
		datei= new JMenu("Datei");
		speichern = new JMenuItem("Speichern");
		
		datei.setForeground(Color.white);
		speichern.setForeground(Color.BLACK);
		datei.setBackground(Color.black);
		datei.setOpaque(true);
		
			
		
		
	
	
		//auswhahl spieler
				if(spieler1.zahl()==4){
					
					
					sp1=new JLabel(spieler1.getNameEingabe().getText());
					sp1.setForeground(spieler1.farbAuswahl(
							(String)spieler1.getFarbAuswahl().getSelectedItem()));
					
				sp1.setMaximumSize(new Dimension(Integer.MAX_VALUE,30));
					
					
					
					imageFigurRot = new JLabel(new ImageIcon("figurRotBild.png")); 
					imageFigurRot.setToolTipText(spieler1.getNameEingabe().getText());
					imageFigurRot.setForeground (spieler1.farbAuswahl(
							(String)spieler1.getFarbAuswahl().getSelectedItem()));
					
					imageFigurBlau = new JLabel(new ImageIcon("figurBlauBild.png"));
					imageFigurBlau.setToolTipText(spieler2.getNameEingabe().getText());
					
					imageFigurGelb = new JLabel(new ImageIcon("figurGelbBild.png"));
					imageFigurGelb.setToolTipText(spieler3.getNameEingabe().getText());
					
					imageFigurGruen = new JLabel(new ImageIcon("figurGruenBild.png"));
					imageFigurGruen.setToolTipText(spieler4.getNameEingabe().getText());
					
				}
				else if(spieler1.zahl()==3){
					imageFigurRot = new JLabel(new ImageIcon("figurRotBild.png")); 
					imageFigurRot.setToolTipText(spieler1.getNameEingabe().getText());
					
					imageFigurBlau = new JLabel(new ImageIcon("figurBlauBild.png"));
					imageFigurBlau.setToolTipText(spieler2.getNameEingabe().getText());
					
					imageFigurGelb = new JLabel(new ImageIcon("figurGelbBild.png"));
					imageFigurGelb.setToolTipText(spieler3.getNameEingabe().getText());
					
				}
				else if(spieler1.zahl()==2){
					imageFigurRot = new JLabel(new ImageIcon("figurRotBild.png")); 
					imageFigurRot.setToolTipText(spieler1.getNameEingabe().getText());
					
					imageFigurBlau = new JLabel(new ImageIcon("figurBlauBild.png"));
					imageFigurBlau.setToolTipText(spieler2.getNameEingabe().getText());
			
					
				}
				else if(spieler1.zahl()==1){
					imageFigurRot = new JLabel(new ImageIcon("figurRotBild.png")); 
					imageFigurRot.setToolTipText(spieler1.getNameEingabe().getText());
			
			
				}
				

    }

	public Spieler1AuswahlDialog getSpieler1(){
		return spieler1;
	}
	
	public Spieler2AuswahlDialog getSpieler2(){
		return spieler2;
	}
	
	public Spieler3AuswahlDialog getSpieler3(){
		return spieler3;
	}
	
	public Spieler4AuswahlDialog getSpieler4(){
		return spieler4;
	}
	
	
	

	private void addListener() {
		btnLaufen.addActionListener(new EventHandler(this));
		btnLaufen.setActionCommand("laufen");
		btnWuerfel.addActionListener(new EventHandler(this));
		btnWuerfel.setActionCommand("wuerfeln");
		btnFertig.addActionListener(new EventHandler(this));
		btnFertig.setActionCommand("beenden");
	}
	
	public ArrayList<JButton> getStartRot(){
		return startRot;
	}
	
	public ArrayList<JButton> getStartBlau(){
		return startBlau;
	}
	
	public ArrayList<JButton> getStartGruen(){
		return startGruen;
	}
	
	public ArrayList<JButton> getStartGelb(){
		return startGelb;
	}
	
	public ArrayList<JButton> getEndRot(){
		return endRot;
	}
	
	public ArrayList<JButton> getEndBlau(){
		return endBlau;
	}
	
	public ArrayList<JButton> getEndGruen(){
		return endGruen;
	}
	
	public ArrayList<JButton> getEndGeld(){
		return endGelb;
	}
	
	public ArrayList<JButton> getFelder(){
		return felder;
		
	}
	public JButton getWuerfeln(){
		return btnWuerfel;
	}
	
	public int[] getZahl(){
		return zahl;
	}

	public JButton getLaufen(){
		return btnLaufen;
	}
	
	public JButton getFertig(){
		return btnFertig;
	}
	

	

	}
	

