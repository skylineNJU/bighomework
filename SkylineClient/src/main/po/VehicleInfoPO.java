package main.po;

import java.io.Serializable;


public class VehicleInfoPO extends Message implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String carID;//��������
	private String engineID;//���̴���
    private String carNum;//������
    private String underpanID;//���̺�
    private String boughtTime;//����ʱ��
    private String usedTime;//����ʱ��

    public VehicleInfoPO(String i,String j,String k,String m,String n,String p){
    	carID=i;
    	engineID=j;
    	carNum=k;
    	underpanID=m;
    	boughtTime=n;
    	usedTime=p;
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
}