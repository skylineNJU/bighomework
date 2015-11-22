package main.po;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

//����δͨ������
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
		String content="'"+"�ܾ���"+"','"+code+"','"+kinds+"'";
		writer.writeIntoSql("ApprovalList", content);
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("ApprovalList");
		reader.findNext("ID","�ܾ���");
		if(code!=null)
			code=reader.getString("����")+" "+code;
		else
			code=reader.getString("����");
		
		if(kinds!=null)
			kinds=reader.getString("��������")+" "+kinds;
		else
			kinds=reader.getString("��������");
		
		reader.close();
	}
}
