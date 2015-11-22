package main.presentation.receiveui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import main.presentation.mainui.MainController;

//Ӫҵ�����յ�
public class LobbyReceivePanel {
	
	private JPanel panel;
	private int panelWidth;
	private int panelHeight;
	private JLabel title;
	private JTabbedPane tabbedPane;
	private String[] tableTitle;
	private String[][] tableData;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton cancleButton;
	private JButton saveButton;
	private JPanel lookPanel;//�鿴���յ�
	private JPanel writePanel;//��д���յ�
	private JLabel arriveLabel;//��������
	private JLabel orderCode;//������
	private JLabel trainsCode;//��ת�����
	private JLabel startPlace;//������
	private JLabel endPlace;//�����
	private JTextField arriveText;//���������ı���
	private JTextField orderCodeText;//�������ı���
	private JTextField trainsCodeText;//��ת�����ı���
	private JTextField startText;//�������ı���
	private JTextField endText;//������ı���
	private JButton writeCancleButton;//ȡ����ť
	private JButton writeSaveButton;//���水ť
	
	public LobbyReceivePanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth = panel.getWidth();
		panelHeight = panel.getHeight();
	}

	public void init(){
		lookPanel = new JPanel();
		lookPanel.setLayout(null);
		writePanel = new JPanel();
		writePanel.setLayout(null);
		lookTable();
		writeTable();
		initButton();
		tabbedPane=new JTabbedPane(JTabbedPane.TOP);
		panel.add(tabbedPane);
		tabbedPane.setBounds(panelWidth/10, panelHeight/10, panelWidth*4/5, panelHeight*4/5);
		tabbedPane.add("�鿴���յ�",lookPanel);
		tabbedPane.add("��д���յ�",writePanel);
		tabbedPane.setVisible(true);
		title();
		panel.repaint();
	}
	
	public void initButton(){
		cancleButton = new JButton("ȡ��");
		saveButton = new JButton("����");
		lookPanel.add(cancleButton);
		lookPanel.add(saveButton);
		cancleButton.setBounds(panelWidth/2+panelWidth/50, panelHeight*27/40, panelWidth/10, panelHeight/20);
		saveButton.setBounds(panelWidth*13/20+panelWidth/50, panelHeight*27/40, panelWidth/10, panelHeight/20);
		writeCancleButton = new JButton("ȡ��");//ȡ����ť
		writeSaveButton = new JButton("����");//���水ť
		writePanel.add(writeCancleButton);
		writePanel.add(writeSaveButton);
		writeCancleButton.setBounds(panelWidth*2/5, panelHeight*5/8, panelWidth/10, panelHeight/20);
		writeSaveButton.setBounds(panelWidth*6/10,  panelHeight*5/8, panelWidth/10, panelHeight/20);
	}
	//����
	public void title(){
		title = new JLabel("���յ�����");	
		panel.add(title);
		title.setBounds(panelWidth/3, panelHeight/40, panelWidth/6, panelHeight/20);
	}
	//�����б�
	public void lookTable(){		
		tableTitle = new String[]{"ID","ʱ��","���յ���","����","״̬"};
		tableData = new String[][]{{"20152","2015/03/15","209090","��ͨ","��"},{"20152","2015/03/15","209090","��ͨ","��"},
				{"20152","2015/03/15","209090","��ͨ","��"},{"20152","2015/03/15","209090","��ͨ","��"},
				{"20152","2015/03/15","209090","��ͨ","��"},{"20152","2015/03/15","209090","��ͨ","��"},
				{"20152","2015/03/15","209090","��ͨ","��"},{"20152","2015/03/15","209090","��ͨ","��"},
				{"20152","2015/03/15","209090","��ͨ","��"},{"20152","2015/03/15","209090","��ͨ","��"},
				{"20152","2015/03/15","209090","��ͨ","��"},{"20152","2015/03/15","209090","��ͨ","��"},
				{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""},
		};
		table = new JTable(tableData,tableTitle);
		table.setRowHeight(panelWidth/20);//�����п�
		table.getTableHeader().setPreferredSize(new Dimension(1, panelWidth/20));//���ñ�ͷ�߶�
		table .getTableHeader().setReorderingAllowed(false);//��ͷ�����ƶ�
		table.setDragEnabled(false);
		table.getTableHeader().setResizingAllowed(false);//�����п��ɱ�
		table.setVisible(true);
		scrollPane = new JScrollPane(table);
		lookPanel.add("�鿴���յ�",scrollPane);
		if(tableData.length>9){
			scrollPane.setBounds(panelWidth/50, panelHeight/50, panelWidth*19/25, 10*table.getRowHeight());
		}else{
			scrollPane.setBounds(panelWidth/50, panelHeight/50, panelWidth*19/25, (table.getRowCount()+1)*table.getRowHeight());
		}
		scrollPane.setVisible(true);
	}
	//
	public void writeTable(){
		arriveLabel = new JLabel("��������");//��������
		orderCode = new JLabel("������");//������
		trainsCode = new JLabel("��ת�����");//��ת�����
		startPlace = new JLabel("������");//������
		endPlace = new JLabel("�����");//�����
		arriveText = new JTextField();//���������ı���
		orderCodeText = new JTextField();//�������ı���
		trainsCodeText = new JTextField();//��ת�����ı���
		startText = new JTextField();//�������ı���
		endText = new JTextField();//������ı���
		
		writePanel.add(arriveLabel);
		writePanel.add(orderCode);
		writePanel.add(trainsCode);
		writePanel.add(startPlace);
		writePanel.add(endPlace);
		writePanel.add(arriveText);
		writePanel.add(orderCodeText);
		writePanel.add(trainsCodeText);
		writePanel.add(startText);
		writePanel.add(endText);
		
		arriveLabel.setBounds(panelWidth/10, panelHeight/10, panelWidth/8, panelHeight/20);
		orderCode.setBounds(panelWidth/10, panelHeight/10+arriveLabel.getY(), panelWidth/8, panelHeight/20);
		trainsCode.setBounds(panelWidth/10, panelHeight/10+orderCode.getY(), panelWidth/8, panelHeight/20);
		startPlace.setBounds(panelWidth/10, panelHeight/10+trainsCode.getY(), panelWidth/8, panelHeight/20);
		endPlace.setBounds(panelWidth/10, panelHeight/10+startPlace.getY(), panelWidth/8, panelHeight/20);
		arriveText.setBounds(panelWidth*3/10, panelHeight/10, panelWidth*4/10, panelHeight/20);
		orderCodeText.setBounds(panelWidth*3/10, panelHeight/10+arriveText.getY(), panelWidth*4/10, panelHeight/20);
		trainsCodeText.setBounds(panelWidth*3/10, panelHeight/10+orderCodeText.getY(), panelWidth*4/10, panelHeight/20);
		startText.setBounds(panelWidth*3/10, panelHeight/10+trainsCodeText.getY(), panelWidth*4/10, panelHeight/20);
		endText.setBounds(panelWidth*3/10, panelHeight/10+startText.getY(), panelWidth*4/10, panelHeight/20);
		
	}
		
}
