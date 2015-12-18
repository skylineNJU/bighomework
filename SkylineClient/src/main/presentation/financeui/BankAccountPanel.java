package main.presentation.financeui;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import main.businesslogicservice.FinanceBLService;
import main.constructfactory.ConstructFactory;
import main.presentation.mainui.MainController;
import main.vo.BankAccountVO;

public class BankAccountPanel {
	private JPanel panel;
	private JPanel bankaccount;
	private JTabbedPane tab;
	private PageTable table;
	private JScrollPane scrollPane;
	private String[] tableTitle;
	private String[][] tableData;
	private JLabel next,previous,add,delete;
	private JLabel label1,label2,title,update,save,back;
	private int account=0;
	public BankAccountPanel (){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
	}
	
	public void init(){
		bankaccount = new JPanel();
		bankaccount.setLayout(null);
		tab=new JTabbedPane(JTabbedPane.TOP);
		tab.addTab("银行账户账目", bankaccount);
		tab.setSize(panel.getWidth()*16/18,panel.getHeight()/100*90);
		tab.setLocation(panel.getWidth()/18,panel.getHeight()*2/20);
		panel.add(tab);
		getBankAcountData();
		bankaccountPanel();
		account++;
		button();
		Listener();
		tab.repaint();
		panel.repaint();
	}
	
	public void bankaccountPanel(){
		tableTitle =  new String[]{"银行账户","金额/元"};
	//	tableData = new String[][]{{"航运区","","","","100%"},{"铁路区","","","","100%"},{"汽运区","","","","100%"},{"机动区","","","","100%"}};	
		
		if(account==0){
			table = new PageTable(tableTitle,tableData);
		}
		table.setEnabled(false);//设置不可编辑内容
		table.setRowHeight(panel.getWidth()/20);//设置列宽
		table.getTableHeader().setPreferredSize(new Dimension(1, panel.getWidth()/20));//设置表头高度
		table.getTableHeader().setReorderingAllowed(false);//表头不可移动
		table.setDragEnabled(false);
		table.setVisible(true);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(tab.getX()-panel.getWidth()/18, tab.getY()-panel.getWidth()/50,tab.getWidth(), 10*table.getRowHeight());
		table.getTableHeader().setResizingAllowed(false);//设置列宽不可变
		scrollPane.setVisible(true);		
		bankaccount.add(scrollPane);
		
	}
	
	public void getBankAcountData(){
		FinanceBLService service = ConstructFactory.FinanceFactory();
		ArrayList<BankAccountVO> bankListVO = service.showBalance();
		tableData = new String[bankListVO.size()][2];
		if(bankListVO.size()==0){
			tableData = new String[10][2];
			for(int x=0;x<10;x++)
				for(int y=0;y<2;y++)
					tableData[x][y]=null;
		}
		int counter = 0;
		for(BankAccountVO bankVO:bankListVO){
			tableData[counter][0] = bankVO.getCode();
			BigDecimal bigDecimal = new BigDecimal(bankVO.getBalance());
			tableData[counter][1] = bigDecimal.toString();
			counter++;
		}
	}
	
	public void button(){
		  title = new JLabel("银行账户账目");
		  title .setBounds(panel.getWidth()*40/100,panel.getHeight()*1/60, panel.getWidth()/10, panel.getHeight()/20);
			
			
	/*	  previous=new JLabel("上一页");
		  previous.setBounds(panel.getWidth()*50/100,panel.getHeight()*71/100, panel.getWidth()/10, panel.getHeight()/20);
		  next=new JLabel("下一页");
		  next.setBounds(panel.getWidth()*60/100,panel.getHeight()*71/100, panel.getWidth()/10, panel.getHeight()/20);
		   delete=new JLabel("删除");
		  delete.setBounds(panel.getWidth()*73/100,panel.getHeight()*71/100, panel.getWidth()/10, panel.getHeight()/20);
		  add=new JLabel("添加");
		  add.setBounds(panel.getWidth()*80/100,panel.getHeight()*71/100, panel.getWidth()/10, panel.getHeight()/20);
		  label1=new JLabel("总共"+table.totalRowCount+"记录|当前第"+table.currentPage+"页");
		  label1.setBounds(institution.getWidth()*9/100,panel.getHeight()*71/100, panel.getWidth()/5, panel.getHeight()/20);
		*/  
		  
		  previous=new JLabel("上一页");
		  previous.setBounds(panel.getWidth()*70/100,panel.getHeight()*71/100, panel.getWidth()/10, panel.getHeight()/20);
		  next=new JLabel("下一页");
		  next.setBounds(panel.getWidth()*80/100,panel.getHeight()*71/100, panel.getWidth()/10, panel.getHeight()/20);
		   delete=new JLabel("删除");
		  delete.setBounds(panel.getWidth()*73/100,panel.getHeight()*1/60, panel.getWidth()/10, panel.getHeight()/20);
		  add=new JLabel("添加");
		  add.setBounds(panel.getWidth()*80/100,panel.getHeight()*1/60, panel.getWidth()/10, panel.getHeight()/20);
		  label1=new JLabel("总共"+table.totalPage+"页|当前第"+table.currentPage+"页");
		  label1.setBounds(panel.getWidth()*50/100,panel.getHeight()*71/100, panel.getWidth()/4, panel.getHeight()/20); 
		  label2=new JLabel("总共"+table.totalRowCount+"条记录"); 
		  label2.setBounds(panel.getWidth()*2/100,panel.getHeight()*71/100, panel.getWidth()/4, panel.getHeight()/20);
		  update = new JLabel("新建账目");
		  update.setBounds(panel.getWidth()*78/100,panel.getHeight()*1/60, panel.getWidth()/10, panel.getHeight()/20);
		  save = new JLabel("存档");
		  save.setBounds(panel.getWidth()*70/100,panel.getHeight()*1/60, panel.getWidth()/10, panel.getHeight()/20);
		  back = new JLabel("返回");
		  back.setBounds(panel.getWidth()*62/100,panel.getHeight()*1/60, panel.getWidth()/10, panel.getHeight()/20);
		  
		  bankaccount.add(previous);
		  bankaccount.add(next);
//		  institution.add(add);
//		  institution.add(delete);
		  bankaccount.add(label1);
		  bankaccount.add(label2);
		  bankaccount.add(update);
		  bankaccount.add(save);
		  bankaccount.add(back);
		//  institution.add(title);
		  
		 }
		 /**
		  * 按钮事件
		  */
	public void Listener() {
		  previous.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
				System.out.println("previousPage!!!!!");
					int i=table.getPreviousPage();
					DefaultTableModel model=new DefaultTableModel(table.getPageData(),tableTitle);
					table.setModel(model);
					label1.setText("总共"+table.totalPage+"页|当前第"+table.currentPage+"页");
					label2.setText("总共"+table.totalRowCount+"条记录");
					if(i==-1)return;
		  }});
		  
		  next.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					System.out.println("nextPage!!!!!");
					int i=table.getNextPage();
					DefaultTableModel model=new DefaultTableModel(table.getPageData(),tableTitle);
					table.setModel(model);
					label1.setText("总共"+table.totalPage+"页|当前第"+table.currentPage+"页");
					label2.setText("总共"+table.totalRowCount+"条记录");
					if(i==-1)return;
		  }});
		  back.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					panel.removeAll();
					InitialAccountPanel Initial = new InitialAccountPanel();
					Initial.init();
			}});
		  
		  update.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					account=0;
					table = new PageTable(tableTitle,tableData);
					
			}});
	}
}
