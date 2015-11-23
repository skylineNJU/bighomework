package main.businesslogic.rightbl;

import main.businesslogicservice.RightBLService;
import main.vo.AccountVO;
import main.vo.BankAccountVO;
import main.vo.RightVO;

public class RightController implements RightBLService{
	
	public boolean modifyCode(String oldCode,String newCode){//–ﬁ∏ƒ√‹¬Î
		Account account=new Account(oldCode,newCode);
		return account.saveInfo();
	}
	
	public boolean initCode(String ID){//√‹¬Î≥ı ºªØ
		Account account=new Account(ID);
		
		return account.saveInfo();
	}


	@Override
	public boolean createNewAccount(BankAccountVO accountInfo) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean login(String AccountName, String code, AccountVO account) {
		// TODO Auto-generated method stub
		
		return false;
	}
}
