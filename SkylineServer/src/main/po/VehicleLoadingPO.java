package main.po;
import java.io.Serializable;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;
public class VehicleLoadingPO  extends Receipt implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String loadingDate;//װ������
	private String carNum;//��ת�������˱��
	private String carTourNum;//���κ�
	private String departure;//������
	private String destination;//�����
	private String monitor;//��װԱ
	private String guard;//Ѻ��Ա
	private String shipment;//װ����������
	private double freight;//�˷�
	
	public void writeIntoDatabase(){
		SqlWriter writer=new SqlWriter();
		shipment=readOrderCode(shipment);
		String content="'"+this.getCode()+"','"+loadingDate+"','"+carNum+"','"
				+carTourNum+"','"+departure+"','"+destination+"','"+monitor+"','"
				+guard+"','"+shipment+"',"+freight;
		writer.writeIntoSql("VehicleLoading", content);
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
		SqlReader reader=new SqlReader("VehicleLoading");
		reader.findNext("��ת��������װ�˵�",this.getCode());
		this.loadingDate=reader.getString("װ������");
		this.carNum=reader.getString("��ת�������˱��");
		this.carTourNum=reader.getString("���κ�");
		this.departure=reader.getString("������");
		this.destination=reader.getString("�����");
		this.monitor=reader.getString("��װԱ");
		this.guard=reader.getString("Ѻ��Ա");
		this.shipment=reader.getString("���ж�������");
		this.freight=reader.getDouble("�˷�");
	}
}
