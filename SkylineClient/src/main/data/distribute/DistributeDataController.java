package main.data.distribute;

import java.util.ArrayList;
import java.util.List;

import main.dataservice.DistributeDataService;
import main.po.DistributePO;
import main.po.DistributePOList;
import main.po.Message;
import main.po.OrderPO;
import main.po.ReceivePO;
import main.presentation.mainui.MainController;
import main.socketservice.Client;

public class DistributeDataController implements DistributeDataService{
	
	Client client;

	@Override
	public boolean saveTask(List<OrderPO> orderpo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DistributePOList lookTask(String code) {
		client=MainController.getClient();
		DistributePOList distributeList = new DistributePOList();
		distributeList.setKey("Inquire");
		distributeList.getList().add(new DistributePO(code, code, code, code, code, code));
		client.writeReceipt(distributeList);
		return (DistributePOList)client.getResponse();
	}

	@Override
	public boolean inputOrder(ReceivePO receivePO) {
		client=MainController.getClient();
		receivePO.setKey("Check");
		client.writeReceipt(receivePO);
		Message message=client.getResponse();
		if(message.getKey().equals("success")){
			return true;
		}
		return false;
	}

	@Override
	public boolean writeDistribute(ArrayList<DistributePO> poList) {
		DistributePOList distributePOList = new DistributePOList();
		for(DistributePO distributePO:poList){
			distributePOList.add(distributePO);
		}
		client=MainController.getClient();
		distributePOList.setKey("Save");
		client.writeReceipt(distributePOList);
		return true;
	}
}
