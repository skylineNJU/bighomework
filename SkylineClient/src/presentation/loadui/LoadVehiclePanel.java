package presentation.loadui;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.mainui.MainController;

public class LoadVehiclePanel {
	private JPanel panel;
	private JComboBox transmitCenterNumber;//中转中心编号下拉框
	private JLabel  transmitCenterNumberLabel;
    private JLabel  receiptNumberLabel;
    private JTextField receiptNumber;//订单单号输入框
    private JLabel receiveDateLabel;
    private JTextField receiveDate;//接收时间输入框
	
	public LoadVehiclePanel(){
		panel=MainController.getWritepanel();
		panel.setLayout(null);
	}
	
	public void init(){
		transmitCenterNumber=new JComboBox();
		
	}
	
}
