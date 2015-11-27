package main.presentation.mainui;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class WritePanel extends JPanel{
	private FrameMain frame;
	private String belong;
	
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
	        // «Â∆¡
	        super.paintComponent(g);
	        g.drawImage(AllImage.background.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
	    }
		
	
}
