package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ArtAuswahlDialog {
	
	
	JFrame frame;
	JButton spielStarten;
	JLabel spielTypFrage;
	JLabel name;
	JLabel farben;
	TextField nameEingabe;
	JComboBox artAuswahl;
	JComboBox farbAuswahl;
	JLabel spieloptionen;
	JPanel panel = new JPanel();
	
	 String[] art = {"Mensch", "KI Aggressiv" , "KI Defensiv"};
	 String[] farbe = {"Rot","Blau", "Gruen", "Gelb"};
	
	
	
	
	public ArtAuswahlDialog() {
		
		frame=new JFrame("Mensch ärgere dich nicht");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 290);
		
		erstelle();
		hinzufuegen();
		addListener();
		
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
//		frame.pack();
		frame.setVisible(true);	
	}
	

	
	private void erstelle() {
		
		spieloptionen= new JLabel("Spieloptionen");
		spieloptionen.setBounds(180, 0, 250, 30);
		spieloptionen.setFont(spieloptionen.getFont().deriveFont(Font.BOLD+Font.ITALIC,20));
		spieloptionen.setForeground(Color.black);
//		
		
		spielTypFrage = new JLabel("Wähle eine Art");
		spielTypFrage.setBounds(50, 40, 250, 20);
		
		artAuswahl = new JComboBox(art);
		artAuswahl.setBackground(Color.WHITE);
		artAuswahl.setBounds(300, 40, 120, 25);
		
		name = new JLabel();
		name.setText("Gib deinen Namen ein");
		name.setBounds(50, 50, 250, 100);
		
		nameEingabe = new TextField();
		nameEingabe.setBounds(300, 90, 120, 20);
		
		farben = new JLabel("Wähle eine Farbe");
		farben.setBounds(50, 140, 250, 20);
		
		farbAuswahl = new JComboBox(farbe);
		farbAuswahl.setBackground(Color.WHITE);
		farbAuswahl.setBounds(300, 140, 120, 25);
		
		
		spielStarten = new JButton("Spiel starten");
		spielStarten.setFont(new Font("Arial", Font.BOLD, 12));
		spielStarten.setBackground(Color.WHITE);
		spielStarten.setBounds(310, 200, 120, 30);	
	}
	
	

	private void hinzufuegen() {
	
		
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel.setLayout(null);
		
		panel.add(spielTypFrage);
		panel.add(artAuswahl);
		
		panel.add(name);
		panel.add(nameEingabe);
		
		panel.add(farben);
		panel.add(farbAuswahl);
		
		panel.add(spielStarten);
		
		panel.add(spieloptionen);
		
		frame.add(panel);
	}
	
	
	
	private void addListener() {
		spielStarten.addActionListener(new MyActionListener());
	}
	

	class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == spielStarten) {
				frame.setVisible(false); 
				frame.dispose(); 
				new GuiSpielbrett();
			} 
		}
	}
	
	
	
	
	
	
	
	
    	
    	
    	
		
	}


