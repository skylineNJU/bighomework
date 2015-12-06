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
	
	
	
	public AccountListBL(AccountListPO po, String codeList) {
		super();
		this.po = po;
		this.codeList = codeList;
	}



	public AccountListBL() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ArrayList<AccountVO> inquire(){
		System.out.println("inquire account");
		ArrayList<AccountVO> voList=new ArrayList<AccountVO>();
		po=new AccountListPO();
		RightDataService service=new RightDataController();
		po=service.inquireAccountList(po);
		ArrayList<AccountPO> poList=po.getList();
		if(poList.size()==0){
			System.out.println("po «null");
		}else{
			System.out.println("po≤ª «null");
		}
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
