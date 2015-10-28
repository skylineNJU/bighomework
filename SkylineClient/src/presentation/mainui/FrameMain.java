package presentation.mainui;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

//自定义的边框和退出、最小化、最大化的按钮
public class FrameMain extends JFrame{
	
	//窗口的原点X坐标
	public int startX = 0;
	//窗口的原点Y坐标
	public int startY = 0;
	public int frameWidth;
	public int frameHeight;
	//每个Lanel之间的间隔
	public static final int INTERSPACE = 1;
	//边框的宽度
	public static final int PADDING = 7;
	//Label的大小
	public static final int LABEL_SIZE = 20;
	
	LabelExit labelExit;
	LabelMin labelMin;
	Point nowPoint = null;
	Point newPoint = null;
	
	
	public void initWH(){
		Toolkit toolkit=Toolkit.getDefaultToolkit();
	    Dimension screen=toolkit.getScreenSize();
	    frameWidth = screen.width>>1;
	    frameHeight = screen.height>>1; 
		this.setBounds(startX, startY, frameWidth, frameHeight);	
		this.setLayout(null);//布局设置为自定义布局	
		this.setUndecorated(true);//去掉边框
	}
	
	//描绘边框，安装Label，注册监听
	//思考：Laebl其实可以写成一个类，通过new对象来实现
	public void initLabel(){
		
		labelExit = new LabelExit(AllImage.exitImg, AllImage.exitEnterImg,this.getWidth()-LABEL_SIZE-PADDING, PADDING, LABEL_SIZE, LABEL_SIZE);
		labelMin = new LabelMin(AllImage.smallestImg,AllImage.smallestEnterImg,this.getWidth()-LABEL_SIZE*2-INTERSPACE*2-PADDING, PADDING, LABEL_SIZE, LABEL_SIZE,this);
		
		LabelEdge[] labelEdge = new LabelEdge[4];
		
		labelEdge[0] = new LabelEdge(AllImage.frameEdgingWImg,0, 0, frameWidth, PADDING);
		labelEdge[1] = new LabelEdge(AllImage.frameEdgingWImg,0, frameHeight-PADDING, frameWidth, PADDING);
		labelEdge[2] = new LabelEdge(AllImage.frameEdgingHImg,0, 0, PADDING, frameHeight);
		labelEdge[3] = new LabelEdge(AllImage.frameEdgingHImg,frameWidth-PADDING, 0, PADDING, frameHeight);
		
		this.getContentPane().add(labelMin);
		this.getContentPane().add(labelExit);
		
		for(int i = 0;i<4;i++){
			this.getContentPane().add(labelEdge[i]);
		}
		labelEdge[0].addMouseListener(new labelEdgeListener());
		labelEdge[0].addMouseMotionListener(new edgeMoveListener());
	}
	
	public FrameMain(){
		initWH();		
		initLabel();
		this.setVisible(true);	
	}
	
	public void updateFrame(Graphics g){
		this.setBounds(startX, startY, frameWidth, frameHeight);	
	}
	
	public static void main(String[] args) {
		FrameMain mainFrame = new FrameMain();
	}

	//鼠标按下的监听器
	class labelEdgeListener implements MouseListener{
		public void mouseClicked(MouseEvent e) {}

		public void mouseEntered(MouseEvent e) {}

		public void mouseExited(MouseEvent e) {}

		public void mousePressed(MouseEvent e) {
			nowPoint = new Point(e.getX(),e.getY());
		}

		public void mouseReleased(MouseEvent e) {}
	}
	
	class edgeMoveListener implements MouseMotionListener {

		public void mouseDragged(MouseEvent e) {
			newPoint = new Point(e.getX(),e.getY());
			startX = (int) (startX + newPoint.getX() - nowPoint.getX());
			startY = (int) (startY + newPoint.getY() - nowPoint.getY());
			Graphics g = getGraphics();
			updateFrame(g);
		}
		public void mouseMoved(MouseEvent e) {}
		
	}
}
