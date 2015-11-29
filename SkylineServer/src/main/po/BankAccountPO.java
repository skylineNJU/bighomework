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
	private String code;//numberָ���Ǳ��
	public BankAccountPO(String account,double money,String code){
		this.account = account;
		this.money = money;
		this.code = code;
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("BankAccount");
		System.out.println("--------------this.getCode()--------------");
		reader.findNext("�˻����",this.getCode());
		this.account = reader.getString("�����˻���");
		this.money=reader.getDouble("���");
		reader.close();
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
