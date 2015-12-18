package main.serverFrame;

import javax.swing.ImageIcon;

public class AllImage {
	
	private AllImage() {}

	// 退出按钮，鼠标点击时的图片
	public static ImageIcon exitClicking = new ImageIcon("graphics/exitFrameClick.png");
	// 退出按钮，鼠标进入时的图片
	public static ImageIcon exitEnterImg = new ImageIcon("graphics/exitFrameMove.png");
	// 退出按钮，鼠标未进入时的图片
	public static ImageIcon exitImg = new ImageIcon("graphics/exitFrameExit.png");
	// 最小化按钮，鼠标未进入时的图片
	public static ImageIcon minMin = new ImageIcon("graphics/minFrameMin.png");
	// 最小化按钮，鼠标进入时的图片
	public static ImageIcon minMove = new ImageIcon("graphics/minFrameMove.png");
	// 最小化按钮，鼠标点击时的图片
	public static ImageIcon minClick = new ImageIcon("graphics/minFrameClick.png");
}
