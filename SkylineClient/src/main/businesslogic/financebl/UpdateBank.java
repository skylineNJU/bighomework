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
			if(bankList.get(i).getCode().split(" ")[1].equals(belong)){//�ҵ������˻�
				findBank = true;
				if(bankList.get(i).getBalance()+money<0.1){//�ж�����Ƿ��㹻
					System.err.println(bankList.get(i).getCode()+"���㣡");
					return false;
				}else{//�������
					bankList.get(i).setBalance(bankList.get(i).getBalance()+money);
				}
			}
		}
		if(!findBank){
			System.err.println("û���ҵ������˻���");
			return false;
		}
		return true;
	}
	public ArrayList<BankAccountVO> getBankList(){
		return bankList;
	}
}
