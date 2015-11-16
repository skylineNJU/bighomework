package po;

import java.io.Serializable;


public class VehicleInfoPO extends Message implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int carID;//车辆代号
	private int engineID;//底盘代号
    private int carNum;//车辆号
    private int underpanID;//底盘号
    private String boughtTime;//购买时间
    private int usedTime;//服役时间

public VehicleInfoPO(int i,int j,int k,int m,String n,int p){
	carID=i;
	engineID=j;
	carNum=k;
	underpanID=m;
	boughtTime=n;
	usedTime=p;
}

public int getCarID() {
	return carID;
}

public void setCarID(int carID) {
	this.carID = carID;
}

public int getEngineID() {
	return engineID;
}

public void setEngineID(int engineID) {
	this.engineID = engineID;
}

public int getCarNum() {
	return carNum;
}

public void setCarNum(int carNum) {
	this.carNum = carNum;
}

public int getUnderpanID() {
	return underpanID;
}

public void setUnderpanID(int underpanID) {
	this.underpanID = underpanID;
}

public String getBoughtTime() {
	return boughtTime;
}

public void setBoughtTime(String boughtTime) {
	this.boughtTime = boughtTime;
}

public int getUsedTime() {
	return usedTime;
}

public void setUsedTime(int usedTime) {
	this.usedTime = usedTime;
}


}
