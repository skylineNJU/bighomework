package main.businesslogic.distributebl;

import main.data.distribute.DistributeDataController;
import main.dataservice.DistributeDataService;
import main.dataservice.FinanceDataService;
import main.po.ReceivePO;
import main.vo.RecipientVO;


//收件信息
public class ReceiveMessage {

	//写到数据库里面
	public boolean writeReceviceMessage(RecipientVO recipentVO){
		DistributeDataService distribute = new DistributeDataController();
		ReceivePO receivePO = new ReceivePO(recipentVO.getCode(), recipentVO.getName(), 
				recipentVO.getSendeePhone(), recipentVO.getCourierCode(), recipentVO.getDate());
		receivePO.setCode(recipentVO.getCode());
		return distribute.inputOrder(receivePO);
	}
}
