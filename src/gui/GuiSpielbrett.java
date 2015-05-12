package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
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
	
	private ArrayList<ImageIcon>rot;
	private ArrayList<ImageIcon>blau;
	private ArrayList<ImageIcon>gruen;
	private ArrayList<ImageIcon>gelb;
	
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
	
	
	
	public GuiSpielbrett(Spieler1AuswahlDialog spieler1,Spieler2AuswahlDialog spieler2,
			Spieler3AuswahlDialog spieler3,Spieler4AuswahlDialog spieler4){
	
	
		frame.setTitle("Mensch ärgere dich nicht"); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		zahl=new int[1];
		
//		addListener(); 
		createWidgets();
		addWidgets();
		
		this.spieler1=spieler1;
		this.spieler2=spieler2;
		this.spieler3=spieler3;
		this.spieler4=spieler4;
		
		spiel=new Spiel();
	
		frame.pack();
		addListener() ;
		frame.setLocationRelativeTo(null);
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
		
		pnlAdd.add(imageFigurRot);
		pnlAdd.add(imageFigurBlau);
		pnlAdd.add(imageFigurGelb);
		pnlAdd.add(imageFigurGruen);
		
		
		
		
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
		
	}
//		startRot = new ArrayList<JButton>();
//		for(int i=0; i<=3; i++){
//			startRot.add(new JButton());
//			imageBrett.add(startRot.get(i));
//			startRot.get(i).setBorderPainted(false);
//			startRot.get(i).setContentAreaFilled(false);
//			startRot.get(i).addActionListener(new EventHandler(this));
//			startRot.get(i).setActionCommand("feld");
//		}
//		
//		startRot.get(0).setBounds(60, 8, 40, 45);
//		startRot.get(1).setBounds(11, 9, 40, 45);
//		startRot.get(2).setBounds(11, 55, 40, 45);
//		startRot.get(3).setBounds(60, 54, 40, 45);
//		
//		startBlau = new ArrayList<JButton>();
//		
//		for(int i=0; i<=3; i++){
//			startBlau.add(new JButton());
//			imageBrett.add(startBlau.get(i));
//			startBlau.get(i).setBorderPainted(false);
//			startBlau.get(i).setContentAreaFilled(false);
//			startBlau.get(i).addActionListener(new EventHandler(this));
//			startBlau.get(i).setActionCommand("feld");
//		}
//		startBlau.get(0).setBounds(486, 7, 40, 45);
//		startBlau.get(1).setBounds(436, 7, 40, 45);
//		startBlau.get(2).setBounds(436, 52, 40, 45);
//		startBlau.get(3).setBounds(486, 52, 40, 45);
//		
//		
//		startGruen = new ArrayList<JButton>();
//		
//		for(int i=0; i<=3; i++){
//			startGruen.add(new JButton());
//			imageBrett.add(startGruen.get(i));
//			startGruen.get(i).setBorderPainted(false);
//			startGruen.get(i).setContentAreaFilled(false);
//			startGruen.get(i).addActionListener(new EventHandler(this));
//			startGruen.get(i).setActionCommand("feld");
//		}
//		startGruen.get(0).setBounds(486, 436, 40, 45);
//		startGruen.get(1).setBounds(437, 437, 40, 45);
//		startGruen.get(2).setBounds(437, 486, 40, 45);
//		startGruen.get(3).setBounds(486, 487, 40, 45);
//		
//		startGelb = new ArrayList<JButton>();
//		
//		for(int i=0; i<=3; i++){
//			startGelb.add(new JButton());
//			imageBrett.add(startGelb.get(i));
//			startGelb.get(i).setBorderPainted(false);
//			startGelb.get(i).setContentAreaFilled(false);
//			startGelb.get(i).addActionListener(new EventHandler(this));
//			startGelb.get(i).setActionCommand("feld");
//		}
//		startGelb.get(0).setBounds(59, 435, 40, 45);
//		startGelb.get(1).setBounds(11, 435, 40, 45);
//		startGelb.get(2).setBounds(12, 488, 40, 45);
//		startGelb.get(3).setBounds(59, 487, 40, 45);
//		
//		
//		endRot = new ArrayList<JButton>();
//		
//		for(int i=0; i<=3; i++){
//			endRot.add(new JButton());
//			imageBrett.add(endRot.get(i));
//			endRot.get(i).setBorderPainted(false);
//			endRot.get(i).setContentAreaFilled(false);
//			endRot.get(i).addActionListener(new EventHandler(this));
//			endRot.get(i).setActionCommand("feld");
//		}
//		endRot.get(0).setBounds(58, 248, 40, 45);
//		endRot.get(1).setBounds(106, 248, 40, 45);
//		endRot.get(2).setBounds(155, 248, 40, 45);
//		endRot.get(3).setBounds(200, 248, 40, 45);
//		
//		endBlau = new ArrayList<JButton>();
//		
//		for(int i=0; i<=3; i++){
//			endBlau.add(new JButton());
//			imageBrett.add(endBlau.get(i));
//			endBlau.get(i).setBorderPainted(false);
//			endBlau.get(i).setContentAreaFilled(false);
//			endBlau.get(i).addActionListener(new EventHandler(this));
//			endBlau.get(i).setActionCommand("feld");
//		}
//		endBlau.get(0).setBounds(249, 56, 40, 45);
//		endBlau.get(1).setBounds(249, 102, 40, 45);
//		endBlau.get(2).setBounds(249, 151, 40, 45);
//		endBlau.get(3).setBounds(249, 196, 40, 45);
//		
//		endGruen = new ArrayList<JButton>();
//		
//		for(int i=0; i<=3; i++){
//			endGruen .add(new JButton());
//			imageBrett.add(endGruen .get(i));
//			endGruen .get(i).setBorderPainted(false);
//			endGruen .get(i).setContentAreaFilled(false);
//			endGruen .get(i).addActionListener(new EventHandler(this));
//			endGruen .get(i).setActionCommand("feld");
//		}
//		endGruen .get(0).setBounds(441, 246, 40, 45);
//		endGruen .get(1).setBounds(395, 246, 40, 45);
//		endGruen .get(2).setBounds(347, 246, 40, 45);
//		endGruen .get(3).setBounds(299, 246, 40, 45);
//		
//		endGelb = new ArrayList<JButton>();
//		
//		for(int i=0; i<=3; i++){
//			endGelb .add(new JButton());
//			imageBrett.add(endGelb.get(i));
//			endGelb.get(i).setBorderPainted(false);
//			endGelb.get(i).setContentAreaFilled(false);
//			endGelb.get(i).addActionListener(new EventHandler(this));
//			endGelb.get(i).setActionCommand("feld");
//		}
//		endGelb.get(0).setBounds(250, 439, 40, 45);
//		endGelb.get(1).setBounds(250, 391, 40, 45);
//		endGelb.get(2).setBounds(250, 343, 40, 45);
//		endGelb.get(3).setBounds(250, 297, 40, 45);
//		
//		
//		felder=new ArrayList<JButton>();
//		for(int i=0; i<=39;i++){
//			felder.add(new JButton());
//			imageBrett.add(felder.get(i));
//			felder.get(i).setBorderPainted(false);
//			felder.get(i).setContentAreaFilled(false);
//			felder.get(i).addActionListener(new EventHandler(this));
//			felder.get(i).setActionCommand("feld");
//		}
//		
//		felder.get(0).setBounds(12, 200, 40, 45);
//		felder.get(1).setBounds(54, 200, 40, 45);
//		felder.get(2).setBounds(99, 200, 40, 45);
//		felder.get(3).setBounds(145,200, 40, 45);
//		felder.get(4).setBounds(201,197, 40, 45);
//		felder.get(5).setBounds(201,148, 40, 45);
//		felder.get(6).setBounds(201,100, 40, 45);
//		felder.get(7).setBounds(201,52, 40, 45);
//		felder.get(8).setBounds(201,9, 40, 45);
//		felder.get(9).setBounds(252,9, 40, 45);
//		felder.get(10).setBounds(299,7, 40, 45);
//		felder.get(11).setBounds(299,51, 40, 45);
//		felder.get(12).setBounds(300,97, 40, 45);
//		felder.get(13).setBounds(300,142, 40, 45);
//		felder.get(14).setBounds(300,196, 40, 45);
//		felder.get(15).setBounds(434,198, 40, 45);
//		felder.get(16).setBounds(391,198, 40, 45);
//		felder.get(17).setBounds(440,198, 40, 45);
//		felder.get(18).setBounds(485,198, 40, 45);
//		felder.get(19).setBounds(486,246, 40, 45);
//		felder.get(20).setBounds(486,296, 40, 45);
//		felder.get(21).setBounds(440,296, 40, 45);
//		felder.get(22).setBounds(392,296, 40, 45);
//		felder.get(23).setBounds(343,296, 40, 45);
//		felder.get(24).setBounds(300,297, 40, 45);
//		felder.get(25).setBounds(300,343, 40, 45);
//		felder.get(26).setBounds(300,388, 40, 45);
//		felder.get(27).setBounds(300,433, 40, 45);
//		felder.get(28).setBounds(300,486, 40, 45);
//		felder.get(29).setBounds(252,485, 40, 45);
//		felder.get(30).setBounds(202,484, 40, 45);
//		felder.get(31).setBounds(202,438, 40, 45);
//		felder.get(32).setBounds(202,390, 40, 45);
//		felder.get(33).setBounds(202,342, 40, 45);
//		felder.get(34).setBounds(202,297, 40, 45);
//		felder.get(35).setBounds(146,294, 40, 45);
//		felder.get(36).setBounds(100,294, 40, 45);
//		felder.get(37).setBounds(54,294, 40, 45);
//		felder.get(38).setBounds(13,294, 40, 45);
//		felder.get(39).setBounds(13,249, 40, 45);
		
		
//		if(spieler1.zahl()==1){
//			
//			Color farbe =spieler1.farbAuswahl((String) spieler1.getArtAuswahl().
//					getSelectedItem());
//			
//			if(farbe==Color.RED){
//				felder.get(10).setIcon(rot.get(0));
//				startRot.get(1).setIcon(rot.get(1));
//				startRot.get(2).setIcon(rot.get(2));
//				startRot.get(3).setIcon(rot.get(3));
//			}
//			
//			else if(farbe==Color.BLUE){
//				startBlau.get(0).setIcon(blau.get(0));
//				startBlau.get(1).setIcon(blau.get(1));
//				startBlau.get(2).setIcon(blau.get(2));
//				startBlau.get(3).setIcon(blau.get(3));
//				
//			}
//			
//			else if(farbe==Color.GREEN){
//				startGruen.get(0).setIcon(gruen.get(0));
//				startGruen.get(1).setIcon(blau.get(1));
//				startGruen.get(2).setIcon(blau.get(2));
//				startGruen.get(3).setIcon(gruen.get(3));
//				
//			}
//			
//			else if(farbe==Color.YELLOW){
//				startGelb.get(0).setIcon(gelb.get(0));
//				startGelb.get(1).setIcon(gelb.get(1));
//				startGelb.get(2).setIcon(gelb.get(2));
//				startGelb.get(3).setIcon(gelb.get(3));
//				
//			}
//			
//		}
//		
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
//		
//		
//	}
		
		
	
		
		
		
	
	
	
	

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
		
			
		
		
	
	}
		//auswhahl spieler
