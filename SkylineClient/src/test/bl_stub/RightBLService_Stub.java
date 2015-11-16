package bl_stub;

import vo.AccountVO;
import vo.RightVO;
import businesslogicservice.RightBLService;

public class RightBLService_Stub implements RightBLService{

	@Override
	public RightVO login(String AccountName, String code) {
		// TODO Auto-generated method stub
		RightVO rightVO = null;
		return rightVO;
	}

	@Override
	public AccountVO createNewAccount(String ID, String code, RightVO right) {
		// TODO Auto-generated method stub
		AccountVO accountVO = new AccountVO(ID,12);
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
