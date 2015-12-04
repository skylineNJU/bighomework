package main.presentation.mainui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import main.presentation.rightui.Rightui;
import main.presentation.warehouseui.Warehouseui;

@SuppressWarnings("serial")
public class WarehousePanel extends GuidePanel{
	private JButton addWarehouseInReceipt=new JButton("ÌîÐ´Èë¿âµ¥");
	private JButton addWarehouseOutReceipt=new JButton("ÌîÐ´³ö¿âµ¥");
	private JButton showInventory=new JButton("¿â´æ²é¿´");
	private JButton checkInventory=new JButton("¿â´æÅÌµã");
	private JButton modifyPassword=new JButton("ÃÜÂëÐÞ¸Ä");
	private JLabel back=new JLabel("×¢Ïú");
	private JPanel panel;
	public WarehousePanel(){
		panel=FrameMain.getContentPanel();
		this.setLayout(null);
	}
	
	public void init(){

		this.add(addWarehouseInReceipt);
		this.add(addWarehouseOutReceipt);
		this.add(showInventory);
		this.add(checkInventory);
		this.add(modifyPassword);
		this.add(back);
		
		addWarehouseInReceipt.setSize(this.getWidth()/4*3,this.getHeight()/15);
		addWarehouseOutReceipt.setSize(this.getWidth()/4*3,this.getHeight()/15);
		showInventory.setSize(this.getWidth()/4*3,this.getHeight()/15);
		checkInventory.setSize(this.getWidth()/4*3,this.getHeight()/15);
		back.setSize(this.getWidth()/4*3,this.getHeight()/15);
		
		addWarehouseInReceipt.setLocation((this.getWidth()-addWarehouseInReceipt.getWidth())/2
				,this.getHeight()/4*1);
		addWarehouseOutReceipt.setLocation((this.getWidth()-addWarehouseInReceipt.getWidth())/2
				,addWarehouseInReceipt.getY()+addWarehouseInReceipt.getHeight()*3/2);
		showInventory.setLocation((this.getWidth()-addWarehouseInReceipt.getWidth())/2
				,addWarehouseOutReceipt.getY()+addWarehouseOutReceipt.getHeight()*3/2);
		checkInventory.setLocation((this.getWidth()-addWarehouseInReceipt.getWidth())/2
				,showInventory.getY()+showInventory.getHeight()*3/2);
		back.setLocation((this.getWidth()-addWarehouseInReceipt.getWidth())/2
				,checkInventory.getY()+checkInventory.getHeight()*3/2);
		
		
		addWarehouseInReceipt.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				MainController.getWritepanel().removeAll();
				panel.repaint();
				MainController.jumpToWarehouseui(Warehouseui.AddWarehouseInReceipt);
			}
		});
		
		addWarehouseOutReceipt.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				MainController.getWritepanel().removeAll();
				panel.repaint();
				MainController.jumpToWarehouseui(Warehouseui.AddWarehouseOutReceipt);
			}
		});
		
		showInventory.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				MainController.getWritepanel().removeAll();
				panel.repaint();
				MainController.jumpToWarehouseui(Warehouseui.ShowInventory);
			}
		});
		
		checkInventory.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				MainController.getWritepanel().removeAll();
				panel.repaint();
				MainController.jumpToWarehouseui(Warehouseui.CheckInventory);
			}
		});
		
		
		
		back.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				panel.removeAll();
				panel.repaint();
				MainController.jumpToRightui(Rightui.Login);
			}
		});
		

		panel.add(this);	
		panel.repaint();
		this.repaint();
		this.setVisible(true);
		
	}
	
	public void remove(){
		
		
	}
	
}
