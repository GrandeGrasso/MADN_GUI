package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class GuiSpielbrett{

	
	private JFrame frame = new JFrame();
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
	private JPanel pnlDown;
	private JLabel imageFigurRot;
	private JLabel imageFigurBlau;
	private JLabel imageFigurGelb;
	private JLabel imageFigurGruen;
	
	
	public GuiSpielbrett(){
	
		

		frame.setTitle("Mensch ärgere dich nicht"); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		createWidgets();
		addWidgets();
		
	
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	
	private  void addWidgets(){
		
		frame.getContentPane().setLayout(new BorderLayout(15,15));
		frame.getContentPane().add(BorderLayout.PAGE_START,lblHeader);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().add(BorderLayout.CENTER,imageBrett);
		frame.getContentPane().add(BorderLayout.LINE_END,pnlRight);
		frame.getContentPane().add(BorderLayout.LINE_START,pnlLeft);
		frame.getContentPane().add(BorderLayout.PAGE_END,pnlDown);
				
		
		
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
		imageFigurBlau = new JLabel(new ImageIcon("figurBlauBild.png"));
		imageFigurGelb = new JLabel(new ImageIcon("figurGelbBild.png")); 		
		imageFigurGruen = new JLabel(new ImageIcon("figurGruenBild.png"
				+ ""));
		
		imageFigurRot.setToolTipText("Spieler Rot");
		imageFigurBlau.setToolTipText("Spieler Blau");
		imageFigurGelb.setToolTipText("Spieler Gelb");
		imageFigurGruen.setToolTipText("Spieler Grün");
		
		
		
		
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
		
		
		pnlDown= new JPanel();
		pnlDown.setPreferredSize(new Dimension(0,50));
		pnlDown.setBackground(Color.BLACK);
		
		
		
		
	}
	
	
	
	
	

	
	
	
}
