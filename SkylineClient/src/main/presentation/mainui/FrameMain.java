package main.presentation.mainui;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FrameMain extends JFrame{
	private static MyButton exit=new MyButton();
	private static MyButton min=new MyButton();
	private static JLabel title=new JLabel(AllImage.edg);
	private static JPanel panel=new JPanel();
	private static FrameMain frame;
	private static boolean move=false;
	private static Point origin = new Point();
	private static java.awt.Dimension scrSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	private FrameMain(){


		try
	    {
	      //org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
	    }
	    catch(Exception e)
	    {
	        //TODO exception
	    }
	}
	
	public static FrameMain getFrame(){
		return frame;
	}
	public static void init(){
		frame.setSize((int)((double)scrSize.getHeight()*3/4/490*724),(int)((double)scrSize.getHeight()*3/4));
		frame.setLocation((int)(scrSize.getWidth()/2-(int)((double)scrSize.getHeight()*3/4/490*724/2))
				,(int)(scrSize.getHeight()/2-(int)((double)scrSize.getHeight()*3/4/2)));
		frame.setUndecorated(true);
		frame.setResizable(false);
		exit.setSize((int)((double)frame.getWidth()*18/490),(int)((double)frame.getHeight()*22/490));
		min.setSize((int)((double)frame.getWidth()*18/490),(int)((double)frame.getHeight()*22/490));
		title.setSize(frame.getWidth()-(int)((double)frame.getWidth()*18/490)*2,(int)((double)frame.getHeight()*22/490));
		title.setLocation(0,0);
		title.setOpaque(false);
		exit.setLocation(frame.getWidth()-exit.getWidth(),0);
		min.setLocation(frame.getWidth()-2*min.getWidth(),0);
		frame.setContentPane(panel);
		panel.setLayout(null);
		panel.add(exit);
		panel.add(min);
		panel.add(title);
		panel.setOpaque(false);
		frame.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {  //按下（mousePressed 不是点击，而是鼠标被按下没有抬起）
            	 if(e.getY()<=(int)((double)frame.getHeight()*22/490)){
            		 move=true;
            	origin.x = e.getX();  //当鼠标按下的时候获得窗口当前的位置
                origin.y = e.getY();
            	 }
            }
            public void mouseReleased(MouseEvent e){ 
				   move=false;
			    } 
          
		});
		frame.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {  //拖动（mouseDragged 指的不是鼠标在窗口中移动，而是用鼠标拖动）
            	if(move){
                Point p = frame.getLocation();  //当鼠标拖动时获取窗口当前位置
                //设置窗口的位置
                //窗口当前的位置 + 鼠标当前在窗口的位置 - 鼠标按下的时候在窗口的位置
               
                frame.setLocation(p.x + e.getX() - origin.x, p.y + e.getY() - origin.y);
            	}
            }
		});
		exit.setIMG(AllImage.exitEnterImg, AllImage.exitImg, AllImage.exitClicking);
		min.setIMG(AllImage.minMove, AllImage.minMin, AllImage.minClick);
		exit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				System.exit(0);
			}
		});
		min.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				frame.setExtendedState(Frame.ICONIFIED);
			}
		});
		frame.setVisible(true);
	}
	public static FrameMain createFrame(){
		frame=new FrameMain();
		return frame;
	}
	
	public static JPanel getContentPanel(){
		return panel;
	}

}
