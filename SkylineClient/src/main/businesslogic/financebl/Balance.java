package main.businesslogic.financebl;

import java.util.ArrayList;

import main.data.finance.FinanceDataController;
import main.dataservice.FinanceDataService;
import main.po.BankAccountPO;
import main.po.BankList;
import main.vo.BankAccountVO;

public class Balance {

	public ArrayList<BankAccountVO> readBalance(){
		ArrayList<BankAccountVO> bankVOList = new ArrayList<BankAccountVO>();
		FinanceDataService dataService = new FinanceDataController();
		BankList bankList = dataService.readBankAccount();
		for(BankAccountPO bankPO:bankList.getList()){
			bankVOList.add(new BankAccountVO(bankPO.getAccount(), bankPO.getMoney()));
		}
		return bankVOList;
	}
	
	public boolean changeBalance(BankAccountVO bank){
		BankAccountPO bankPO = new BankAccountPO(bank.getCode(), bank.getBalance());
		FinanceDataService finance = new FinanceDataController();
		return finance.modifyBalance(bankPO);
	}
}
