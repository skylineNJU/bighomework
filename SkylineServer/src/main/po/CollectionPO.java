package main.po;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

//һ��������տPO
public class CollectionPO extends Receipt{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int collectionYear;//�������
	private int collectionMonth;//�����·�
	private int collectionDay;//������
	private String unit;//�տλ�������
	private String account;//�տ����˻�
	private double money;//�տ���
	private String remark;//��ע
	
	


	public CollectionPO(int collectionYear, int collectionMonth, int collectionDay, String unit, String account,
			double money, String remark) {
		super();
		this.collectionYear = collectionYear;
		this.collectionMonth = collectionMonth;
		this.collectionDay = collectionDay;
		this.unit = unit;
		this.account = account;
		this.money = money;
		this.remark = remark;
	}

	public void writeIntoDatabase(){
		SqlWriter writer=new SqlWriter();
		String content="'"+this.getCode()+"','"+collectionYear+"/"+collectionMonth+"/"+collectionDay+"','"
				+unit+"','"+account+"',"+money+",'"+remark+"'";
		writer.writeIntoSql("Collection", content);
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("Collection");
		reader.findNext("������",this.getCode());
		String date[]=reader.getString("��������").split("/");
		this.collectionYear=Integer.parseInt(date[0]);
		this.collectionMonth=Integer.parseInt(date[1]);
		this.collectionDay=Integer.parseInt(date[2]);
		this.unit=reader.getString("���뵥λ");
		this.account=reader.getString("�����˻�");
		this.money=reader.getDouble("������");
		this.remark=reader.getString("��ע");
	}
	
	
	public int getCollectionYear() {
		return collectionYear;
	}


	public String getUnit() {
		return unit;
	}

	public String getAccount() {
		return account;
	}

	
	public String getRemark() {
		return remark;
	}
	
}
