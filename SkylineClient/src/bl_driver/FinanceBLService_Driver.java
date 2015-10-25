package bl_driver;

import java.util.ArrayList;

import vo.AccountVO;
import vo.CostVO;
import vo.EarnVO;
import businesslogicservice.FinanceBLService;

public class FinanceBLService_Driver {
	
	ArrayList<EarnVO> earnlist;
	ArrayList<CostVO> costlist;
	
	public void drive(FinanceBLService financeBLService){
		earnlist.clear();
		earnlist =financeBLService.showStatisticsList("20130201", "20130212");
		if(earnlist != null){
			System.out.println("---------Earnlist Showing!-------------");
		}
		
		earnlist.clear();
		earnlist =financeBLService.showEarnListDependsOnDay("20120203");
		if(earnlist != null){
			System.out.println("---------Earnlist Showing!-------------");
		}
		
		
		earnlist.clear();
		earnlist =financeBLService.showEarnListDependsOnInstitution("110210000001", "20091002", "22091102");
		if(earnlist != null){
			System.out.println("---------Earnlist Showing!-------------");
		}
		
		AccountVO account =financeBLService.showBalance("A");
		if(account != null){
			System.out.println("---------Balance Showing!-------------");
		}
		
		costlist.clear();
	    costlist = financeBLService.showCostList();
		if(costlist != null){
			System.out.println("---------Costlist Showing!-------------");
		}
		
		costlist.clear();
		costlist = financeBLService.showCostList("20010101");
		if(costlist != null){
			System.out.println("---------Costlist Showing!-------------");
		}
		
		earnlist.clear();
		ArrayList<EarnVO> earn = new ArrayList<EarnVO>();
		earnlist =financeBLService.writeEarnList(earn);
		if(costlist != null){
			System.out.println("-----------Write Success!-------------");
		}
		
	}
}
