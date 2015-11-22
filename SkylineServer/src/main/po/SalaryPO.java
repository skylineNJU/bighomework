package main.po;

import java.io.Serializable;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

public class SalaryPO extends Message implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private double coutierSalary=0;
    private double lobbySalary=0;
    private double driverSalary=0;
    private double intermediateSalary=0;
    private double storehouseSalary=0;
    private double financeSalary=0;
    private double managerSalary=0;
    private double accountSalary=0;
    private double Performance=0;
    
    
    public void writeIntoDatabase() {
    	SqlWriter writer=new SqlWriter();
    	String content="'нˮ',"+coutierSalary+","+lobbySalary+","+driverSalary+","
    			+intermediateSalary+","+storehouseSalary+","+financeSalary+","
    			+managerSalary+","+accountSalary+","+Performance;
    	writer.writeIntoSql("SalaryInfo", content);
	}
    
    public void getDataFromBase(){
    	SqlReader reader=new SqlReader("SalaryInfo");
    	reader.findNext("ID","нˮ");
    	this.accountSalary=reader.getDouble("�˻�������Աнˮ");
    	this.coutierSalary=reader.getDouble("���Աнˮ");
    	this.driverSalary=reader.getDouble("˾��нˮ");
    	this.intermediateSalary=reader.getDouble("��ת����ҵ��Աнˮ");
    	this.lobbySalary=reader.getDouble("Ӫҵ��ҵ��Աнˮ");
    	this.managerSalary=reader.getDouble("�ܾ���нˮ");
    	this.Performance=reader.getDouble("�������");
    	this.storehouseSalary=reader.getDouble("�ֿ������Աнˮ");
    	reader.close();
    }
    
	public double getCoutierSalary() {
		return coutierSalary;
	}
	public void setCoutierSalary(double coutierSalary) {
		this.coutierSalary = coutierSalary;
	}
	public double getLobbySalary() {
		return lobbySalary;
	}
	public void setLobbySalary(double lobbySalary) {
		this.lobbySalary = lobbySalary;
	}
	public double getDriverSalary() {
		return driverSalary;
	}
	public void setDriverSalary(double driverSalary) {
		this.driverSalary = driverSalary;
	}
	public double getIntermediateSalary() {
		return intermediateSalary;
	}
	public void setIntermediateSalary(double intermediateSalary) {
		this.intermediateSalary = intermediateSalary;
	}
	public double getStorehouseSalary() {
		return storehouseSalary;
	}
	public void setStorehouseSalary(double storehouseSalary) {
		this.storehouseSalary = storehouseSalary;
	}
	public double getFinanceSalary() {
		return financeSalary;
	}
	public void setFinanceSalary(double financeSalary) {
		this.financeSalary = financeSalary;
	}
	public double getManagerSalary() {
		return managerSalary;
	}
	public void setManagerSalary(double managerSalary) {
		this.managerSalary = managerSalary;
	}
	public double getAccountSalary() {
		return accountSalary;
	}
	public void setAccountSalary(double accountSalary) {
		this.accountSalary = accountSalary;
	}
	public double getPerformance() {
		return Performance;
	}
	public void setPerformance(double performance) {
		Performance = performance;
	}
}
