package main.businesslogic.financebl.mockTest;


import main.businesslogic.financebl.Balance;
import main.vo.BankAccountVO;

public class MockBalance extends Balance{
	
	public boolean readBalance(String name, BankAccountVO account){
		account.write(name, "2609059");
		return true;
	}
}
