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
import main.vo.VehicleLoadingVO;

public class CreateCar extends CreatePanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CreateCar(JTabbedPane tabbedPane, JPanel panel) {
		super(tabbedPane, panel);
		// TODO Auto-generated constructor stub
	}

	protected void initLabel(){
		LoadCode.setText("汽车装运编号");
		Code.setText("汽车车牌号");
		Start.setText("出发地");
		Arrive.setText("到达地");
		Montior.setText("监装员");
		Container.setText("押运员");
		LoadArea.setText("托运区号");
		Fee.setText("费用");
	}
	
	protected void initListener(){
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
		
		SaveButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				WritePanel wp=(WritePanel)panel;
				IntermediateMemory memory=(IntermediateMemory) wp.getMemory();
				String code=memory.getRoadLoadCode();
				ReceiptCode codeService=ConstructFactory.calculateCode();
				code=codeService.calculCode(code, memory.getUserName());
				Date dt=new Date();
				SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
				String time=format.format(dt);
				VehicleLoadingVO vo=new VehicleLoadingVO(code,time,LoadCodeText.getText(),CodeText.getText(),
						StartText.getText(),ArriveText.getText(),MontiorText.getText(),Container.getText(),
						wp.getBelong()+" "+LoadAreaText.getText(),Double.parseDouble(FeeText.getText()));
				vo.setBelong(wp.getBelong());
				IntermediateReceipt intermRservice=ConstructFactory.IntermediateFactory();
				intermRservice.saveRoadLoadCode(memory.getRoadLoadCode(), code);
				memory.setRoadLoadCode(memory.getRoadLoadCode()+" "+code);
				memory.setRoadLoadDate(memory.getAirLoadDate()+" "+time);
				LoadBLService service=ConstructFactory.LoadFactory();
				service.loadCar(vo);
			}
		});
	}
}
