package test.data_driver;

import java.util.ArrayList;
import java.util.List;

import main.dataservice.DistributeDataService;
import main.po.OrderPO;
import main.po.OrderPO.PackageCost;
import main.po.OrderPO.Size;
import main.po.ReceivePO;
import main.po.Type;

public class DistributeDataService_Driver {
	OrderPO order=new OrderPO("null","null","null","null","null","null","null","null",PackageCost.paperBox,
			Type.fast,1,1,1,"null",Size.small,"null",1);
	String code = "1341324";
	List<OrderPO> orderpo;
	ReceivePO receive=new ReceivePO("null","null","null");
	public void drive(DistributeDataService service){
		orderpo=new ArrayList<OrderPO>();
		orderpo.add(order);
		if(service.saveTask(orderpo)){
			System.out.println("------------------save success--------------");
		}
		
		if(service.lookTask(code,orderpo)){
			System.out.println("------------look success------------");
		}
		
		service.inputOrder(receive);
	}
}

