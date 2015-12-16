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
		String content="'"+"�ܾ���"+"','"+courrierCode+"','"+lobbyCode+"','"+intermediateCode+"','"
				+warehouseCode+"','"+financeCode+"'";
		writer.writeIntoSql("ReceiptRecord", content);
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("ReceiptRecord");
		if(reader.hasNext()){
			courrierCode=reader.getString("���Ա����");
			lobbyCode=reader.getString("Ӫҵ������");
			intermediateCode=reader.getString("��ת���ĵ���");
			warehouseCode=reader.getString("�ֿⵥ��");
			financeCode=reader.getString("���񵥺�");
		}
		reader.close();
	}
	
	public void modifyTheDate(){
		this.deleteFromDatabase();
		SqlWriter writer=new SqlWriter();
		String content="'"+"�ܾ���"+"','"+courrierCode+"','"+lobbyCode+"','"+intermediateCode+"','"
				+warehouseCode+"','"+financeCode+"'";
		System.out.println("save info");
		writer.writeIntoSql("ReceiptRecord", content);
	}
	
	public void peekDataFromBase(){
		SqlReader reader=new SqlReader("ReceiptRecord");
		if(courrierCode!=null){
			courrierCode=reader.getString("���Ա����")+" "+courrierCode;
		}else{
			courrierCode=reader.getString("���Ա����");
		}
		if(courrierCode!=null){
			lobbyCode=reader.getString("Ӫҵ������")+" "+lobbyCode;
		}else{
			lobbyCode=reader.getString("Ӫҵ������");
		}
		
		if(intermediateCode!=null){
			intermediateCode=reader.getString("��ת���ĵ���")+" "+intermediateCode;
		}else{
			intermediateCode=reader.getString("��ת���ĵ���");	
		}
		
		if(warehouseCode!=null){
			warehouseCode=reader.getString("�ֿⵥ��")+" "+warehouseCode;
		}else{
			warehouseCode=reader.getString("�ֿⵥ��");	
		}
		
		if(financeCode!=null){
			financeCode=reader.getString("���񵥺�")+" "+financeCode;
		}else{
			financeCode=reader.getString("���񵥺�");	
		}
	}
	public void deleteFromDatabase(){
		SqlDeleter deleter=new SqlDeleter();
		deleter.deleteData("ReceiptRecord","ID","�ܾ���");
	}
}
