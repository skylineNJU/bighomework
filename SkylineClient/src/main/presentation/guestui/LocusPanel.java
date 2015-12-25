package main.presentation.guestui;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import main.businesslogicservice.GuestBLService;
import main.constructfactory.ConstructFactory;
import main.presentation.mainui.AllImage;
import main.presentation.mainui.FrameMain;
import main.presentation.mainui.MainController;
import main.vo.HistoryVO;

public class LocusPanel {
	private JPanel panel;
	private JLabel background;
	private JLabel label[]=new JLabel[6];
	private String orderCode;
	private HistoryVO vo;
	private int process=0;
	private JProgressBar progressBar=new JProgressBar();
	private JTextField searchField=new JTextField(18);
	private JLabel back=new JLabel("返回");
	
	public LocusPanel(String orderCode){
		for(int x=0;x<6;x++){
			label[x]=new JLabel();
		}

		int w=FrameMain.getFrame().getWidth()/851;
		int h=FrameMain.getFrame().getHeight()/576;
		this.panel=FrameMain.getContentPanel();	
		this.orderCode=orderCode;
		searchField.setSize(w*290,h*54);
		searchField.setLocation(w*240,searchField.getHeight());
		searchField.setText(orderCode);
		background=new JLabel(AllImage.backGround);
		background.setSize(panel.getWidth(),panel.getHeight());
		background.setLocation(0,0);
		label[5].setText("	查询");
		label[5].setSize(58*w,62*h);
		label[5].setLocation(searchField.getX()+searchField.getWidth(),searchField.getY());
		back.setSize(75*w,13*h);
		back.setLocation(768*w,54*h);
		back.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				RemoveAll();
				panel.repaint();
				MainController.jumpToGuestui(Guestui.Search);
			}
		});
		label[5].addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				setOrderCode(searchField.getText());
				searchInfo();
			}
		});
		for(int x=0;x<6;x++){
			panel.add(label[x]);
		}
		panel.add(back);
		panel.add(progressBar);
		panel.add(searchField);
		panel.add(background);
		panel.repaint();
		this.init();
	}
	
	public void setOrderCode(String orderCode){
		if(orderCode==null||orderCode.equals("")){
			return;
		}
		this.orderCode=orderCode;
		if(this.searchInfo()){
			
		}else{
			
		}
	}
	public boolean searchInfo(){	
		int frameWidth=FrameMain.getFrame().getWidth();
		int frameHeight=FrameMain.getFrame().getHeight();
		AllImage.backGround.setImage(AllImage.backGround.getImage().getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_DEFAULT));
		int w=frameWidth/851;
		int h=frameHeight/576;
		
		GuestBLService service=ConstructFactory.GuestFactory();
		vo=service.showHistory(orderCode);
		
		if(!vo.getBeginCity().equals("")){
		label[0].setText("到达"+vo.getBeginCity()+"营业厅");
		label[1].setText("到达"+vo.getBeginCity()+"中转中心");
		label[2].setText("到达"+vo.getEndCity()+"中转中心");
		label[3].setText("到达"+vo.getEndCity()+"营业厅");
		label[4].setText("已送达至收件人");
		process=vo.getArriveInterm1()+vo.getArriveInterm2()+vo.getArriveLobby1()+vo.getArriveLobby2()
		+vo.getIsReceived();
		System.out.println("the process is:"+process);
		for(int x=0;x<5;x++){
		label[x].setSize(58*w*2,62*h);
		}
		progressBar.setSize(this.searchField.getWidth()/2*3,this.searchField.getHeight()/3*2);
		progressBar.setLocation((frameWidth-progressBar.getWidth())/2,(frameHeight-progressBar.getHeight())/2);
		
		int y=1;
		for(int x=0;x<5;x++){
			
			int z=0;
			if(y<0){
				z=progressBar.getHeight();
			}
			label[x].setLocation(progressBar.getX()+progressBar.getWidth()/4*x-label[0].getWidth()/2
				,progressBar.getY()-z+y*label[0].getHeight());
			y=-y;
			System.out.println(z);
		}

		progressBar.setMaximum(4);
		progressBar.setMinimum(0);
		progressBar.setValue(process-1);
		panel.repaint();
		return true;
		}else{
			return false;
		}
		
	}
	public void init(){
		if(this.searchInfo()){
			
		}else{
			
		}
		
	}
	
	public void RemoveAll(){
		for(int x=0;x<6;x++){
			panel.remove(label[x]);
		}
		panel.remove(back);
		panel.remove(progressBar);
		panel.remove(searchField);
		panel.remove(background);
	}
}
