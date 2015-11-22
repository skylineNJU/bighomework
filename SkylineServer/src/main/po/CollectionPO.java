package main.po;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

//一项收入的收款单PO
public class CollectionPO extends Receipt{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int collectionYear;//收入年份
	private int collectionMonth;//收入月份
	private int collectionDay;//收入天
	private String unit;//收款单位，即编号
	private String account;//收款人账户
	private double money;//收款金额
	private String remark;//备注
	
	


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
		reader.findNext("入款单单号",this.getCode());
		String date[]=reader.getString("收入日期").split("/");
		this.collectionYear=Integer.parseInt(date[0]);
		this.collectionMonth=Integer.parseInt(date[1]);
		this.collectionDay=Integer.parseInt(date[2]);
		this.unit=reader.getString("收入单位");
		this.account=reader.getString("收入账户");
		this.money=reader.getDouble("收入金额");
		this.remark=reader.getString("备注");
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
