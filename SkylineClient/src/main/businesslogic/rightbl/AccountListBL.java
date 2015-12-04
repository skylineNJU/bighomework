package main.businesslogic.rightbl;

import java.util.ArrayList;



import main.data.right.RightDataController;
import main.dataservice.RightDataService;
import main.po.AccountListPO;
import main.po.AccountPO;
import main.vo.AccountVO;


public class AccountListBL {
	private AccountListPO po;
	private String codeList;
	
	public AccountListBL(String codeList){
		this.codeList=codeList;
	}
	
	public ArrayList<AccountVO> inquire(){
		System.out.println("inquire account");
		ArrayList<AccountVO> voList=new ArrayList<AccountVO>();
		po=new AccountListPO(codeList);
		RightDataService service=new RightDataController();
		po=service.inquireAccountList(po);
		ArrayList<AccountPO> poList=po.getList();
		
		for(AccountPO p:poList){
			AccountVO vo=new AccountVO(
				
					p.getRight(),
					p.getID(),
					p.getCode(),
					p.getBelong()
					);
			voList.add(vo);
		}
		return voList;
	}
}
