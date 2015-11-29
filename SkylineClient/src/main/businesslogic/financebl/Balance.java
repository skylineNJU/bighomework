package main.businesslogic.financebl;

import java.util.ArrayList;

import main.data.finance.FinanceDataController;
import main.dataservice.FinanceDataService;
import main.po.BankAccountPO;
import main.vo.BankAccountVO;

public class Balance {
	BankAccountPO bankAccountPO = new BankAccountPO("", 0,"2");
	
	public BankAccountVO readBalance(String code){
		BankAccountVO bankAccountVO = new BankAccountVO();
		FinanceDataService dataService = new FinanceDataController();
		bankAccountPO.setCode(code);
		bankAccountPO = dataService.readBankAccount(bankAccountPO);
		bankAccountVO.setCode(bankAccountPO.getAccount());
		bankAccountVO.setBalance(Double.valueOf(bankAccountPO.getMoney()));
		return bankAccountVO;
	}
	
	public boolean changeBalance(double balance,BankAccountVO account){
		account.setBalance(balance);
		return false;
	}
}
