package main.businesslogic.financebl;

import main.data.finance.FinanceDataController;
import main.dataservice.FinanceDataService;
import main.po.BuildAccountPO;
import main.vo.BuildAccountVO;

public class BuildAccountBL {
	private BuildAccountPO po=new BuildAccountPO();
	
	public BuildAccountBL(int x){
		po.setId(x);
	}
	
	public BuildAccountBL(BuildAccountVO vo){
		po.addAccount(vo.getName().getFirst(),
				vo.getDate().getFirst(),
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
		po=service.getAccount(po);
		BuildAccountVO vo=new BuildAccountVO();
		System.out.println(po.getName().size());
		vo.setName(po.getName());
		vo.setDate(po.getDate());
		return vo;
	}
}
