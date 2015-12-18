package main.presentation.financeui;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

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
	private JButton addButton;
	private JLabel addLabel;
	private JLabel accountLabel;
	private JLabel balanceLabel;
	private JTextField accountText;
	private JTextField balanceText;
	private JButton saveButton;
	
	//银行账户的信息,需要从数据库中读取
	private String[][] bankAccountMessage;
	//列表中的标题
	private String[] tableTitle;
	
	public BalancePanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth = panel.getWidth();
		panelHeight = panel.getHeight();
	}
	
	public void init(){
		title();
		initTable();
		addPane();
		panel.repaint();
	}
	
	//获得银行信息
	public void getBankAcount(){
		FinanceBLService service = ConstructFactory.FinanceFactory();
		ArrayList<BankAccountVO> bankListVO = service.showBalance();
		bankAccountMessage = new String[bankListVO.size()][2];
		int counter = 0;
		
		for(BankAccountVO bankVO:bankListVO){
			bankAccountMessage[counter][0] = bankVO.getCode();
			BigDecimal bigDecimal = new BigDecimal(bankVO.getBalance());
			bankAccountMessage[counter][1] = bigDecimal.toString();
			counter++;
		}
	}
	
	public void initTable(){
		tableTitle = new String[]{"银行账户","余额"};
		getBankAcount();
		table = new JTable(bankAccountMessage,tableTitle);
		table.setEnabled(false);//设置不可编辑内容
		table.setRowHeight(panelWidth/20);//设置列宽
		table.getTableHeader().setPreferredSize(new Dimension(1, panelWidth/20));//设置表头高度
		table .getTableHeader().setReorderingAllowed(false);//表头不可移动
		table.setDragEnabled(false);
		table.getTableHeader().setResizingAllowed(false);//设置列宽不可变
		table.setVisible(true);
		scrollPane = new JScrollPane(table);
		if(bankAccountMessage.length>4){
			scrollPane.setBounds(panelWidth/6, panelHeight/6, panelWidth*2/3, 5*table.getRowHeight());
		}else{
			scrollPane.setBounds(panelWidth/6, panelHeight/6, panelWidth*2/3, (table.getRowCount()+1)*table.getRowHeight());
		}
		scrollPane.setVisible(true);
		panel.add(scrollPane);
	}
	
	public void title(){
		title = new JLabel("银行账户");
		title.setBounds(panelWidth/3, panelHeight/40, panelWidth/6, panelHeight/20);
		panel.add(title);
	}
	public void addPane() {
		addButton = new JButton("新增");
		addLabel = new JLabel();
		accountLabel = new JLabel("银行账户名");
		balanceLabel = new JLabel("余额");
		accountText = new JTextField();
		balanceText = new JTextField();
		saveButton = new JButton("保存");
		panel.add(addLabel);
		panel.add(addButton);
		addLabel.add(accountLabel);
		addLabel.add(balanceLabel);
		addLabel.add(accountText);
		addLabel.add(balanceText);
		addLabel.add(saveButton);
		addLabel.setVisible(false);
		
		addLabel.setBounds(panelWidth/6, panelHeight/2, panelWidth*5/6, panelHeight/3);
		accountLabel.setBounds(0, panelHeight/10, panelWidth/8, panelHeight/20);
		balanceLabel.setBounds(0, panelHeight/5, panelWidth/8, panelHeight/20);
		accountText.setBounds(panelWidth/8, panelHeight/10, panelWidth*2/5, panelHeight/20);
		balanceText.setBounds(panelWidth/8, panelHeight/5, panelWidth*2/5, panelHeight/20);
		saveButton.setBounds(panelWidth*7/12, panelHeight/4, panelWidth/10, panelHeight/20);
		addButton.setBounds(panelWidth*3/4, panelHeight*6/7, panelWidth/10, panelHeight/20);
		addButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				addLabel.setVisible(true);
			}
		});
		saveButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				BankAccountVO bankvo = new BankAccountVO(accountText.getText(), Double.valueOf(balanceText.getText()));
				FinanceBLService service = ConstructFactory.FinanceFactory();
				if(service.addBankAccount(bankvo)){
					addLabel.setVisible(false);
				}else{
					
				}	
			}
		});
	}

}
