package main.po;

import java.io.Serializable;

import main.socketservice.SqlDeleter;
import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;


public class VehicleInfoPO extends Message implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String carID;//���ƺ�
	private String engineID;//�������
    private String carNum;//������
    private String underpanID;//���̺�
    private String boughtTime;//����ʱ��
    private String usedTime;//����ʱ��

 
    public String gerCarNum(){
    	return carNum;
    }
    public void writeIntoDatabase(){
    	SqlWriter writer=new SqlWriter();
    	String content="'"+carID+"','"+engineID+"','"+carNum+"','"
    			+underpanID+"','"+boughtTime+"','"+usedTime+"'";
    	writer.writeIntoSql("VehicleInfo", content);
    	
    }
    
    public void deleteFromDatabase(){
    	SqlDeleter deleter=new SqlDeleter();
    	deleter.deleteData("VehicleInfo","���ƺ�",this.carID);
    }

    public void getDataFromBase(){
    	SqlReader reader=new SqlReader("VehicleInfo");
    	reader.findNext("��������",carNum);
    	this.carID=reader.getString("���ƺ�");
    	this.engineID=reader.getString("�������");
    	this.underpanID=reader.getString("���̴���");
    	this.usedTime=reader.getString("����ʱ��");
    	this.boughtTime=reader.getString("����ʱ��");
    	reader.close();
    }

	public VehicleInfoPO(String carID, String engineID, String carNum, String underpanID, String boughtTime,
			String usedTime) {
		super();
		this.carID = carID;
		this.engineID = engineID;
		this.carNum = carNum;
		this.underpanID = underpanID;
		this.boughtTime = boughtTime;
		this.usedTime = usedTime;
	}
}
