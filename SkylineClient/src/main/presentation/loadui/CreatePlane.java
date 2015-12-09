package main.presentation.loadui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import main.businesslogicservice.LoadBLService;
import main.businesslogicservice.receiptblService.IntermediateReceipt;
import main.businesslogicservice.receiptblService.ReceiptCode;
import main.constructfactory.ConstructFactory;
import main.presentation.mainui.WritePanel;
import main.presentation.mainui.memory.IntermediateMemory;
import main.vo.PlaneLoadingVO;

public class CreatePlane extends CreatePanel {

	public CreatePlane(JTabbedPane tabbedPane, JPanel panel) {
		super(tabbedPane, panel);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	protected void initLabel(){
		LoadCode.setText("�ɻ�װ�˱��");
		Code.setText("�����");
		Start.setText("������");
		Arrive.setText("�����");
		Montior.setText("��װԱ");
		Container.setText("Ѻ��Ա");
		LoadArea.setText("��������");
		Fee.setText("����");
	}
	
	protected void initListener(){
		SaveButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				WritePanel wp=panel;
				IntermediateMemory memory=(IntermediateMemory) wp.getMemory();
				String code=memory.getAirLoadCode();
				ReceiptCode codeService=ConstructFactory.calculateCode();
				code=codeService.calculCode(code, memory.getUserName());
				Date dt=new Date();
				SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
				String time=format.format(dt);
				PlaneLoadingVO vo=new PlaneLoadingVO(code,time,LoadCodeText.getText(),
						CodeText.getText(),StartText.getText(),ArriveText.getText(),
						MontiorText.getText(),ContainerText.getText(),wp.getBelong()+" "+LoadAreaText.getText(),
						Double.parseDouble(FeeText.getText()));
				vo.setBelong(wp.getBelong());
				IntermediateReceipt intermRservice=ConstructFactory.IntermediateFactory();
				intermRservice.saveAirLoadCode(memory.getUserName(), code);
				memory.setAirLoadCode(memory.getAirLoadCode()+" "+code);
				memory.setAirLoadDate(memory.getAirLoadDate()+" "+code);
				LoadBLService service=ConstructFactory.LoadFactory();
				service.loadPlane(vo);
			}
		});
		
		backButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				p.setVisible(false);
				tabbedPane.setVisible(true);
			}
		});
		
		CancleButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				LoadCodeText.setText(null);
				CodeText.setText(null);
				StartText.setText(null);
				ArriveText.setText(null);
				MontiorText.setText(null);
				ContainerText.setText(null);
			    LoadAreaText.setText(null);
			}
		});
	}
}
