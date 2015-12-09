package main.presentation.receiveui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import main.businesslogicservice.ReceiveBLService;
import main.businesslogicservice.receiptblService.CourrierReceipt;
import main.businesslogicservice.receiptblService.ReceiptCode;
import main.constructfactory.ConstructFactory;
import main.po.OrderPO.PackageCost;
import main.po.OrderPO.Size;
import main.po.Type;
import main.presentation.mainui.MainController;
import main.presentation.mainui.WritePanel;
import main.presentation.mainui.memory.CourrierMemory;
import main.vo.OrderVO;

public class OrderInputPanel {
	private JPanel panel;
	private JLabel title;
	private int panelWidth;
	private int panelHeight;
	
	private JLabel name1;//1表示寄件人，2表示收件人
	private JLabel phone1;//
	private JLabel address1;
	private JLabel name2;//1表示寄件人，2表示收件人
	private JLabel phone2;//
	private JLabel address2;
	private JLabel kind;
	private JLabel packageKind;
	private JLabel size;
	private JLabel cargoNameLabel;
	private JButton cancleButton;
	private JButton saveButton;
	private JTextField nameText1;
	private JTextField phoneText1;
	private JTextField addressText1;
	private JTextField nameText2;
	private JTextField phoneText2;
	private JTextField addressText2;
	private ButtonGroup kindGroup;
	private JRadioButton kindRadio1;
	private JRadioButton kindRadio2;
	private JRadioButton kindRadio3;
	private ButtonGroup packageGroup;
	private JRadioButton packageRadio1;
	private JRadioButton packageRadio2;
	private JRadioButton packageRadio3;
	private JTextField widthSizeText;
	private JTextField heightSizeText;
	private JTextField highSizeText;
	private JTextField cargoNameText;
	private JLabel widthLabel;
	private JLabel heightLabel;
	private JLabel highLabel;
	private JLabel weight;
	private JTextField weightText;
	private JLabel senderCom;
	private JLabel receivorCom;
	private JTextField snederComText;
	private JTextField receivorComText;
	private JLabel num;
	private JTextField numText;
	

	public OrderInputPanel(){
		panel = MainController.getWritepanel();
		panel.setLayout(null);
		panelWidth = panel.getWidth();
		panelHeight = panel.getHeight();
	}

	public void init(){
		initTitle();
		initPanel();
		panel.repaint();
	}

