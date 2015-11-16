package businesslogic.financebl.financeTest;

import vo.AccountVO;
import businesslogic.financebl.Balance;

public class MockBalance extends Balance{
	
	public boolean readBalance(String name, AccountVO account){
		return true;
	}
}
