package main.businesslogic.loadbl;

import java.util.ArrayList;
import main.data.receive.ReceiveDataController;
import main.dataservice.ReceiveDataService;
import main.po.CenterReceiveListPO;
import main.po.CenterReceivePO;
import main.vo.TransitReceptionVO;


public class TransitReceiveListBL {
private CenterReceiveListPO po;
private String codeList;

public TransitReceiveListBL(String codeList){
	this.codeList=codeList;
}

public ArrayList<TransitReceptionVO> inquire(){
	System.out.println("inquire plane");
	ArrayList<TransitReceptionVO> voList=new ArrayList<TransitReceptionVO>();
	po=new CenterReceiveListPO(codeList);
	ReceiveDataService service=new ReceiveDataController();
	po=service.readCenterOrder(po);
	ArrayList<CenterReceivePO> poList=po.getList();
	
	for(CenterReceivePO p:poList){
		TransitReceptionVO vo=new TransitReceptionVO(
				p.getReceiveYear(),
				p.getReceiveMonth(),
				p.getReceiveDay(),
				p.getCenterNumber(),
				p.getBar(),
				p.getCode()
			);
		voList.add(vo);
	}
	return voList;
}
}
