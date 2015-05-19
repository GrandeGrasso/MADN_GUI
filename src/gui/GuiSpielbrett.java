package gui;

import interfaces.iBediener;
import interfaces.iDatenzugriff;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import Datenaustausch.DatenzugriffSerialisiert;

import com.itextpdf.text.Element;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;

import klassen.KI_Aggressiv;
import klassen.Spiel;
import klassen.Spielbrett;


public class GuiSpielbrett  extends JFrame{

	
	JFrame frame = new JFrame();
	private JLabel imageBrett; 	
	private JButton wuerfeln;
	private JButton btnLaufen;
	private JPanel pnlAdd;
	private JPanel pnlRight;
	private JButton btnFertig;
	private JPanel pnlLeft;

	
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
	

	private static iBediener spiel;
	private EventHandler event;
	GuiSpielbrett gui;
	
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
	
	
	JLabel sp1;
	JLabel sp2;
	JLabel sp3;
	JLabel sp4;
	

	JLabel diceLabel = new JLabel(new ImageIcon());
	ImageIcon dice1 = new ImageIcon("wuerfel1.jpg");
	ImageIcon dice2 = new ImageIcon("wuerfel2.jpg");
	ImageIcon dice3 = new ImageIcon("wuerfel3.jpg");
	ImageIcon dice4 = new ImageIcon("wuerfel4.jpg");
	ImageIcon dice5 = new ImageIcon("wuerfel5.jpg");
	ImageIcon dice6 = new ImageIcon("wuerfel6.jpg");
	

	private ArrayList<ImageIcon> rot;
	private ArrayList<ImageIcon> blau;
	private ArrayList<ImageIcon> gruen;
	private ArrayList<ImageIcon> gelb;
	
	private MenuTop menuTop;
	
	KI_Aggressiv kiA;
	


	

	
	public GuiSpielbrett(Spieler1AuswahlDialog spieler1,Spieler2AuswahlDialog spieler2,
			Spieler3AuswahlDialog spieler3,Spieler4AuswahlDialog spieler4){
	
	
		frame.setTitle("Mensch ärgere dich nicht"); 
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		GuiSpielbrett.spielErstellen();
		zahl=new int[1];
		
		this.spieler1=spieler1;
		this.spieler2=spieler2;
		this.spieler3=spieler3;
		this.spieler4=spieler4;
		this.menuTop = new MenuTop();


		createWidgets();
		addWidgets();
		
		
		
		frame.pack();
		addListener() ;
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
		
		 WindowListener winListener = new WindowAdapter(){
			 public void windowClosing(WindowEvent e){
				int antw=JOptionPane.showConfirmDialog(GuiSpielbrett.this, "Möchtst du "
						+ " das Spiel wirklich verlassen?","Spiel verlassen?",
						JOptionPane.YES_NO_OPTION);
				if(antw==JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
					}
				}
		 };
		 frame.addWindowListener(winListener);
	}
	
	
	private  void addWidgets(){
		
		frame.getContentPane().setLayout(new BorderLayout(15,15));
		frame.getContentPane().add(BorderLayout.PAGE_START,menuTop.pnlOben);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().add(BorderLayout.CENTER,imageBrett);
		frame.getContentPane().add(BorderLayout.LINE_END,pnlRight);
		frame.getContentPane().add(BorderLayout.LINE_START,pnlLeft);
		frame.getContentPane().add(BorderLayout.PAGE_END,scrollPane);
				
		
		
		pnlAdd.add(wuerfeln);
		pnlAdd.add(btnLaufen);
		
		
		
		pnlAdd.add(Box.createVerticalGlue());
		

		pnlAdd.setMaximumSize(pnlAdd.getPreferredSize());
		pnlAdd.setAlignmentX(frame.LEFT_ALIGNMENT);
		
	
		
		pnlRight.add(pnlAdd);
		
		pnlRight.add(Box.createVerticalGlue());
		
		
		pnlRight.add(btnFertig);
		
		
		pnlLeft.add(diceLabel);
			
	
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
			endRot.get(i).setBorderPainted(false);
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
			endBlau.get(i).setBorderPainted(false);
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
			endGruen .get(i).setBorderPainted(false);
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
			endGelb.get(i).setBorderPainted(false);
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
			felder.get(i).setBorderPainted(false);
			felder.get(i).setContentAreaFilled(false);
			felder.get(i).addActionListener(new EventHandler(this));
			felder.get(i).setActionCommand("feld");
		}
		
		felder.get(0).setBounds(50, 197,40, 40);
		felder.get(1).setBounds(93, 197,40, 40);
		felder.get(2).setBounds(136,197,40, 40);
		felder.get(3).setBounds(179,197,40, 40);
		felder.get(4).setBounds(221,197,40, 40);
		felder.get(5).setBounds(221,155,40, 40);
		felder.get(6).setBounds(221,111,40, 40);
		felder.get(7).setBounds(221,68,40, 40);
		felder.get(8).setBounds(221,26,40, 40);
		felder.get(9).setBounds(263,26,40, 40);
		felder.get(10).setBounds(305,26,40, 40);
		felder.get(11).setBounds(305,68,40, 40);
		felder.get(12).setBounds(305,111,40, 40);
		felder.get(13).setBounds(305,153,40, 40);
		felder.get(14).setBounds(305,196,40, 40);
		felder.get(15).setBounds(346,196,40, 40);
		felder.get(16).setBounds(389,196,40, 40);
		felder.get(17).setBounds(430,196,40, 40);
		felder.get(18).setBounds(473,196,40, 40);
		felder.get(19).setBounds(473,237,40, 40);
		felder.get(20).setBounds(473,278,40, 40);
		felder.get(21).setBounds(430,278,40, 40);
		felder.get(22).setBounds(390,278,40, 40);
		felder.get(23).setBounds(347,278,40, 40);
		felder.get(24).setBounds(304,278,40, 40);
		felder.get(25).setBounds(304,320,40, 40);
		felder.get(26).setBounds(304,363,40, 40);
		felder.get(27).setBounds(304,406,40, 40);
		felder.get(28).setBounds(304,448,40, 40);
		felder.get(29).setBounds(263,448,40, 40);
		felder.get(30).setBounds(221,448,40, 40);
		felder.get(31).setBounds(221,406,40, 40);
		felder.get(32).setBounds(221,364,40, 40);
		felder.get(33).setBounds(221,321,40, 40);
		felder.get(34).setBounds(221,279,40, 40);
		felder.get(35).setBounds(177,279,40, 40);
		felder.get(36).setBounds(135,279,40, 40);
		felder.get(37).setBounds(93,279,40, 40);
		felder.get(38).setBounds(51,279,40, 40);
		felder.get(39).setBounds(51,237,40, 40);
		
		

		
		if(spieler1.zahl()==1){
			Color farbe1 = spieler1.farbAuswahl((String)spieler1.getFarbAuswahl().
					getSelectedItem());
			
			if(	farbe1 == Color.RED){
				for(int i=0;i<=3;i++){
					startRot.get(i).setIcon(rot.get(i));
					pnlAdd.add(imageFigurRot);
					
				}
			}
			else if(farbe1 == Color.BLUE){
				for(int i=0;i<=3;i++){
					startBlau.get(i).setIcon(blau.get(i));
					pnlAdd.add(imageFigurBlau);
				
				}
			}
			else if( farbe1 == Color.GREEN){
				for(int i=0;i<=3;i++){
					startGruen.get(i).setIcon(gruen.get(i));
					pnlAdd.add(imageFigurGruen);
				
				}
			}
			else if(farbe1 == Color.ORANGE){
				for(int i=0;i<=3;i++){
					startGelb.get(i).setIcon(gelb.get(i));
					pnlAdd.add(imageFigurGelb);
				
				}
			}
		}
		
