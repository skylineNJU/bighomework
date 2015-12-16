package main.po;
import java.io.Serializable;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;
public class TrainLoadingPO  extends Receipt implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String loadingDate;//װ������
	private String trainNum;//��ת���Ļ��˱��
	private String trainTourNum;//���κ�
	private String departure;//������
	private String destination;//�����
	private String monitor;//��װԱ
	private String store;//�����
	private String shipment;//װ����������
	private double freight;//�˷�
	
	public void writeIntoDatabase(){
		SqlWriter writer=new SqlWriter();
		shipment=readOrderCode(shipment);
		String content="'"+trainNum+"','"+trainTourNum+"','"+store+"','"+departure+"','"
				+destination+"','"+monitor+"','"+shipment+"','"+super.getCode()+"',"+freight+",'"+loadingDate+"'";
		writer.writeIntoSql("TrainLoading", content);
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
		SqlReader reader=new SqlReader("TrainLoading");
		reader.findNext("��װ�˵�����",this.getCode());
		this.departure=reader.getString("������");
		this.destination=reader.getString("�����");
		this.trainTourNum=reader.getString("�𳵳��κ�");
		this.trainNum=reader.getString("��ת���Ļ𳵻��˱�ű��");
		this.monitor=reader.getString("��װԱ");
		this.shipment=reader.getString("���л��ﶩ����");
		this.store=reader.getString("�����");
		this.loadingDate=reader.getString("��������ʱ��");
		this.freight=reader.getDouble("�˷�");
		reader.close();
	}
	
	

	public String getLoadingDate() {
		return loadingDate;
	}

	public void setLoadingDate(String loadingDate) {
		this.loadingDate = loadingDate;
	}

	public String getTrainNum() {
		return trainNum;
	}

	public void setTrainNum(String trainNum) {
		this.trainNum = trainNum;
	}

	public String getTrainTourNum() {
		return trainTourNum;
	}

	public void setTrainTourNum(String trainTourNum) {
		this.trainTourNum = trainTourNum;
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
