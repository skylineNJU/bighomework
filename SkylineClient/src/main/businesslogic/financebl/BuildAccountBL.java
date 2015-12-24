package main.businesslogic.financebl;

import main.data.finance.FinanceDataController;
import main.dataservice.FinanceDataService;
import main.po.BuildAccountPO;
import main.vo.BuildAccountVO;

public class BuildAccountBL {
	private BuildAccountPO po=new BuildAccountPO();
	
	public BuildAccountBL(){}
	
	public BuildAccountBL(BuildAccountVO vo){
		po.addAccount(vo.getName().getFirst(),
				vo.getName().getFirst(),
				vo.getId());
	}
	
	public void saveAccount(){
		FinanceDataService service=new FinanceDataController();
		service.buildAccount(po);
	}
	
	public void loadAccount(){
		FinanceDataService service=new FinanceDataController();
		service.loadAccount(po);
	}
	
	public BuildAccountVO inquireAccount(){
		FinanceDataService service=new FinanceDataController();
		service.getAccount(po);
		BuildAccountVO vo=new BuildAccountVO();
		vo.setName(po.getName());
		vo.setDate(po.getDate());
		return vo;
	}
}
