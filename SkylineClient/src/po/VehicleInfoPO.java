package po;

import java.io.Serializable;


public class VehicleInfoPO implements Serializable{
int carID;//车辆代号
int engineID;//底盘代号
int carNum;//车辆号
int underpanID;//底盘号
String boughtTime;//购买时间
int usedTime;//服役时间

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
