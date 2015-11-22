package main.po;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

//�ɱ�����һ��ɱ���Ϣ
public class CostPO extends Receipt{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String costItem;//�ɱ���Ŀ������𡢹��ʵ�
	private int costYear;//֧�����
	private int costMonth;//֧���·�
	private int costDay;//֧����
	private double money;//֧�����
	private String count;//֧�����˻�
	private String remark;//֧����ע


	public CostPO(String costItem, int costYear, int costMonth, int costDay, double money, String count,
			String remark) {
		super();
		this.costItem = costItem;
		this.costYear = costYear;
		this.costMonth = costMonth;
		this.costDay = costDay;
		this.money = money;
		this.count = count;
		this.remark = remark;
	}


	public void writeIntoDatabase(){
		SqlWriter writer=new SqlWriter();
		String content="'"+count+"',"+money+",'"+costItem+"','"
				+costYear+"/"+costMonth+"/"+costDay+"','"+remark+"','"+this.getCode()+"'";
		writer.writeIntoSql("Cost", content);
	}

	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("Cost");
		reader.findNext("�������",this.getCode());
		this.count=reader.getString("�����˻���");
		this.money=reader.getDouble("����");
		this.costItem=reader.getString("֧������");
		String date[]=reader.getString("֧������").split(" ");
		this.costYear=Integer.parseInt(date[0]);
		this.costMonth=Integer.parseInt(date[1]);
		this.costDay=Integer.parseInt(date[2]);
		this.remark=reader.getString("��ע");
	}
	
	public String getCostItem() {
		return costItem;
	}

	public void setCostItem(String costItem) {
		this.costItem = costItem;
	}

	public int getCostYear() {
		return costYear;
	}

	public void setCostYear(int costYear) {
		this.costYear = costYear;
	}


	public double getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
