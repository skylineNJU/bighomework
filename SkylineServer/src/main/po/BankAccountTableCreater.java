package main.po;

import java.util.ArrayList;

import main.socketservice.SqlBuilder;
import main.socketservice.SqlWriter;

public class BankAccountTableCreater {
	private BankList list=new BankList();
	private String tableName;
	
	public BankAccountTableCreater(int id){
		list.getDataFromBase();
		tableName="BankAccount"+id;
	}
	
	public void createTable(){
		SqlBuilder builder=new SqlBuilder(tableName);
		String[] titleName={
				"银行账户名 Text(30)",
				"余额  Number"
		};
		if(builder.createTable(titleName)){
			SqlWriter writer=new SqlWriter();
			ArrayList<BankAccountPO> poList=list.getBank();
			for(BankAccountPO po:poList){
				String content="'"+po.getAccount()+"',"+po.getMoney();
				writer.writeIntoSql(tableName, content);
			}
		}
		
	}
}
