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
		this.setLayout(null);
		this.width = width;
		this.height = height;
		setSize(width,height);
		setUndecorated(true);
	}
	public void init() {
		origin = new Point();
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(e.getY()<=(int)((double)getHeight()/10)){
					move=true;
					origin.x = e.getX();
					origin.y = e.getY();
				}
			}
			public void mouseReleased(MouseEvent e){ 
				move=false;
			} 
      
		});
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				if(move){
					Point nowPoint = getLocation();
					setLocation(nowPoint.x + e.getX() - origin.x, nowPoint.y + e.getY() - origin.y);
				}
			}
		});
		exitLabel = new MyButton();
		minLabel = new MyButton();
		this.add(exitLabel);
		this.add(minLabel);
		minLabel.setBounds(width-62, 0, 30, 30);
		exitLabel.setBounds(width-30, 0, 30, 30);
		exitLabel.setIMG(AllImage.exitEnterImg, AllImage.exitImg, AllImage.exitClicking);
		minLabel.setIMG(AllImage.minMove, AllImage.minMin, AllImage.minClick);
		exitLabel.setToolTipText("ÍË³öÏµÍ³");
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
		this.repaint();
	}
}
