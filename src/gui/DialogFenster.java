package gui;



import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DialogFenster {
	

		JButton button = new JButton("Jetzt spielen");
        JFrame fra;
        JLabel backImgPanel = new JLabel(new ImageIcon("2wuerfel.jpg"));
    	private EventHandler event;
    	
    	MenuDialogLaden laden;
        
        public DialogFenster(){
        
        	fra=new JFrame("Mensch ärgere dich nicht");
        	 fra.setSize(300, 300);
             fra.setLocationRelativeTo(null);
             fra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             
             event = new EventHandler(this);
             
             this.laden = new MenuDialogLaden();
             
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
           backImgPanel.add(laden.pnlOben);
           button.setBounds(80, 270, 120, 50);
           backImgPanel.setBounds(0,0,400,300);
    
           laden.pnlOben.setBounds(1, 1, 640, 20);
    	   
    	
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

