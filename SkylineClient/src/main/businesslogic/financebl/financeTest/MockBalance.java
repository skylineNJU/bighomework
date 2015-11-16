package main.businesslogic.financebl.financeTest;

import main.vo.AccountVO;
import main.businesslogic.financebl.Balance;

public class MockBalance extends Balance{
	
	public boolean readBalance(String name, AccountVO account){
		return true;
	}
}
