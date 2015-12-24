package main.po;

import main.socketservice.SqlDeleter;
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
	
	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	//�����˻�ͳһ���Ϊ1
	public BankAccountPO(String account,double money){
		this.account = account;
		this.money = money;
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("BankAccount");
		if(reader.findNext("�����˻���",this.account)){
		this.account = reader.getString("�����˻���");
		this.money=reader.getDouble("���");
		}
		reader.close();
	}

	public void writeIntoDatabase(){
		SqlWriter writer=new SqlWriter();
		String content="'"+account+"',"+money;
		writer.writeIntoSql("BankAccount", content);
	}
	
	public void deleteFromDatabase(){
		SqlDeleter deleter=new SqlDeleter();
		deleter.deleteData("BankAccount","�����˻���",account);
	}
	
	public void modifyTheDate(){
		SqlReader reader=new SqlReader("BankAccount");
		if(reader.findNext("�����˻���",this.account)){
			this.money=reader.getDouble("���")+this.money;
		}
		String ac=this.account;
		if(this.changeAccount()){
			this.money=0;
			this.account=ac;
		}
		
		reader.close();
		this.deleteFromDatabase();
		this.writeIntoDatabase();
	}
	
	private boolean changeAccount(){
		if(money>=0){
			return false;
		}else{
			SqlReader reader=new SqlReader("BankAccount");
			double x=this.money;
			while(reader.hasNext()){
				if((x+=reader.getDouble("���"))>=0){
					this.account=reader.getString("�����˻���");
					this.money=x;
					this.deleteFromDatabase();
					this.writeIntoDatabase();
					return true;
				}
			}
			return true;
		}
	}
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
}
