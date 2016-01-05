package main.presentation.financeui;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import main.businesslogicservice.FinanceBLService;
import main.constructfactory.ConstructFactory;
import main.presentation.mainui.MainController;
import main.vo.BankAccountVO;
import main.vo.EarnVO;

public class EarnListPanel {

	private int panelWidth;
	private int panelHeight;
	private JPanel panel;
	private JLabel title;
	private int year;//��ǰ���
	private JLabel timeLabel;
	private JLabel yearLabel;
	private JLabel monthLabel;
	private JLabel dayLabel;
	private String[] yearString;
	private String[] monthString;
	private String[] dayString;//31��
	private String[] dayString1;//30��
	private String[] dayString2;//29��
	private String[] dayString3;//28��
	private JComboBox<String> yearBox;//��ʾ��ݵ���Ͽ�
	private JComboBox<String> monthBox;//��ʾ�·ݵ���Ͽ�
	private JComboBox<String> dayBox;//��ʾ�����Ͽ�
	private String[] tableTitle;
	private String[][] tableData;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton calculationButton;
	private JButton ensureButton;//ȷ��ѡ��ʱ�����
	
	public EarnListPanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth = panel.getWidth();
		panelHeight = panel.getHeight();
	}
	
	public void init(){
		tableTitle = new String[]{"�տ����", "�տ���", "���뵥λ", "��������","�����˻�","�Ƿ����","��ע"};
		title();
		setTime();
		initTable();
		initButton();
		panel.repaint();
	}
	public void title(){
		title = new JLabel("�������");
		title.setBounds(panelWidth/3, 10, panelWidth/6, 40);
		panel.add(title);
	}
	
	public void initButton(){
		ensureButton = new JButton("ȷ��");
		calculationButton = new JButton("����");
		panel.add(calculationButton);
		panel.add(ensureButton);
		calculationButton.setBounds(panelWidth*4/5, panelHeight*9/10, panelWidth/10, panelHeight/20);
		ensureButton.setBounds(dayLabel.getX()+panelWidth/10, panelHeight/10, panelWidth/10, panelHeight/20);
		
		calculationButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				updateEarn();
				panel.repaint();
			}
		});
		
		ensureButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				scrollPane.remove(table);
				panel.remove(scrollPane);
				data();
				initTable();
				panel.repaint();
			}
		});
	}
	
	//���㣬���������ݿ�
	public void updateEarn(){
		String[][] allData = new String[tableData.length][tableData[0].length];
		for(int i = 0; i<tableData.length; i++){//��ñ��е�����,��allData�洢
			for(int j = 0; j<tableData[i].length; j++){
				allData[i][j] = String.valueOf(table.getModel().getValueAt(i, j));
			}
		}
		FinanceBLService service=ConstructFactory.FinanceFactory();
		
		for(int i = 0;i<allData.length; i++) {
			//"�տ����", "�տ���", "���뵥λ", "��������","�����˻�","�Ƿ����","��ע"
			if(allData[i][5].equals("δ����")){
				BankAccountVO bankVO = new BankAccountVO(allData[i][4],Double.valueOf(allData[i][1]));
				service.modifyBalance(bankVO);
				allData[i][5] = "�ѽ���";
				table.getModel().setValueAt("�ѽ���", i, 5);
				EarnVO vo=new EarnVO(
						allData[i][0],
						allData[i][3],
						allData[i][2],
						allData[i][4],
						Double.valueOf(allData[i][1]),
						allData[i][6],
						allData[i][5]);
				service.modifyCollection(vo);
			}
			
		}
		
	}
	//����ʱ��Ŀ�
	public void setTime(){
		Calendar calendar = Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
		yearString = new String[]{String.valueOf(year-2), String.valueOf(year-1), String.valueOf(year), String.valueOf(year+1)};
		monthString = new String[]{"12", "11", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1"};
		dayString = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
				"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		dayString1 = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
				"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};
		dayString2 = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
				"16","17","18","19","20","21","22","23","24","25","26","27","28","29"};
		dayString3 = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
				"16","17","18","19","20","21","22","23","24","25","26","27","28"};
		timeLabel = new JLabel("ʱ��");
		yearLabel = new JLabel("��");
		monthLabel = new JLabel("��");
		dayLabel = new JLabel("��");
		yearBox = new JComboBox<String>(yearString);
		monthBox = new JComboBox<String>(monthString);
		dayBox = new JComboBox<String>(dayString);
	/*	String y =yearBox.getSelectedItem()+"" ;
		String m =monthBox.getSelectedItem()+"";
		System.out.println("year++++++::::"+y);
		System.out.println("month++++++::::"+m);
		if(m.equals("4")||m.equals("9")||m.equals("11")||m.equals("6")){
			dayBox = new JComboBox<String>(dayString1);
		}
		if(isLeap(y)&&m.equals("2")){
			dayBox = new JComboBox<String>(dayString2);
		}
		if(!isLeap(y)&&m.equals("2")){
			dayBox = new JComboBox<String>(dayString3);
		}
		*/
		panel.add(timeLabel);
		panel.add(yearLabel);
		panel.add(monthLabel);
		panel.add(dayLabel);
		panel.add(yearBox);
		panel.add(monthBox);
		panel.add(dayBox);
		
		timeLabel.setBounds(panelWidth/20, panelHeight/10, panelWidth/10, panelHeight/20);
		yearBox.setBounds(timeLabel.getX()+panelWidth/10, panelHeight/10, panelWidth/10, panelHeight/20);
		yearLabel.setBounds(yearBox.getX()+panelWidth/10+panelWidth/40, panelHeight/10, panelWidth/20, panelHeight/20);
		monthBox.setBounds(yearLabel.getX()+panelWidth/10, panelHeight/10, panelWidth/10, panelHeight/20);
		monthLabel.setBounds(monthBox.getX()+panelWidth/10+panelWidth/40, panelHeight/10, panelWidth/20, panelHeight/20);
		dayBox.setBounds(monthLabel.getX()+panelWidth/10, panelHeight/10,  panelWidth/10, panelHeight/20);
		dayLabel.setBounds(dayBox.getX()+panelWidth/40+panelWidth/10, panelHeight/10, panelWidth/10, panelHeight/20);

	}
	
	public void data(){
		int counter = 0;
		String date = yearBox.getSelectedItem()+"/"+monthBox.getSelectedItem()+"/"+dayBox.getSelectedItem();
		FinanceBLService finance = ConstructFactory.FinanceFactory();
		ArrayList<EarnVO> voList = finance.showEarnListDependsOnDay(date);
		if(voList.size()!=0){
			tableData = new String[voList.size()][tableTitle.length];
		}else{
			tableData = new String[1][tableTitle.length];
			tableData[0][0] = "   no data";
			tableData[0][1] = "   no data";
			tableData[0][2] = "   no data";
			tableData[0][3] = "   no data";
			tableData[0][4] = "   no data";
			tableData[0][5] = "   no data";
			tableData[0][6] = "   no data";
		}
		for(EarnVO earnVO:voList){
			tableData[counter][0] = earnVO.getCollectionCode();
			tableData[counter][1] = String.valueOf(earnVO.getMoney());
			tableData[counter][2] = earnVO.getUnit();
			tableData[counter][3] = earnVO.getDate();
			tableData[counter][4] = earnVO.getBankAccount();
			tableData[counter][5] = earnVO.getIsPaid();
			tableData[counter][6] = earnVO.getRemark();
			counter++;
		}
	}
	//�ɱ������б�
	@SuppressWarnings("serial")
	public void initTable(){
		data();
		table = new JTable(tableData,tableTitle);
		scrollPane = new JScrollPane(table);
		table .getTableHeader().setReorderingAllowed(false);//��ͷ�����ƶ�
		table.setRowHeight(panelWidth/20);//�����п�
		table.getTableHeader().setPreferredSize(new Dimension(1, panelWidth/20));//���ñ�ͷ�߶�
		table.getTableHeader().setResizingAllowed(false);//�����п��ɱ�
		table.setDragEnabled(false);
		if(tableData.length<=9){
			scrollPane.setBounds(panelWidth/12, panelHeight/5, panelWidth/6*5, (table.getRowCount()+1)*table.getRowHeight());
		}else{
			scrollPane.setBounds(panelWidth/12, panelHeight/5, panelWidth/6*5, 10*table.getRowHeight());
		}
		
		table.setModel(new DefaultTableModel(tableData,tableTitle){
			public boolean isCellEditable(int row,int column){
				if((column==1||column==6)&&
						!String.valueOf(table.getModel().getValueAt(row, 5)).equals("�ѽ���")){
					return true;
				}
				return false;
			}
		});
		panel.add(scrollPane);
	}
	
	
	static public boolean isLeap(String a){
		a=a.substring(0,4);
		int year = Integer.parseInt(a);
		if( year % 400 == 0 || ( year % 100 != 0 && year % 4 == 0)){
		  return true;
		}
		else
			return false;
		
	} 
}
