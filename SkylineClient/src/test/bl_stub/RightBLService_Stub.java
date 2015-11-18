package test.bl_stub;

import  main.vo.BankAccountVO;
import  main.vo.RightVO;
import  main.businesslogicservice.RightBLService;

public class RightBLService_Stub implements RightBLService{

	@Override
	public RightVO login(String AccountName, String code) {
		// TODO Auto-generated method stub
		RightVO rightVO = null;
		return rightVO;
	}

	@Override
	public BankAccountVO createNewAccount(String ID, String code, RightVO right) {
		// TODO Auto-generated method stub
		BankAccountVO accountVO = new BankAccountVO(ID,12);
		return accountVO;
	}

	@Override
	public boolean modifyCode(String oldCode, String newCode) {
		// TODO Auto-generated method stub
		oldCode=newCode;
		System.out.println("--------------Modify Success!---------------");
		return true;
	}

	@Override
	public boolean initCode(String ID) {
		// TODO Auto-generated method stub
		System.out.println("-------------Initialize Success!------------");
		return true;
	}

}
