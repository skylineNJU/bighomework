package main.presentation.distributeui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.businesslogicservice.DistributeBLService;
import main.businesslogicservice.receiptblService.CourrierReceipt;
import main.businesslogicservice.receiptblService.ReceiptCode;
import main.constructfactory.ConstructFactory;
import main.presentation.mainui.MainController;
import main.presentation.mainui.WritePanel;
import main.presentation.mainui.memory.CourrierMemory;
import main.vo.RecipientVO;

public class ReceiveMessagePanel {
	
	private JPanel panel;
	private int panelWidth;
	private int panelHeight;
	private JLabel title;
	private JLabel codeLabel;
	private JLabel nameLabel;
	private JLabel phoneLabel;
	private JTextField receiveCode;
	private JTextField receiverName;
	private JTextField phone;
	private JButton cancleButton;//ȡ��
	private JButton saveButton;//����
	
	public ReceiveMessagePanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth = panel.getWidth();
		panelHeight = panel.getHeight();
	}
	
	public void init(){
		title();
		allTextFiled();
		panel.repaint();
	}
	
	public void title(){
		title = new JLabel("�ռ���Ϣ����");
		title.setBounds(panelWidth/3, 10, panelWidth/6, 40);
		panel.add(title);
	}
	
	public void allTextFiled(){
		codeLabel = new JLabel("������");
		nameLabel = new JLabel("�ռ�������");
		phoneLabel = new JLabel("��ϵ��ʽ");
		receiveCode = new JTextField();
		receiverName = new JTextField();
		phone = new JTextField();
		codeLabel.setBounds(panelWidth/8, panelHeight/4, panelWidth/10, panelHeight/20);
		nameLabel.setBounds(panelWidth/8, codeLabel.getY()+panelHeight/6, panelWidth/10, panelHeight/20);
		phoneLabel.setBounds(panelWidth/8, nameLabel.getY()+panelHeight/6, panelWidth/10, panelHeight/20);
		receiveCode.setBounds(codeLabel.getX()+panelWidth/8, panelHeight/4, panelWidth/2, panelHeight/20);
		receiverName.setBounds(nameLabel.getX()+panelWidth/8, codeLabel.getY()+panelHeight/6, panelWidth/2, panelHeight/20);
		phone.setBounds(phoneLabel.getX()+panelWidth/8, nameLabel.getY()+panelHeight/6, panelWidth/2, panelHeight/20);
		
		cancleButton = new JButton("���");
		saveButton = new JButton("����");
		cancleButton.setBounds(panelWidth*3/8, phone.getY()+panelHeight/6, panelWidth/8, panelHeight/20);
		saveButton.setBounds(panelWidth*5/8,phone.getY()+panelHeight/6, panelWidth/8, panelHeight/20);
		
		panel.add(codeLabel);
		panel.add(nameLabel);
		panel.add(phoneLabel);
		panel.add(receiveCode);
		panel.add(receiverName);
		panel.add(phone);
		panel.add(cancleButton);
		panel.add(saveButton);
		
		cancleButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				receiveCode.setText(null);
				receiverName.setText(null);
				phone.setText(null);
			}
		});
		
		saveButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				Calendar calendar = Calendar.getInstance();
				String date = calendar.get(Calendar.YEAR)+"/"+(calendar.get(Calendar.MONTH)+1)
						+"/"+calendar.get(Calendar.DAY_OF_MONTH);
				String code=null;
				ReceiptCode service0=ConstructFactory.calculateCode();
				CourrierMemory memory=(CourrierMemory) ((WritePanel)panel).getMemory();
				code=service0.calculCode(memory.getReceiveCode(),memory.getUserName());
				RecipientVO recipientVO = new RecipientVO(receiverName.getText(), 
						phone.getText(),code, 
						date,receiveCode.getText());
				DistributeBLService distribute = ConstructFactory.DistributeFactory();
				if(distribute.writeReceiveMessage(recipientVO)){//����ɹ�
					CourrierReceipt service=ConstructFactory.CourrierReceiptFactory();
					service.saveReceiveCode(code,memory.getUserName());
					memory.setReceiveCode(memory.getReceiveCode()+" "+code);
					memory.setReceiveDate(memory.getReceiveDate()+" "+date);
				}else{
					System.out.println("����ʧ��");
				}
			}
		});
	}
}
