package main.presentation.receiptui;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import main.businesslogicservice.ReceiveBLService;
import main.constructfactory.ConstructFactory;
import main.presentation.mainui.MainController;
import main.presentation.mainui.WritePanel;
import main.presentation.mainui.memory.CourrierMemory;
import main.vo.OrderVO;

public class AllOrderPanel {
	
	private JPanel panel;
	private int panelWidth;
	private int panelHeight;
	private JTable table;
	private JLabel title;
	private JScrollPane scrollPane;
	private String[] tableTitle;
	private String[][] tableData;
	private boolean[] selectRow;
	
	public AllOrderPanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth = panel.getWidth();
		panelHeight = panel.getHeight();
	}
	
	public void init(){
		initTable();
		title();
		panel.repaint();
	}
	public void title(){
		title = new JLabel("�鿴ȫ������");
		title.setBounds(panelWidth/3, 20, panelWidth/6, 40);
		panel.add(title);
	}
	
	public void initTableData(){
		WritePanel wp=(WritePanel)panel;
		CourrierMemory memory=(CourrierMemory) wp.getMemory();
		String code=memory.getOrderCode();
		ReceiveBLService service=ConstructFactory.ReceiveFactory();
		ArrayList<OrderVO> voList=service.inquireOrderReceive(code);
		int length;
		
		if(voList.size()>10){
			length=voList.size();
		}else{
			length=10;
		}
		tableData=new String[length][15];
		selectRow=new boolean[length];
		for(int x=0;x<length;x++){
			selectRow[x]=false;
			for(int y=0;y<14;y++){
				tableData[x][y]=null;
			}
		}
		int x=0;
		for(OrderVO vo:voList){
			tableData[x][0]=vo.getOrderCode();
			tableData[x][1]=vo.getSenderName();
			tableData[x][2]=vo.getSenderAddress();
			tableData[x][3]=vo.getSenderCom();
			tableData[x][4]=vo.getSenderMobile();
			tableData[x][5]=vo.getReceiverName();
			tableData[x][6]=vo.getReceiverAddress();
			tableData[x][7]=vo.getReceiverCom();
			tableData[x][8]=vo.getReceiverMobile();
			tableData[x][9]=vo.getNum()+"";
			tableData[x][10]=vo.getWeight()+"";
			tableData[x][11]=vo.getHeight()+"";
			tableData[x][12]=vo.getCargoName();
			tableData[x][13]=vo.getSum()+"";
			tableData[x][14]=null;
			x++;
		}
	}
	
	
	public void initTable(){
		tableTitle = new String[]{"������","�ļ�������","�ļ���סַ","�ļ��˵�λ","�ļ��˵绰",
				"�ռ�������","�ռ���סַ","�ռ��˵�λ","�ռ��˵绰", "�ļ���Ŀ","�ļ�����","�ļ����","�ļ�����","����","ѡ��"};
		this.initTableData();
		table = new JTable(tableData,tableTitle);
		table.setRowHeight(panelWidth/20);//�����п�
		table.getTableHeader().setPreferredSize(new Dimension(10000, panelWidth/20));//���ñ�ͷ�߶�
		table .getTableHeader().setReorderingAllowed(false);//��ͷ�����ƶ�
		table.getTableHeader().setResizingAllowed(true);//�����п��ɱ�
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//���ò��ɵ�����С
		table.setEnabled(false);//���ò��ɱ༭����
		for(int i = 0;i<tableTitle.length;i++){
			table.getColumnModel().getColumn(i).setPreferredWidth(panelWidth/5);
		}
		
		scrollPane = new JScrollPane(table);
		if(tableData.length>=10){
			scrollPane.setBounds(panelWidth/20, panelHeight/6, panelWidth*9/10, 11*table.getRowHeight());		
		}else{
			scrollPane.setBounds(panelWidth/20, panelHeight/6, panelWidth*9/10, (table.getRowCount()+1)*table.getRowHeight());
		}
		panel.add(scrollPane);
//		table.addMouseListener(new MouseAdapter(){
//			public void mouseClicked(MouseEvent e){
//				int x=table.getSelectedRow();
//				if(!selectRow[x]){
//					selectRow[x]=true;
//					table.setValueAt("��ѡ",x,13);
//				}else{
//					selectRow[x]=false;
//					table.setValueAt("",x,13);
//				}
//			}
//		});
	}
}
