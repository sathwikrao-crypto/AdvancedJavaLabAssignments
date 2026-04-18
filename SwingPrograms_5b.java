//Develop a Swing program in Java to create a Tabbed Pan of RED, BLUE and GREEN and display the concerned color whenever the specific tab is selected in the Pan.
package SwingPrograms_5; 
import java.awt.Color;

import javax.swing.*;

public class SwingPrograms_5b {
	
	     
	    JFrame f;  
	    SwingPrograms_5b(){  
	        f=new JFrame();  
	        
	        JPanel p1=new JPanel();  
	        JPanel p2=new JPanel();  
	        JPanel p3=new JPanel();
	        p1.setBackground(Color.BLUE);
	        p2.setBackground(Color.RED);
	        p3.setBackground(Color.GREEN);
	        JTabbedPane tp=new JTabbedPane();  
	        tp.setBounds(50,50,200,200);  
	        tp.add("BLUE",p1);  
	        tp.add("RED",p2);  
	        tp.add("GREEN",p3);    
	        f.add(tp);  
	        f.setSize(400,400);  
	        f.setLayout(null);  
	        f.setVisible(true);  
	    }  
	    public static void main(String[] args) {  
	        new SwingPrograms_5b();  
	    }}  



