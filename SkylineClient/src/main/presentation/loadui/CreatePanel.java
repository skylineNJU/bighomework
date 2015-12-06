package main.presentation.loadui;

import javax.swing.*;

import main.presentation.mainui.WritePanel;

public class CreatePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JLabel LoadCode = new JLabel();//车运编号
	protected JLabel Code = new JLabel();//车次号
	protected JLabel Start = new JLabel();
	protected JLabel Arrive = new JLabel();//到达地
	protected JLabel Montior = new JLabel();//监装员
	protected JLabel Container = new JLabel();//押运员
	protected JLabel LoadArea = new JLabel();//托运区号
	protected JLabel Fee = new JLabel();//运费
	protected JTextField LoadCodeText = new JTextField();
	protected JTextField CodeText = new JTextField();
	protected JTextField StartText = new JTextField();
	protected JTextField ArriveText = new JTextField();
	protected JTextField MontiorText = new JTextField();
	protected JTextField ContainerText = new JTextField();
	protected JTextField LoadAreaText = new JTextField();
	protected JTextField FeeText = new JTextField();
	protected JButton backButton = new JButton("返回");
	protected JButton SaveButton = new JButton("保存");
	protected JButton CancleButton = new JButton("取消");
	protected JTabbedPane tabbedPane; 
	protected final int PANEL_WIDTH;
	protected final int PANEL_HIGHT;
	protected final int LABELWidth;
	protected final int LABELHEIGHT;
	protected WritePanel panel;
	protected final CreatePanel p=this;

	public CreatePanel(JTabbedPane tabbedPane,JPanel panel){
		this.tabbedPane=tabbedPane;
		this.PANEL_WIDTH=tabbedPane.getWidth();
		this.PANEL_HIGHT=tabbedPane.getHeight();
		this.setBounds(tabbedPane.getX(),tabbedPane.getY(),PANEL_WIDTH,PANEL_HIGHT);
		LABELWidth = this.PANEL_WIDTH/10;
		LABELHEIGHT = this.PANEL_HIGHT/15;
		System.out.println("----------------"+LABELWidth);
		this.panel=(WritePanel) panel;
		panel.add(this);
		this.setLayout(null);
		
		this.initLocation();
		this.initLabel();
		this.initListener();
	}
	
	protected void initLocation(){
		int high=this.PANEL_HIGHT*4/35;
		LoadCode.setBounds(PANEL_WIDTH/10, high, LABELWidth, LABELHEIGHT);
		Code.setBounds(PANEL_WIDTH/2, high, LABELWidth, LABELHEIGHT);
		Start.setBounds(LoadCode.getX(), high*2+LABELHEIGHT, LABELWidth, LABELHEIGHT);
		Arrive.setBounds(Code.getX(), high*2+LABELHEIGHT, LABELWidth, LABELHEIGHT);
		Montior.setBounds(LoadCode.getX(), high*3+LABELHEIGHT*2, LABELWidth, LABELHEIGHT);
		Container.setBounds(Code.getX(), high*3+LABELHEIGHT*2, LABELWidth, LABELHEIGHT);
		LoadArea.setBounds(LoadCode.getX(), high*4+LABELHEIGHT*3, LABELWidth, LABELHEIGHT);
		Fee.setBounds(Code.getX(), high*4+LABELHEIGHT*3, LABELWidth, LABELHEIGHT);
		LoadCodeText.setBounds(LoadCode.getX()+LABELWidth, high, PANEL_WIDTH/4, LABELHEIGHT);
		CodeText.setBounds(Code.getX() + LABELWidth, high, PANEL_WIDTH/4, LABELHEIGHT);
		StartText.setBounds(LoadCodeText.getX(), high*2+LABELHEIGHT, PANEL_WIDTH/4, LABELHEIGHT);
		ArriveText.setBounds(Code.getX() + LABELWidth, high*2+LABELHEIGHT, PANEL_WIDTH/4, LABELHEIGHT);
		MontiorText.setBounds(LoadCodeText.getX(),high*3+LABELHEIGHT*2, PANEL_WIDTH/4, LABELHEIGHT);
		ContainerText.setBounds(Code.getX() + LABELWidth, high*3+LABELHEIGHT*2, PANEL_WIDTH/4, LABELHEIGHT);
		LoadAreaText.setBounds(LoadCodeText.getX(), high*4+LABELHEIGHT*3, PANEL_WIDTH/4, LABELHEIGHT);
		FeeText.setBounds(Code.getX() + LABELWidth, high*4+LABELHEIGHT*3, PANEL_WIDTH/4, LABELHEIGHT);
		backButton.setBounds(PANEL_WIDTH*7/20, high*5+LABELHEIGHT*4, LABELWidth, LABELHEIGHT);
		SaveButton.setBounds(PANEL_WIDTH*15/20, high*5+LABELHEIGHT*4, LABELWidth, LABELHEIGHT);
		CancleButton.setBounds(PANEL_WIDTH*11/20, high*5+LABELHEIGHT*4, LABELWidth, LABELHEIGHT);
		
		this.add(LoadCode);
		this.add(Code);
		this.add(Start);
		this.add(Arrive);
		this.add(Montior);
		this.add(Container);
		this.add(LoadArea);
		this.add(Fee);
		this.add(LoadCodeText);
		this.add(CodeText);
		this.add(StartText);
		this.add(ArriveText);
		this.add(MontiorText);
		this.add(ContainerText);
		this.add(LoadAreaText);
		this.add(FeeText);
		this.add(backButton);
		this.add(SaveButton);
		this.add(CancleButton);
		
		this.setVisible(false);
	}
	
	
	protected void initLabel(){}
	
	protected void initListener(){};
}
