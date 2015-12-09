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
	private String carID;//车牌号
	private String engineID;//引擎代号
    private String carNum;//车辆号
    private String underpanID;//底盘号
    private String boughtTime;//购买时间
    private String usedTime;//服役时间

 
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
    	deleter.deleteData("VehicleInfo","车牌号",this.carID);
    }

    public void getDataFromBase(){
    	SqlReader reader=new SqlReader("VehicleInfo");
    	reader.findNext("车辆代号",carNum);
    	this.carID=reader.getString("车牌号");
    	this.engineID=reader.getString("引擎代号");
    	this.underpanID=reader.getString("底盘代号");
    	this.usedTime=reader.getString("服役时间");
    	this.boughtTime=reader.getString("购买时间");
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
