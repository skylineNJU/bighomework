package test.bl_driver;

import java.util.ArrayList;

import main.businesslogicservice.FinanceBLService;
import main.vo.BankAccountVO;
import main.vo.CostVO;
import main.vo.DistanceVO;
import main.vo.EarnVO;
import main.vo.FeeVO;
import main.vo.SalaryVO;

public class FinanceBLService_Driver {
	
	ArrayList<EarnVO> earnlist;
	ArrayList<CostVO> costlist;
	BankAccountVO account;
	
	public void drive(FinanceBLService financeBLService){
		ArrayList<ArrayList> show =financeBLService.showStatisticsList("20130201") ;
		FeeVO fee= new FeeVO(20,20,20);
		SalaryVO salary = new  SalaryVO();
		String[] city={"shanghai","nanjing"};
		double[][] dis={{20},{30}};
		DistanceVO distance = new  DistanceVO(city,dis);
		ArrayList<EarnVO> earn = new ArrayList<EarnVO>();
		EarnVO earns = new EarnVO("324242", "2015/02/20", null, null, 0, null, null);
		BankAccountVO bank= new BankAccountVO("232345345",20);
		CostVO cost = new CostVO("2015/01/01", "2342424", null, 0, null, null, null);
		String date ="20150101";
		
		
		
		if(show!=null){
			System.out.println("---------Earnlist Showing!-------------");
		}
		
		if(financeBLService.showEarnListDependsOnDay("20120203") != null){
			System.out.println("---------Earnlist Showing!-------------");
		}
		
		if(financeBLService.showCostList(date) != null){
			System.out.println("---------Costlist Showing!-------------");
		}

		if(financeBLService.delSalary(salary)){
			System.out.println("---------Salary deleted-------------");
		}
		
		if( financeBLService.modifySalary(salary)){
			System.out.println("---------salary  modifty!-------------");
		}
		
		if( financeBLService.delFee(fee)){
			System.out.println("---------fee deleted-------------");
		}
		
		if(financeBLService.modifyFee(fee)){
			System.out.println("--------fee moditified-------------");
		}
		
		if( financeBLService.delCollection(earns)){
			System.out.println("---------earn deleted-------------");
		}
		
		if( financeBLService.modifyCollection(earns)){
			System.out.println("---------earn moditified-------------");
		}
		
		if(financeBLService.modifyCost(cost)){
			System.out.println("---------cost moditified-------------");
		}
		
		if( financeBLService.deleteCost(cost)){
			System.out.println("---------cost deleted-------------");
		}
		
		if( financeBLService.getDistance() != null){
			System.out.println("---------get distance-------------");
		}
		
		if(financeBLService.showStatisticsList(date) != null){
			System.out.println("---------StatisticsList showing!-------------");
		}
		
		if(financeBLService.showLobbyEarn(date,"12") != null){
			System.out.println("--------LobbyEarn showing!-------------");
		}
		
		if( financeBLService.readSalary() != null){
			System.out.println("--------salary readed!-------------");
		}
		
		if(financeBLService.readFee() != null){
			System.out.println("--------fee readed!-------------");

		}
		//输入账户编号，显示账户余额
		if(financeBLService.showBalance() != null){
			System.out.println("--------balance showing!-------------");
			
		}

		//填写收款单信息，系统显示收款单
		if( financeBLService.writeEarn(earns)){
			System.out.println("--------Earn writing!-------------");
			
		}
		
		if(financeBLService.writeCost(cost)){
			System.out.println("--------cost writing!-------------");
		}
		
		if(financeBLService.writeSalary(salary)){
			System.out.println("--------salary writing!-------------");
		}
		
		if( financeBLService.writeFee(fee)){
			System.out.println("--------fee writing!-------------");
		}
		
		if( financeBLService.writeDistance(distance)){
			System.out.println("--------diatance writing!-------------");
			
		}
		
		if( financeBLService.modifyDistance(distance)){
			System.out.println("--------diatance moditified!-------------");
		}
		
		if(financeBLService.delDistance(distance)){
			System.out.println("--------diatance deleted!-------------");
		}
		
		if( financeBLService.modifyBalance(bank)){
			System.out.println("--------balance moditified------------");
		}
		
	}
}
