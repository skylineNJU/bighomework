package main.po;

import java.io.Serializable;

import main.socketservice.SqlDeleter;
import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

public class AccountPO extends Message implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ID;
	private String code;
	private Rights right;
	private String belong;
	
	public AccountPO(String ID, String code, Rights right, String belong) {
		super();
		this.ID = ID;
		this.code = code;
		this.right = right;
		this.belong = belong;
	}

	public void deleteFromDatabase(){
		SqlDeleter deleter=new SqlDeleter();
		deleter.deleteData("AccountInfo","�˺�",ID);
		switch(right){
		case COURIER:
			deleter=new SqlDeleter();
			deleter.deleteData("CourrierReceipt","�˻���",ID);
			break;
		case FINANCE:
			deleter=new SqlDeleter();
			deleter.deleteData("FinanceReceipt","�˺�",ID);
			break;
		case INTERMEDIATE:
			deleter=new SqlDeleter();
			deleter.deleteData("IntermediateReceipt","�˻���",ID);
			break;
		case LOBBY:
			deleter=new SqlDeleter();
			deleter.deleteData("LobbyReceipt","�˻���",ID);
			break;
		case STOREHOUSE:
			deleter=new SqlDeleter();
			deleter.deleteData("WarhouseReceipt","�˻���",ID);
			break;
		default:
			break;

		}
	}
	
	public void writeIntoDatabase(){
		SqlWriter writer=new SqlWriter();
		String content="'"+ID+"','"+code+"','"+right.name()+"','"+belong+"'";
		System.out.println(content);
		writer.writeIntoSql("AccountInfo", content);
		switch(right){
		case COURIER:
			CourrierReceiptPO po=new CourrierReceiptPO(
					ID,"0","0","1","0","2");
			po.writeIntoDatabase();
			break;
		case FINANCE:
			FinanceReceipt po1=new FinanceReceipt(
					ID,"1","2");
			po1.writeIntoDatabase();
			break;
		case INTERMEDIATE:
			IntermediateReceipt po2=new IntermediateReceipt(
					ID,"1","2","3","4","0","0","0","0");
			po2.writeIntoDatabase();
			break;
		case LOBBY:
			LobbyReceiptPO po3=new LobbyReceiptPO(
					ID,"1","2","0","0","3");
			po3.writeIntoDatabase();
			break;
		case STOREHOUSE:
			WarhouseReceiptPO po4=new WarhouseReceiptPO(
					ID,"1","2",this.belong,"0","0");
			po4.writeIntoDatabase();
			break;
		default:
			break;
		
		}
	}
	public String readAccount(String ID){
		String content="";
		SqlReader reader=new SqlReader("AccountInfo");
		while(reader.findNext("�˺�",ID)){
			content=content+reader.getString("�˺�")+" ";
		}
		reader.close();
		return content;
	}

	public void modifyTheDate(){
		SqlReader reader=new SqlReader("AccountInfo");
		Rights job=null;
		if(reader.findNext("�˺�",this.getID())){
			job=Rights.valueOf(reader.getString("Ȩ��"));
		}
		reader.close();
		if(job.equals(right)){
			this.deleteFromDatabase();
			this.writeIntoDatabase();
		}else{
			System.out.println("can't do it");
		}
	}

	public void getDataFromBase(){
		SqlReader reader=new SqlReader("AccountInfo");
		System.out.println(this.ID);
		if(reader.findNext("�˺�",this.getID())){
		this.ID=reader.getString("�˺�");
		this.code=reader.getString("����");
		this.right=Rights.valueOf(reader.getString("Ȩ��"));
		this.belong=reader.getString("������λ");
		}
		reader.close();
	}
	
	
	public void checkLogin(){
		SqlReader reader=new SqlReader("AccountInfo");
		System.out.println(ID);
		System.out.println(code);
		if(reader.findNext("�˺�",ID)){
			String code=reader.getString("����");

			if(this.code.equals(code)){
				
				right=Rights.valueOf(reader.getString("Ȩ��"));
				belong=reader.getString("������λ");
				System.out.println("login success");
				System.out.println(right);
				return;
			}
		}else{
			System.out.println("can not found this account");
			System.out.println("login failed");
			right=null;
			belong=null;
		}
		
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Rights getRight() {
		return right;
	}

	public void setRight(Rights right) {
		this.right = right;
	}

	public String getBelong() {
		return belong;
	}

	public void setBelong(String belong) {
		this.belong = belong;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
	
	
	
}
