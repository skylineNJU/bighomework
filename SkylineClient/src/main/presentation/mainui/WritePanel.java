package main.presentation.mainui;



import java.awt.Graphics;

import javax.swing.JPanel;

import main.presentation.mainui.memory.Memory;

@SuppressWarnings("serial")
public class WritePanel extends JPanel{
	private FrameMain frame;
	private String belong;
	private Memory memory;
	
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
	        g.drawImage(AllImage.background.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
	    }


	public Memory getMemory() {
		return memory;
	}

	public void setMemory(Memory memory) {
		this.memory = memory;
	}

}
