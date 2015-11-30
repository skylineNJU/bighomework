package main.presentation.mainui;

import java.awt.*;

import javax.swing.*;

import main.presentation.mainui.memory.Memory;

@SuppressWarnings("serial")
public class WritePanel extends JPanel{
	private FrameMain frame;
	private String belong;
	private Memory memory;
	private JLabel search;
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
	   
	        search= new JLabel();
			search.setBounds(this.getWidth()*12/20,this.getHeight()/50,this.getWidth()/2,this.getHeight()/20);
			search.setIcon(AllImage.search);

			this.add(search);
	
	}


	public Memory getMemory() {
		return memory;
	}

	public void setMemory(Memory memory) {
		this.memory = memory;
	}

}
