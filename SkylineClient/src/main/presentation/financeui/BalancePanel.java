package main.presentation.financeui;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import main.businesslogicservice.FinanceBLService;
import main.constructfactory.ConstructFactory;
import main.presentation.mainui.MainController;
import main.vo.BankAccountVO;

public class BalancePanel {
	
	private int panelWidth;
	private int panelHeight;
	private JPanel panel;
	private JLabel title;
	private JScrollPane scrollPane;
	private JTable table;
	//�����˻�����Ϣ,��Ҫ�����ݿ��ж�ȡ
	private String[][] bankAccountMessage;
	//�б��еı���
	private String[] tableTitle;
	
	public BalancePanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth = panel.getWidth();
		panelHeight = panel.getHeight();
	}
	
	public void init(){
		title();
		getBankAcount();
		initTable();
		panel.repaint();
	}
	
	//���������Ϣ
	public String[][] getBankAcount(){
		bankAccountMessage = new String[6][2];
		FinanceBLService service = ConstructFactory.FinanceFactory();
		BankAccountVO bankAccountVO= new BankAccountVO();
		int counter = 0;
		while(counter<3){
			bankAccountVO = service.showBalance(String.valueOf(counter));
			this.bankAccountMessage[counter][0] = bankAccountVO.getCode();
			this.bankAccountMessage[counter][1] = String.valueOf(bankAccountVO.getBalance());
			counter++;
		};
		return null;
	}
	
	public void initTable(){
		tableTitle = new String[]{"�����˻�","���"};
		table = new JTable(bankAccountMessage,tableTitle);
		table.setEnabled(false);//���ò��ɱ༭����
		table.setRowHeight(panelWidth/20);//�����п�
		table.getTableHeader().setPreferredSize(new Dimension(1, panelWidth/20));//���ñ�ͷ�߶�
		table .getTableHeader().setReorderingAllowed(false);//��ͷ�����ƶ�
		table.setDragEnabled(false);
		table.getTableHeader().setResizingAllowed(false);//�����п��ɱ�
		table.setVisible(true);
		scrollPane = new JScrollPane(table);
		if(bankAccountMessage.length>4){
			scrollPane.setBounds(panelWidth/6, panelHeight/3, panelWidth*2/3, 5*table.getRowHeight());
		}else{
			scrollPane.setBounds(panelWidth/6, panelHeight/3, panelWidth*2/3, (table.getRowCount()+1)*table.getRowHeight());
		}
		scrollPane.setVisible(true);
		panel.add(scrollPane);
	}
	
	public void title(){
		title = new JLabel("�����˻�");
		title.setBounds(panelWidth/3, panelHeight/40, panelWidth/6, panelHeight/20);
		panel.add(title);
	}

}
