package main.businesslogic.financebl;

import java.util.ArrayList;

import main.vo.BankAccountVO;

public class UpdateBank {
	
	private ArrayList<BankAccountVO> bankList = new ArrayList<BankAccountVO>();
	
	public UpdateBank(){
		bankList = new Balance().readBalance();
	}
	
	public boolean updateMoney(String belong,double money){
		boolean findBank = false;
		for(int i = 0;i<bankList.size();i++){
			if(bankList.get(i).getCode().split(" ")[1].equals(belong)){//找到银行账户
				findBank = true;
				if(bankList.get(i).getBalance()+money<0.1){//判断余额是否足够
					System.err.println(bankList.get(i).getCode()+"余额不足！");
					return false;
				}else{//操作余额
					bankList.get(i).setBalance(bankList.get(i).getBalance()+money);
				}
			}
		}
		if(!findBank){
			System.err.println("没有找到银行账户！");
			return false;
		}
		return true;
	}
	public ArrayList<BankAccountVO> getBankList(){
		return bankList;
	}
}
