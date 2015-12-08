package main.presentation.financeui;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import main.businesslogicservice.FinanceBLService;
import main.constructfactory.ConstructFactory;
import main.presentation.mainui.MainController;
import main.vo.DistanceVO;
import main.vo.FeeVO;

public class FeeStrategyPanel {
	private JPanel panel;
	private int panelWidth;
	private int panelHeight;
	private JLabel title;
	private JLabel carLabel;
	private JLabel trainLabel;
	private JLabel planeLabel;
	private JLabel label1;//Ԫÿ����
	private JLabel label2;//Ԫÿ����
	private JLabel label3;//Ԫÿ����
	private JTextField carText;
	private JTextField trainText;
	private JTextField planeText;
	private String[] tableTitle;
	private String[][] tableData;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel cityDistance;
	private JButton saveButton;
	
	public FeeStrategyPanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth = panel.getWidth();
		panelHeight = panel.getHeight();
	}
	public void init(){
		initTitle();
		initText();
		getFee();
		initTable();
		panel.repaint();
	}
	public void initTitle(){
		title = new JLabel("�ƶ��շѲ���");
		panel.add(title);
		title.setBounds(panelWidth*2/5, panelHeight/60, panelWidth/5, panelHeight/30);
	}
	
	//�����ݿ����ȡ�շѲ�����Ϣ
	public void getFee(){
		FinanceBLService finance = ConstructFactory.FinanceFactory();
		FeeVO feeVO  = finance.readFee();
		carText.setText(String.valueOf(feeVO.getRoadFee()));
		trainText.setText(String.valueOf(feeVO.getRailFee()));
		planeText.setText(String.valueOf(feeVO.getAirFee()));
	}
	
	public void getTableData(){
		FinanceBLService finance = ConstructFactory.FinanceFactory();
		DistanceVO distanceVO = finance.getDistance();
		String[] cityName = distanceVO.getCity();
		double[][] distance = distanceVO.getDistance();
		tableTitle = new String[cityName.length+1];
		tableData = new String[cityName.length][cityName.length+1];
		tableTitle[0] = "���о���";
		for(int i = 1; i<cityName.length+1; i++) {
			tableTitle[i] = cityName[i-1];
		}
		for(int i = 0; i < distance.length; i++){
			tableData[i][0] = tableTitle[i+1];//��ȡ��һ�еĳ�����
			for(int j = 1; j<distance[i].length+1; j++){
				tableData[i][j] = String.valueOf(distance[i][j-1]);
			}
		}
	}
	public void initText(){
		carLabel = new JLabel("����:");
		trainLabel = new JLabel("��:");
		planeLabel = new JLabel("�ɻ�:");
		label1 = new JLabel("Ԫ/��ǧ��*���");
		label2 = new JLabel("Ԫ/��ǧ��*���");
		label3 = new JLabel("Ԫ/��ǧ��*���");
		carText = new JTextField();
		trainText = new JTextField();
		planeText = new JTextField();	
		
		panel.add(carLabel);
		panel.add(trainLabel);
		panel.add(planeLabel);
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		panel.add(carText);
		panel.add(trainText);
		panel.add(planeText);
		
		carLabel.setBounds(panelWidth/5, panelHeight/10, panelWidth/20, panelHeight/20);
		trainLabel.setBounds(panelWidth/5, panelHeight/10+carLabel.getY(),  panelWidth/20, panelHeight/20);
		planeLabel.setBounds(panelWidth/5, panelHeight/10+trainLabel.getY(),  panelWidth/20, panelHeight/20);
		carText.setBounds(panelWidth*3/10, carLabel.getY(), panelWidth/5, panelHeight/20);
		trainText.setBounds(panelWidth*3/10, panelHeight/10+carLabel.getY(), panelWidth/5, panelHeight/20);
		planeText.setBounds(panelWidth*3/10, panelHeight/10+trainLabel.getY(), panelWidth/5, panelHeight/20);
		label1.setBounds(panelWidth*11/20, carLabel.getY(), panelWidth*7/20, panelHeight/20);
		label2.setBounds(panelWidth*11/20, panelHeight/10+carLabel.getY(), panelWidth*7/20, panelHeight/20);
		label3.setBounds(panelWidth*11/20, panelHeight/10+trainLabel.getY(), panelWidth*7/20, panelHeight/20);
		
	}
	public void initTable(){
		getTableData();
		table = new JTable(tableData,tableTitle);
		scrollPane = new JScrollPane(table);
		cityDistance = new JLabel("���о���:");
		saveButton = new JButton("����");
		
		panel.add(scrollPane);
		panel.add(saveButton);
		panel.add(cityDistance);
		
		table .getTableHeader().setReorderingAllowed(false);//��ͷ�����ƶ�
		table.setRowHeight(panelWidth/20);//�����п�
		table.setDragEnabled(false);//���ò����϶�
		table.getTableHeader().setPreferredSize(new Dimension(10000, panelWidth/20));//���ñ�ͷ�߶�
		table.getTableHeader().setResizingAllowed(false);//�����п��ɱ�
		
		cityDistance.setBounds(panelWidth/10, panelHeight*23/60, panelWidth/4, panelHeight/20);
		scrollPane.setBounds(panelWidth/10, panelHeight*9/20, panelWidth*4/5, panelHeight*31/100);
		saveButton.setBounds(panelWidth*4/5, panelHeight*17/20, panelWidth/10, panelHeight/20);
		
		saveButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				FinanceBLService finance = ConstructFactory.FinanceFactory();
				FeeVO feeVO = new FeeVO(Double.valueOf(carText.getText()), 
						Double.valueOf(trainText.getText()), 
						Double.valueOf(planeText.getText()));
				String[] city = new String[tableTitle.length-1];
				double[][] cityDistance = new double[tableTitle.length-1][tableTitle.length-1];
				for(int i = 0;i<tableTitle.length-1;i++){
					city[i] = tableTitle[i+1];
					for(int j = 1;j<tableTitle.length;j++){
						cityDistance[i][j-1] = Double.valueOf((String) table.getModel().getValueAt(i, j));
					}
				}
				DistanceVO distanceVO = new DistanceVO(city, cityDistance);
				if(finance.modifyFee(feeVO)&&finance.modifyDistance(distanceVO)){//�˻���������
					
				}else{//ʧ��ʱ�Ĵ���
					
				}
			}
		});
	}
}