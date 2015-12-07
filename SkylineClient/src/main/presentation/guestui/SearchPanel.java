package main.presentation.guestui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import main.presentation.mainui.AllImage;
import main.presentation.mainui.FrameMain;
import main.presentation.mainui.MainController;
import main.presentation.rightui.Rightui;

public class SearchPanel{
	private FrameMain frame;
	private JPanel panel;
	private JTextField searchField=new JTextField("");
	private JLabel welComeLabel=new JLabel("");
	private JLabel login=new JLabel("");
	private JLabel aboutUs=new JLabel("");
	private JLabel version=new JLabel("");
	private JLabel search=new JLabel("");
	private JLabel welcome;//±³¾°Í¼
	
	public SearchPanel(){
		this.frame=FrameMain.getFrame();
		panel=FrameMain.getContentPanel();
	}
	
	public void init(){
		int w=frame.getWidth()/851;
		int h=frame.getHeight()/576;
		AllImage.welcome.setImage(AllImage.welcome.getImage().getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_DEFAULT));
		AllImage.welcome_version.setImage(AllImage.welcome_version.getImage().getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_DEFAULT));
		AllImage.welcome_login.setImage(AllImage.welcome_login.getImage().getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_DEFAULT));
		AllImage.welcome_input2.setImage(AllImage.welcome_input2.getImage().getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_DEFAULT));
		AllImage.welcome_input1.setImage(AllImage.welcome_input1.getImage().getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_DEFAULT));
		AllImage.welcome_aboutus.setImage(AllImage.welcome_aboutus.getImage().getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_DEFAULT));
	
		
		welcome=new JLabel(AllImage.welcome);
		welcome.setSize(panel.getWidth(),panel.getHeight());
		welcome.setLocation(0,0);
		
		
		searchField.setOpaque(false);
		searchField.setBorder(null);
		searchField.setFont(new Font("ºÚÌå",Font.PLAIN,18));
		searchField.setForeground(Color.BLACK);
		searchField.setSize(w*290,h*54);
		searchField.setLocation(w*240,h*221);
		searchField.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				welcome.setIcon(AllImage.welcome_input1);
				panel.repaint();
			}
			public void mouseClicked(MouseEvent e){
				welcome.setIcon(AllImage.welcome_input2);
				panel.repaint();
			}
			public void mouseExited(MouseEvent e){
				welcome.setIcon(AllImage.welcome);
				panel.repaint();
			}
		});
		
		panel.setLayout(null);
		welComeLabel.setSize(frame.getWidth()/4,frame.getHeight()/10);
		welComeLabel.setLocation(frame.getWidth()/8*3,
				frame.getHeight()/5*2-welComeLabel.getHeight());
		welComeLabel.setFont(new Font("ºÚÌå",0,30));
		
		search.setOpaque(false);
		search.setBorder(null);
		search.setSize(58*w,62*h);
		search.setLocation(565*w,236*h);
		
		
		aboutUs.setOpaque(false);
		aboutUs.setBorder(null);
		aboutUs.setSize(54*w,15*h);
		aboutUs.setLocation(432*w,470*h);
		
		version.setOpaque(false);
		version.setBorder(null);
		version.setSize(50*w,11*h);
		version.setLocation(350*w,470*h);
		
		
		login.setOpaque(false);
		login.setBorder(null);
		login.setSize(75*w,13*h);
		login.setLocation(768*w,54*h);
		
		panel.add(login);
		panel.add(search);
		panel.add(welComeLabel);
		panel.add(searchField);
		panel.add(aboutUs);
		panel.add(version);
		panel.add(welcome);
		search.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				
			}
			public void mouseEntered(MouseEvent e){
				welcome.setIcon(AllImage.welcome_input2);
				panel.repaint();
			}
			public void mouseExited(MouseEvent e){
				welcome.setIcon(AllImage.welcome);
				panel.repaint();
			}
		});
		aboutUs.addMouseListener(new MouseAdapter(){
			
			public void mouseEntered(MouseEvent e){
				welcome.setIcon(AllImage.welcome_aboutus);
				panel.repaint();
			}
			public void mouseExited(MouseEvent e){
				welcome.setIcon(AllImage.welcome);
				panel.repaint();
			}
		});
		version.addMouseListener(new MouseAdapter(){
			
			public void mouseEntered(MouseEvent e){
				welcome.setIcon(AllImage.welcome_version);
				panel.repaint();
			}
			public void mouseExited(MouseEvent e){
				welcome.setIcon(AllImage.welcome);
				panel.repaint();
			}
		});
		login.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				panel.removeAll();
				panel.repaint();
				MainController.jumpToRightui(Rightui.Login);
			}
			public void mouseEntered(MouseEvent e){
				welcome.setIcon(AllImage.welcome_login);
				panel.repaint();
			}
			public void mouseExited(MouseEvent e){
				welcome.setIcon(AllImage.welcome);
				panel.repaint();
			}
		});
		panel.repaint();
	}
	
	public void remove(){
		panel.remove(this.searchField);
		panel.remove(this.welComeLabel);
		panel.remove(login);
		panel.remove(search);
	}
	
	
}
