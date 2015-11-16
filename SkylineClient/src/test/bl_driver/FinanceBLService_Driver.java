package test.bl_driver;

import java.util.ArrayList;

import main.businesslogicservice.FinanceBLService;
import main.vo.BankAccountVO;
import main.vo.CostVO;
import main.vo.EarnVO;

public class FinanceBLService_Driver {
	
	ArrayList<EarnVO> earnlist;
	ArrayList<CostVO> costlist;
	BankAccountVO account;
	
	public void drive(FinanceBLService financeBLService){
		boolean show =financeBLService.showStatisticsList("20130201", "20130212", earnlist, costlist);
		if(show){
			System.out.println("---------Earnlist Showing!-------------");
		}
		
		if(financeBLService.showEarnListDependsOnDay("20120203", earnlist)){
			System.out.println("---------Earnlist Showing!-------------");
		}
		
		if(financeBLService.showEarnListDependsOnInstitution("110210000001", "20091002", "22091102", earnlist)){
			System.out.println("---------Earnlist Showing!-------------");
		}
		
		if(financeBLService.showBalance("A", account)){
			System.out.println("---------Balance Showing!-------------");
		}
		
		if(financeBLService.showCostList(costlist)){
			System.out.println("---------Costlist Showing!-------------");
		}
		
		if(financeBLService.showCostList("20010101",costlist)){
			System.out.println("---------Costlist Showing!-------------");
		}
		
		ArrayList<EarnVO> earn = new ArrayList<EarnVO>();
		if(financeBLService.writeEarnList(earn)){
			System.out.println("-----------Write Success!-------------");
		}
		
	}
}
