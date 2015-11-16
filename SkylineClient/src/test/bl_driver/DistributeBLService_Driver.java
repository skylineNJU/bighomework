package bl_driver;

import java.util.ArrayList;

import vo.DistributeVO;
import vo.RecipientVO;
import businesslogicservice.DistributeBLService;

public class DistributeBLService_Driver {
	public void drive(DistributeBLService distributeBLService){
		
		ArrayList<DistributeVO> distributelist = distributeBLService.showDistributeList();
		if(distributelist != null){
			System.out.println("---------Distributelist Showing!-------------");
			}
		
		RecipientVO  recipient = distributeBLService.writeReceiveMessage("101111", "1", "20010201", "уехЩ");
		if(recipient != null){
			System.out.println("-------------Write Success!-------------");
		}
	
	
	}
}
