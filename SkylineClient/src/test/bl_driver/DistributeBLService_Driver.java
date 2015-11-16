package test.bl_driver;

import java.util.ArrayList;

import main.vo.DistributeVO;
import main.vo.RecipientVO;
import main.businesslogicservice.DistributeBLService;

public class DistributeBLService_Driver {
	public void drive(DistributeBLService distributeBLService){
		ArrayList<DistributeVO> distributelist = new ArrayList<DistributeVO>();
		if(distributeBLService.showDistributeList(distributelist)){
			System.out.println("---------Distributelist Showing!-------------");
			}
		
		RecipientVO  recipient = new RecipientVO(null, null, null);
		recipient.write("101111", "1", "20010201", "ÕÅÈý","5+5+5266");
		if(distributeBLService.writeReceiveMessage(recipient)){
			System.out.println("-------------Write Success!-------------");
		}
	
	
	}
}
