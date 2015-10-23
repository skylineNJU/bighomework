package po;

import java.util.List;

//�ɱ�����һ��ɱ���Ϣ
public class CostPO {
	private String costItem;//�ɱ���Ŀ������𡢹��ʵ�
	private int costYear;//֧�����
	private int costMonth;//֧���·�
	private int costDay;//֧����
	private int money;//֧�����
	private String count;//֧�����˻�
	private String remark;//֧����ע

	public CostPO(String costItem,int costYear,int costMonth,int costDay,int money,String count,String remark){
		this.costItem = costItem;
		this.costYear = costYear;
		this.costMonth = costMonth;
		this.costDay = costDay;
		this.money = money;
		this.count = count;
		this.remark = remark;
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

	public int getCostMonth() {
		return costMonth;
	}

	public void setCostMonth(int costMonth) {
		this.costMonth = costMonth;
	}

	public int getCostDay() {
		return costDay;
	}

	public void setCostDay(int costDay) {
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