//		if(spieler1.zahl()==4){
//			
//			
//			sp1=new JLabel(spieler1.getNameEingabe().getText());
//			sp1.setForeground(spieler1.farbAuswahl(
//					(String)spieler1.getFarbAuswahl().getSelectedItem()));
//			
//		sp1.setMaximumSize(new Dimension(Integer.MAX_VALUE,30));
//			
//			
//			
//			imageFigurRot = new JLabel(new ImageIcon("figurRotBild.png")); 
//			imageFigurRot.setToolTipText(spieler1.getNameEingabe().getText());
//			imageFigurRot.setForeground (spieler1.farbAuswahl(
//					(String)spieler1.getFarbAuswahl().getSelectedItem()));
//			
//			imageFigurBlau = new JLabel(new ImageIcon("figurBlauBild.png"));
//			imageFigurBlau.setToolTipText(spieler2.getNameEingabe().getText());
//			
//			imageFigurGelb = new JLabel(new ImageIcon("figurGelbBild.png"));
//			imageFigurGelb.setToolTipText(spieler3.getNameEingabe().getText());
//			
//			imageFigurGruen = new JLabel(new ImageIcon("figurGruenBild.png"));
//			imageFigurGruen.setToolTipText(spieler4.getNameEingabe().getText());
//			
//		}
//		else if(spieler1.zahl()==3){
//			imageFigurRot = new JLabel(new ImageIcon("figurRotBild.png")); 
//			imageFigurRot.setToolTipText(spieler1.getNameEingabe().getText());
//			
//			imageFigurBlau = new JLabel(new ImageIcon("figurBlauBild.png"));
//			imageFigurBlau.setToolTipText(spieler2.getNameEingabe().getText());
//			
//			imageFigurGelb = new JLabel(new ImageIcon("figurGelbBild.png"));
//			imageFigurGelb.setToolTipText(spieler3.getNameEingabe().getText());
//			
//		}
//		else if(spieler1.zahl()==2){
//			imageFigurRot = new JLabel(new ImageIcon("figurRotBild.png")); 
//			imageFigurRot.setToolTipText(spieler1.getNameEingabe().getText());
//			
//			imageFigurBlau = new JLabel(new ImageIcon("figurBlauBild.png"));
//			imageFigurBlau.setToolTipText(spieler2.getNameEingabe().getText());
//	
//			
//		}
//		else if(spieler1.zahl()==1){
//			imageFigurRot = new JLabel(new ImageIcon("figurRotBild.png")); 
//			imageFigurRot.setToolTipText(spieler1.getNameEingabe().getText());
//	
//	
//		}
//		
//		rot=new ArrayList<ImageIcon>();
//		for(int i=1;i<=4;i++){
//			rot.add(new ImageIcon("rot"+i+".png"));
//		}
//		
//		
//		blau=new ArrayList<ImageIcon>();
//		for(int i=1; i<=4;i++){
//			blau.add(new ImageIcon("blau"+i+".png"));
//		}
//		
//		gruen=new ArrayList<ImageIcon>();
//		for(int i=1;i<=4;i++){
//			gruen.add(new ImageIcon("gruen"+i+".png"));
//		}
//		
//		gelb=new ArrayList<ImageIcon>();
//		for(int i=1;i<=4;i++){
//			gelb.add(new ImageIcon("gelb"+i+".png"));
//		}
//
//		
//	}
	
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
	
	public ArrayList<ImageIcon> getRot(){
		return rot;
	}
	
	public ArrayList<ImageIcon> getBlau(){
		return blau;
	}
	
	public ArrayList<ImageIcon> getGruen(){
		return gruen;
	}
	
	public ArrayList<ImageIcon> getGelb(){
		return gelb;
	}
	
	

	}
	

