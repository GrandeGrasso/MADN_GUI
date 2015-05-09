package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DialogFenster {
	

		JButton button = new JButton("Jetzt spielen");
        JFrame fra;
        JLabel backImgPanel = new JLabel(new ImageIcon("2wuerfel.jpg"));
    	private EventHandler event;
        
        public DialogFenster(){
        
        	fra=new JFrame("Mensch �rgere dich nicht");
        	 fra.setSize(300, 300);
             fra.setLocationRelativeTo(null);
             fra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             
             
             event = new EventHandler(this);
             erstelle();
             hinzufuegen();
             addListener();
            
             
             fra.setResizable(false);
             fra.pack();
             fra.setVisible(true);
             
        	
        }
        
       private void erstelle(){
    	   backImgPanel.setLayout(null);
           backImgPanel.setOpaque(false);
           backImgPanel.add(button);        
           button.setBounds(80, 220, 120, 50);
           backImgPanel.setBounds(0,0,400,300);
    	 
    	   
       }
       
       private void hinzufuegen(){
    	   fra.getContentPane().add(backImgPanel);
    	   
       }
       
       private void addListener() {
   		button.addActionListener(event);
   		button.setActionCommand("button");
   	}
       
    
   	public JButton getButton() {
		return button;
	}
       
       
   
 
  
	}

