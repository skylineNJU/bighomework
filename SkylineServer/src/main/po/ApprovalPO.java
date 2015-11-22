package main.po;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

//审批未通过单号
public class ApprovalPO extends Message{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	private String kinds;
	
	
	public ApprovalPO(String code,String kinds) {
		super();
		this.code = code;
		this.kinds=kinds;
	}

	public void writeIntoDatabase(){
		SqlWriter writer=new SqlWriter();
		getDataFromBase();
		String content="'"+"总经理"+"','"+code+"','"+kinds+"'";
		writer.writeIntoSql("ApprovalList", content);
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("ApprovalList");
		reader.findNext("ID","总经理");
		if(code!=null)
			code=reader.getString("单号")+" "+code;
		else
			code=reader.getString("单号");
		
		if(kinds!=null)
			kinds=reader.getString("单据种类")+" "+kinds;
		else
			kinds=reader.getString("单据种类");
		
		reader.close();
	}
}
