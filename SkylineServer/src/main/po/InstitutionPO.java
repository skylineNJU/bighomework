package main.po;

import java.io.Serializable;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

public class InstitutionPO extends Message implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String kinds;
	private String situation;
	private String ID;
	private String name;
	
	public InstitutionPO(String ki,String si,String id,String na){
		this.kinds=ki;
		this.situation=si;
		this.ID=id;
		this.name=na;
	}
	
	public void writeIntoDatabase(){
		SqlWriter writer=new SqlWriter();
		String content="'"+name+"','"+kinds+"','"+situation+"','"+ID+"'";
		writer.writeIntoSql("InstitutionInfo", content);
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("InstitutionInfo");
		reader.findNext("机构编号",ID);
		this.name=reader.getString("机构名称");
		this.kinds=reader.getString("机构种类");
		this.situation=reader.getString("机构位置");
	}
	
	public String getKinds() {
		return kinds;
	}
	public void setKinds(String kinds) {
		this.kinds = kinds;
	}
	public String getSituation() {
		return situation;
	}
	public void setSituation(String situation) {
		this.situation = situation;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
