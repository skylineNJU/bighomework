package businesslogic.rightbl;

import vo.AccountVO;
import vo.RightVO;

public class RightController {
	public boolean login(String AccountName,String code,RightVO rightInfo){
		Account account=new Account(AccountName,code,rightInfo);
		
		return account.saveInfo();
	
	}
	public boolean createNewAccount(AccountVO accountInfo){
		Account account=new Account(accountInfo);
		
		return account.saveInfo();
	}
	
	public boolean modifyCode(String oldCode,String newCode){//–ﬁ∏ƒ√‹¬Î
		Account account=new Account(oldCode,newCode);
		return account.saveInfo();
	}
	
	public boolean initCode(String ID){//√‹¬Î≥ı ºªØ
		Account account=new Account(ID);
		
		return account.saveInfo();
	}
}
