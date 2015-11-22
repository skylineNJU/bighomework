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
    	String content="'薪水',"+coutierSalary+","+lobbySalary+","+driverSalary+","
    			+intermediateSalary+","+storehouseSalary+","+financeSalary+","
    			+managerSalary+","+accountSalary+","+Performance;
    	writer.writeIntoSql("SalaryInfo", content);
	}
    
    public void getDataFromBase(){
    	SqlReader reader=new SqlReader("SalaryInfo");
    	reader.findNext("ID","薪水");
    	this.accountSalary=reader.getDouble("账户管理人员薪水");
    	this.coutierSalary=reader.getDouble("快递员薪水");
    	this.driverSalary=reader.getDouble("司机薪水");
    	this.intermediateSalary=reader.getDouble("中转中心业务员薪水");
    	this.lobbySalary=reader.getDouble("营业厅业务员薪水");
    	this.managerSalary=reader.getDouble("总经理薪水");
    	this.Performance=reader.getDouble("表现提成");
    	this.storehouseSalary=reader.getDouble("仓库管理人员薪水");
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
