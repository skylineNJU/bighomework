package main.po;
import java.io.Serializable;

import main.State.TransType;
import main.socketservice.SqlDeleter;
import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

public class WarehouseOutPO extends Receipt implements Serializable{

	private static final long serialVersionUID = 1L;
/*
 * ��ݱ�š��������ڡ�Ŀ�ĵء�װ����ʽ���𳵡��ɻ�������������ת����Ż������˱��
 */
	
	private String bar;
	private String code;
	private String outDate;
	private String destination;
	private TransType type;
	private String transferCode;
	private String vehicleCode;
	private String damageCondition;
	private String area;
	private int row;
	private int shelf;
	private int position;
	
	public WarehouseOutPO(String code,String area,int row,int shelf,int position) {
		super();
		this.code = code;
		this.area = area;
		this.row = row;
		this.shelf = shelf;
		this.position = position;
	}
	public WarehouseOutPO(String bar, String code,String outDate, String destination, TransType type, String transferCode,
			String vehicleCode,	String damageCondition) {
		super();
		this.bar = bar;
		this.code=code;
		this.outDate = outDate;
		this.destination = destination;
		this.type = type;
		this.transferCode = transferCode;
		this.vehicleCode = vehicleCode;
		this.damageCondition=damageCondition;
	}
	
	
	public void writeIntoDatabase(){
		if(hasCargo()){
		
			SqlWriter writer=new SqlWriter();
			String content="'"+transferCode+"','"+type.name()+"','"+outDate+"','"
					+bar+"','"+vehicleCode+"','"+destination+"','"+super.getCode()+"','"+damageCondition+"'";
			writer.writeIntoSql("WarhouseOut", content);
			SqlDeleter delete=new SqlDeleter();
			delete.deleteData("InventoryInfo", "������", bar);
			this.setKey("success");
		}
		else{
			
			this.setKey("Can't build!!!");
		}
	}
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("WarhouseOut");
		if(reader.findNext("���ⵥ����",this.getCode())){
			this.bar = reader.getString("��������");
			this.transferCode = reader.getString("��ת���ı��");
			this.outDate = reader.getString("����ʱ��");
			this.vehicleCode = reader.getString("���乤�߱��");
			this.type = TransType.valueOf(reader.getString("װ����ʽ"));
			this.destination = reader.getString("Ŀ�ĵ�");
			this.damageCondition = reader.getString("�����");
			reader.close();
		
	
			SqlReader reader1 = new SqlReader("WarhouseIn");
			if(reader1.findNext("��������",this.getBar())){
			this.area = reader1.getString("����");
			this.row = reader1.getInt("�ź�");
			this.shelf = reader1.getInt("�ܺ�");
			this.position = reader1.getInt("λ��");
			}
			reader1.close();
		
		}
		
	}
	
	public boolean hasCargo(){
		SqlReader reader=new SqlReader("InventoryInfo");
		if(reader.findNext("������", this.getBar())){
			System.out.println("++++++++++++++!!!!!!!!!!!!!!!!!"+transferCode);
			if(reader.getString("����").split(" ")[0].equals(transferCode)){
				return true;
			}
			else{
				reader.close();
				return false;
			}
		}
		else{
			reader.close();
			return false;
		}
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
