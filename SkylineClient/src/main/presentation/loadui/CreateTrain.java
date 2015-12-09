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
import main.presentation.mainui.memory.IntermediateMemory;
import main.vo.TrainLoadingVO;

public class CreateTrain extends CreatePanel {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CreateTrain(JTabbedPane tabbedPane, JPanel panel) {
		super(tabbedPane, panel);
		// TODO Auto-generated constructor stub
	}

	protected void initLabel(){
		LoadCode.setText("货车装运编号");
		Code.setText("火车车次号");
		Start.setText("出发地");
		Arrive.setText("到达地");
		Montior.setText("监装员");
		Container.setText("押运员");
		LoadArea.setText("托运区号");
		Fee.setText("费用");
	}
	
	protected void initListener(){
		SaveButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				IntermediateMemory memory=(IntermediateMemory)panel.getMemory();
				String code=memory.getRailLoadCode();
				ReceiptCode codeService=ConstructFactory.calculateCode();
				code=codeService.calculCode(code, memory.getUserName());
				Date dt=new Date();
				SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
				String time=format.format(dt);
				TrainLoadingVO vo=new TrainLoadingVO(code,time,LoadCodeText.getText(),
						CodeText.getText(),StartText.getText(),ArriveText.getText(),
						MontiorText.getText(),Container.getText(),panel.getBelong()+" "+LoadAreaText.getText(),
						Double.parseDouble(FeeText.getText()));
				vo.setBelong(panel.getBelong());
				IntermediateReceipt intermRservice=ConstructFactory.IntermediateFactory();
				intermRservice.saveRailLoadCode(memory.getUserName(), code);
				memory.setRailLoadCode(memory.getRailLoadCode()+" "+code);
				memory.setRailLoadDate(memory.getRailLoadDate()+" "+code);
				LoadBLService service=ConstructFactory.LoadFactory();
				service.loadTrain(vo);
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
