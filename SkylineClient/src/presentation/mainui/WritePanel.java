package presentation.mainui;

import java.awt.Color;

import javax.swing.*;

@SuppressWarnings("serial")
public class WritePanel extends JPanel{
	private FrameMain frame;
	public WritePanel(){
		frame=FrameMain.getFrame();
		this.setBounds((int)((double)frame.getWidth()*138/724),(int)((double)frame.getHeight()*22/490)
				,frame.getWidth()-(int)((double)frame.getWidth()*138/724)
				,frame.getHeight()-(int)((double)frame.getHeight()*22/490));
		this.setBackground(Color.GREEN);
	}
}
