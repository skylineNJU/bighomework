package businesslogic.financebl.financeTest;

import vo.AccountVO;

public class BalanceTester {
	
	public boolean readBalance(String name, AccountVO account){
		account.setBalance(52005.5);
		return true;
	}

}
