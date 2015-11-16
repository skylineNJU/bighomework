package po;

import java.util.List;

//成本单，一项成本信息
public class CostPO extends Message{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String costItem;//成本项目，如租金、工资等
	private int costYear;//支出年份
	private String costMonth;//支出月份
	private String costDay;//支出天
	private int money;//支出金额
	private String count;//支出人账户
	private String unit;//支出单位
	private String remark;//支出备注

	public CostPO(String costItem,int costYear,String costMonth,String costDay,int money,String count,String remark,String unit){
		this.costItem = costItem;
		this.costYear = costYear;
		this.costMonth = costMonth;
		this.costDay = costDay;
		this.money = money;
		this.count = count;
		this.remark = remark;
		this.unit = unit;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
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

	public String getCostMonth() {
		return costMonth;
	}

	public void setCostMonth(String costMonth) {
		this.costMonth = costMonth;
	}

	public String getCostDay() {
		return costDay;
	}

	public void setCostDay(String costDay) {
		this.costDay = costDay;
	}

	public int getMoney() {
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
