package main.po;
import java.io.Serializable;

import main.State.TransType;
import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

public class WarehouseOutPO extends Receipt implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/*
 * ��ݱ�š��������ڡ�Ŀ�ĵء�װ����ʽ���𳵡��ɻ�������������ת����Ż������˱��
 */
	
	private String bar;
	private String outDate;
	private String destination;
	private TransType type;
	private String transferCode;
	private String vehicleCode;
	private String damageCondition;
	
	
	public WarehouseOutPO(String bar, String outDate, String destination, TransType type, String transferCode,
			String vehicleCode,String damageCondition) {
		super();
		this.bar = bar;
		this.outDate = outDate;
		this.destination = destination;
		this.type = type;
		this.transferCode = transferCode;
		this.vehicleCode = vehicleCode;
		this.damageCondition=damageCondition;
	}
	
	public void writeIntoDatabase(){
		SqlWriter writer=new SqlWriter();
		String content="'"+transferCode+"','"+type.name()+"','"+outDate+"','"
				+bar+"','"+vehicleCode+"','"+destination+"','"+super.getCode()+"'";
		writer.writeIntoSql("WarhouseOut", content);
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("WarhouseOut");
		reader.findNext("���ⵥ����",this.getCode());
		this.bar=reader.getString("��������");
		this.transferCode=reader.getString("��ת���ı��");
		this.outDate=reader.getString("����ʱ��");
		this.vehicleCode=reader.getString("���乤�߱��");
		this.type=TransType.valueOf(reader.getString("װ����ʽ"));
		this.destination=reader.getString("Ŀ�ĵ�");
		this.damageCondition=reader.getString("�����");
		reader.close();
	}
	
	
	public String getDamageCondition() {
		return damageCondition;
	}

	public void setDamageCondition(String damageCondition) {
		this.damageCondition = damageCondition;
	}

	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public TransType getTType() {
		return type;
	}
	public void setTType(TransType type) {
		this.type = type;
	}
	public String getVehicleCode() {
		return vehicleCode;
	}
	public void setVehicleCode(String vehicleCode) {
		this.vehicleCode = vehicleCode;
	}
	public String getBar() {
		return bar;
	}
	public String getOutDate() {
		return outDate;
	}
	public String getTransferCode() {
		return transferCode;
	}
	
}
