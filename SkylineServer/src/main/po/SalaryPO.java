package main.po;

import java.io.Serializable;

import main.socketservice.SqlDeleter;
import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

public class SalaryPO extends Message implements Serializable{
	
	private static final long serialVersionUID = 1L;
    private double courierSalary = 0;
    private double lobbySalary = 0;
    private double driverSalary = 0;
    private double intermediateSalary = 0;
    private double warehouseSalary = 0;
    private double financeSalary = 0;
    private double managerSalary = 0;
    private double adminSalary = 0;
    private double courierCommission = 0;
    private double lobbyCommission = 0;
    private double driverCommission = 0;
    private double intermediateCommission = 0;
    private double warehouseCommission = 0;
    private double financeCommission = 0;
    private double managerCommission = 0;
    private double adminCommission = 0;
    
    
    public void writeIntoDatabase() {
    	SqlWriter writer=new SqlWriter();
    	String content="'"+"1"+"','"+courierSalary+"','"+lobbySalary+"','"+driverSalary+"','"
    			+intermediateSalary+"','"+warehouseSalary+"','"+financeSalary+"','"
    			+managerSalary+"','"+adminSalary+"','"+courierCommission+"','"+lobbyCommission+"','"
    			+driverCommission+"','"+intermediateCommission+"','"+warehouseCommission+"','"
    			+financeCommission+"','"+managerCommission+"','"+adminCommission+"'";
    	writer.writeIntoSql("SalaryInfo", content);
	}
    
    public void getDataFromBase(){
    	SqlReader reader=new SqlReader("SalaryInfo");
    	if(reader.hasNext()){
    		this.courierSalary=reader.getDouble("���Աнˮ");
        	this.driverSalary=reader.getDouble("˾��нˮ");
        	this.lobbySalary=reader.getDouble("Ӫҵ��ҵ��Աнˮ");
        	this.intermediateSalary=reader.getDouble("��ת����ҵ��Աнˮ");
        	this.warehouseSalary=reader.getDouble("�ֿ������Աнˮ");
        	this.financeSalary=reader.getDouble("������Աнˮ");
        	this.managerSalary=reader.getDouble("�ܾ���нˮ");
        	this.adminSalary = reader.getDouble("�˻�������Աнˮ");
        	
        	this.courierCommission=reader.getDouble("���Ա���");
        	this.driverCommission=reader.getDouble("˾�����");
        	this.lobbyCommission=reader.getDouble("Ӫҵ��ҵ��Ա���");
        	this.intermediateCommission=reader.getDouble("��ת����ҵ��Ա���");
        	this.warehouseCommission=reader.getDouble("�ֿ������Ա���");
        	this.financeCommission = reader.getDouble("������Ա���");
        	this.adminCommission=reader.getDouble("�˻�������Ա���");
        	this.managerCommission=reader.getDouble("�ܾ������");
        	reader.close();
    	}
    }
    
    public void deleteFromDatabase(){
		SqlDeleter deleter = new SqlDeleter();
		deleter.deleteData("SalaryInfo","ID","1");
	}

	public double getCourierSalary() {
		return courierSalary;
	}

	public void setCourierSalary(double courierSalary) {
		this.courierSalary = courierSalary;
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

	public double getWarehouseSalary() {
		return warehouseSalary;
	}

	public void setWarehouseSalary(double warehouseSalary) {
		this.warehouseSalary = warehouseSalary;
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

	public double getAdminSalary() {
		return adminSalary;
	}

	public void setAdminSalary(double adminSalary) {
		this.adminSalary = adminSalary;
	}

	public double getCourierCommission() {
		return courierCommission;
	}

	public void setCourierCommission(double courierCommission) {
		this.courierCommission = courierCommission;
	}

	public double getLobbyCommission() {
		return lobbyCommission;
	}

	public void setLobbyCommission(double lobbyCommission) {
		this.lobbyCommission = lobbyCommission;
	}

	public double getDriverCommission() {
		return driverCommission;
	}

	public void setDriverCommission(double driverCommission) {
		this.driverCommission = driverCommission;
	}

	public double getIntermediateCommission() {
		return intermediateCommission;
	}

	public void setIntermediateCommission(double intermediateCommission) {
		this.intermediateCommission = intermediateCommission;
	}

	public double getWarehouseCommission() {
		return warehouseCommission;
	}

	public void setWarehouseCommission(double warehouseCommission) {
		this.warehouseCommission = warehouseCommission;
	}

	public double getFinanceCommission() {
		return financeCommission;
	}

	public void setFinanceCommission(double financeCommission) {
		this.financeCommission = financeCommission;
	}

	public double getManagerCommission() {
		return managerCommission;
	}

	public void setManagerCommission(double managerCommission) {
		this.managerCommission = managerCommission;
	}

	public double getAdminCommission() {
		return adminCommission;
	}

	public void setAdminCommission(double adminCommission) {
		this.adminCommission = adminCommission;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
