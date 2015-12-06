package main.businesslogic.rightbl;

import java.util.ArrayList;





import main.businesslogicservice.RightBLService;
import main.data.right.RightDataController;
import main.dataservice.RightDataService;
import main.po.AccountListPO;
import main.po.AccountPO;
import main.vo.AccountVO;
import main.vo.BankAccountVO;
import main.vo.DriverVO;

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
	public boolean createNewAccount(AccountVO vo) {
		// TODO Auto-generated method stub
		Account account=new Account(vo);
		account.saveInfo();
		return false;
	}


	@Override
	public boolean login(AccountVO account) {
		// TODO Auto-generated method stub
		Account ac=new Account(account);
		System.out.println(account.getRight());
		account=ac.login(account);
		if(ac!=null){
			System.out.println(account.getRight());
		return true;
		}
		else
			return false;
	}

	@Override
	public boolean inquireAccount(String code, AccountVO account) {
		// TODO Auto-generated method stub
		Account acc=new Account(code);	
		return account.writeAccountVO(acc);
	}

	@Override
	public ArrayList<AccountVO> inquireAccount(String codeList) {
		// TODO Auto-generated method stub
		AccountListBL bl=new AccountListBL(codeList);		
		
		Account account=new Account(codeList);
		ArrayList<AccountVO> volist=account.inquire(codeList);
		
		return bl.inquire();
	}

	@Override
	public boolean deleteAccount(String accountName) {
		// TODO Auto-generated method stub
		return Account.delete(accountName);
	}

	@Override
	public boolean modifyAccount(AccountVO accountInfo) {
		// TODO Auto-generated method stub
		Account account=new Account(accountInfo);
		return account.modify();
	}

	@Override
	public ArrayList<AccountVO> inquireAccount() {
		// TODO Auto-generated method stub
		AccountListBL bl=new AccountListBL();		
		
		Account account=new Account();
		ArrayList<AccountVO> volist=account.inquire();
		
		return bl.inquire();
		
	}
}
