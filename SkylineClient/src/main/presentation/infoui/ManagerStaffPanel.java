package main.presentation.infoui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import main.presentation.mainui.MainController;

//��Ա����
public class ManagerStaffPanel {
	
	private JPanel panel;
	private int tabWidth;
	private int tabHeight;
	private JTabbedPane tab;
	private JPanel addPanel;
	private JPanel inquirePanel;
	private JLabel title;
	
	//����Ա�������
	private JLabel position;//ְλ
	private JLabel staffCode;//���
	private JLabel company;//��λ
	private JLabel name;//Ա������
	private JLabel startWorkTime;//��ְʱ��
	private JTextField positionText;//ְλ
	private JTextField staffCodeText;//���
	private JTextField companyText;//��λ
	private JTextField nameText;//Ա������
	private JTextField startWorkTimeText;//��ְʱ��
	private JButton saveButton;
	private JButton cancleButton;
	
	//��ѯԱ�����
	private JLabel dataLabel;
	private JLabel inquirePosition;//ְλ
	private JLabel inquireStaffCode;//���
	private JLabel inquireCompany;//��λ
	private JLabel inquireName;//Ա������
	private JLabel inquireStartWorkTime;//��ְʱ��
	private JTextField inquirePositionText;//ְλ
	private JTextField inquireStaffCodeText;//���
	private JTextField inquireCompanyText;//��λ
	private JTextField inquireNameText;//Ա������
	private JTextField inquireStartWorkTimeText;//��ְʱ��
	private JButton inquireSaveButton;
	private JButton inquireCancleButton;
	private JButton backButton;
	
	private JLabel label;
	private JLabel inquire;
	private JTextField inquireText;
	private JButton inquireButton;
	
