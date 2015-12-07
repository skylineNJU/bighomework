package main.presentation.mainui;

import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GuidePanel extends JPanel{
	private FrameMain frame;
	public GuidePanel(){
		frame=FrameMain.getFrame();
		this.setBounds(0,(int)((double)frame.getHeight()*22/490),(int)((double)frame.getWidth()*138/724)
				,frame.getHeight()-(int)((double)frame.getHeight()*22/490));
		this.setOpaque(false);
	}
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(AllImage.guideback.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
