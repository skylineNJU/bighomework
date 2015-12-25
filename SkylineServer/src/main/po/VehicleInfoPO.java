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

 
    public VehicleInfoPO(String carID, String engineID, String carNum,
			String underpanID, String boughtTime, String usedTime) {
		super();
		this.carID = carID;
		this.engineID = engineID;
		this.carNum = carNum;
		this.underpanID = underpanID;
		this.boughtTime = boughtTime;
		this.usedTime = usedTime;
	}
    
	public String getCarID() {
		return carID;
	}

	public void setCarID(String carID) {
		this.carID = carID;
	}

	public String getEngineID() {
		return engineID;
	}

	public void setEngineID(String engineID) {
		this.engineID = engineID;
	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public String getUnderpanID() {
		return underpanID;
	}

	public void setUnderpanID(String underpanID) {
		this.underpanID = underpanID;
	}

	public String getBoughtTime() {
		return boughtTime;
	}

	public void setBoughtTime(String boughtTime) {
		this.boughtTime = boughtTime;
	}

	public String getUsedTime() {
		return usedTime;
	}

	public void setUsedTime(String usedTime) {
		this.usedTime = usedTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

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
    	if(reader.findNext("��������",carNum)){
    	this.carID=reader.getString("���ƺ�");
    	this.engineID=reader.getString("�������");
    	this.carNum=reader.getString("��������");
    	this.underpanID=reader.getString("���̴���");
    	this.usedTime=reader.getString("����ʱ��");
    	this.boughtTime=reader.getString("����ʱ��");
    	}
    	reader.close();
    }
}
