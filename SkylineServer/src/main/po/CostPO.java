package main.po;

import main.socketservice.SqlReader;
import main.socketservice.SqlWriter;

//成本单，一项成本信息
public class CostPO extends Receipt{
	private static final long serialVersionUID = 1L;
	private String bankAccount;
	private String fee;
	private String costType;
	private String costDate;
	private String remark;
	private String costCode;
	private String isPaid;
		
	public CostPO(String bankAccount, String fee, String costType,
			String costDate, String remark, String costCode,String isPaid) {
		super();
		this.bankAccount = bankAccount;
		this.fee = fee;
		this.costType = costType;
		this.costDate = costDate;
		this.remark = remark;
		this.costCode = costCode;
		this.isPaid = isPaid;
	}
	public void writeIntoDatabase(){
		SqlWriter writer = new SqlWriter();
		String content = "'"+bankAccount+"','"+fee+"','"+costType+"','"+
				costDate+"','"+remark+"','"+costCode+"','"+isPaid+"'";
		writer.writeIntoSql("Cost", content);
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("Cost");
		reader.findNext("付款单单号",this.getCode());
		this.bankAccount = reader.getString("银行账户");
		this.fee = reader.getString("花费");
		this.costType = reader.getString("支出类型");
		this.costDate = reader.getString("支出日期");
		this.remark = reader.getString("备注");
		this.costCode = reader.getString("付款单单号");
	}
		
	public String getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(String isPaid) {
		this.isPaid = isPaid;
	}

	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	public String getCostType() {
		return costType;
	}
	public void setCostType(String costType) {
		this.costType = costType;
	}
	public String getCostDate() {
		return costDate;
	}
	public void setCostDate(String costDate) {
		this.costDate = costDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCostCode() {
		return costCode;
	}
	public void setCostCode(String costCode) {
		this.costCode = costCode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
