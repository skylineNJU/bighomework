package main.po;

import main.socketservice.SqlDeleter;
import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

public class ReceiptRecordPO extends Message{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String courrierCode;
	private String lobbyCode;
	private String intermediateCode;
	private String warehouseCode;
	private String financeCode;
	
	public void writeIntoDataBase(){
		this.peekDataFromBase();
		this.deleteFromDatabase();
		SqlWriter writer=new SqlWriter();
		String content="'"+"总经理"+"','"+courrierCode+"','"+lobbyCode+"','"+intermediateCode+"','"
				+warehouseCode+"','"+financeCode+"'";
		writer.writeIntoSql("ReceiptRecord", content);
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("ReceiptRecord");
		if(reader.hasNext()){
			courrierCode=reader.getString("快递员单号");
			lobbyCode=reader.getString("营业厅单号");
			intermediateCode=reader.getString("中转中心单号");
			warehouseCode=reader.getString("仓库单号");
			financeCode=reader.getString("财务单号");
		}
		reader.close();
	}
	
	public void modifyTheDate(){
		this.deleteFromDatabase();
		SqlWriter writer=new SqlWriter();
		String content="'"+"总经理"+"','"+courrierCode+"','"+lobbyCode+"','"+intermediateCode+"','"
				+warehouseCode+"','"+financeCode+"'";
		System.out.println("save info");
		writer.writeIntoSql("ReceiptRecord", content);
	}
	
	public void peekDataFromBase(){
		SqlReader reader=new SqlReader("ReceiptRecord");
		if(courrierCode!=null){
			courrierCode=reader.getString("快递员单号")+" "+courrierCode;
		}else{
			courrierCode=reader.getString("快递员单号");
		}
		if(courrierCode!=null){
			lobbyCode=reader.getString("营业厅单号")+" "+lobbyCode;
		}else{
			lobbyCode=reader.getString("营业厅单号");
		}
		
		if(intermediateCode!=null){
			intermediateCode=reader.getString("中转中心单号")+" "+intermediateCode;
		}else{
			intermediateCode=reader.getString("中转中心单号");	
		}
		
		if(warehouseCode!=null){
			warehouseCode=reader.getString("仓库单号")+" "+warehouseCode;
		}else{
			warehouseCode=reader.getString("仓库单号");	
		}
		
		if(financeCode!=null){
			financeCode=reader.getString("财务单号")+" "+financeCode;
		}else{
			financeCode=reader.getString("财务单号");	
		}
	}
	public void deleteFromDatabase(){
		SqlDeleter deleter=new SqlDeleter();
		deleter.deleteData("ReceiptRecord","ID","总经理");
	}
}
