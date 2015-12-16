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
	private String receiveYear;//Ӫҵ������ʱ�� 
	private String receiveMonth;//Ӫҵ������ʱ�� 
	private String receiveDay;//Ӫҵ������ʱ�� 
	private String condition;//���ﵽ��״̬
	private String expressBar;//expressBar��ʾ����
	

	public void writeIntoDatabase(){
		SqlWriter writer=new SqlWriter();
		String content="'"+receiveYear+"/"+receiveMonth+"/"+receiveDay+"','"
				+condition+"','"+expressBar+"','"+this.getCode()+"'";
		writer.writeIntoSql("LobbyReceive",content);
		LocusPO po=new LocusPO(this.expressBar);
		po.arriveLobby();
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("LobbyReceive");
		if(reader.findNext("���ݺ�",this.getCode())){
		String date[]=reader.getString("����ʱ��").split("/");
		this.receiveYear=date[0];
		this.receiveMonth=date[1];
		this.receiveDay=date[2];
		condition=reader.getString("���ﵽ��״̬");
	    this.expressBar=reader.getString("������");
		}
	}
	
	
	
}
