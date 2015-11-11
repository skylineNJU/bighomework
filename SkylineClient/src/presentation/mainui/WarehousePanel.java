package presentation.mainui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import presentation.rightui.Rightui;

public class WarehousePanel extends GuidePanel{
	private JButton addWarehouseInReceipt=new JButton("填写入库单");
	private JButton addWarehouseOutReceipt=new JButton("填写出库单");
	private JButton showInventory=new JButton("库存查看");
	private JButton checkInventory=new JButton("库存盘点");
	private JButton modifyPassword=new JButton("密码修改");
	private JLabel back=new JLabel("注销");
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
		
		back.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				remove();
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
		this.removeAll();
		panel.remove(this);
		MainController.getWritepanel().removeAll();
		panel.remove(MainController.getWritepanel());
	}
	
}
