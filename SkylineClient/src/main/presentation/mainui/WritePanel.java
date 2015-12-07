package main.presentation.mainui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import main.presentation.mainui.memory.Memory;

@SuppressWarnings("serial")
public class WritePanel extends JPanel{
	private FrameMain frame;
	private String belong;
	private Memory memory;
	private  JLabel search;
	private  JTextField s;
	
	public String getBelong() {
		return belong;
	}

	public void setBelong(String belong) {
		this.belong = belong;
	}

	public WritePanel(){
		frame=FrameMain.getFrame();
		this.setBounds((int)((double)frame.getWidth()*138/724),(int)((double)frame.getHeight()*22/490)
				,frame.getWidth()-(int)((double)frame.getWidth()*138/724)
				,frame.getHeight()-(int)((double)frame.getHeight()*22/490));
		
		  
	}

	protected void paintComponent(Graphics g) {			
	        super.paintComponent(g);
	        g.drawImage(AllImage.writeback.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
	    	searchLabel();
	}
	
	public void searchLabel(){
		 	search= new JLabel();
			search.setBounds(this.getWidth()*12/20,this.getHeight()/50,this.getWidth()/2,this.getHeight()/20);
			search.setIcon(AllImage.search);
			this.add(search);
		  	
			s= new JTextField();
			s.setCaretColor(Color.WHITE);
			s.setForeground(Color.WHITE);
			s.setBounds(this.getWidth()*12/20,this.getHeight()/50,this.getWidth()*31/100,this.getHeight()/20);
			s.setBorder(new EmptyBorder(0,0,0,0));
			s.setOpaque(false);
			this.add(s);
			
			
			s.addMouseListener( new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					search.setIcon(AllImage.searchClick);
				}
			 
			});
	}

	public Memory getMemory() {
		return memory;
	}

	public void setMemory(Memory memory) {
		this.memory = memory;
	}

}
