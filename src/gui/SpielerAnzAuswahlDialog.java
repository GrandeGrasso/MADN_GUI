package gui;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;



public class SpielerAnzAuswahlDialog {
	
	JFrame frame;
	private JLabel text;
	private JLabel text2;
	JButton buttonWeiter;
	private JPanel panelLeft;
	private JPanel panelRight;
	private JComboBox liste;
	Integer[] anzahlSpieler ={1,2,3,4};
	private EventHandler event;
	

	
	
	    public SpielerAnzAuswahlDialog() {
	    	
	    frame = new JFrame("Mensch ärgere dich nicht");	
	    frame.setSize(300, 100);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
		event=new EventHandler(this);
        erstelle();
        hinzufuegen();
        addListener();
       
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
//	    frame.pack();
	    frame.setVisible(true);
	    	 	
		
	}
	    
	  
	    
	   
	     
	
	    
	    
	    private void erstelle(){
	    	
	    	text = new JLabel("Spieloptionen");
	    	text.setFont(text.getFont().deriveFont(Font.BOLD+Font.ITALIC,20));
	    	text.setForeground(Color.black);
	    	text.setHorizontalAlignment(SwingConstants.CENTER);
	    	
	    	buttonWeiter = new JButton("weiter");
	    
	    	text2 = new JLabel("Anzahl Spieler");
	    	
	    	
	    	liste = new JComboBox (anzahlSpieler);
	    
	    	panelLeft = new JPanel();
	    	panelLeft.add(liste);
	    	panelLeft.add(text2);
	    	
	    	panelRight= new JPanel();
	    	panelRight.add(buttonWeiter);
	    	
	    	
	    	
	    	
	    }
	    
	    
	    private void hinzufuegen(){
	    	
	    	frame.getContentPane().setLayout(new BorderLayout());
	    	frame.getContentPane().add(BorderLayout.PAGE_START,text);
	    	frame.getContentPane().add(BorderLayout.EAST,panelRight);
	    	frame.getContentPane().add(BorderLayout.WEST,panelLeft);
	    	
	    }
	
	    private void addListener() {
	   		buttonWeiter.addActionListener(event);
	   		buttonWeiter.setActionCommand("buttonWeiter");
	   	}
	       
	       
	    public JButton getButtonWeiter() {
			return buttonWeiter;
		}
	    

		public JComboBox getListe() {
			return liste;
		}
		public JButton getWeiter() {
			return buttonWeiter;
		}
		public Integer [] getAnahlSpieler() {
			return anzahlSpieler;
		}
		
	         
}


