package main.po;

//�ɱ�����һ��ɱ���Ϣ
public class CostPO extends Receipt{

	private static final long serialVersionUID = 1L;
	private String bankAccount;
	private String fee;
	private String costType;
	private String costDate;
	private String remark;
	private String costCode;
	
	
	public CostPO(String bankAccount, String fee, String costType,
			String costDate, String remark, String costCode) {
		super();
		this.bankAccount = bankAccount;
		this.fee = fee;
		this.costType = costType;
		this.costDate = costDate;
		this.remark = remark;
		this.costCode = costCode;
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
