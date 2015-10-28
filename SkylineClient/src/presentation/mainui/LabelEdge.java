package presentation.mainui;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * ±ß¿ò
 * @author ÔøÅÊ
 *
 */
public class LabelEdge extends JLabel{
	
	public LabelEdge(ImageIcon img, int locationX, int locationY, int width, int height){
		this.setIcon(img);
		this.setBounds(locationX, locationY, width, height);
	}
	
	public void updateLocation(ImageIcon img, int locationX, int locationY, int width, int height){
		this.setIcon(img);
		this.setBounds(locationX, locationY, width, height);
		Graphics g = getGraphics();
		update(g);
	}

}
