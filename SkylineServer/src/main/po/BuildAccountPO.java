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
	private int id=0;
	
	public void addAccount(String name,String date,int id){
		this.name.add(name);
		this.date.add(date);
		this.id=id;
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
		BankAccountTableCreater bc=new BankAccountTableCreater(id);
		bc.createTable();
		IntermediateTableCreater ic=new IntermediateTableCreater(id);
		ic.createTable();
		LobbyTableCreater lc=new LobbyTableCreater(id);
		lc.createTable();
		StaffTableCreater sc=new StaffTableCreater(id);
		sc.creatTable();
		VehicleTableCreater vc=new VehicleTableCreater(id);
		vc.createTable();
		WarehouseTableCreater wc=new WarehouseTableCreater(id);
		wc.createTable();
		InventoryTableCreater inc=new InventoryTableCreater(id);
		inc.createTable();
	}
	
	public void Load(){
		BankAccountTableCreater bc=new BankAccountTableCreater(id);
		IntermediateTableCreater ic=new IntermediateTableCreater(id);
		LobbyTableCreater lc=new LobbyTableCreater(id);
		StaffTableCreater sc=new StaffTableCreater(id);
		VehicleTableCreater vc=new VehicleTableCreater(id);
		WarehouseTableCreater wc=new WarehouseTableCreater(id);
		InventoryTableCreater inc=new InventoryTableCreater(id);
		bc.createTable();
		ic.createTable();
		lc.createTable();
		sc.creatTable();
		vc.createTable();
		wc.createTable();
		inc.createTable();
	}
}
