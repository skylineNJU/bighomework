package main.serverFrame;

import java.awt.Frame;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	private boolean move;
	private Point origin;
	private MyButton exitLabel;
	private MyButton minLabel;
	private int width;
	private int height;
	
	public MyFrame(int width, int height){
		this.width = width;
		this.height = height;
		setSize(width,height);
		setUndecorated(true);
		addMoveListener();
		initLabel();
	}
	private void addMoveListener() {
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(e.getY()<=(int)((double)getHeight()/20)){
					move=true;
					origin.x = e.getX();
					origin.y = e.getY();
				}
			}
			public void mouseReleased(MouseEvent e){ 
				move=false;
			} 
      
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				if(move){
					Point nowPoint = getLocation();
					setLocation(nowPoint.x + e.getX() - origin.x, nowPoint.y + e.getY() - origin.y);
				}
			}
		});
	}
	private void initLabel() {
		exitLabel = new MyButton();
		minLabel = new MyButton();
		exitLabel.setBounds(width-40, 0, 40, 40);
		minLabel.setBounds(width-90, 0, 40, 40);
		getContentPane().add(exitLabel);
		getContentPane().add(minLabel);
		exitLabel.setIMG(AllImage.exitEnterImg, AllImage.exitImg, AllImage.exitClicking);
		minLabel.setIMG(AllImage.minMove, AllImage.minMin, AllImage.minClick);
		exitLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		minLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setExtendedState(Frame.ICONIFIED);
			}
		});
		repaint();
	}
}
