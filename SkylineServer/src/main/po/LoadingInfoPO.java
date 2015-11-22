package main.po;
import java.io.Serializable;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;
//����װ������
public class LoadingInfoPO  extends Receipt implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String loadingDate;//װ������
	private String autoMobileNum;//Ӫҵ�����˱��
	private String departure;//������
	private String destination;//�����
	private String monitor;//��װԱ
	private String guard;//Ѻ��Ա
	private String shipment;//װ����������
	double freight;//�˷�
	
	
	public void writeIntoDatabase(){
		shipment=readOrderCode(shipment);
		SqlWriter writer=new SqlWriter();
		String content="'"+super.getCode()+"','"+autoMobileNum+"','"+departure+"','"
				+destination+"','"+monitor+"','"+guard+"','"+shipment+"',"+freight;
		writer.writeIntoSql("LobbyLoading", content);
	}
	
	public String readOrderCode(String area){
		String content="";
		SqlReader reader=new SqlReader("InventoryInfo");
		while(reader.findNext("����",area)){
			content=content+reader.getString("������")+" ";
		}
		reader.close();
		return content;
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("LobbyLoading");
		reader.findNext("Ӫҵ��װ�˵�����",this.getCode());
		this.autoMobileNum=reader.getString("�������κ�");
		this.departure=reader.getString("������");
		this.destination=reader.getString("�����");
		this.monitor=reader.getString("��װԱ");
		this.guard=reader.getString("Ѻ��Ա");
		this.shipment=reader.getString("���л��ﶩ����");
		this.freight=reader.getDouble("�˷�");
		reader.close();
	}
	
	public String getLoadingDate() {
		return loadingDate;
	}

	public void setLoadingDate(String loadingDate) {
		this.loadingDate = loadingDate;
	}

	public String getAutoMobileNum() {
		return autoMobileNum;
	}

	public void setAutoMobileNum(String autoMobileNum) {
		this.autoMobileNum = autoMobileNum;
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

	public String getGuard() {
		return guard;
	}

	public void setGuard(String guard) {
		this.guard = guard;
	}

	public String getShipment() {
		return shipment;
	}

	public void setShipment(String shipment) {
		this.shipment = shipment;
	}

}
