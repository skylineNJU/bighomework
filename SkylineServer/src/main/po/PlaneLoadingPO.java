package main.po;
import java.io.Serializable;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;
public class PlaneLoadingPO  extends Receipt implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String loadingDate;//װ������
	private String flightNum;//��ת���ĺ��˱��
	private String planeNum;//�����
	private String departure;//������
	private String destination;//�����
	private String monitor;//��װԱ
	private String store;//�����
	private String shipment;//װ����������
	private double freight;//�˷�
	

	

	public void writeIntoDatabase(){
		shipment=readOrderCode(shipment);
		SqlWriter writer=new SqlWriter();
		String content="'"+super.getCode()+"','"+flightNum+"','"+planeNum+"','"+departure+"','"
				+destination+"','"+store+"','"+monitor+"','"+shipment+"',"+freight+",'"+loadingDate+"'";
		writer.writeIntoSql("PlaneLoading", content);
	}
	
	public String readOrderCode(String area){
		String content="";
		SqlReader reader=new SqlReader("InventoryInfo");
		String position[]=area.split("  ");
		while(reader.findNext("����",position[0])){
			if(reader.getString("�ܺ�").equals(position[1]))
			content=content+reader.getString("������")+" ";
		}
		reader.close();
		return content;
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("PlaneLoading");
		if(reader.findNext("�ɻ�װ�˵�����",this.getCode())){
		this.flightNum=reader.getString("��ת���ı��");
		this.planeNum=reader.getString("�ɻ������");
		this.departure=reader.getString("������");
		this.destination=reader.getString("�����");
		this.store=reader.getString("�ɻ��պ�");
		this.monitor=reader.getString("��װԱ");
		this.freight=reader.getDouble("�˷�");
		this.loadingDate=reader.getString("��������ʱ��");
		this.shipment=reader.getString("���еĶ�����");
		}
		reader.close();
	}
	public String getLoadingDate() {
		return loadingDate;
	}

	public void setLoadingDate(String loadingDate) {
		this.loadingDate = loadingDate;
	}

	public String getFlightNum() {
		return flightNum;
	}

	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}

	public String getPlaneNum() {
		return planeNum;
	}

	public void setPlaneNum(String planeNum) {
		this.planeNum = planeNum;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getMonitor() {
		return monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getShipment() {
		return shipment;
	}

	public void setShipment(String shipment) {
		this.shipment = shipment;
	}

}