	public void initTitle(){
		title = new JLabel("订单输入");
		panel.add(title);
		title.setBounds(panelWidth*2/5, panelHeight/60, panelWidth/5, panelHeight/30);
	}
	public void initPanel(){
		name1 = new JLabel("寄件人姓名");
		phone1 = new JLabel("寄件人手机号");//
		address1 = new JLabel("寄件人地址");
		name2 = new JLabel("收件人姓名");//1表示寄件人，2表示收件人
		phone2 = new JLabel("收件人手机号");//
		address2 = new JLabel("收件人地址");
		kind = new JLabel("快递种类");
		packageKind = new JLabel("包装种类");
		size = new JLabel("快递尺寸");
		cargoNameLabel = new JLabel("寄件名称");
		cancleButton = new JButton("取消");
		saveButton = new JButton("保存");
		senderCom=new JLabel("寄件人单位");
		receivorCom=new JLabel("收件人单位");
		num=new JLabel("寄件数量");
		
		snederComText=new JTextField();
		receivorComText=new JTextField();
		numText=new JTextField();
		nameText1 = new JTextField();
		phoneText1 = new JTextField();
		addressText1 = new JTextField();
		nameText2 = new JTextField();
		phoneText2 = new JTextField();
		addressText2 = new JTextField();
		kindGroup = new ButtonGroup();
		kindRadio1 = new JRadioButton("经济");
		kindRadio2 = new JRadioButton("普通");
		kindRadio3 = new JRadioButton("特快");
		packageGroup = new ButtonGroup();
		packageRadio1 = new JRadioButton("纸箱");
		packageRadio2 = new JRadioButton("木箱");
		packageRadio3 = new JRadioButton("包装袋");
		widthSizeText = new JTextField();
		heightSizeText = new JTextField();
		highSizeText = new JTextField();
		cargoNameText = new JTextField();
		widthLabel = new JLabel("长");
		heightLabel = new JLabel("宽");
		highLabel = new JLabel("高");
		weight = new JLabel("快递总重量");
		weightText = new JTextField();
		
		kindGroup.add(kindRadio1);
		kindGroup.add(kindRadio2);
		kindGroup.add(kindRadio3);
		packageGroup.add(packageRadio1);
		packageGroup.add(packageRadio2);
		packageGroup.add(packageRadio3);
		
		panel.add(name1);
		panel.add(phone1);
		panel.add(address1);
		panel.add(name2);
		panel.add(phone2);
		panel.add(address2);
		panel.add(kind);
		panel.add(packageKind);
		panel.add(size);
		panel.add(cargoNameLabel);
		panel.add(cancleButton);
		panel.add(saveButton);
		panel.add(nameText1);
		panel.add(phoneText1);
		panel.add(addressText1);
		panel.add(nameText2);
		panel.add(phoneText2);
		panel.add(addressText2);
		panel.add(kindRadio1);
		panel.add(kindRadio2);
		panel.add(kindRadio3);
		panel.add(packageRadio1);
		panel.add(packageRadio2);
		panel.add(packageRadio3);
		panel.add(widthSizeText);
		panel.add(heightSizeText);
		panel.add(highSizeText);
		panel.add(widthLabel);
		panel.add(heightLabel);
		panel.add(highLabel);
		panel.add(cargoNameText);
		panel.add(weight);
		panel.add(weightText);
		panel.add(senderCom);
		panel.add(snederComText);
		panel.add(receivorCom);
		panel.add(receivorComText);
		panel.add(num);
		panel.add(numText);
		final int INTER = panelHeight/20;
		name1.setBounds(panelWidth/20, panelHeight/10, panelWidth*3/20, panelHeight/20);
		phone1.setBounds(name1.getX(), name1.getY()+name1.getHeight()+INTER, name1.getWidth(), name1.getHeight());
		address1.setBounds(name1.getX(), phone1.getY()+phone1.getHeight()+INTER, name1.getWidth(), name1.getHeight());
		senderCom.setBounds(name1.getX(),address1.getY()+address1.getHeight()+INTER,name1.getWidth(), name1.getHeight());
		
		nameText1.setBounds(panelWidth/5, name1.getY(), panelHeight*3/10, name1.getHeight());
		phoneText1.setBounds(nameText1.getX(), phone1.getY(), nameText1.getWidth(), nameText1.getHeight());
		addressText1.setBounds(nameText1.getX(), address1.getY(), nameText1.getWidth(), nameText1.getHeight());
		snederComText.setBounds(nameText1.getX(),senderCom.getY(), nameText1.getWidth(), nameText1.getHeight());
		
		name2.setBounds(panelWidth/2, panelHeight/10, panelWidth*3/20, panelHeight/20);
		phone2.setBounds(name2.getX(), name2.getY()+name2.getHeight()+INTER, name2.getWidth(), name2.getHeight());
		address2.setBounds(name2.getX(), phone2.getY()+phone2.getHeight()+INTER, name2.getWidth(), name2.getHeight());
		receivorCom.setBounds(name2.getX(),address2.getY()+address2.getHeight()+INTER, name2.getWidth(), name2.getHeight());
		
		nameText2.setBounds(panelWidth*13/20, name2.getY(), panelHeight*3/10, name2.getHeight());
		phoneText2.setBounds(nameText2.getX(), phone2.getY(), nameText2.getWidth(), nameText2.getHeight());
		addressText2.setBounds(nameText2.getX(), address2.getY(), nameText2.getWidth(), nameText2.getHeight());
		receivorComText.setBounds(nameText2.getX(),receivorCom.getY(),nameText2.getWidth(), nameText2.getHeight());
		
		kind.setBounds(panelWidth/20, snederComText.getY()+snederComText.getHeight()+INTER, name1.getWidth(), name1.getHeight());
		kindRadio1.setBounds(panelWidth/4, kind.getY(), panelWidth/10, name1.getHeight());
		kindRadio2.setBounds(panelWidth*2/4, kind.getY(), panelWidth/10, name1.getHeight());
		kindRadio3.setBounds(panelWidth*3/4, kind.getY(), panelWidth/10, name1.getHeight());
		
		packageKind.setBounds(panelWidth/20, kind.getY()+kind.getHeight()+INTER, name1.getWidth(), name1.getHeight());
		packageRadio1.setBounds(panelWidth/4, packageKind.getY(), panelWidth/10, name1.getHeight());
		packageRadio2.setBounds(panelWidth*2/4, packageKind.getY(), panelWidth/10, name1.getHeight());
		packageRadio3.setBounds(panelWidth*3/4, packageKind.getY(), panelWidth/10, name1.getHeight());
		
		size.setBounds(panelWidth/20, packageKind.getY()+packageKind.getHeight()+INTER, name1.getWidth(), name1.getHeight());
		widthSizeText.setBounds(panelWidth/4, size.getY(), panelWidth/10, name1.getHeight());
		heightSizeText.setBounds(panelWidth*2/4, size.getY(), panelWidth/10, name1.getHeight());
		highSizeText.setBounds(panelWidth*3/4, size.getY(), panelWidth/10, name1.getHeight());
		widthLabel.setBounds(panelWidth/4+panelWidth/9, size.getY(), panelWidth/20, name1.getHeight());
		heightLabel.setBounds(panelWidth*2/4+panelWidth/9, size.getY(), panelWidth/20, name1.getHeight());
		highLabel.setBounds(panelWidth*3/4+panelWidth/9, size.getY(), panelWidth/20, name1.getHeight());
		
		cargoNameLabel.setBounds(panelWidth*13/20, size.getY()+size.getHeight()+INTER, panelWidth/10, name1.getHeight());
		cargoNameText.setBounds(panelWidth*3/4, size.getY()+size.getHeight()+INTER, panelWidth/10, name1.getHeight());
		weight.setBounds(size.getX(), size.getY()+size.getHeight()+INTER,panelWidth/10, name1.getHeight());
		weightText.setBounds(panelWidth/4, weight.getY(), panelWidth/10, name1.getHeight());
		num.setBounds(weightText.getX()+weight.getWidth()+INTER/3,weight.getY(),panelWidth/10, name1.getHeight());
		numText.setBounds(heightSizeText.getX(),weight.getY(),panelWidth/10, name1.getHeight());
		
		cancleButton.setBounds(panelWidth*11/20, cargoNameLabel.getY()+cargoNameLabel.getHeight()+INTER, panelWidth/10, name1.getHeight());
		saveButton.setBounds(panelWidth*3/4, cargoNameText.getY()+cargoNameText.getHeight()+INTER, panelWidth/10, name1.getHeight());
		
		
		saveButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				WritePanel wr=(WritePanel) panel;
				CourrierMemory memory=(CourrierMemory) wr.getMemory();
				String code=memory.getOrderCode();
				ReceiptCode service0=ConstructFactory.calculateCode();
				code=service0.calculCode(code,memory.getUserName());
				ReceiveBLService service1=ConstructFactory.ReceiveFactory();
				PackageCost packageCost;
				Size size;
				Type type;
				double volum;
				
				if(kindRadio1.isSelected()){
					type=Type.cheap;
				}else if(kindRadio2.isSelected()){
					type=Type.normal;
				}else if(kindRadio3.isSelected()){
					type=Type.fast;
				}else{
					return;
				}
				
				if(packageRadio1.isSelected()){
					packageCost=PackageCost.paperBox;
				}else if(packageRadio2.isSelected()){
					packageCost=PackageCost.woodBox;
				}else if(packageRadio3.isSelected()){
					packageCost=PackageCost.plasticPackage;
				}else{
					return;
				}
				
				double width=Double.parseDouble(widthSizeText.getText());
				double height=Double.parseDouble(heightSizeText.getText());
				double high=Double.parseDouble(heightSizeText.getText());
				
				volum=width*height*high;
				
				if(volum<5){
					size=Size.small;
				}else if(volum<10){
					size=Size.medium;
				}else{
					size=Size.large;
				}
				
				OrderVO vo=new OrderVO(
						code,
						nameText1.getText(),
						addressText1.getText(),
						snederComText.getText(),
						phoneText1.getText(),
						nameText2.getText(),
						addressText2.getText(),
						receivorComText.getText(),
						phoneText2.getText(),
						Integer.parseInt(numText.getText()),
						0,
						packageCost,
						type, size,
						cargoNameText.getText(),
						Double.parseDouble(weightText.getText()),
						volum);
				service1.createNewOrder(vo);
				CourrierReceipt service2=ConstructFactory.CourrierReceiptFactory();
				System.out.println("order save success");
				service2.saveOrderCode(code,memory.getUserName());
				memory.setOrderCode(memory.getOrderCode()+" "+code);
			}
		});
		
		
	}
	
}
