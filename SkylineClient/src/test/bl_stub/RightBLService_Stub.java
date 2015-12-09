package test.bl_stub;

import java.util.ArrayList;

import main.po.Rights;
import main.vo.AccountVO;
import  main.vo.BankAccountVO;
import  main.businesslogicservice.RightBLService;
/**
 * 
 * @author QiHan
 * 
 *
 */
public class RightBLService_Stub implements RightBLService{

	@Override
	public boolean login(AccountVO account) {
		// TODO Auto-generated method stub
		account = new AccountVO(Rights.COURIER, "San",null, null);
		if(account.getAccountName()!=null){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean createNewAccount(AccountVO accountInfo) {
		// TODO Auto-generated method stub
		accountInfo = new AccountVO(Rights.COURIER, "San",null, null);
		if(accountInfo.getAccountName()!=null){
			return true;
		}
		else{
			return false;
		}
	}

	
	@Override
	public boolean inquireAccount(String code, AccountVO account) {
		// TODO Auto-generated method stub
		account = new AccountVO(Rights.COURIER, "San",null, null);
		if(account.getAccountName()!=null){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean modifyCode(String oldCode, String newCode) {
		// TODO Auto-generated method stub
		oldCode = newCode;
		if(newCode!=null){
			return true; 
		}	
		
		else{
			return false;
		}
	}

	@Override
	public boolean initCode(String ID) {
		// TODO Auto-generated method stub
		if(ID!=null){
			return true;
		}
		
		else {
			return false;
		}
	}

	@Override
	public ArrayList<AccountVO> inquireAccount(String code) {
		// TODO Auto-generated method stub
		AccountVO account = new AccountVO(Rights.COURIER, "San",code, null);
		ArrayList<AccountVO> list = new ArrayList<AccountVO>();
		list.add(account);
		return list;
	}

	@Override
	public boolean deleteAccount(String accountName) {
		// TODO Auto-generated method stub
		if(accountName!=null){
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean modifyAccount(AccountVO accountInfo) {
		// TODO Auto-generated method stub
		accountInfo = new AccountVO(Rights.COURIER, "San",null, null);
		if(accountInfo.getAccountName()!=null){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public ArrayList<AccountVO> inquireAccount() {
		// TODO Auto-generated method stub
		AccountVO account = new AccountVO(Rights.COURIER, "San",null, null);
		ArrayList<AccountVO> list = new ArrayList<AccountVO>();
		list.add(account);
		return list;
	}

	

}
