package main.businesslogic.rightbl.mocktest;

import main.businesslogic.rightbl.Account;
import main.vo.BankAccountVO;
import main.vo.RightVO;


public class MockAccount extends Account{

	public MockAccount(String string, String string2, RightVO rightInfo) {
		super(string, string2, rightInfo);
		// TODO Auto-generated constructor stub
	}

	public MockAccount(String oldCode, String newCode) {
		super(oldCode, newCode);
	// TODO Auto-generated constructor stub
	}

public MockAccount(String iD2) {
	super(iD2);
		// TODO Auto-generated constructor stub
	}

public MockAccount(BankAccountVO ac) {
	super(ac);
	// TODO Auto-generated constructor stub
	}

}
