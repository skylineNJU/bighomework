package presentation.guestui;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

import presentation.mainui.FrameMain;
import presentation.mainui.MainController;
import presentation.rightui.Rightui;

public class SearchPanel{
	private FrameMain frame;
	private JPanel panel;
	private JTextField searchField=new JTextField("请输入订单号");
	private JLabel welComeLabel=new JLabel("欢迎使用本系统");
	private JLabel login=new JLabel("员工登陆入口");
	private JButton comfirm=new JButton("确认");
	
	public SearchPanel(){
		this.frame=FrameMain.getFrame();
		panel=FrameMain.getContentPanel();
	}
	
	public void init(){
		this.searchField.setSize(frame.getWidth()/2,
				frame.getHeight()/10);		
		this.searchField.setLocation(frame.getWidth()/4,
				frame.getHeight()/5*2);
		this.searchField.setFont(new Font("黑体",0,30));
		
		panel.setLayout(null);
		welComeLabel.setSize(frame.getWidth()/4,frame.getHeight()/10);
		welComeLabel.setLocation(frame.getWidth()/8*3,
				frame.getHeight()/5*2-welComeLabel.getHeight());
		welComeLabel.setFont(new Font("黑体",0,30));
		panel.add(welComeLabel);
		panel.add(searchField);
		comfirm.setSize(frame.getWidth()/10,frame.getHeight()/10);
		comfirm.setLocation(searchField.getX()+searchField.getWidth()
		,searchField.getY());
		panel.add(comfirm);
		login.setSize(frame.getWidth()/10,frame.getHeight()/10);
		login.setLocation(frame.getWidth()/10*9,
				(int)((double)frame.getHeight()*22/490));
		panel.add(login);
		
		comfirm.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				
			}
		
		});
		login.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				remove();
				panel.repaint();
				MainController.jumpToRightui(Rightui.Login);
			}
		});
		panel.repaint();
	}
	
	public void remove(){
		panel.remove(this.searchField);
		panel.remove(this.welComeLabel);
		panel.remove(login);
		panel.remove(comfirm);
	}
	
	
}
