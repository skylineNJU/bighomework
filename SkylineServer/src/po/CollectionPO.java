package po;

//一项收入的收款单PO
public class CollectionPO {
	
	private int collectionYear;//收入年份
	private String collectionMonth;//收入月份
	private String collectionDay;//收入天
	private String unit;//收款单位，即编号
	private String account;//收款人账户
	private int money;//收款金额
	private String remark;//备注
	
	public CollectionPO(int collectionYear,String collectionMonth,String collectionDay,String unit,String account,int money,String remark){
		this.collectionYear = collectionYear;
		this.collectionMonth = collectionMonth;
		this.collectionDay = collectionDay;
		this.unit = unit;
		this.account = account;
		this.money = money;
		this.remark = remark;
	}

	public int getCollectionYear() {
		return collectionYear;
	}

	public String getCollectionMonth() {
		return collectionMonth;
	}

	public String getCollectionDay() {
		return collectionDay;
	}

	public String getUnit() {
		return unit;
	}

	public String getAccount() {
		return account;
	}

	public int getMoney() {
		return money;
	}

	public String getRemark() {
		return remark;
	}
	
}
