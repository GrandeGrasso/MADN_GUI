package gui;

import gui.DialogFenster.MyActionListener;

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



public class SpielerAuswahlDialog {
	
	private JFrame frame;
	private JLabel text;
	private JLabel text2;
	private JButton buttonWeiter;
	private JPanel panelLeft;
	private JPanel panelRight;
	private JComboBox liste;
	

	
	
	    public SpielerAuswahlDialog() {
	    	
	    frame = new JFrame("Mensch aergere dich nicht");	
	    frame.setSize(300, 100);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        
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
	    	
	    	String[] anzahlSpieler ={"1","2","3","4"};
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
	   		buttonWeiter.addActionListener(new MyActionListener());
	   	}
	       
	       
	       class MyActionListener implements ActionListener {
	   		@Override
	   		public void actionPerformed(ActionEvent e) {
	   			if (e.getSource() == buttonWeiter) {
	   				frame.setVisible(false); 
	   				frame.dispose(); 
	   				new ArtAuswahlDialog();
	   			} 
	   		}
	   	}

	
}


