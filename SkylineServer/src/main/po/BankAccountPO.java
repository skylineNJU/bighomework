package main.po;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

//�����˻���Ϣ
public class BankAccountPO extends Message{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String account;//�����˻�ID
	private double money;//���
	
	//�����˻�ͳһ���Ϊ1
	public BankAccountPO(String account,double money){
		this.account = account;
		this.money = money;
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("BankAccount");
		reader.findNext("�˻����","1");
		this.account = reader.getString("�����˻���");
		this.money=reader.getDouble("���");
		reader.close();
	}

	public void writeIntoDatabase(){
		SqlWriter writer=new SqlWriter();
		String content="'"+account+"','"+money+"'";
		writer.writeIntoSql("BankAccount", content);
	}
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
}
