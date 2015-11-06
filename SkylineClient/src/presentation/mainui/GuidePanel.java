package presentation.mainui;

import java.awt.Color;

import javax.swing.*;

@SuppressWarnings("serial")
public class GuidePanel extends JPanel{
	private FrameMain frame;
	public GuidePanel(){
		frame=FrameMain.getFrame();
		this.setBounds(0,(int)((double)frame.getHeight()*22/490),(int)((double)frame.getWidth()*138/724)
				,frame.getHeight()-(int)((double)frame.getHeight()*22/490));
		this.setBackground(Color.BLUE);
	}
}
