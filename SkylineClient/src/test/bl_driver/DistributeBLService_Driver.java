package test.bl_driver;

import java.util.ArrayList;

import main.vo.DistributeVO;
import main.vo.RecipientVO;
import main.businesslogicservice.DistributeBLService;

public class DistributeBLService_Driver {
	public void drive(DistributeBLService distributeBLService){
		String courierCode="00000000";
		if(distributeBLService.showDistributeList(courierCode)!=null){
			System.out.println("---------Distributelist Showing!-------------");
			}
		
		ArrayList<DistributeVO> voList=new ArrayList<DistributeVO>();		
		DistributeVO volist=new DistributeVO("101111", "20010201", "张三","木叶村","1388888888","000890004");
		voList.add(volist);
		if(distributeBLService.writeDistributeList(voList)){
			System.out.println("-------------Write distributelist Success!-------------");
		}
		RecipientVO recipient=new RecipientVO("李四", "1377777777", "6666666",
				"2013/05/01", "000890004");
		if(distributeBLService.writeReceiveMessage(recipient)){
			System.out.println("-------------Write receive message Success!-------------");
		}
	
	}
}
