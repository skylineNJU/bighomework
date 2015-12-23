package main.po;

import java.util.LinkedList;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

public class BuildAccountPO extends Message{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LinkedList<String> name=new LinkedList<String>();
	private LinkedList<String> date=new LinkedList<String>();
	
	
	public void addAccount(String name,String date){
		this.name.add(name);
		this.date.add(date);
	}
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("BuildAccount");
		while(reader.hasNext()){
			name.add(reader.getString("建账人"));
			date.add(reader.getString("建账时间"));
		}
	}
	
	public void writeIntoDatabase(){
		SqlWriter writer=new SqlWriter();
		String content="'"+date.getLast()+"','"+name.getLast()+"'";
		writer.writeIntoSql("BuildAccount", content);
	}
}
