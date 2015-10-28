package presentation.mainui;

import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;


public class LabelExit extends LabelFather{
	
	
	public LabelExit(ImageIcon img, ImageIcon enterImg, int locationX, int locationY, int width, int height){
		super(img, enterImg, locationX, locationY, width, height);
	}
	
	public void mouseClicked(MouseEvent e) {
		System.exit(0);
	}
}
