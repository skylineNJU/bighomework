package presentation.mainui;

import javax.swing.ImageIcon;

public class AllImage {
	
	//构造方法私有化
	private AllImage(){}
	
		//退出按钮，鼠标进入时的图片
		public static ImageIcon exitEnterImg = new ImageIcon("graphics/label/exitFrameEnter.gif");
		//退出按钮，鼠标未进入时的图片
		public static ImageIcon exitImg = new ImageIcon("graphics/label/exitFrameExit.gif");
		//最小化按钮，鼠标进入时的图片
		public static ImageIcon smallestEnterImg = new ImageIcon("graphics/label/smallestEnter.gif");
		//最小化按钮，鼠标未进入时的图片
		public static ImageIcon smallestImg = new ImageIcon("graphics/label/smallestExit.gif");
		//边框图标，长
		public static ImageIcon frameEdgingWImg = new ImageIcon("graphics/label/frameedge.jpg");
		//边框图标，宽
		public static ImageIcon frameEdgingHImg = new ImageIcon("graphics/label/frameedge1.jpg");
		//最大化按钮，鼠标进入时的图片
		public static ImageIcon maxEnterImg = new ImageIcon("graphics/label/max1.jpg");
		//最大化按钮，鼠标未进入时的图片
		public static ImageIcon maxImg = new ImageIcon("graphics/label/max.jpg");
		//边框
		public static ImageIcon edgW = new ImageIcon("graphics/label/frameedge.jpg");
		public static ImageIcon egdH = new ImageIcon("graphics/label/frameedge1.jpg");
}
