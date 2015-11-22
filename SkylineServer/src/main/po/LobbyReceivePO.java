package main.po;

import java.io.Serializable;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

//Ӫҵ���յ���ݺ�������һ���ռ�����Ϣ
public class LobbyReceivePO extends Receipt implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int receiveYear;//Ӫҵ������ʱ�� 
	private int receiveMonth;//Ӫҵ������ʱ�� 
	private int receiveDay;//Ӫҵ������ʱ�� 
	private int condition;//���ﵽ��״̬
	private String expressBar;//expressBar��ʾ����
	

	public void writerIntoDataBase(){
		SqlWriter writer=new SqlWriter();
		String cond = null;
		switch(condition){
		case 0:
			cond="���";
			break;
		case 1:
			cond="����";
			break;
		case 2:
			cond="��ʧ";
			break;
		}
		String content="'"+receiveYear+"/"+receiveMonth+"/"+receiveDay+"','"
				+cond+"','"+expressBar+"','"+this.getCode()+"'";
		writer.writeIntoSql("LobbyReceive",content);
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("LobbyReceive");
		reader.findNext("���ݺ�",this.getCode());
		String date[]=reader.getString("����ʱ��").split(" ");
		this.receiveYear=Integer.parseInt(date[0]);
		this.receiveMonth=Integer.parseInt(date[1]);
		this.receiveDay=Integer.parseInt(date[2]);
		String condition=reader.getString("���ﵽ��״̬");
		switch(condition){
		case "���":
			this.condition=0;
		case "����":
			this.condition=1;
		case "��ʧ":
			this.condition=2;
		}
		this.expressBar=reader.getString("������");
	}
	
	
	
}
