package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GuiSpielbrett {
	
	
	JFrame frame ;
	JLabel lab = new JLabel(new ImageIcon("brett1.jpg"));
	JLabel lab2 = new JLabel(new ImageIcon("würfelSpielbrett.jpg"));
	 

	
	
	  private JButton wuerfeln=new JButton("würfeln"); 
	  private JButton laufen=new JButton("laufen"); 
	  private JButton figurZiehen=new JButton("figurZiehen"); 
	  private JButton zugBeenden=new JButton("zugBeenden"); 
	
	
	
	
	public GuiSpielbrett() {
		
		  frame=new JFrame("Mensch ärgere dich nicht"); 
		  
		  
//		  erstelle();
//		  hinzufuegen();
		   
		    JPanel panelRight = new JPanel();
		  
		    
		 
			
		    
		    frame.getContentPane().setLayout(new BorderLayout(15,15));
	    	
	    	frame.getContentPane().add(BorderLayout.EAST,panelRight);
	    	frame.getContentPane().add(BorderLayout.WEST,lab2);
	    	frame.getContentPane().add(BorderLayout.CENTER,lab);
	    	
	    	
		    
	    	panelRight.setLayout(new GridLayout(0,1,10,50));
	    	
		    panelRight.add(wuerfeln);
		    panelRight.add(figurZiehen);
		    panelRight.add(laufen);
		    panelRight.add(zugBeenden);
		    
		    wuerfeln.setBounds(50, 50, 200, 200);
		    
		
//		    panelRight.setPreferredSize(new Dimension(3*35, 3*35));
		    
		  

		 
		 
		 
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		  frame.setLocationRelativeTo(null);


		  frame.pack();
		  frame.setVisible(true); 
		
	}
	
	

}