		if(spieler1.zahl()==2){
			Color farbe1 = spieler1.farbAuswahl((String)spieler1.getFarbAuswahl().
					getSelectedItem());
			Color farbe2 = spieler2.farbAuswahl((String)spieler2.getFarbAuswahl().
					getSelectedItem());
			
			if(	farbe1 == Color.RED||
				farbe2 == Color.RED){
				
				for(int i=0;i<=3;i++){
					startRot.get(i).setIcon(rot.get(i));
					pnlAdd.add(imageFigurRot);
				}
			}
			if(	farbe1 == Color.BLUE||
				farbe2 == Color.BLUE){
				
				for(int i=0;i<=3;i++){
					startBlau.get(i).setIcon(blau.get(i));
					pnlAdd.add(imageFigurBlau);
				}
			}
			if(	farbe1 == Color.GREEN||
				farbe2 == Color.GREEN){
				
				for(int i=0;i<=3;i++){
					startGruen.get(i).setIcon(gruen.get(i));
					pnlAdd.add(imageFigurGruen);
				}
			}
			if(	farbe1 == Color.ORANGE||
				farbe2 == Color.ORANGE){
				
				for(int i=0;i<=3;i++){
					startGelb.get(i).setIcon(gelb.get(i));
					pnlAdd.add(imageFigurGelb);
				}
			}
		}
		
		if(spieler1.zahl()==3){
			Color farbe1 = spieler1.farbAuswahl((String)spieler1.getFarbAuswahl().
					getSelectedItem());
			Color farbe2 = spieler2.farbAuswahl((String)spieler2.getFarbAuswahl().
					getSelectedItem());
			Color farbe3 = spieler3.farbAuswahl((String)spieler3.getFarbAuswahl().
					getSelectedItem());
			
			if(	farbe1 == Color.RED||
				farbe2 == Color.RED||
				farbe3 == Color.RED){
				
				for(int i=0;i<=3;i++){
					startRot.get(i).setIcon(rot.get(i));
					pnlAdd.add(imageFigurRot);
				}
			}
			if(	farbe1 == Color.BLUE||
				farbe2 == Color.BLUE||
				farbe3 == Color.BLUE){
				
				for(int i=0;i<=3;i++){
					startBlau.get(i).setIcon(blau.get(i));
					pnlAdd.add(imageFigurBlau);
				}
			}
			if(	farbe1 == Color.GREEN||
				farbe2 == Color.GREEN||
				farbe3 == Color.GREEN){
				
				for(int i=0;i<=3;i++){
					startGruen.get(i).setIcon(gruen.get(i));
					pnlAdd.add(imageFigurGruen);
				}
			}
			if(	farbe1 == Color.ORANGE||
				farbe2 == Color.ORANGE||
				farbe3 == Color.ORANGE){
				
				for(int i=0;i<=3;i++){
					startGelb.get(i).setIcon(gelb.get(i));
					pnlAdd.add(imageFigurGelb);
				}
			}
		}
		
		if(spieler1.zahl()==4){
			Color farbe1 = spieler1.farbAuswahl((String)spieler1.getFarbAuswahl()
					.getSelectedItem());
			Color farbe2 = spieler2.farbAuswahl((String)spieler2.getFarbAuswahl().
					getSelectedItem());
			Color farbe3 = spieler3.farbAuswahl((String)spieler3.getFarbAuswahl().
					getSelectedItem());
			Color farbe4 = spieler4.farbAuswahl((String)spieler4.getFarbAuswahl().
					getSelectedItem());
			
			if(	farbe1 == Color.RED||
				farbe2 == Color.RED||
				farbe3 == Color.RED||
				farbe4 == Color.RED){
				
				for(int i=0;i<=3;i++){
					startRot.get(i).setIcon(rot.get(i));
					pnlAdd.add(imageFigurRot);
				}
			}
			if(	farbe1 == Color.BLUE||
				farbe2 == Color.BLUE||
				farbe3 == Color.BLUE||
				farbe4== Color.BLUE){
				
				for(int i=0;i<=3;i++){
					startBlau.get(i).setIcon(blau.get(i));
					pnlAdd.add(imageFigurBlau);
				}
			}
			if(	farbe1 == Color.GREEN||
				farbe2 == Color.GREEN||
				farbe3 == Color.GREEN||
				farbe4 == Color.GREEN){
				
				for(int i=0;i<=3;i++){
					startGruen.get(i).setIcon(gruen.get(i));
					pnlAdd.add(imageFigurGruen);
				}
			}
			if(	farbe1 == Color.ORANGE||
				farbe2 == Color.ORANGE||
				farbe3 == Color.ORANGE||
				farbe4 == Color.ORANGE){
				
				for(int i=0;i<=3;i++){
					startGelb.get(i).setIcon(gelb.get(i));
					pnlAdd.add(imageFigurGelb);
				}
			}
		}
		
		//
		
		
		this.spieler(); 
		