	public ManagerStaffPanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
	}
	public void init(){
		initTitle();
		tab = new JTabbedPane(JTabbedPane.TOP);
		panel.add(tab);
		tab.setBounds(panel.getWidth()/10, panel.getHeight()/15, panel.getWidth()*4/5, panel.getHeight()*13/15);
		tabWidth = tab.getWidth();
		tabHeight = tab.getHeight();
		addPanel = new JPanel();
		inquirePanel = new JPanel();
		addPanel.setLayout(null);
		inquirePanel.setLayout(null);
		tab.addTab("����Ա��", addPanel);
		tab.addTab("��ѯԱ��", inquirePanel);
		initAddPanel();
		initInquirePanel();
		panel.repaint();
	}
	
	public void initTitle(){
		title = new JLabel("��Ա����");
		panel.add(title);
		title.setBounds(panel.getWidth()*2/5, panel.getHeight()/60, panel.getWidth()/5, panel.getHeight()/30);
	}
	public void initAddPanel(){
		position = new JLabel("ְλ");//ְλ
		staffCode = new JLabel("���");//���
		company = new JLabel("��λ");//��λ
		name = new JLabel("Ա������");//Ա������
		startWorkTime = new JLabel("��ְʱ��");//��ְʱ��
		positionText = new JTextField();//ְλ
		staffCodeText = new JTextField();//���
		companyText = new JTextField();//��λ
		nameText = new JTextField();//Ա������
		startWorkTimeText = new JTextField();//��ְʱ��
		saveButton = new JButton("����");
		cancleButton = new JButton("ȡ��");
		
		addPanel.add(position);//ְλ
		addPanel.add(staffCode);//���
		addPanel.add(company);//��λ
		addPanel.add(name);//Ա������
		addPanel.add(startWorkTime);//��ְʱ��
		addPanel.add(positionText);//ְλ
		addPanel.add(staffCodeText);//���
		addPanel.add(companyText);//��λ
		addPanel.add(nameText);//Ա������
		addPanel.add(startWorkTimeText);//��ְʱ��
		addPanel.add(saveButton);
		addPanel.add(cancleButton);
		
		final int INTER = tabHeight*3/35;
		
		position.setBounds(tabWidth/10, INTER, tabWidth/10, tabHeight/15);//ְλ
		staffCode.setBounds(position.getX(), INTER+position.getY()+position.getHeight(), tabWidth/10, tabHeight/15);//���
		company.setBounds(position.getX(), INTER+staffCode.getY()+staffCode.getHeight(), tabWidth/10, tabHeight/15);//��λ
		name.setBounds(position.getX(), INTER+company.getY()+company.getHeight(), tabWidth/10, tabHeight/15);//Ա������
		startWorkTime.setBounds(position.getX(),INTER+name.getY()+name.getHeight(), tabWidth/10, tabHeight/15);//��ְʱ��
		positionText.setBounds(tabWidth/4, INTER, tabWidth*11/20, tabHeight/15);//ְλ
		staffCodeText.setBounds(tabWidth/4, INTER+position.getY()+position.getHeight(), tabWidth*11/20, tabHeight/15);//���
		companyText.setBounds(tabWidth/4, INTER+staffCode.getY()+staffCode.getHeight(), tabWidth*11/20, tabHeight/15);//��λ
		nameText.setBounds(tabWidth/4, INTER+company.getY()+company.getHeight(), tabWidth*11/20, tabHeight/15);//Ա������
		startWorkTimeText.setBounds(tabWidth/4, INTER+name.getY()+name.getHeight(), tabWidth*11/20, tabHeight/15);//��ְʱ��
		cancleButton.setBounds(tabWidth*19/40, INTER+startWorkTimeText.getY()+startWorkTimeText.getHeight(), tabWidth/8, tabHeight/15);
		saveButton.setBounds(tabWidth*27/40, INTER+startWorkTimeText.getY()+startWorkTimeText.getHeight(), tabWidth/8, tabHeight/15);
	}
	public void initInquirePanel(){
		
		label  = new JLabel();
		dataLabel = new JLabel();
		inquirePosition = new JLabel("ְλ");//ְλ
		inquireStaffCode = new JLabel("���");//���
		inquireCompany = new JLabel("��λ");//��λ
		inquireName = new JLabel("Ա������");//Ա������
		inquireStartWorkTime = new JLabel("��ְʱ��");//��ְʱ��
		inquirePositionText = new JTextField();//ְλ
		inquireStaffCodeText = new JTextField();//���
		inquireCompanyText = new JTextField();//��λ
		inquireNameText = new JTextField();//Ա������
		inquireStartWorkTimeText = new JTextField();//��ְʱ��
		inquireSaveButton = new JButton("����");
		inquireCancleButton = new JButton("ȡ��");
		backButton = new JButton("����");
		backButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				label.setVisible(true);
				dataLabel.setVisible(false);
			}
		});
		
		inquire = new JLabel("��ѯ");
		inquireText = new JTextField();
		inquireButton = new JButton("��ѯ");
		inquireButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				dataLabel.setVisible(true);
				label.setVisible(false);
			}
		});
		
		inquirePanel.add(label);
		inquirePanel.add(dataLabel);
		label.setBounds(0, 0, tabWidth, tabHeight);
		dataLabel.setBounds(0, 0, tabWidth, tabHeight);
		label.setVisible(true);
		dataLabel.setVisible(false);
		
		dataLabel.add(inquirePosition);//ְλ
		dataLabel.add(inquireStaffCode);//���
		dataLabel.add(inquireCompany);//��λ
		dataLabel.add(inquireName);//Ա������
		dataLabel.add(inquireStartWorkTime);//��ְʱ��
		dataLabel.add(inquirePositionText);//ְλ
		dataLabel.add(inquireStaffCodeText);//���
		dataLabel.add(inquireCompanyText);//��λ
		dataLabel.add(inquireNameText);//Ա������
		dataLabel.add(inquireStartWorkTimeText);//��ְʱ��
		dataLabel.add(inquireSaveButton);
		dataLabel.add(inquireCancleButton);
		dataLabel.add(backButton);
		
		label.add(inquire);
		label.add(inquireText);
		label.add(inquireButton);
		
		final int INTER = tabHeight*3/35;
		
		inquirePosition.setBounds(tabWidth/10, INTER, tabWidth/10, tabHeight/15);//ְλ
		inquireStaffCode.setBounds(position.getX(), INTER+inquirePosition.getY()+inquirePosition.getHeight(), tabWidth/10, tabHeight/15);//���
		inquireCompany.setBounds(inquirePosition.getX(), INTER+inquireStaffCode.getY()+inquireStaffCode.getHeight(), tabWidth/10, tabHeight/15);//��λ
		inquireName.setBounds(inquirePosition.getX(), INTER+inquireCompany.getY()+inquireCompany.getHeight(), tabWidth/10, tabHeight/15);//Ա������
		inquireStartWorkTime.setBounds(inquirePosition.getX(),INTER+inquireName.getY()+inquireName.getHeight(), tabWidth/10, tabHeight/15);//��ְʱ��
		inquirePositionText.setBounds(tabWidth/4, INTER, tabWidth*11/20, tabHeight/15);//ְλ
		inquireStaffCodeText.setBounds(tabWidth/4, INTER+inquirePosition.getY()+inquirePosition.getHeight(), tabWidth*11/20, tabHeight/15);//���
		inquireCompanyText.setBounds(tabWidth/4, INTER+inquireStaffCode.getY()+inquireStaffCode.getHeight(), tabWidth*11/20, tabHeight/15);//��λ
		inquireNameText.setBounds(tabWidth/4, INTER+inquireCompany.getY()+inquireCompany.getHeight(), tabWidth*11/20, tabHeight/15);//Ա������
		inquireStartWorkTimeText.setBounds(tabWidth/4, INTER+inquireName.getY()+inquireName.getHeight(), tabWidth*11/20, tabHeight/15);//��ְʱ��
		inquireCancleButton.setBounds(tabWidth*19/40, INTER+inquireStartWorkTimeText.getY()+inquireStartWorkTimeText.getHeight(), tabWidth/8, tabHeight/15);
		inquireSaveButton.setBounds(tabWidth*27/40, INTER+inquireStartWorkTimeText.getY()+inquireStartWorkTimeText.getHeight(), tabWidth/8, tabHeight/15);
		backButton.setBounds(2*inquireCancleButton.getX()-inquireSaveButton.getX(), inquireSaveButton.getY(), tabWidth/8, tabHeight/15);
		
		inquire.setBounds(tabWidth/10-tabWidth/40,tabHeight*2/5,tabWidth/10, tabHeight/15);
		inquireText.setBounds(tabWidth*3/20, tabHeight*2/5, tabWidth*3/5, tabHeight/15);
		inquireButton.setBounds(tabWidth*4/5, tabHeight*2/5, tabWidth/8, tabHeight/15);
	}
}