		for(JButton b:felder){
			if(spiel.ermittleSpielerAmZug()==0){
				b.setDisabledIcon(rot.get(0));
				b.setDisabledIcon(rot.get(1));
				b.setDisabledIcon(rot.get(2));
				b.setDisabledIcon(rot.get(3));
			}
			if(spiel.ermittleSpielerAmZug()==1){
				b.setDisabledIcon(blau.get(0));
				b.setDisabledIcon(blau.get(1));
				b.setDisabledIcon(blau.get(2));
				b.setDisabledIcon(blau.get(3));
			}		
			if(spiel.ermittleSpielerAmZug()==2){
				b.setDisabledIcon(gruen.get(0));
				b.setDisabledIcon(gruen.get(1));
				b.setDisabledIcon(gruen.get(2));
				b.setDisabledIcon(gruen.get(3));
			}
			if(spiel.ermittleSpielerAmZug()==3){
				b.setDisabledIcon(gelb.get(0));
				b.setDisabledIcon(gelb.get(1));
				b.setDisabledIcon(gelb.get(2));
				b.setDisabledIcon(gelb.get(3));
			}		
		}
		

	}
		

	private void createWidgets(){
		
		
		imageBrett = new JLabel(new ImageIcon("brett1.jpg")); 		

		
		imageFigurRot = new JLabel(new ImageIcon("figurRotBild.png")); 
		imageFigurBlau = new JLabel(new ImageIcon("figurBlauBild.png"));
		imageFigurGelb = new JLabel(new ImageIcon("figurGelbBild.png"));
		imageFigurGruen = new JLabel(new ImageIcon("figurGruenBild.png"));

		
		

		wuerfeln= new JButton("wuerfeln");
		btnLaufen= new JButton("laufen");
		btnFertig = new JButton("Fertig");
		
		btnFertig.setAlignmentX(frame.LEFT_ALIGNMENT);
		
		//zum ausprobieren
		rot=new ArrayList<ImageIcon>();
		for(int i=1; i<=4; i++){
	   	 	rot.add(new ImageIcon("rot"+i+".png"));
		}
		
		blau=new ArrayList<ImageIcon>();
		for(int i=1; i<=4; i++){
	   	 	blau.add(new ImageIcon("blau"+i+".png"));
		}
		
		gruen=new ArrayList<ImageIcon>();
		for(int i=1; i<=4; i++){
	   	 	gruen.add(new ImageIcon("gruen"+i+".png"));
		}
		
		gelb=new ArrayList<ImageIcon>();
		for(int i=1; i<=4; i++){
	   	 	gelb.add(new ImageIcon("gelb"+i+".png"));
		}
		//
		
		
		pnlAdd= new JPanel();
		pnlAdd.setLayout(new GridLayout(0,1,5,5));
		
		pnlRight= new JPanel();
		pnlRight.setLayout(new BoxLayout(pnlRight,BoxLayout.PAGE_AXIS));
		pnlRight.setBackground(Color.BLACK);
		pnlRight.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
		pnlAdd.setBackground(Color.BLACK);
		
		pnlLeft = new JPanel();
		pnlLeft.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
		pnlLeft.setBackground(Color.BLACK);
	

		textArea = new JTextArea();
		textArea.setFont(textArea.getFont().deriveFont(Font.BOLD+ Font.ITALIC,15));
		textArea.setEditable(false);
		
		scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(120,80));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);		
		
		diceLabel.setIcon(dice1);
	
		
	
	
		//auswhahl spieler 
		// die namen der spieler wird auf den icons angezeit mit der figurfarbe die 
		// sie gewaehlt haben 
				if(spieler1.zahl()==4){
					
					 Color farbe1 = spieler1.farbAuswahl((String)spieler1.getFarbAuswahl().
								getSelectedItem());

						if(	farbe1 == Color.RED){
							imageFigurRot.setToolTipText(spieler1.getNameEingabe().getText());
						}
						else if(farbe1==Color.BLUE){
							imageFigurBlau.setToolTipText(spieler1.getNameEingabe().getText());
							
						}
						else if(farbe1==Color.GREEN){
							imageFigurGruen.setToolTipText(spieler1.getNameEingabe().getText());
							
						}
						else if(farbe1==Color.ORANGE){
							imageFigurGelb.setToolTipText(spieler1.getNameEingabe().getText());
							
						}
						
						
					  Color farbe2 = spieler2.farbAuswahl((String)spieler2.getFarbAuswahl().
									getSelectedItem());

							if(	farbe2 == Color.RED){
								imageFigurRot.setToolTipText(spieler2.getNameEingabe().getText());
							}
							else if(farbe2==Color.BLUE){
								imageFigurBlau.setToolTipText(spieler2.getNameEingabe().getText());
								
							}
							else if(farbe2==Color.GREEN){
								imageFigurGruen.setToolTipText(spieler2.getNameEingabe().getText());
								
							}
							else if(farbe2==Color.ORANGE){
								imageFigurGelb.setToolTipText(spieler2.getNameEingabe().getText());
								
							}
			
							  Color farbe3 = spieler3.farbAuswahl((String)spieler3.getFarbAuswahl().
										getSelectedItem());

								if(	farbe3 == Color.RED){
									imageFigurRot.setToolTipText(spieler3.getNameEingabe().getText());
								}
								else if(farbe3==Color.BLUE){
									imageFigurBlau.setToolTipText(spieler3.getNameEingabe().getText());
									
								}
								else if(farbe3==Color.GREEN){
									imageFigurGruen.setToolTipText(spieler3.getNameEingabe().getText());
									
								}
								else if(farbe3==Color.ORANGE){
									imageFigurGelb.setToolTipText(spieler3.getNameEingabe().getText());
									
								}
								
								 Color farbe4 = spieler4.farbAuswahl((String)spieler4.getFarbAuswahl().
											getSelectedItem());

									if(	farbe4 == Color.RED){
										imageFigurRot.setToolTipText(spieler4.getNameEingabe().getText());
									}
									else if(farbe4==Color.BLUE){
										imageFigurBlau.setToolTipText(spieler4.getNameEingabe().getText());
										
									}
									else if(farbe4==Color.GREEN){
										imageFigurGruen.setToolTipText(spieler4.getNameEingabe().getText());
										
									}
									else if(farbe4==Color.ORANGE){
										imageFigurGelb.setToolTipText(spieler4.getNameEingabe().getText());
										
									}
				
					
					
					
					
				}
				if(spieler1.zahl()==3){
					 Color farbe1 = spieler1.farbAuswahl((String)spieler1.getFarbAuswahl().
								getSelectedItem());

						if(	farbe1 == Color.RED){
							imageFigurRot.setToolTipText(spieler1.getNameEingabe().getText());
						}
						else if(farbe1==Color.BLUE){
							imageFigurBlau.setToolTipText(spieler1.getNameEingabe().getText());
							
						}
						else if(farbe1==Color.GREEN){
							imageFigurGruen.setToolTipText(spieler1.getNameEingabe().getText());
							
						}
						else if(farbe1==Color.ORANGE){
							imageFigurGelb.setToolTipText(spieler1.getNameEingabe().getText());
							
						}
						
						
					  Color farbe2 = spieler2.farbAuswahl((String)spieler2.getFarbAuswahl().
									getSelectedItem());

							if(	farbe2 == Color.RED){
								imageFigurRot.setToolTipText(spieler2.getNameEingabe().getText());
							}
							else if(farbe2==Color.BLUE){
								imageFigurBlau.setToolTipText(spieler2.getNameEingabe().getText());
								
							}
							else if(farbe2==Color.GREEN){
								imageFigurGruen.setToolTipText(spieler2.getNameEingabe().getText());
								
							}
							else if(farbe2==Color.ORANGE){
								imageFigurGelb.setToolTipText(spieler2.getNameEingabe().getText());
								
							}
			
							  Color farbe3 = spieler3.farbAuswahl((String)spieler3.getFarbAuswahl().
										getSelectedItem());

								if(	farbe3 == Color.RED){
									imageFigurRot.setToolTipText(spieler3.getNameEingabe().getText());
								}
								else if(farbe3==Color.BLUE){
									imageFigurBlau.setToolTipText(spieler3.getNameEingabe().getText());
									
								}
								else if(farbe3==Color.GREEN){
									imageFigurGruen.setToolTipText(spieler3.getNameEingabe().getText());
									
								}
								else if(farbe3==Color.ORANGE){
									imageFigurGelb.setToolTipText(spieler3.getNameEingabe().getText());
									
								}
				
					
				
					
				}
				if(spieler1.zahl()==2){
					
				
					
					 Color farbe1 = spieler1.farbAuswahl((String)spieler1.getFarbAuswahl().
								getSelectedItem());

						if(	farbe1 == Color.RED){
							imageFigurRot.setToolTipText(spieler1.getNameEingabe().getText());
						}
						else if(farbe1==Color.BLUE){
							imageFigurBlau.setToolTipText(spieler1.getNameEingabe().getText());
							
						}
						else if(farbe1==Color.GREEN){
							imageFigurGruen.setToolTipText(spieler1.getNameEingabe().getText());
							
						}
						else if(farbe1==Color.ORANGE){
							imageFigurGelb.setToolTipText(spieler1.getNameEingabe().getText());
							
						}
						
						
					  Color farbe2 = spieler2.farbAuswahl((String)spieler2.getFarbAuswahl().
									getSelectedItem());

							if(	farbe2 == Color.RED){
								imageFigurRot.setToolTipText(spieler2.getNameEingabe().getText());
							}
							else if(farbe2==Color.BLUE){
								imageFigurBlau.setToolTipText(spieler2.getNameEingabe().getText());
								
							}
							else if(farbe2==Color.GREEN){
								imageFigurGruen.setToolTipText(spieler2.getNameEingabe().getText());
								
							}
							else if(farbe2==Color.ORANGE){
								imageFigurGelb.setToolTipText(spieler2.getNameEingabe().getText());
								
							}
			
					}
				 if(spieler1.zahl()==1){
					 
					 Color farbe1 = spieler1.farbAuswahl((String)spieler1.getFarbAuswahl().
								getSelectedItem());

						if(	farbe1 == Color.RED){
							imageFigurRot.setToolTipText(spieler1.getNameEingabe().getText());
						}
						else if(farbe1==Color.BLUE){
							imageFigurBlau.setToolTipText(spieler1.getNameEingabe().getText());
							
						}
						else if(farbe1==Color.GREEN){
							imageFigurGruen.setToolTipText(spieler1.getNameEingabe().getText());
							
						}
						else if(farbe1==Color.ORANGE){
							imageFigurGelb.setToolTipText(spieler1.getNameEingabe().getText());
							
						}
			
				}
				 
	
	}
	
	
	
	

	private void addListener() {
		btnLaufen.addActionListener(new EventHandler(this));
		btnLaufen.setActionCommand("laufen");
		wuerfeln.addActionListener(new EventHandler(this));
		wuerfeln.setActionCommand("wuerfeln");
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
	
	public ArrayList<JButton> getEndGelb(){
		return endGelb;
	}
	
	public ArrayList<JButton> getFelder(){
		return felder;
		
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


	public JButton getWuerfeln(){
		return wuerfeln;
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
	
	public EventHandler getEvent() {
		return event;
	}
	public iBediener getSpiel() {
		return spiel;
	}
	
	public ImageIcon getDice1(){
		return dice1;
	}
	
	public ImageIcon getDice2(){
		return dice2;
	}
	public ImageIcon getDice3(){
		return dice3;
	}
	public ImageIcon getDice4(){
		return dice4;
	}
	public ImageIcon getDice5(){
		return dice5;
	}
	public ImageIcon getDice6(){
		return dice6;
	}
	
	public JLabel getDiceLabel(){
		return diceLabel;
	}
	
	
	
	public ArrayList<ImageIcon> getRot() {
		return rot;
	}
	public ArrayList<ImageIcon> getBlau() {
		return blau;
	}
	public ArrayList<ImageIcon> getGruen() {
		return gruen;
	}
	public ArrayList<ImageIcon> getGelb() {
		return gelb;
	}
	
	public static  void spielErstellen(){
		spiel = new Spiel();
	}
	
	public static iBediener gibSpielZurueck(){
	 	return spiel;
	}


	
	
	
	
	public void spieler(){
		if(spieler1.zahl()==1){
			
			String name1 = spieler1.getNameEingabe().getText();
			String farbe1 = (String)spieler1.getFarbAuswahl().getSelectedItem();
			String ki1 = (String)spieler1.getArtAuswahl().getSelectedItem();
			
			spiel.newSpieler(name1, farbe1, ki1);
			spiel.spielStart();
		}
		
		if(spieler1.zahl()==2){
			
			String name1 = spieler1.getNameEingabe().getText();
			String farbe1 = (String)spieler1.getFarbAuswahl().getSelectedItem();
			String ki1 = (String)spieler1.getArtAuswahl().getSelectedItem();
			
			String name2 = spieler2.getNameEingabe().getText();
			String farbe2 = (String)spieler2.getFarbAuswahl().getSelectedItem();
			String ki2 = (String)spieler2.getArtAuswahl().getSelectedItem();
			
			spiel.newSpieler(name1, farbe1, ki1);
			spiel.newSpieler(name2, farbe2, ki2);
			spiel.spielStart();
		}
		
		if(spieler1.zahl()==3){
			
			String name1 = spieler1.getNameEingabe().getText();
			String farbe1 = (String)spieler1.getFarbAuswahl().getSelectedItem();
			String ki1 = (String)spieler1.getArtAuswahl().getSelectedItem();
			
			String name2 = spieler2.getNameEingabe().getText();
			String farbe2 = (String)spieler2.getFarbAuswahl().getSelectedItem();
			String ki2 = (String)spieler2.getArtAuswahl().getSelectedItem();
			
			String name3 = spieler3.getNameEingabe().getText();
			String farbe3 = (String)spieler3.getFarbAuswahl().getSelectedItem();
			String ki3 = (String)spieler3.getArtAuswahl().getSelectedItem();
			
			spiel.newSpieler(name1, farbe1, ki1);
			spiel.newSpieler(name2, farbe2, ki2);
			spiel.newSpieler(name3, farbe3, ki3);
			spiel.spielStart();
		}
		
		if(spieler1.zahl()==4){
			
			String name1 = spieler1.getNameEingabe().getText();
			String farbe1 = (String)spieler1.getFarbAuswahl().getSelectedItem();
			String ki1 = (String)spieler1.getArtAuswahl().getSelectedItem();
			
			String name2 = spieler2.getNameEingabe().getText();
			String farbe2 = (String)spieler2.getFarbAuswahl().getSelectedItem();
			String ki2 = (String)spieler2.getArtAuswahl().getSelectedItem();
			
			String name3 = spieler3.getNameEingabe().getText();
			String farbe3 = (String)spieler3.getFarbAuswahl().getSelectedItem();
			String ki3 = (String)spieler3.getArtAuswahl().getSelectedItem();
			
			String name4 = spieler4.getNameEingabe().getText();
			String farbe4 = (String)spieler4.getFarbAuswahl().getSelectedItem();
			String ki4 = (String)spieler4.getArtAuswahl().getSelectedItem();
			
			spiel.newSpieler(name1, farbe1, ki1);
			spiel.newSpieler(name2, farbe2, ki2);
			spiel.newSpieler(name3, farbe3, ki3);
			spiel.newSpieler(name4, farbe4, ki4);
			spiel.spielStart();
		}
		
	}
	
	
	
	
	

	public boolean hatButtonIcon(ActionEvent e){
		JButton feld=(JButton) e.getSource();
		
		if(feld.getIcon()!=null){
			return true;
		}
		return false;
	}


	public boolean istSourceDrin(ArrayList<JButton> liste,ActionEvent e){
		JButton feld = (JButton)e.getSource();
		for(JButton b:liste){
			if(b==feld){
				return true;
			}
		}
		return false;
	}
	
	

	public boolean istIconDrin(ArrayList<JButton> liste,ImageIcon i){
		
		for(JButton b:liste){
			if(b.getIcon()==i){
				return true;
			}
		}
		return false;
	}


	public boolean figurGleich(ImageIcon i1, Icon i2){
	
	
		for(ImageIcon b:rot){
			if(b==i1){
				for(Icon c:rot){
					if(c==i2){
						return true;
				}
			}
		}
	}
	
	for(ImageIcon b:blau){
		if(b==i1){
			for(Icon c:blau){
				if(c==i2){
					return true;
				}
			}
		}
	}
	
	for(ImageIcon b:gruen){
		if(b==i1){
			for(Icon c:gruen){
				if(c==i2){
					return true;
				}
			}
		}
	}
	
	for(ImageIcon b:gelb){
		if(b==i1){
			for(Icon c:gelb){
				if(c==i2){
					return true;
				}
			}
		}
	}
	
	return false;
}
	
	
	public int gibIconPos(ArrayList<JButton>button,int id){
		int y=0;
		
		for(JButton b:button){
			if(b.getIcon()!=null){
				if(b.getIcon()==farbeIcon(spiel.farbePlayer()).get(id)){
					y=button.indexOf(b);
				}
			}
		}
		return y;
	}
	

	public void lauf(ActionEvent e){
		
		ImageIcon figur=null;
		JButton feld = (JButton)e.getSource();
		
		if(this.istSourceDrin(this.getStartRot(), e)==true){
			for(JButton button:this.getStartRot()){
				if(button==feld){
					if(button.getIcon()!=null){
						
						this.getZahl()[0]=rot.indexOf(button.getIcon());
						figur=(ImageIcon)this.rot.get(this.getZahl()[0]);	
						
						spiel.laufen(this.getZahl()[0]);
						this.getStartRot().get(this.getStartRot().indexOf(button)).setIcon(null);
						this.listCorrespond(spiel.giveList(this.getZahl()[0])).get(this.convertPos
								(spiel.updatePos(this.getZahl()[0]))).setIcon(figur);
						break;
					}
				}
			} 
		}
		
		else if(this.istSourceDrin(this.getStartBlau(), e)==true){
			for(JButton button:this.getStartBlau()){
				if(button==feld){
					if(button.getIcon()!=null){
						
						this.getZahl()[0]=blau.indexOf(button.getIcon());
						figur=(ImageIcon)this.blau.get(this.getZahl()[0]);	
						
						spiel.laufen(this.getZahl()[0]);
						this.getStartBlau().get(this.getStartBlau().indexOf(button)).setIcon(null);
						this.listCorrespond(spiel.giveList(this.getZahl()[0])).get(this.convertPos
								(spiel.updatePos(this.getZahl()[0]))).setIcon(figur);
						break;
					}
				}
			} 
		}
		
		else if(this.istSourceDrin(this.getStartGruen(), e)==true){
			for(JButton button:this.getStartGruen()){
				if(button==feld){
					if(button.getIcon()!=null){
						
						this.getZahl()[0]=gruen.indexOf(button.getIcon());
						figur=(ImageIcon)this.gruen.get(this.getZahl()[0]);	
						
						spiel.laufen(this.getZahl()[0]);
						this.getStartGruen().get(this.getStartGruen().indexOf(button)).setIcon(null);
						this.listCorrespond(spiel.giveList(this.getZahl()[0])).get(this.convertPos
								(spiel.updatePos(this.getZahl()[0]))).setIcon(figur);
						break;
					}
				}
			} 
		}
		
		else if(this.istSourceDrin(this.getStartGelb(), e)==true){
			for(JButton button:this.getStartGelb()){
				if(button==feld){
					if(button.getIcon()!=null){
						
						this.getZahl()[0]=gelb.indexOf(button.getIcon());
						figur=(ImageIcon)this.gelb.get(this.getZahl()[0]);	
						
						spiel.laufen(this.getZahl()[0]);
						this.getStartGelb().get(this.getStartGelb().indexOf(button)).setIcon(null);
						this.listCorrespond(spiel.giveList(this.getZahl()[0])).get(this.convertPos
								(spiel.updatePos(this.getZahl()[0]))).setIcon(figur);
						break;
					}
				}
			} 
		}
		
		else if(this.istSourceDrin(this.getFelder(), e)==true){
			for(JButton button:this.getFelder()){
				if(button==feld){
					if(button.getIcon()!=null){
						
						this.getZahl()[0]=this.farbeIcon(spiel.farbePlayer()).indexOf(button.getIcon());
						figur=(ImageIcon)this.farbeIcon(spiel.farbePlayer()).get(this.getZahl()[0]);						
						
						spiel.laufen(this.getZahl()[0]);
						
						if(	this.listCorrespond(spiel.giveList(this.getZahl()[0])).get(this.convertPos(spiel.updatePos(this.getZahl()[0]))).getIcon()==null||
							this.figurGleich(figur, this.listCorrespond(spiel.giveList(this.getZahl()[0])).get(this.convertPos(spiel.updatePos(this.getZahl()[0]))).getIcon())==true){
							this.getFelder().get(this.getFelder().indexOf(button)).setIcon(null);
							this.listCorrespond(spiel.giveList(this.getZahl()[0])).get(this.convertPos(spiel.updatePos(this.getZahl()[0]))).setIcon(figur);
							
						}
						else{
							this.zuruck(this.listCorrespond(spiel.giveList(this.getZahl()[0])).get(this.convertPos(spiel.updatePos(this.getZahl()[0]))).getIcon());
							this.getFelder().get(this.getFelder().indexOf(button)).setIcon(null);
							this.listCorrespond(spiel.giveList(this.getZahl()[0])).get(this.convertPos(spiel.updatePos(this.getZahl()[0]))).setIcon(figur);
						}	
						break;
					}
				}
			}
		}
		
		else if(this.istSourceDrin(this.getEndRot(), e)==true){
			for(JButton button:this.getEndRot()){
				if(button==feld){
					if(button.getIcon()!=null){
						
						this.getZahl()[0]=rot.indexOf(button.getIcon());
						figur=(ImageIcon)this.rot.get(this.getZahl()[0]);	
						
						spiel.laufen(this.getZahl()[0]);
						this.getEndRot().get(this.getEndRot().indexOf(button)).setIcon(null);
						this.listCorrespond(spiel.giveList(this.getZahl()[0])).get(this.convertPos(spiel.updatePos(this.getZahl()[0]))).setIcon(figur);
						break;
					}
				}
			} 
		}
		
		else if(this.istSourceDrin(this.getEndBlau(), e)==true){
			for(JButton button:this.getEndBlau()){
				if(button==feld){
					if(button.getIcon()!=null){
						
						this.getZahl()[0]=blau.indexOf(button.getIcon());
						figur=(ImageIcon)this.blau.get(this.getZahl()[0]);	
						
						spiel.laufen(this.getZahl()[0]);
						this.getEndBlau().get(this.getEndBlau().indexOf(button)).setIcon(null);
						this.listCorrespond(spiel.giveList(this.getZahl()[0])).get(this.convertPos(spiel.updatePos(this.getZahl()[0]))).setIcon(figur);
						break;
					}
				}
			} 
		}
		
		else if(this.istSourceDrin(this.getEndGruen(), e)==true){
			for(JButton button:this.getEndGruen()){
				if(button==feld){
					if(button.getIcon()!=null){
						
						this.getZahl()[0]=gruen.indexOf(button.getIcon());
						figur=(ImageIcon)this.gruen.get(this.getZahl()[0]);	
						
						spiel.laufen(this.getZahl()[0]);
						this.getEndGruen().get(this.getEndGruen().indexOf(button)).setIcon(null);
						this.listCorrespond(spiel.giveList(this.getZahl()[0])).get(this.convertPos(spiel.updatePos(this.getZahl()[0]))).setIcon(figur);
						break;
					}
				}
			} 
		}
		
		else if(this.istSourceDrin(this.getEndGelb(), e)==true){
			for(JButton button:this.getEndGelb()){
				if(button==feld){
					if(button.getIcon()!=null){
						
						this.getZahl()[0]=gelb.indexOf(button.getIcon());
						figur=(ImageIcon)this.gelb.get(this.getZahl()[0]);	
						
						spiel.laufen(this.getZahl()[0]);
						this.getEndGelb().get(this.getEndGelb().indexOf(button)).setIcon(null);
						this.listCorrespond(spiel.giveList(this.getZahl()[0])).get(this.convertPos(spiel.updatePos(this.getZahl()[0]))).setIcon(figur);
						break;
					}
				}
			} 
		}
	}
	
	
	
	
	public void laufKi(){
		ImageIcon figur=null;
		final int figurId=spiel.gibFigurKi();
		
		if(this.istIconDrin(startRot, rot.get(figurId))&&spiel.ermittleSpielerAmZug()==0){			
			figur=this.rot.get(figurId);	
			
			startRot.get(this.gibIconPos(startRot,figurId)).setIcon(null);
			spiel.laufen(figurId);
			this.listCorrespond(spiel.giveList(figurId)).get(this.convertPos(spiel.updatePos(figurId))).setIcon(figur);
		}
		
		else if(this.istIconDrin(startBlau, blau.get(figurId))&&spiel.ermittleSpielerAmZug()==1){			
			figur=this.blau.get(figurId);	
			
			startBlau.get(this.gibIconPos(startBlau,figurId)).setIcon(null);
			spiel.laufen(figurId);
			this.listCorrespond(spiel.giveList(figurId)).get(this.convertPos(spiel.updatePos(figurId))).setIcon(figur);
		}
		
		else if(this.istIconDrin(startGruen, gruen.get(figurId))&&spiel.ermittleSpielerAmZug()==2){			
			figur=this.gruen.get(figurId);	
			
			startGruen.get(this.gibIconPos(startGruen,figurId)).setIcon(null);
			spiel.laufen(figurId);
			this.listCorrespond(spiel.giveList(figurId)).get(this.convertPos(spiel.updatePos(figurId))).setIcon(figur);
		}
		
		else if(this.istIconDrin(startGelb, gelb.get(figurId))&&spiel.ermittleSpielerAmZug()==3){			
			figur=this.gelb.get(figurId);	
			
			startGelb.get(this.gibIconPos(startGelb,figurId)).setIcon(null);
			spiel.laufen(figurId);
			this.listCorrespond(spiel.giveList(figurId)).get(this.convertPos(spiel.updatePos(figurId))).setIcon(figur);
		}
		
		else if(this.istIconDrin(felder, farbeIcon(spiel.farbePlayer()).get(figurId))){			
			figur=this.farbeIcon(spiel.farbePlayer()).get(figurId);
			spiel.laufen(figurId);
			
			if(this.listCorrespond(spiel.giveList(figurId)).get(this.convertPos(spiel.updatePos(figurId))).getIcon()==null||
				this.figurGleich(figur, this.listCorrespond(spiel.giveList(figurId)).get(this.convertPos(spiel.updatePos(figurId))).getIcon())==true){
				felder.get(this.gibIconPos(felder, figurId)).setIcon(null);
				this.listCorrespond(spiel.giveList(figurId)).get(this.convertPos(spiel.updatePos(figurId))).setIcon(figur);
			}
			
			else{
				this.zuruck(this.listCorrespond(spiel.giveList(figurId)).get(this.convertPos(spiel.updatePos(figurId))).getIcon());
				felder.get(this.gibIconPos(felder,figurId)).setIcon(null);
				this.listCorrespond(spiel.giveList(figurId)).get(this.convertPos(spiel.updatePos(figurId))).setIcon(figur);
			}
		}
		
		else if(this.istIconDrin(endRot, rot.get(figurId))&&spiel.ermittleSpielerAmZug()==0){			
			figur=this.rot.get(figurId);	
			
			spiel.laufen(figurId);
			endRot.get(this.gibIconPos(endRot,figurId)).setIcon(null);
			this.listCorrespond(spiel.giveList(figurId)).get(this.convertPos(spiel.updatePos(figurId))).setIcon(figur);
			
		}
		else if(this.istIconDrin(endBlau, blau.get(figurId))&&spiel.ermittleSpielerAmZug()==1){			
			figur=this.blau.get(figurId);	
			
			spiel.laufen(figurId);
			endBlau.get(this.gibIconPos(endBlau,figurId)).setIcon(null);
			this.listCorrespond(spiel.giveList(figurId)).get(this.convertPos(spiel.updatePos(figurId))).setIcon(figur);
			
		}
		else if(this.istIconDrin(endGruen, gruen.get(figurId))&&spiel.ermittleSpielerAmZug()==2){			
			figur=this.gruen.get(figurId);	
			
			spiel.laufen(figurId);
			endGruen.get(this.gibIconPos(endGruen,figurId)).setIcon(null);
			this.listCorrespond(spiel.giveList(figurId)).get(this.convertPos(spiel.updatePos(figurId))).setIcon(figur);
			
		}
		else if(this.istIconDrin(endGelb, gelb.get(figurId))&&spiel.ermittleSpielerAmZug()==3){			
			figur=this.gelb.get(figurId);	
			
			spiel.laufen(figurId);
			endGelb.get(this.gibIconPos(endGelb,figurId)).setIcon(null);
			this.listCorrespond(spiel.giveList(figurId)).get(this.convertPos(spiel.updatePos(figurId))).setIcon(figur);
			
		}
	}
	

public void zuruck(Icon icon){
		
		if(icon.toString().startsWith("r")){
			startRot.get(rot.indexOf(icon)).setIcon(icon);
		}
		
		if(icon.toString().startsWith("b")){
			startBlau.get(blau.indexOf(icon)).setIcon(icon);
		}
		
		if(icon.toString().startsWith("gr")){
			startGruen.get(gruen.indexOf(icon)).setIcon(icon);
		}
		
		if(icon.toString().startsWith("ge")){
			startGelb.get(gelb.indexOf(icon)).setIcon(icon);
		}
	}
	


	public int bestandJButton(ArrayList<JButton>list){
		int i=0;
		for(JButton button:list){
			if(button.getIcon()!=null){
				i++;
			}
		}
		return i;
	}

	public int convertPos(String pos){
		int i=0;
		
		switch(pos){
		case "1":
			i=0;
			return i;
		case "2":
			i=1;
			return i;
		case "3":
			i=2;
			return i;
		case "4":
			i=3;
			return i;
		case "5":
			i=4;
			return i;
		case "6":
			i=5;
			return i;
		case "7":
			i=6;
			return i;
		case "8":
			i=7;
			return i;
		case "9":
			i=8;
			return i;
		case "10":
			i=9;
			return i;
		case "11":
			i=10;
			return i;
		case "12":
			i=11;
			return i;
		case "13":
			i=12;
			return i;
		case "14":
			i=13;
			return i;
		case "15":
			i=14;
			return i;
		case "16":
			i=15;
			return i;
		case "17":
			i=16;
			return i;
		case "18":
			i=17;
			return i;
		case "19":
			i=18;
			return i;
		case "20":
			i=19;
			return i;
		case "21":
			i=20;
			return i;
		case "22":
			i=21;
			return i;
		case "23":
			i=22;
			return i;
		case "24":
			i=23;
			return i;
		case "25":
			i=24;
			return i;
		case "26":
			i=25;
			return i;
		case "27":
			i=26;
			return i;
		case "28":
			i=27;
			return i;
		case "29":
			i=28;
			return i;
		case "30":
			i=29;
			return i;
		case "31":
			i=30;
			return i;
		case "32":
			i=31;
			return i;
		case "33":
			i=32;
			return i;
		case "34":
			i=33;
			return i;
		case "35":
			i=34;
			return i;
		case "36":
			i=35;
			return i;
		case "37":
			i=36;
			return i;
		case "38":
			i=37;
			return i;
		case "39":
			i=38;
			return i;
		case "40":
			i=39;
			return i;
		case "S1":
			i=0;
			return i;
		case "S2":
			i=1;
			return i;
		case "S3":
			i=2;
			return i;
		case "S4":
			i=3;
			return i;
		case "E1":
			i=0;
			return i;
		case "E2":
			i=1;
			return i;
		case "E3":
			i=2;
			return i;
		case "E4":
			i=3;
			return i;
		}
		return i;
	}
	
	
	
	
	

	public ArrayList<JButton> listCorrespond(String eingabe){
		ArrayList<JButton>JList= null;
		switch(eingabe){
			case "StartRot":
				JList=this.getStartRot();
					return JList;
			case "StartBlau":
				JList=this.getStartBlau();
					return JList;
			case "StartGelb":
				JList=this.getStartGelb();
					return JList;
			case "StartGruen":
				JList=this.getStartGruen();
					return JList;
			case "EndRot":
				JList=this.getEndRot();
					return JList;
			case "EndBlau":
				JList=this.getEndBlau();
					return JList;
			case "EndGelb":
				JList=this.getEndGelb();
					return JList;
			case "EndGruen":
				JList=this.getEndGruen();
					return JList;
			case "Weg":
				JList=this.getFelder();
					return JList;
		}
		return JList;
		
	}
	
	

	public ArrayList<ImageIcon>farbeIcon(String farbe){
		ArrayList<ImageIcon>l=null;
		switch(farbe){
		case "Rot":
			l=rot;
			return l;
		case "Blau":
			l=blau;
			return l;
		case "Gruen":
			l=gruen;
			return l;
		case "Gelb":
			l=gelb;
			return l;	
		}
		
		return l;
		
	}
	
	

	public void ermittleSpieler(){
		
		if(spiel.ermittleSpielerAmZug()==0){
			for(JButton b:startRot){						
				b.setEnabled(true);
			}
			for(JButton b:startBlau){						
				b.setEnabled(false);
			}
			for(JButton b:startGruen){						
				b.setEnabled(false);
			}
			for(JButton b:startGelb){						
				b.setEnabled(false);
			}
			for(JButton b:felder){
				if(b.getIcon()!=null){
					if(b.getIcon().toString().startsWith("r")){
						b.setEnabled(true);
					}
					else{
						b.setEnabled(false);
					}
				}
			}
		}
		
		if(spiel.ermittleSpielerAmZug()==1){
			for(JButton b:startRot){						
				b.setEnabled(false);
			}
			for(JButton b:startBlau){						
				b.setEnabled(true);
			}
			for(JButton b:startGruen){						
				b.setEnabled(false);
			}
			for(JButton b:startGelb){						
				b.setEnabled(false);
			}
			for(JButton b:felder){
				if(b.getIcon()!=null){
					if(b.getIcon().toString().startsWith("b")){
						b.setEnabled(true);
					}
					else{
						b.setEnabled(false);
					}
				}
			}
		}
		
		if(spiel.ermittleSpielerAmZug()==2){
			for(JButton b:startRot){						
				b.setEnabled(false);
			}
			for(JButton b:startBlau){						
				b.setEnabled(false);
			}
			for(JButton b:startGruen){						
				b.setEnabled(true);
			}
			for(JButton b:startGelb){						
				b.setEnabled(false);
			}
			for(JButton b:felder){
				if(b.getIcon()!=null){
					if(b.getIcon().toString().startsWith("gr")){
						b.setEnabled(true);
					}
					else{
						b.setEnabled(false);
					}
				}
			}
		}
		
		if(spiel.ermittleSpielerAmZug()==3){
			for(JButton b:startRot){						
				b.setEnabled(false);
			}
			for(JButton b:startBlau){						
				b.setEnabled(false);
			}
			for(JButton b:startGruen){						
				b.setEnabled(false);
			}
			for(JButton b:startGelb){						
				b.setEnabled(true);
			}
			for(JButton b:felder){
				if(b.getIcon()!=null){
					if(b.getIcon().toString().startsWith("ge")){
						b.setEnabled(true);
					}
					else{
						b.setEnabled(false);
					}
				}
			}
		}
	}
	
	
	

	public void unsButton(){
		
		if(	spiel.ermittleSpielerAmZug()==0||
			spiel.ermittleSpielerAmZug()==1||
			spiel.ermittleSpielerAmZug()==2||
			spiel.ermittleSpielerAmZug()==3){
			
			for(JButton b:startRot){						
				b.setEnabled(false);
			}
			for(JButton b:startBlau){						
				b.setEnabled(false);
			}
			for(JButton b:startGruen){						
				b.setEnabled(false);
			}
			for(JButton b:startGelb){						
				b.setEnabled(false);
			}
			for(JButton b:felder){
				b.setEnabled(false);
			}
		}
		
	
	}
	
	
	
public void kiOderMensch(){
		
		if(spieler1.zahl()==1){
			if(((String)spieler1.getArtAuswahl().getSelectedItem()).startsWith("K")){
				btnLaufen.setEnabled(true);
				
				laufKi();

				
//				JOptionPane.showMessageDialog(null,
//                        "Fortfahren?",
//                        "!",					      
//    JOptionPane.WARNING_MESSAGE);


				
				
			}else{
				this.ermittleSpieler();
			}
		}
		else if(spieler1.zahl()==2){
			if(spiel.ermittleSpielerAmZug()==spieler1.getFarbAuswahl().getSelectedIndex()){
				if(((String)spieler1.getArtAuswahl().getSelectedItem()).startsWith("K")){
					btnLaufen.setEnabled(true);
				
					laufKi();
				
				}else{
					this.ermittleSpieler();
				}
			}
			else if(spiel.ermittleSpielerAmZug()==spieler2.getFarbAuswahl().getSelectedIndex()+1){
				if(((String)spieler2.getArtAuswahl().getSelectedItem()).startsWith("K")){
					btnLaufen.setEnabled(true);
					laufKi();
				
				
				}else{
					this.ermittleSpieler();
				}
			}
		}
		else if(spieler1.zahl()==3){
			if(spiel.ermittleSpielerAmZug()==spieler1.getFarbAuswahl().getSelectedIndex()){
				if(((String)spieler1.getArtAuswahl().getSelectedItem()).startsWith("K")){
					btnLaufen.setEnabled(true);
				
				
				}else{
					this.ermittleSpieler();
				}
			}
			else if(spiel.ermittleSpielerAmZug()==spieler2.getFarbAuswahl().getSelectedIndex()+1){
				if(((String)spieler2.getArtAuswahl().getSelectedItem()).startsWith("K")){
					btnLaufen.setEnabled(true);
			
				}else{
					this.ermittleSpieler();
				}
			}
			else if(spiel.ermittleSpielerAmZug()==spieler3.getFarbAuswahl().getSelectedIndex()+2){
				if(((String)spieler3.getArtAuswahl().getSelectedItem()).startsWith("K")){
					btnLaufen.setEnabled(true);
					
				}else{
					this.ermittleSpieler();
				}
			}
		}
		else if(spieler1.zahl()==4){
			if(spiel.ermittleSpielerAmZug()==spieler1.getFarbAuswahl().getSelectedIndex()){
				if(((String)spieler1.getArtAuswahl().getSelectedItem()).startsWith("K")){
					btnLaufen.setEnabled(true);
					
					
				}else{
					this.ermittleSpieler();
				}
			}
			else if(spiel.ermittleSpielerAmZug()==spieler2.getFarbAuswahl().getSelectedIndex()+1){
				if(((String)spieler2.getArtAuswahl().getSelectedItem()).startsWith("K")){
					btnLaufen.setEnabled(true);
					
				}else{
					this.ermittleSpieler();
				}
			}
			else if(spiel.ermittleSpielerAmZug()==spieler3.getFarbAuswahl().getSelectedIndex()+2){
				if(((String)spieler3.getArtAuswahl().getSelectedItem()).startsWith("K")){
					btnLaufen.setEnabled(true);
				
				}else{
					this.ermittleSpieler();
				}
			}
			else if(spiel.ermittleSpielerAmZug()==spieler4.getFarbAuswahl().getSelectedIndex()+3){
				if(((String)spieler4.getArtAuswahl().getSelectedItem()).startsWith("K")){
					btnLaufen.setEnabled(true);
					
				}else{
					this.ermittleSpieler();
				}
			}
		}
	}

	

}

